package archipelagoon;

import archipelagoon.ap.APContext;
import archipelagoon.ap.mapping.LocationState;
import archipelagoon.ap.mapping.items.Goods;
import archipelagoon.ap.mapping.items.Items;
import archipelagoon.ap.mapping.locations.Additions;
import archipelagoon.ap.mapping.locations.Shops;
import archipelagoon.config.ArchipelagoConfigEntry;
import archipelagoon.config.ItemIndexConfigEntry;
import archipelagoon.config.LocationStateRegistry;
import archipelagoon.data.APIconUiType;
import archipelagoon.data.APInventoryEntry;
import archipelagoon.data.APShopEntry;
import archipelagoon.data.APShopExtension;
import legend.core.GameEngine;
import legend.game.combat.deff.RegisterDeffsEvent;
import legend.game.inventory.Good;
import legend.game.inventory.Item;
import legend.game.inventory.ItemRegistryEvent;
import legend.game.inventory.screens.GatherShopExtensionsEvent;
import legend.game.modding.events.RenderEvent;
import legend.game.modding.events.battle.BattleEndedEvent;
import legend.game.modding.events.characters.AdditionUnlockEvent;
import legend.game.modding.events.gamestate.GameLoadedEvent;
import legend.game.modding.events.gamestate.GameStateEvent;
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
import static legend.game.Scus94491BpeSegment_8005.submapCut_80052c30;
import legend.game.submap.SMap;
import legend.game.submap.SubmapState;
import legend.game.types.GameState52c;
import legend.lodmod.LodMod;
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

import static legend.core.GameEngine.EVENTS;
import static legend.game.EngineStates.currentEngineState_8004dd04;
import static legend.game.SItem.buildUiRenderable;
import static legend.game.Scus94491BpeSegment_800b.gameState_800babc8;

@Mod(id = Archipelagoon.MOD_ID, version = "^3.0.0")
public class Archipelagoon {
  public static final String MOD_ID = "archipelagoon";
  public static RegistryId id(final String entryId) {
    return new RegistryId(MOD_ID, entryId);
  }

  private static final Registrar<ConfigEntry<?>, ConfigRegistryEvent> CONFIG_REGISTRAR = new Registrar<>(GameEngine.REGISTRIES.config, MOD_ID);
  private static final Registrar<Item, ItemRegistryEvent> ITEM_REGISTRAR = new Registrar<>(GameEngine.REGISTRIES.items, MOD_ID);

  public static final RegistryDelegate<ArchipelagoConfigEntry> ARCHIPELAGO_CONFIG = CONFIG_REGISTRAR.register("archipelago_config", ArchipelagoConfigEntry::new);
  public static final RegistryDelegate<StringConfigEntry> ADDRESS_CONFIG = CONFIG_REGISTRAR.register("address", () -> new StringConfigEntry("archipelago.gg:12345", 1, ConfigStorageLocation.CAMPAIGN, ConfigCategory.OTHER));
  public static final RegistryDelegate<StringConfigEntry> SLOT_NAME_CONFIG = CONFIG_REGISTRAR.register("slot_name", () -> new StringConfigEntry("", 1, ConfigStorageLocation.CAMPAIGN, ConfigCategory.OTHER));
  public static final RegistryDelegate<StringConfigEntry> PASSWORD_CONFIG = CONFIG_REGISTRAR.register("password", () -> new StringConfigEntry("", 1, ConfigStorageLocation.CAMPAIGN, ConfigCategory.OTHER));
  public static final RegistryDelegate<ItemIndexConfigEntry> LAST_ITEM_INDEX = CONFIG_REGISTRAR.register("last_item_index", () -> new ItemIndexConfigEntry(0));
  public static final RegistryDelegate<LocationStateRegistry> LOCATION_STATE_REGISTRY = CONFIG_REGISTRAR.register("location_states", LocationStateRegistry::new);
//  public static final RegistryDelegate<Item> AP_PRIORITY_ITEM = ITEM_REGISTRAR.register("ap_priority_item", () -> new APPriorityItem(100));
//  public static final RegistryDelegate<Item> AP_OTHER_ITEM = ITEM_REGISTRAR.register("ap_other_item", () -> new APOtherItem(50));

  private GameState52c state;
  private static final Logger LOGGER = LogManager.getFormatterLogger(Archipelagoon.class);

  public Archipelagoon() {
    EVENTS.register(this);
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
    event.addExtension(new APShopExtension(),999);
  }

  @EventListener
  public void gameLoaded(final GameLoadedEvent game) {
    this.state = game.gameState;
    try {
      APContext.getContext().reconnect();
    } catch(final URISyntaxException e) {
      // Will only happen if the player submits a malformed URL
      LOGGER.error("User error - malformed URL", e);
      //TODO should probably display a message or something
    }
  }

  @EventListener
  public void additionUnlock(final AdditionUnlockEvent event) {
    if (!event.additionStats.unlocked) {
      return;
    }

    if (!Additions.getStaticMap().containsValue(event.addition.getRegistryId().entryId())) {
      return;
    }

    final long apId = Additions.getAPLocationIdFromRegistryId(event.addition.getRegistryId());
    final List<LocationState> locationStates =GameEngine.CONFIG.getConfig(LOCATION_STATE_REGISTRY.get());
    final LocationState locationState = locationStates.stream()
      .filter(ls -> ls.getLocationID() == apId)
      .findFirst()
      .orElse(null);

    event.cancel();

    if (locationState == null) {
      return;
    }

    if (locationState.isApplied()) {
      return;
    }

    if (!event.addition.isUnlocked(gameState_800babc8, event.charData, event.additionStats)) {
      return;
    }

    APContext.getContext().applyLocationState(locationState.getLocationID());
    APContext.getContext().checkAdditionLocation(event.addition.getRegistryId());
  }

  @EventListener
  public void shopContents(final ShopContentsEvent event) {
    final List<Long> shopSlots = Shops.getShopLocationIds(event.shop.getRegistryId().entryId()).stream().toList();
    final List<LocationState> locationStates = GameEngine.CONFIG.getConfig(LOCATION_STATE_REGISTRY.get());
    final List<LocationState> slots = locationStates.stream()
      .filter(ls -> shopSlots.contains(ls.getLocationID())).toList();

    final List<APShopEntry> adjustedContents = new ArrayList<>();

    int index = 0;
    for (final LocationState locationState : slots) {
      final String itemId = Items.getEntryIdFromAPItemId(locationState.getItemID());
      final RegistryId registryId = new RegistryId(LodMod.MOD_ID, itemId);
      final int price = event.contents.get(index).price; // original price (for now)
      final APInventoryEntry entry = new APInventoryEntry(locationState);


      adjustedContents.add(new APShopEntry(entry, price, locationState.getLocationID()));


//      if (GameEngine.REGISTRIES.items.hasEntry(registryId)) {
//        // this is an item from legend of dragoon
//        final Item item = GameEngine.REGISTRIES.items.getEntry(registryId).get();

////        adjustedContents.add(new ShopScreen.ShopEntry<>(new ItemStack(item), price));
//      } else if (GameEngine.REGISTRIES.equipment.hasEntry(registryId)) {
//        // this is equipment from legend of dragoon
//        final Equipment equipment = GameEngine.REGISTRIES.equipment.getEntry(registryId).get();
//        adjustedContents.add(new ShopScreen.ShopEntry<>(equipment, price));
//      } else if (GameEngine.REGISTRIES.goods.hasEntry(registryId)) {
//        // this is a good from legend of dragoon
//        final Good good = GameEngine.REGISTRIES.goods.getEntry(registryId).get();
//        final APGood apGood = new APGood(good, price);
//        adjustedContents.add(new ShopScreen.ShopEntry<>(new APStack(apGood, new APPriorityItem(price)), price));
//      } else if (GameEngine.REGISTRIES.additions.hasEntry(registryId)) {
//        // this is an addition from legend of dragoon
//        final Addition addition = GameEngine.REGISTRIES.additions.getEntry(registryId).get();
//        final Item item = GameEngine.REGISTRIES.items.getEntry(registryId).get();
//        adjustedContents.add(new ShopScreen.ShopEntry<>(new ItemStack(new APPriorityItem(price)), price));
//        final APItem apItem = new APItem(price, registryId, locationState.getFlags(), locationState.getItemName(), locationState.getPlayerName());
//        adjustedContents.add(new ShopScreen.ShopEntry<>(new APPriorityItem(price), price));
//      } else {
//       // item exists outside of legend of dragoon
//        final APItem apItem = new APItem(price, registryId, locationState.getFlags(), locationState.getItemName(), locationState.getPlayerName());
//        if ((locationState.getFlags() & NetworkItem.ADVANCEMENT) != 0) {
//          adjustedContents.add(new ShopScreen.ShopEntry<>(new ItemStack(new APPriorityItem(price)), price));
//        } else {
//          adjustedContents.add(new ShopScreen.ShopEntry<>(new ItemStack(new APOtherItem(price)), price));
//        }
//      }
//
//      index++;
    }

    event.contents.clear();
    event.contents.addAll((Collection)adjustedContents);
  }

  @EventListener
  public void shopBuy(final ShopBuyEvent event) {
    if(!(event.item instanceof final APInventoryEntry entry)) {
      return;
    }


    final APContext ctx = APContext.getContext();
    final List<LocationState> locationStates =GameEngine.CONFIG.getConfig(LOCATION_STATE_REGISTRY.get());
    final LocationState locationState = locationStates.stream()
      .filter(ls -> ls.getLocationID() == entry.locationId)
      .findFirst()
      .orElse(null);
    if (locationState == null) {
      return;
    }

    ctx.applyLocationState(locationState.getLocationID());
    ctx.checkShopPurchase(entry.locationId);
  }

  @EventListener
  public void giveGood(final GiveGoodsEvent event) {
    // received a good from somewhere SC/AP
    final List<Good> goods = event.givenGoods;
    final List<LocationState> locationStates = GameEngine.CONFIG.getConfig(LOCATION_STATE_REGISTRY.get());
    final List<Good> allowedGoods = new ArrayList<>();
    final APContext ctx = APContext.getContext();

    if (!ctx.isConnected()) {
      return;
    }

    // how do we find out if it came from SC or not?
    // check good ap id to list of received id's via ItemManager
    for (final Good good : goods) {
      final long apId = Goods.getAPItemIdFromRegistryId(good.getRegistryId());
      final List<Long> receivedItemIds = ctx.getReceivedItemIDs();

      // if we've received this item via archipelago
      if (receivedItemIds.contains(apId)) {
        // AND we haven't stored it before
        if(!event.goods.has(good)) {
          // queue it for add
          allowedGoods.add(good);
        } else {
          // must have been SC given later
          // potentially check?
          continue;
        }
      } else {
        // this wasn't in our received list, must be from SC
        // potentially check?
        continue;
      }
    }

    if (allowedGoods.isEmpty()) {
      event.cancel();
      return;
    }

    event.givenGoods.clear();
    event.givenGoods.addAll(allowedGoods);
  }

  @EventListener
  public void takeGood(final TakeGoodsEvent event) {
    event.cancel();
  }

  @EventListener
  public void battleEnded(final BattleEndedEvent event) {
    final APContext ctx = APContext.getContext();
    ctx.checkEncounter(event.encounter.getRegistryId());
  }

  @EventListener
  public void gameStateChanged(final GameStateEvent event) {
    this.state = event.gameState;
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
