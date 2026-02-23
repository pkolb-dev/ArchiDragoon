package archipelagoon;

import legend.game.additions.Addition;
import legend.game.additions.AdditionRegistryEvent;
import org.legendofdragoon.modloader.registries.Registrar;

import static legend.core.GameEngine.REGISTRIES;

public final class APAdditions {
  private static final Registrar<Addition, AdditionRegistryEvent> REGISTRAR = new Registrar<>(REGISTRIES.additions, "archipelagoon");
  //  public static final RegistryDelegate<Addition> PROGRESSIVE_DART = REGISTRAR.register("progressive_dart", ctor here)
  //  public static final RegistryDelegate<Addition> PROGRESSIVE_LAVITZ = REGISTRAR.register("progressive_lavitz", ctor here)
  //  public static final RegistryDelegate<Addition> PROGRESSIVE_ROSE = REGISTRAR.register("progressive_rose", ctor here)
  //  public static final RegistryDelegate<Addition> PROGRESSIVE_ALBERT = REGISTRAR.register("progressive_albert", ctor here)
  //  public static final RegistryDelegate<Addition> PROGRESSIVE_HASCHEL = REGISTRAR.register("progressive_haschel", ctor here)
  //  public static final RegistryDelegate<Addition> PROGRESSIVE_MERU = REGISTRAR.register("progressive_meru", ctor here)
  //  public static final RegistryDelegate<Addition> PROGRESSIVE_KONGOL = REGISTRAR.register("progressive_kongol", ctor here)

  private APAdditions() {
  }

  static void register(final AdditionRegistryEvent event) {
    REGISTRAR.registryEvent(event);
  }

}
