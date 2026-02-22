package archipelagoon;

import archipelagoon.ap.APContext;
import archipelagoon.ap.mapping.LocationState;
import archipelagoon.ap.mapping.items.Goods;
import archipelagoon.ap.mapping.locations.Additions;
import archipelagoon.ap.mapping.locations.Shops;
import archipelagoon.config.ArchipelagoConfigEntry;
import archipelagoon.config.ItemIndexConfigEntry;
import archipelagoon.config.LocationStateRegistry;
import archipelagoon.data.APIconUiType;
import archipelagoon.data.APInventoryEntry;
import archipelagoon.data.APShopEntry;
import archipelagoon.data.APShopExtension;
import archipelagoon.data.SlotData;
import archipelagoon.randomizer.AdditionManager;
import legend.core.GameEngine;
import legend.game.combat.deff.RegisterDeffsEvent;
import legend.game.inventory.Good;
import legend.game.inventory.Item;
import legend.game.inventory.ItemRegistryEvent;
import legend.game.inventory.screens.GatherShopExtensionsEvent;
import legend.game.modding.events.RenderEvent;
import legend.game.modding.events.battle.BattleEndedEvent;
import legend.game.modding.events.characters.AdditionUnlockEvent;
import legend.game.modding.events.characters.CharacterLevelUpEvent;
import legend.game.modding.events.gamestate.GameLoadedEvent;
import legend.game.modding.events.gamestate.NewGameEvent;
import legend.game.modding.events.inventory.GiveGoodsEvent;
import legend.game.modding.events.inventory.ShopBuyEvent;
import legend.game.modding.events.inventory.ShopContentsEvent;
import legend.game.modding.events.inventory.TakeGoodsEvent;
import legend.game.saves.ConfigCategory;
import legend.game.saves.ConfigEntry;
import legend.game.saves.ConfigRegistryEvent;
import legend.game.saves.ConfigStorageLocation;
import legend.game.saves.StringConfigEntry;
import legend.game.submap.SMap;
import legend.game.submap.SubmapState;
import legend.game.types.GameState52c;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.legendofdragoon.modloader.Mod;
import org.legendofdragoon.modloader.events.EventListener;
import org.legendofdragoon.modloader.registries.Registrar;
import org.legendofdragoon.modloader.registries.RegistryDelegate;
import org.legendofdragoon.modloader.registries.RegistryId;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static legend.core.GameEngine.EVENTS;
import static legend.game.EngineStates.currentEngineState_8004dd04;
import static legend.game.SItem.buildUiRenderable;
import static legend.game.Scus94491BpeSegment_8005.submapCut_80052c30;

@Mod(id = Archipelagoon.MOD_ID, version = "^3.0.0")
public class Archipelagoon {
  public static final String MOD_ID = "archipelagoon";
  private static final Registrar<ConfigEntry<?>, ConfigRegistryEvent> CONFIG_REGISTRAR = new Registrar<>(GameEngine.REGISTRIES.config, MOD_ID);
  public static final RegistryDelegate<ArchipelagoConfigEntry> ARCHIPELAGO_CONFIG = CONFIG_REGISTRAR.register("archipelago_config", ArchipelagoConfigEntry::new);
  public static final RegistryDelegate<StringConfigEntry> ADDRESS_CONFIG = CONFIG_REGISTRAR.register("address", () -> new StringConfigEntry("archipelago.gg:12345", 1, ConfigStorageLocation.CAMPAIGN, ConfigCategory.OTHER));
  public static final RegistryDelegate<StringConfigEntry> SLOT_NAME_CONFIG = CONFIG_REGISTRAR.register("slot_name", () -> new StringConfigEntry("", 1, ConfigStorageLocation.CAMPAIGN, ConfigCategory.OTHER));
  public static final RegistryDelegate<StringConfigEntry> PASSWORD_CONFIG = CONFIG_REGISTRAR.register("password", () -> new StringConfigEntry("", 1, ConfigStorageLocation.CAMPAIGN, ConfigCategory.OTHER));
  public static final RegistryDelegate<ItemIndexConfigEntry> LAST_ITEM_INDEX = CONFIG_REGISTRAR.register("last_item_index", () -> new ItemIndexConfigEntry(0));
  public static final RegistryDelegate<LocationStateRegistry> LOCATION_STATE_REGISTRY = CONFIG_REGISTRAR.register("location_states", LocationStateRegistry::new);
  private static final Registrar<Item, ItemRegistryEvent> ITEM_REGISTRAR = new Registrar<>(GameEngine.REGISTRIES.items, MOD_ID);
  private static final Logger LOGGER = LogManager.getFormatterLogger(Archipelagoon.class);
  private final AdditionManager additionManager = AdditionManager.getInstance();
  private GameState52c state;

  public Archipelagoon() {
    EVENTS.register(this);
  }

  public static RegistryId id(final String entryId) {
    return new RegistryId(MOD_ID, entryId);
  }

  @EventListener
  public void registerItems(final ItemRegistryEvent event) {
    APItems.register(event);
  }

  @EventListener
  public void registerDeffs(final RegisterDeffsEvent event) {
    APDeffs.register(event);
  }

  @EventListener
  public void gameConfig(final ConfigRegistryEvent event) {
    CONFIG_REGISTRAR.registryEvent(event);
  }

  @EventListener
  public void newGame(final NewGameEvent event) {
    submapCut_80052c30 = 10; // warp to seles
    ((SMap)currentEngineState_8004dd04).smapLoadingStage_800cb430 = SubmapState.CHANGE_SUBMAP_4;
  }

  @EventListener
  public void gatherShopExtensions(final GatherShopExtensionsEvent event) {
    event.addExtension(new APShopExtension(), 999);
  }

  @EventListener
  public void gameLoaded(final GameLoadedEvent game) {
    final APContext ctx = APContext.getContext();

    if(ctx.isConnected()) {
      ctx.initAdditions(game.gameState);
      return;
    }

    try {
      ctx.reconnect();
    } catch(final URISyntaxException e) {
      // Will only happen if the player submits a malformed URL
      LOGGER.error("User error - malformed URL", e);
      //TODO should probably display a message or something
    }
  }

  @EventListener
  public void additionUnlock(final AdditionUnlockEvent event) {
    if(!Additions.getStaticMap().containsValue(event.addition.getRegistryId().entryId())) {
      return;
    }

    final long apId = Additions.getAPLocationIdFromRegistryId(event.addition.getRegistryId());

    final List<LocationState> locationStates = GameEngine.CONFIG.getConfig(LOCATION_STATE_REGISTRY.get());
    final LocationState locationState = locationStates.stream()
      .filter(ls -> ls.getLocationID() == apId)
      .findFirst()
      .orElse(null);

    event.cancel();

    if(locationState == null) {
      return;
    }

    if(locationState.isApplied()) {
      return;
    }

    final APContext ctx = APContext.getContext();
    ctx.applyLocationState(locationState.getLocationID());
    ctx.checkLocation(locationState.getLocationID());
  }

  @EventListener
  public void shopContents(final ShopContentsEvent event) {
    final APContext ctx = APContext.getContext();
    final SlotData slotData = ctx.getSlotData();
    if(slotData.enableShopsanity == 0) {
      return;
    }

    final List<Long> shopSlots = Shops.getShopLocationIds(event.shop.getRegistryId().entryId()).stream().toList();
    final List<LocationState> locationStates = GameEngine.CONFIG.getConfig(LOCATION_STATE_REGISTRY.get());
    final List<LocationState> slots = locationStates.stream()
      .filter(ls -> shopSlots.contains(ls.getLocationID())).toList();

    final List<APShopEntry> adjustedContents = new ArrayList<>();

    for(final LocationState locationState : slots) {
      final int price = event.contents.getFirst().price; // original price (for now)
      final APInventoryEntry entry = new APInventoryEntry(locationState);

      adjustedContents.add(new APShopEntry(entry, price, locationState.getLocationID()));
    }

    event.contents.clear();
    event.contents.addAll((Collection)adjustedContents);
  }

  @EventListener
  public void shopBuy(final ShopBuyEvent event) {
    if(!(event.item instanceof final APInventoryEntry entry)) {
      return;
    }

    //    final APInventoryEntry entry = (APInventoryEntry)event.item;

    final APContext ctx = APContext.getContext();
    final List<LocationState> locationStates = GameEngine.CONFIG.getConfig(LOCATION_STATE_REGISTRY.get());
    final LocationState locationState = locationStates.stream()
      .filter(ls -> ls.getLocationID() == entry.locationId)
      .findFirst()
      .orElse(null);
    if(locationState == null) {
      return;
    }

    ctx.applyLocationState(locationState.getLocationID());
    ctx.checkLocation(entry.locationId);
  }

  @EventListener
  public void giveGood(final GiveGoodsEvent event) {
    final APContext ctx = APContext.getContext();
    if(!ctx.isConnected()) {
      return;
    }

    final Set<Long> receivedIds = Set.copyOf(ctx.getReceivedItemIDs());
    final List<Good> allowedGoods = new ArrayList<>();

    for(final Good good : event.givenGoods) {
      final Long apId = Goods.getAPItemIdFromRegistryId(good.getRegistryId());
      if(apId == null) {
        continue;
      }

      if(receivedIds.contains(apId)) {
        allowedGoods.add(good);
      } else if(Objects.equals(good.getRegistryId().entryId(), "law_maker")) {
        // check for whitelist
        allowedGoods.add(good);
      }
    }

    if(allowedGoods.isEmpty()) {
      event.cancel();
    } else {
      event.givenGoods.clear();
      event.givenGoods.addAll(allowedGoods);
    }
  }

  @EventListener
  public void takeGood(final TakeGoodsEvent event) {

    final List<Good> allowedGoods = new ArrayList<>();

    for(final Good good : event.takenGoods) {
      if(Objects.equals(good.getRegistryId().entryId(), "law_maker")) {
        allowedGoods.add(good);
      }
    }


    if(allowedGoods.isEmpty()) {
      event.cancel();
    } else {
      event.takenGoods.clear();
      event.takenGoods.addAll(allowedGoods);
    }
  }

  @EventListener
  public void characterLevelUp(final CharacterLevelUpEvent event) {
    AdditionManager.getInstance().checkUnlock(event.charData);
  }

  @EventListener
  public void battleEnded(final BattleEndedEvent event) {
    final APContext ctx = APContext.getContext();
    ctx.checkEncounter(event.encounter.getRegistryId());
  }

  @EventListener
  public void onRender(final RenderEvent event) {
    if(APIconUiType._ICONS.obj == null) {
      APIconUiType._ICONS.obj = buildUiRenderable(APIconUiType._ICONS, "AP icons");
    }
  }

/* Example of giving the player an ice trap item impersonating healing breeze
  @EventListener
  public void onLoad(final GameLoadedEvent event) {
    event.gameState.items_2e9.give(APItems.ICE_TRAP.get().impersonate(LodItems.HEALING_BREEZE.get()));
  }
*/
}
