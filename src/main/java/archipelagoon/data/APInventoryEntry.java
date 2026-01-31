package archipelagoon.data;

import archipelagoon.ap.mapping.LocationState;
import io.github.archipelagomw.flags.NetworkItem;
import legend.core.GameEngine;
import legend.game.inventory.InventoryEntry;
import legend.game.inventory.ItemIcon;
import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.List;

import static archipelagoon.Archipelagoon.LOCATION_STATE_REGISTRY;

public class APInventoryEntry implements InventoryEntry<APInventoryEntry>{
  public final Long locationId;
  public APInventoryEntry(final Long locationId) {
    this.locationId = locationId;
  }

  @Override
  public RegistryId getRegistryId() {
    return null;
  }

  @Override
  public ItemIcon getIcon() {
    final List<LocationState> locationStates = GameEngine.CONFIG.getConfig(LOCATION_STATE_REGISTRY.get());
    final LocationState locationState = locationStates.stream().filter(ls -> ls.getLocationID() == this.locationId).findFirst().orElse(null);
    if  (locationState == null) {
      return null;
    }

    if ((locationState.getFlags() & NetworkItem.ADVANCEMENT) != 0) {
      return APIcon.PRIORITY;
    } else {
      return APIcon.OTHER;
    }
  }

  @Override
  public String getNameTranslationKey() {
    return "some name";
  }

  @Override
  public String getDescriptionTranslationKey() {
    return "some key";
  }

  @Override
  public int getSize() {
    return 1;
  }

  @Override
  public int getMaxSize() {
    return 1;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }
}
