package archipelagoon.ap.mapping.locations;

import legend.lodmod.LodCharacterTemplates;
import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class DragoonLevels {
  private static final Map<RegistryId, Map<Integer, Long>> CHARACTER_MAGIC_LOCATIONS = new LinkedHashMap<>();

  static {
    final Map<Integer, Long> dart_levels = new LinkedHashMap<>();
    dart_levels.put(2, 10870000L);
    dart_levels.put(3, 10870001L);
    dart_levels.put(4, 10870002L);
    dart_levels.put(5, 10870003L);
    CHARACTER_MAGIC_LOCATIONS.put(LodCharacterTemplates.DART.getId(), dart_levels);

    final Map<Integer, Long> lavitz_spells = new LinkedHashMap<>();
    lavitz_spells.put(2, 10870010L);
    lavitz_spells.put(3, 10870011L);
    lavitz_spells.put(4, 10870012L);
    lavitz_spells.put(5, 10870013L);
    CHARACTER_MAGIC_LOCATIONS.put(LodCharacterTemplates.LAVITZ.getId(), lavitz_spells);

    final Map<Integer, Long> shana_spells = new LinkedHashMap<>();
    shana_spells.put(2, 10870020L);
    shana_spells.put(3, 10870021L);
    shana_spells.put(4, 10870022L);
    shana_spells.put(5, 10870023L);
    CHARACTER_MAGIC_LOCATIONS.put(LodCharacterTemplates.SHANA.getId(), shana_spells);

    final Map<Integer, Long> rose_spells = new LinkedHashMap<>();
    rose_spells.put(2, 10870030L);
    rose_spells.put(3, 10870031L);
    rose_spells.put(4, 10870032L);
    rose_spells.put(5, 10870033L);
    CHARACTER_MAGIC_LOCATIONS.put(LodCharacterTemplates.ROSE.getId(), rose_spells);

    // Haschel
    final Map<Integer, Long> haschel_spells = new LinkedHashMap<>();
    haschel_spells.put(2, 10870040L);
    haschel_spells.put(3, 10870041L);
    haschel_spells.put(4, 10870042L);
    haschel_spells.put(5, 10870043L);
    CHARACTER_MAGIC_LOCATIONS.put(LodCharacterTemplates.HASCHEL.getId(), haschel_spells);

    final Map<Integer, Long> albert_spells = new LinkedHashMap<>();
    albert_spells.put(2, 10870050L);
    albert_spells.put(3, 10870051L);
    albert_spells.put(4, 10870052L);
    albert_spells.put(5, 10870053L);
    CHARACTER_MAGIC_LOCATIONS.put(LodCharacterTemplates.ALBERT.getId(), albert_spells);

    final Map<Integer, Long> meru_spells = new LinkedHashMap<>();
    meru_spells.put(2, 10870060L);
    meru_spells.put(3, 10870061L);
    meru_spells.put(4, 10870062L);
    meru_spells.put(5, 10870063L);
    CHARACTER_MAGIC_LOCATIONS.put(LodCharacterTemplates.MERU.getId(), meru_spells);

    final Map<Integer, Long> kongol_spells = new LinkedHashMap<>();
    kongol_spells.put(2, 10870070L);
    kongol_spells.put(3, 10870071L);
    kongol_spells.put(4, 10870072L);
    kongol_spells.put(5, 10870073L);
    CHARACTER_MAGIC_LOCATIONS.put(LodCharacterTemplates.KONGOL.getId(), kongol_spells);

    final Map<Integer, Long> miranda_spells = new LinkedHashMap<>();
    miranda_spells.put(2, 10870080L);
    miranda_spells.put(3, 10870081L);
    miranda_spells.put(4, 10870082L);
    miranda_spells.put(5, 10870083L);
    CHARACTER_MAGIC_LOCATIONS.put(LodCharacterTemplates.MIRANDA.getId(), miranda_spells);
  }

  private DragoonLevels() {
  }

  public static Map<RegistryId, Map<Integer, Long>> getStaticMap() {
    return Collections.unmodifiableMap(CHARACTER_MAGIC_LOCATIONS);
  }

  public static ArrayList<Long> getAllLocationIds() {
    // create array of longs
    final ArrayList<Long> locations = new ArrayList<>();

    // iterate through magic locations and add each value to the array above
    CHARACTER_MAGIC_LOCATIONS.forEach((id, location) -> {
      locations.addAll(location.values());
    });

    return locations;
  }

  public static Long getLocationId(final RegistryId charId, final int level) {
    try {
      return CHARACTER_MAGIC_LOCATIONS.get(charId).getOrDefault(level, -1L);
    } catch(final Exception e) {
      return -1L;
    }
  }
}
