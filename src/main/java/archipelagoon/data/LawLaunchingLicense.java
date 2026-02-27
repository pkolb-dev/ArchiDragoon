package archipelagoon.data;

import legend.game.inventory.Good;
import legend.game.inventory.ItemIcon;
import legend.lodmod.LodGoods;

public class LawLaunchingLicense extends Good {
  public LawLaunchingLicense(final int sortingIndex) {
    super(sortingIndex);
  }

  @Override
  public ItemIcon getIcon() {
    return LodGoods.LAW_OUTPUT.get().getIcon();
  }
}