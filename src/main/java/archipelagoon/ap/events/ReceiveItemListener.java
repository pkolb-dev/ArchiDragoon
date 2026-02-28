package archipelagoon.ap.events;

import archipelagoon.ap.APContext;
import archipelagoon.ap.mapping.items.Items;
import archipelagoon.randomizer.AdditionManager;
import io.github.archipelagomw.events.ArchipelagoEventListener;
import io.github.archipelagomw.events.ReceiveItemEvent;
import legend.core.GameEngine;
import legend.game.SItem;
import legend.game.inventory.Equipment;
import legend.game.inventory.Good;
import legend.game.inventory.Item;
import org.legendofdragoon.modloader.registries.RegistryId;

import static archipelagoon.Archipelagoon.LAST_ITEM_INDEX;
import static legend.game.Scus94491BpeSegment_800b.gameState_800babc8;

public class ReceiveItemListener {
  @ArchipelagoEventListener
  public void onReceiveItem(final ReceiveItemEvent event) {
    final APContext ctx = APContext.getContext();

    ctx.initAdditions(null);

    final long lastItemReceivedIndex = GameEngine.CONFIG.getConfig(LAST_ITEM_INDEX.get());
    if(event.getIndex() <= lastItemReceivedIndex) {
      return;
    }

    final long apItemId = event.getItemID();
    final String itemId = Items.getRegistryIdFromAPItemId(apItemId);
    final RegistryId registryId = new RegistryId(itemId);

    // update index
    GameEngine.CONFIG.setConfig(LAST_ITEM_INDEX.get(), event.getIndex());

    // give to player
    if(GameEngine.REGISTRIES.items.hasEntry(registryId)) {
      final Item item = GameEngine.REGISTRIES.items.getEntry(registryId).get();
      gameState_800babc8.items_2e9.give(item);
    } else if(GameEngine.REGISTRIES.equipment.hasEntry(registryId)) {
      final Equipment equipment = GameEngine.REGISTRIES.equipment.getEntry(registryId).get();
      SItem.giveEquipment(equipment);
    } else if(GameEngine.REGISTRIES.goods.hasEntry(registryId)) {
      final Good good = GameEngine.REGISTRIES.goods.getEntry(registryId).get();
      gameState_800babc8.goods_19c.give(good);
    } else if(GameEngine.REGISTRIES.additions.hasEntry(registryId)) {
      AdditionManager.getInstance().setAddition(registryId, null);
    }

    // queue message
    final String message = String.format("Received\n%s\nfrom\n%s", event.getItemName(), event.getPlayerName());
    ctx.displayMessage(message);
  }
}
