package archipelagoon;

import legend.game.combat.deff.DeffPackage;
import legend.game.combat.deff.RegisterDeffsEvent;
import org.legendofdragoon.modloader.registries.Registrar;
import org.legendofdragoon.modloader.registries.RegistryDelegate;

import static legend.core.GameEngine.REGISTRIES;

public final class APDeffs {
  private APDeffs() { }

  private static final Registrar<DeffPackage, RegisterDeffsEvent> REGISTRAR = new Registrar<>(REGISTRIES.deff, "archipelagoon");

  public static final RegistryDelegate<DeffPackage> ICE_TRAP = REGISTRAR.register("ice_trap", APDeffPackage::new);

  static void register(final RegisterDeffsEvent event) {
    REGISTRAR.registryEvent(event);
  }
}
