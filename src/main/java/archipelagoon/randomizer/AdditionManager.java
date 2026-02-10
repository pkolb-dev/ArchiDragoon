package archipelagoon.randomizer;

import archipelagoon.ap.APContext;
import archipelagoon.ap.mapping.items.Additions;
import archipelagoon.data.AdditionUnlockData;
import legend.core.GameEngine;
import legend.game.additions.CharacterAdditionStats;
import legend.game.additions.UnlockState;
import legend.game.types.CharacterData2c;
import legend.game.types.GameState52c;
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

  public void clearAdditions(final GameState52c gameState) {
    GameState52c state = gameState;
    if (state == null) {
      state = gameState_800babc8;
    }

    for(int charIndex = 0; charIndex < 9; charIndex++) {
      final CharacterData2c charData = state.charData_32c[charIndex];

      charData.additionStats.forEach((_, value) -> value.unlockState = UnlockState.LOCKED);
    }
  }

  public void setAdditions(final GameState52c gameState) {
    final APContext ctx = APContext.getContext();
    final Map<Long, String> additionList = Additions.getStaticMap();
    final List<Long> receivedItemIds = ctx.getReceivedItemIDs()
      .stream()
      .filter(additionList::containsKey)
      .toList();

    GameState52c state = gameState;
    if (state == null) {
      state = gameState_800babc8;
    }

    for (final Long id : receivedItemIds) {
      final String entryId = Additions.getEntryIdFromAPItemId(id);
      final RegistryId registryId = new RegistryId(LodMod.MOD_ID, entryId);
      this.setAddition(registryId, state);
    }
  }

  public void setAddition(final RegistryId registryId, final GameState52c gameState) {
    if (!GameEngine.REGISTRIES.additions.hasEntry(registryId)) {
      return;
    }

    GameState52c state = gameState;
    if (state == null) {
      state = gameState_800babc8;
    }

    for(int charIndex = 0; charIndex < 9; charIndex++) {
      final CharacterData2c charData = state.charData_32c[charIndex];
      final CharacterAdditionStats additionStats = charData.additionStats.get(registryId);
      if (additionStats == null) {
        continue;
      }

      additionStats.unlockState = UnlockState.UNLOCKED;
      break;
    }
  }

  public void selectAddition(final GameState52c gameState) {
    GameState52c state = gameState;
    if (state == null) {
      state = gameState_800babc8;
    }
    for(int charIndex = 0; charIndex < 9; charIndex++) {
      final CharacterData2c charData = state.charData_32c[charIndex];
      final CharacterAdditionStats additionStats = charData.additionStats.get(charData.selectedAddition_19);
      if (additionStats == null) {
        continue;
      }

      if (additionStats.unlockState == UnlockState.UNLOCKED) {
        break;
      }

      final Optional<RegistryId> firstMatchingKey = charData.additionStats.entrySet().stream()
        .filter(entry -> entry.getValue().unlockState == UnlockState.UNLOCKED)
        .map(Map.Entry::getKey)
        .findFirst(); // Terminal operation returns an Optional

      firstMatchingKey.ifPresent(registryId -> charData.selectedAddition_19 = registryId);
    }
  }

  public void checkUnlock(final int charId, final int level12) {
    final Map<Long, Integer> charUnlocks = AdditionUnlockData.getCharUnlocks(charId);
    if (charUnlocks.containsValue(level12)) {
      final APContext apContext = APContext.getContext();
      final Optional<Long> apId = AdditionUnlockData.getApId(charId, level12);
      apId.ifPresent(apContext::checkLocation);
    }
  }
}