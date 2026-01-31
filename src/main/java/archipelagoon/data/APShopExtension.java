package archipelagoon.data;

import legend.game.i18n.I18n;
import legend.game.inventory.screens.MessageBoxScreen;
import legend.game.inventory.screens.ShopExtension;
import legend.game.inventory.screens.ShopScreen;
import legend.game.modding.events.inventory.ShopBuyEvent;
import legend.game.types.GameState52c;
import legend.game.types.MessageBoxResult;
import legend.game.types.Shop;

import static legend.core.GameEngine.EVENTS;
import static legend.game.SItem.giveItem;
import static legend.game.SItem.menuStack;
import static legend.game.Scus94491BpeSegment_800b.gameState_800babc8;

public class APShopExtension extends ShopExtension<APInventoryEntry> {
  @Override
  public String getName(ShopScreen.ShopEntry<APInventoryEntry> entry) {
    return entry.item.getDescriptionTranslationKey();
  }

  @Override
  public boolean accepts(ShopScreen.ShopEntry<?> entry) {
    return entry instanceof APShopEntry;
  }

  @Override
  public boolean selectEntry(ShopScreen screen, Shop shop, GameState52c gameState, ShopScreen.ShopEntry<APInventoryEntry> entry, int index) {

    if(gameState_800babc8.gold_94 < entry.price) {
      screen.deferAction(() -> menuStack.pushScreen(new MessageBoxScreen(I18n.translate("lod_core.ui.shop.not_enough_gold"), 0, result -> { })));
    } else {
      menuStack.pushScreen(new MessageBoxScreen(I18n.translate("lod_core.ui.shop.buy", I18n.translate(entry.item.getNameTranslationKey())), 2, result -> {
        if(result == MessageBoxResult.YES) {
          EVENTS.postEvent(new ShopBuyEvent(shop, entry.item));
        }
      }));
    }

    return false;
  }

}
