package archipelagoon;

import archipelagoon.data.LawLaunchingLicense;
import archipelagoon.data.LawMakingLicense;
import legend.game.inventory.Good;
import legend.game.inventory.GoodsRegistryEvent;
import org.legendofdragoon.modloader.registries.Registrar;
import org.legendofdragoon.modloader.registries.RegistryDelegate;

import static legend.core.GameEngine.REGISTRIES;

public final class APGoods {
  private static final Registrar<Good, GoodsRegistryEvent> REGISTRAR = new Registrar<>(REGISTRIES.goods, "archipelagoon");
  public static final RegistryDelegate<Good> LAW_MAKING_LICENSE = REGISTRAR.register("law_making_license", () -> new LawMakingLicense(380));
  public static final RegistryDelegate<Good> LAW_LAUNCHING_LICENSE = REGISTRAR.register("law_launching_license", () -> new LawLaunchingLicense(390));

  private APGoods() {
  }

  static void register(final GoodsRegistryEvent event) {
    REGISTRAR.registryEvent(event);
  }
}
