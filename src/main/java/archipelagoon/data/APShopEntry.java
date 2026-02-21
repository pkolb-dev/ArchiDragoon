package archipelagoon.data;

import legend.game.inventory.screens.ShopScreen;

public class APShopEntry extends ShopScreen.ShopEntry<APInventoryEntry> {
  public Long locationId;

  public APShopEntry(final APInventoryEntry item, final int price, final Long locationId) {
    super(item, price);
    this.locationId = locationId;
  }
}
