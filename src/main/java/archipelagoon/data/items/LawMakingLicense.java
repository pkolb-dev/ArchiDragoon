package archipelagoon.data.items;

import legend.game.inventory.Good;
import legend.game.inventory.ItemIcon;
import legend.lodmod.LodGoods;

public class LawMakingLicense extends Good {
  public LawMakingLicense(final int sortingIndex) {
    super(sortingIndex);
  }

  @Override
  public ItemIcon getIcon() {
    return LodGoods.LAW_MAKER.get().getIcon();
  }
}
