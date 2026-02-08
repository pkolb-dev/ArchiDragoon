package archipelagoon.randomizer;

import archipelagoon.ap.APContext;
import archipelagoon.ap.mapping.items.Additions;
import archipelagoon.data.AdditionUnlockData;
import legend.core.GameEngine;
import legend.game.additions.CharacterAdditionStats;
import legend.game.additions.UnlockState;
import legend.game.types.CharacterData2c;
import legend.lodmod.LodMod;
import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import static legend.game.Scus94491BpeSegment_800b.gameState_800babc8;

public final class AdditionManager {
  private static final AdditionManager INSTANCE = new AdditionManager();
  public static AdditionManager getInstance() {
    return INSTANCE;
  }

  private AdditionManager() {}

  public void clearAdditions() {
    for(int charIndex = 0; charIndex < 9; charIndex++) {
      final CharacterData2c charData = gameState_800babc8.charData_32c[charIndex];

      charData.additionStats.forEach((_, value) -> value.unlockState = UnlockState.LOCKED);
    }
  }

  public void setAdditions() {
    final APContext ctx = APContext.getContext();
    final Map<Long, String> additionList = Additions.getStaticMap();
    final List<Long> receivedItemIds = ctx.getReceivedItemIDs()
      .stream()
      .filter(additionList::containsKey)
      .toList();

    for (final Long id : receivedItemIds) {
      final String entryId = Additions.getEntryIdFromAPItemId(id);
      final RegistryId registryId = new RegistryId(LodMod.MOD_ID, entryId);
      this.setAddition(registryId);
    }
  }

  public void setAddition(final RegistryId registryId) {
    if (!GameEngine.REGISTRIES.additions.hasEntry(registryId)) {
      return;
    }

    for(int charIndex = 0; charIndex < 9; charIndex++) {
      final CharacterData2c charData = gameState_800babc8.charData_32c[charIndex];
      final CharacterAdditionStats additionStats = charData.additionStats.get(registryId);
      if (additionStats == null) {
        continue;
      }

      additionStats.unlockState = UnlockState.UNLOCKED;
      break;
    }
  }

  public void checkUnlock(final int charId, final int level12) {
    final Map<Long, Integer> charUnlocks = AdditionUnlockData.getCharUnlocks(charId - 1);
    if (charUnlocks.containsValue(level12)) {
      final APContext apContext = APContext.getContext();
      final Optional<Long> apId = AdditionUnlockData.getApId(charId, level12);
      apId.ifPresent(apContext::checkLocation);
    }
  }
}