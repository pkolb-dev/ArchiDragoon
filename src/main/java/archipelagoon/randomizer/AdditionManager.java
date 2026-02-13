package archipelagoon.randomizer;

import archipelagoon.ap.APContext;
import archipelagoon.ap.mapping.items.Additions;
import legend.core.GameEngine;
import legend.game.additions.CharacterAdditionStats;
import legend.game.additions.UnlockState;
import legend.game.types.CharacterData2c;
import legend.game.types.GameState52c;
import legend.lodmod.LodMod;
import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.Map;
import java.util.Set;

import static legend.game.Scus94491BpeSegment_800b.gameState_800babc8;

public final class AdditionManager {
  private static final AdditionManager INSTANCE = new AdditionManager();
  final private static Set<RegistryId> MASTER_ADDITIONS = Set.of(
    new RegistryId(LodMod.MOD_ID, "blazing_dynamo"),
    new RegistryId(LodMod.MOD_ID, "flower_storm"),
    new RegistryId(LodMod.MOD_ID, "demons_dance"),
    new RegistryId(LodMod.MOD_ID, "omni_sweep"),
    new RegistryId(LodMod.MOD_ID, "albert_flower_storm"),
    new RegistryId(LodMod.MOD_ID, "perky_step"),
    new RegistryId(LodMod.MOD_ID, "bone_crush")
  );

  public static AdditionManager getInstance() {
    return INSTANCE;
  }

  private AdditionManager() {}

  public void clearAdditions(final GameState52c gameState) {
    final GameState52c state = this.resolveState(gameState);

    for(int charIndex = 0; charIndex < 9; charIndex++) {
      final CharacterData2c charData = state.charData_32c[charIndex];

      charData.additionStats.forEach((_, value) -> value.unlockState = UnlockState.LOCKED);
    }
  }

  public void setAdditions(final GameState52c gameState) {
    final APContext ctx = APContext.getContext();
    final Map<Long, String> additionList = Additions.getStaticMap();
    final GameState52c state = this.resolveState(gameState);

    for (final Long id : ctx.getReceivedItemIDs()) {
      if (!additionList.containsKey(id)) {
        continue;
      }

      final String entryId = Additions.getEntryIdFromAPItemId(id);
      final RegistryId registryId = new RegistryId(LodMod.MOD_ID, entryId);
      this.setAddition(registryId, state);
    }
  }

  public void setAddition(final RegistryId registryId, final GameState52c gameState) {
    if (!GameEngine.REGISTRIES.additions.hasEntry(registryId)) {
      return;
    }

    final GameState52c state = this.resolveState(gameState);

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
    final GameState52c state = this.resolveState(gameState);
    for(int charIndex = 0; charIndex < 9; charIndex++) {
      final CharacterData2c charData = state.charData_32c[charIndex];
      final CharacterAdditionStats additionStats = charData.additionStats.get(charData.selectedAddition_19);
      if (additionStats == null) {
        continue;
      }

      if (additionStats.unlockState == UnlockState.UNLOCKED) {
        break;
      }

      for (final Map.Entry<RegistryId, CharacterAdditionStats> entry : charData.additionStats.entrySet()) {
        if (entry.getValue().unlockState == UnlockState.UNLOCKED) {
          charData.selectedAddition_19 = entry.getKey();
          break;
        }
      }
    }
  }

  public void checkUnlock(final int charId, final CharacterData2c charData) {
    final GameState52c state = this.resolveState(null);
    final APContext apContext = APContext.getContext();

    for (final Map.Entry<RegistryId, CharacterAdditionStats> entry
      : charData.additionStats.entrySet()) {

      final RegistryId registryId = entry.getKey();
      final CharacterAdditionStats stats = entry.getValue();

      final var addition = GameEngine.REGISTRIES.additions.getEntry(registryId).get();
      if (addition == null) {
        continue;
      }

      if (addition.isUnlocked(state, charData, stats)) {
        final Long apId = archipelagoon.ap.mapping.locations.Additions.getAPLocationIdFromRegistryId(registryId);
        if (apId != null) {
          apContext.checkLocation(apId);
        }
      }
    }
  }

  private GameState52c resolveState(final GameState52c state) {
    return state != null ? state : gameState_800babc8;
  }
}