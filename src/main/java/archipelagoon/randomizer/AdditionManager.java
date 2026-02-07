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

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.IO.print;
import static legend.game.Scus94491BpeSegment_800b.gameState_800babc8;

public final class AdditionManager {
  private static final AdditionManager INSTANCE = new AdditionManager();
  public static AdditionManager getInstance() {
    return INSTANCE;
  }

  private AdditionManager() {}
//
//  private final AdditionUnlockParser additionUnlockParser = AdditionUnlockParser.getInstance();

//  private final Map<Integer, AdditionUnlock> additions = new HashMap<>();
//
  public void initialize() {
    APContext ctx = APContext.getContext();
  }

  public void updateState(final GameState52c state) {
    final APContext ctx = APContext.getContext();
    final List<Long> receivedItemIDs = ctx.getReceivedItemIDs();
    final Map<Long, String> filteredMap = Additions.getStaticMap().entrySet().stream()
      .filter(entry -> receivedItemIDs.contains(entry.getKey()))
      .collect(Collectors.toMap(
        Map.Entry::getKey,
        Map.Entry::getValue
      ));

    for (final CharacterData2c charData : state.charData_32c) {
      for (final var set : charData.additionStats.entrySet()) {
        print("Testing");
      }
    }

  }

  public void clearAdditions() {
    for(int charIndex = 0; charIndex < 9; charIndex++) {
      final CharacterData2c charData = gameState_800babc8.charData_32c[charIndex];

      charData.additionStats.forEach((key, value) -> {
        value.unlockState = UnlockState.LOCKED;
      });
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
      this.setAddition(registryId, true);
    }
  }

  public void setAddition(final RegistryId registryId, final boolean unlocked) {
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
}