package archipelagoon.ap.mapping.goals;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Goals {
  private static final Map<Integer, String> GOAL_MAP = new HashMap<>();

  static {
    GOAL_MAP.put(1, "emperor_doel_dragoon_doel");
    GOAL_MAP.put(2, "lenus_regole");
    GOAL_MAP.put(3, "lloyd_dummy_lloyd");
    GOAL_MAP.put(4, "melbu_frahma_melbu_frahma_melbu_frahma_melbu_frahma_melbu_frahma");
  }

  private Goals() {
  }

  public static Map<Integer, String> getStaticMap() {
    return Collections.unmodifiableMap(GOAL_MAP);
  }
}
