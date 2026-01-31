package archipelagoon.data;

import archipelagoon.ap.APContext;
import legend.game.i18n.I18n;
import legend.game.inventory.screens.MessageBoxScreen;
import legend.game.inventory.screens.ShopExtension;
import legend.game.inventory.screens.ShopScreen;
import legend.game.modding.events.inventory.ShopBuyEvent;
import legend.game.types.GameState52c;
import legend.game.types.MessageBoxResult;
import legend.game.types.Shop;

import static legend.core.GameEngine.EVENTS;
import static legend.game.SItem.UI_TEXT;
import static legend.game.SItem.UI_TEXT_DISABLED;
import static legend.game.SItem.giveItem;
import static legend.game.SItem.menuStack;
import static legend.game.Scus94491BpeSegment_800b.gameState_800babc8;
import static legend.game.SItem.renderFiveDigitNumber;
import static legend.game.SItem.renderRightAlignedNumber;
import static legend.game.SItem.renderString;
import static legend.game.Text.renderText;

public class APShopExtension extends ShopExtension<APInventoryEntry> {
  @Override
  public String getName(ShopScreen.ShopEntry<APInventoryEntry> entry) {
    return "AP Item Store";
  }

  @Override
  public boolean accepts(ShopScreen.ShopEntry<?> entry) {
    return entry instanceof APShopEntry;
  }

  @Override
  public boolean selectEntry(ShopScreen screen, Shop shop, GameState52c gameState, ShopScreen.ShopEntry<APInventoryEntry> entry, int index) {
    if(entry.item.isApplied) {
      screen.deferAction(() -> menuStack.pushScreen(new MessageBoxScreen("Already purchased this item", 0, result -> { })));
    } else if(gameState_800babc8.gold_94 < entry.price) {
      screen.deferAction(() -> menuStack.pushScreen(new MessageBoxScreen(I18n.translate("lod_core.ui.shop.not_enough_gold"), 0, result -> { })));
    } else {
      menuStack.pushScreen(new MessageBoxScreen(I18n.translate("lod_core.ui.shop.buy", I18n.translate(entry.item.getNameTranslationKey())), 2, result -> {
        if(result == MessageBoxResult.YES) {
          entry.item.isApplied = true;
          gameState_800babc8.gold_94 -= entry.price;
          EVENTS.postEvent(new ShopBuyEvent(shop, entry.item));
        }
      }));
    }

    return false;
  }

  @Override
  public void drawShopRow(ShopScreen screen, Shop shop, GameState52c gameState, ShopScreen.ShopEntry<APInventoryEntry> entry, int index, final int x, final int y) {
    // TODO: this isn't updated after purchase.
    if (entry.item.isApplied) {
      renderText(I18n.translate(entry.item.getNameTranslationKey()), x + 20, y + 2, UI_TEXT_DISABLED);
    } else {
      renderText(I18n.translate(entry.item.getNameTranslationKey()), x + 20, y + 2, UI_TEXT);
    }

    renderFiveDigitNumber(x + 176, y + 4, entry.price);
    entry.item.renderIcon(x + 3, y, 0x8);
  }
}
