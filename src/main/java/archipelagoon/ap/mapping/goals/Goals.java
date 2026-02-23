package archipelagoon.ap.mapping.goals;

import legend.lodmod.LodEncounters;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Goals {
  private static final Map<Integer, String> GOAL_MAP = new HashMap<>();

  static {
    GOAL_MAP.put(1, LodEncounters.ENCOUNTER_EMPEROR_DOEL_DRAGOON_DOEL.getId().toString());
    GOAL_MAP.put(2, LodEncounters.ENCOUNTER_LENUS_REGOLE.getId().toString());
    GOAL_MAP.put(3, LodEncounters.ENCOUNTER_LLOYD_DUMMY_LLOYD.getId().toString());
    GOAL_MAP.put(4, LodEncounters.ENCOUNTER_MELBU_FRAHMA.getId().toString());
  }

  private Goals() {
  }

  public static Map<Integer, String> getStaticMap() {
    return Collections.unmodifiableMap(GOAL_MAP);
  }
}
