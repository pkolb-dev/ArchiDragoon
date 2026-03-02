package archipelagoon.randomizer;

import archipelagoon.ap.APContext;
import archipelagoon.ap.mapping.items.Additions;
import archipelagoon.data.ProgressiveAdditions;
import archipelagoon.data.enums.AdditionRandomizerType;
import legend.core.GameEngine;
import legend.game.SItem;
import legend.game.additions.CharacterAdditionStats;
import legend.game.additions.UnlockState;
import legend.game.types.CharacterData2c;
import legend.game.types.GameState52c;
import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static legend.game.Scus94491BpeSegment_800b.gameState_800babc8;

public final class AdditionManager {
  private static final AdditionManager INSTANCE = new AdditionManager();

  private AdditionManager() {
  }

  public static AdditionManager getInstance() {
    return INSTANCE;
  }

  public void clearAdditions(final GameState52c gameState) {
    final GameState52c state = this.resolveState(gameState);

    for(int charIndex = 0; charIndex < 9; charIndex++) {
      final CharacterData2c charData = state.charData_32c[charIndex];

      charData.additionStats.forEach((_, value) -> value.unlockState = UnlockState.LOCKED);
    }
  }

  public void setAdditions(final GameState52c gameState) {
    final APContext ctx = APContext.getContext();

    switch(AdditionRandomizerType.values()[ctx.getSlotData().additionRandomizer]) {
      case AdditionRandomizerType.ADDITIONSANITY:
        this.setAdditionsanity(gameState);
        break;
      case AdditionRandomizerType.PROGRESSIVE:
        this.setProgressive(gameState);
        break;
      case AdditionRandomizerType.OFF:
      default:
        this.setVanilla(gameState);
        break;
    }
  }

  private void setVanilla(final GameState52c gameState) {
    final GameState52c state = this.resolveState(gameState);

    final APContext ctx = APContext.getContext();

    for(int charIndex = 0; charIndex < 9; charIndex++) {
      final CharacterData2c charData = state.charData_32c[charIndex];

      for(final Map.Entry<RegistryId, CharacterAdditionStats> entry : charData.additionStats.entrySet()) {
        entry.getValue().unlockState = UnlockState.UNLOCKABLE;
      }

      SItem.checkForNewlyUnlockedAddition(charIndex);
    }
  }

  private void setAdditionsanity(final GameState52c gameState) {
    final Map<Long, String> additionList = Additions.getStaticMap();
    final GameState52c state = this.resolveState(gameState);
    final APContext ctx = APContext.getContext();

    for(final Long id : ctx.getReceivedItemIDs()) {
      if(!additionList.containsKey(id)) {
        continue;
      }

      final RegistryId registryId = new RegistryId(Additions.getRegistryIdFromAPItemId(id));
      this.setAddition(registryId, state);
    }
  }

  private void setProgressive(final GameState52c gameState) {
    final GameState52c state = this.resolveState(gameState);

    final APContext ctx = APContext.getContext();
    final List<Long> receivedItems = ctx.getReceivedItemIDs();

    for(int charIndex = 0; charIndex < 9; charIndex++) {
      final CharacterData2c charData = state.charData_32c[charIndex];
      final Long progressiveId = Additions.getAPItemIdFromCharacterIndex(charIndex);
      final int totalReceived = Collections.frequency(receivedItems, progressiveId);
      final Map<Integer, RegistryId> additions = ProgressiveAdditions.getAdditionsForChar(charIndex);

      for(int i = 1; i <= totalReceived; i++) {
        if(!additions.containsKey(i)) {
          break;
        }

        final RegistryId registryId = additions.get(i);

        final CharacterAdditionStats additionStats = charData.additionStats.get(registryId);
        if(additionStats == null) {
          continue;
        }
        // we want to enable what we've received.
        additionStats.unlockState = UnlockState.UNLOCKED;
      }
    }
  }

  public void setAddition(final RegistryId registryId, final GameState52c gameState) {
    if(!GameEngine.REGISTRIES.additions.hasEntry(registryId)) {
      return;
    }

    final GameState52c state = this.resolveState(gameState);

    for(int charIndex = 0; charIndex < 9; charIndex++) {
      final CharacterData2c charData = state.charData_32c[charIndex];
      final CharacterAdditionStats additionStats = charData.additionStats.get(registryId);
      if(additionStats == null) {
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
      if(additionStats == null) {
        continue;
      }

      if(additionStats.unlockState == UnlockState.UNLOCKED) {
        break;
      }

      for(final Map.Entry<RegistryId, CharacterAdditionStats> entry : charData.additionStats.entrySet()) {
        if(entry.getValue().unlockState == UnlockState.UNLOCKED) {
          charData.selectedAddition_19 = entry.getKey();
          break;
        }
      }
    }
  }

  public void checkUnlock(final CharacterData2c charData) {
    final GameState52c state = this.resolveState(null);
    final APContext apContext = APContext.getContext();

    for(final Map.Entry<RegistryId, CharacterAdditionStats> entry
      : charData.additionStats.entrySet()) {

      final RegistryId registryId = entry.getKey();
      final CharacterAdditionStats stats = entry.getValue();

      final var addition = GameEngine.REGISTRIES.additions.getEntry(registryId).get();
      if(addition == null) {
        continue;
      }

      if(addition.isUnlocked(state, charData, stats)) {
        final Long apId = archipelagoon.ap.mapping.locations.Additions.getAPLocationIdFromRegistryId(registryId);
        if(apId != null) {
          apContext.checkLocation(apId);
        }
      }
    }
  }

  private GameState52c resolveState(final GameState52c state) {
    return state != null ? state : gameState_800babc8;
  }

  public RegistryId getProgressiveAdditionRegistryId(final long itemId) {
    final APContext ctx = APContext.getContext();
    final List<Long> receivedItems = ctx.getReceivedItemIDs();

    final int charIndex = Additions.getCharacterIndexFromAPItemId(itemId);
    if(charIndex == -1) {
      return null;
    }

    final int totalReceived = Collections.frequency(receivedItems, itemId);
    final Map<Integer, RegistryId> additions = ProgressiveAdditions.getAdditionsForChar(charIndex);

    if(!additions.containsKey(totalReceived)) {
      return null;
    }

    return additions.get(totalReceived);
  }
}