package archipelagoon.data;

import legend.game.inventory.screens.ShopScreen;

public class APShopEntry extends ShopScreen.ShopEntry<APInventoryEntry> {

  public APShopEntry(final APInventoryEntry item, final int price) {
    super(item, price);
  }
}
