package archipelagoon;

import archipelagoon.data.IceTrapItem;
import legend.game.inventory.Item;
import legend.game.inventory.ItemRegistryEvent;
import org.legendofdragoon.modloader.registries.Registrar;
import org.legendofdragoon.modloader.registries.RegistryDelegate;

import static legend.core.GameEngine.REGISTRIES;

public final class APItems {
  private APItems() { }

  private static final Registrar<Item, ItemRegistryEvent> REGISTRAR = new Registrar<>(REGISTRIES.items, "archipelagoon");

  public static final RegistryDelegate<IceTrapItem> ICE_TRAP = REGISTRAR.register("ice_trap", IceTrapItem::new);

  static void register(final ItemRegistryEvent event) {
    REGISTRAR.registryEvent(event);
  }
}
