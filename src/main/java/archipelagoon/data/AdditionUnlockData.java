package archipelagoon.data;

import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public final class AdditionUnlockData {
  private static final List<Map<Long, Integer>> UNLOCKS = new ArrayList<>();

  private static final Map<Long, Integer> DART_UNLOCKS = new HashMap<>();
  private static final Map<Long, Integer> LAVITZ_UNLOCKS = new HashMap<>();
  private static final Map<Long, Integer> SHANA_UNLOCKS = new HashMap<>();
  private static final Map<Long, Integer> ALBERT_UNLOCKS = new HashMap<>();
  private static final Map<Long, Integer> ROSE_UNLOCKS = new HashMap<>();
  private static final Map<Long, Integer> HASCHEL_UNLOCKS = new HashMap<>();
  private static final Map<Long, Integer> MERU_UNLOCKS = new HashMap<>();
  private static final Map<Long, Integer> KONGOL_UNLOCKS = new HashMap<>();
  private static final Map<Long, Integer> MIRANDA_UNLOCKS = new HashMap<>();
  static {

    DART_UNLOCKS.put(10860000L, 1);
    DART_UNLOCKS.put(10860001L, 2);
    DART_UNLOCKS.put(10860002L, 8);
    DART_UNLOCKS.put(10860003L, 15);
    DART_UNLOCKS.put(10860004L, 22);
    DART_UNLOCKS.put(10860005L, 29);
    DART_UNLOCKS.put(10860006L, -1);
    UNLOCKS.add(DART_UNLOCKS);

    LAVITZ_UNLOCKS.put(108_60020L, 1);
    LAVITZ_UNLOCKS.put(108_60021L, 5);
    LAVITZ_UNLOCKS.put(108_60022L, 7);
    LAVITZ_UNLOCKS.put(108_60023L, 11);
    LAVITZ_UNLOCKS.put(108_60024L, -1);
    UNLOCKS.add(LAVITZ_UNLOCKS);

    UNLOCKS.add(SHANA_UNLOCKS);

    ROSE_UNLOCKS.put(108_60010L, 1);
    ROSE_UNLOCKS.put(108_60011L, 14);
    ROSE_UNLOCKS.put(108_60012L, 19);
    ROSE_UNLOCKS.put(108_60013L, -1);
    UNLOCKS.add(ROSE_UNLOCKS);

    HASCHEL_UNLOCKS.put(108_60040L, 1);
    HASCHEL_UNLOCKS.put(108_60041L, 14);
    HASCHEL_UNLOCKS.put(108_60042L, 18);
    HASCHEL_UNLOCKS.put(108_60043L, 22);
    HASCHEL_UNLOCKS.put(108_60044L, 27);
    HASCHEL_UNLOCKS.put(108_60045L, -1);
    UNLOCKS.add(HASCHEL_UNLOCKS);

    ALBERT_UNLOCKS.put(108_60030L, 1);
    ALBERT_UNLOCKS.put(108_60031L, 5);
    ALBERT_UNLOCKS.put(108_60032L, 7);
    ALBERT_UNLOCKS.put(108_60033L, 11);
    ALBERT_UNLOCKS.put(108_60034L, -1);
    UNLOCKS.add(ALBERT_UNLOCKS);

    MERU_UNLOCKS.put(108_60050L, 1);
    MERU_UNLOCKS.put(108_60051L, 21);
    MERU_UNLOCKS.put(108_60052L, 26);
    MERU_UNLOCKS.put(108_60053L, 30);
    MERU_UNLOCKS.put(108_60054L, -1);
    UNLOCKS.add(MERU_UNLOCKS);

    KONGOL_UNLOCKS.put(108_60060L, 1);
    KONGOL_UNLOCKS.put(108_60061L, 23);
    KONGOL_UNLOCKS.put(108_60062L, -1);
    UNLOCKS.add(KONGOL_UNLOCKS);

    UNLOCKS.add(MIRANDA_UNLOCKS);
  }

  private AdditionUnlockData() {
  }

  public static List<Map<Long, Integer>> getStaticMap() {
    return Collections.unmodifiableList(UNLOCKS);
  }

  public static Map<Long, Integer> getCharUnlocks(final int charId) {
    return Collections.unmodifiableMap(UNLOCKS.get(charId));
  }

  public static Optional<Long> getApId(final int charId, final int level) {
    final Map<Long, Integer> charUnlocks = getCharUnlocks(charId);
    final Map<Integer, Long> charReverseUnlock = new HashMap<>();
    for (final Map.Entry<Long, Integer> entry : charUnlocks.entrySet()) {
      charReverseUnlock.put(entry.getValue(), entry.getKey());
    }
    return charReverseUnlock.get(level).describeConstable();
  }
}
