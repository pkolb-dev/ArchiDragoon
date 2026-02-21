package archipelagoon.ap.mapping.locations;

import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public final class Goods {
  private static final Map<Long, String> GOOD_LOCATIONS = new LinkedHashMap<>();
  private static final Map<String, Long> GOOD_LOCATIONS_REVERSE = new LinkedHashMap<>();

  static {
    GOOD_LOCATIONS.put(108_80001L, "red_dragoon_spirit");
    GOOD_LOCATIONS.put(108_80002L, "blue_dragoon_spirit");
    GOOD_LOCATIONS.put(108_80003L, "jade_dragoon_spirit");
    GOOD_LOCATIONS.put(108_80004L, "gold_dragoon_spirit");
    GOOD_LOCATIONS.put(108_80005L, "violet_dragoon_spirit");
    GOOD_LOCATIONS.put(108_80006L, "silver_dragoon_spirit");
    GOOD_LOCATIONS.put(108_80007L, "dark_dragoon_spirit");
    GOOD_LOCATIONS.put(108_80008L, "divine_dragoon_spirit");
    GOOD_LOCATIONS.put(108_80009L, "war_bulletin");
    GOOD_LOCATIONS.put(108_80010L, "fathers_stone");
    GOOD_LOCATIONS.put(108_80011L, "prison_key");
    GOOD_LOCATIONS.put(108_80012L, "axe_from_shack");
    GOOD_LOCATIONS.put(108_80013L, "good_spirits");
    //    GOOD_LOCATIONS.put(108_80014L,  "shiny_bag");
    GOOD_LOCATIONS.put(108_80015L, "water_bottle");
    GOOD_LOCATIONS.put(108_80016L, "life_water");
    GOOD_LOCATIONS.put(108_80017L, "magic_oil");
    GOOD_LOCATIONS.put(108_80018L, "yellow_stone");
    GOOD_LOCATIONS.put(108_80019L, "blue_stone");
    GOOD_LOCATIONS.put(108_80020L, "red_stone");
    GOOD_LOCATIONS.put(108_80021L, "letter_from_lynn");
    GOOD_LOCATIONS.put(108_80022L, "pass_for_valley");
    GOOD_LOCATIONS.put(108_80023L, "kates_bouquet");
    GOOD_LOCATIONS.put(108_80024L, "key_to_ship");
    GOOD_LOCATIONS.put(108_80025L, "boat_license");
    GOOD_LOCATIONS.put(108_80026L, "dragon_blocker");
    GOOD_LOCATIONS.put(108_80027L, "moon_gem");
    GOOD_LOCATIONS.put(108_80028L, "moon_dagger");
    GOOD_LOCATIONS.put(108_80029L, "moon_mirror");
    //    GOOD_LOCATIONS.put(108_80030L,  "omega_bomb");
    //    GOOD_LOCATIONS.put(108_80031L,  "omega_master");
    GOOD_LOCATIONS.put(108_80032L, "law_maker");
    GOOD_LOCATIONS.put(108_80033L, "law_output");
    //    GOOD_LOCATIONS.put(108_80034L,  "gold_dragoon_spirit_2");
    //    GOOD_LOCATIONS.put(108_80035L,  "magic_shiny_bag");
    GOOD_LOCATIONS.put(108_80036L, "vanishing_stone");
    GOOD_LOCATIONS.put(108_80037L, "lavitzs_picture");

    for(final Map.Entry<Long, String> entry : GOOD_LOCATIONS.entrySet()) {
      GOOD_LOCATIONS_REVERSE.put(entry.getValue(), entry.getKey());
    }
    assert GOOD_LOCATIONS.size() == GOOD_LOCATIONS_REVERSE.size();
  }

  private Goods() {
  }

  public static Map<Long, String> getStaticMap() {
    return Collections.unmodifiableMap(GOOD_LOCATIONS);
  }

  public static Map<String, Long> getStaticReverseMap() {
    return Collections.unmodifiableMap(GOOD_LOCATIONS_REVERSE);
  }

  public static Long getAPLocationIdFromRegistryId(final RegistryId registryId) {
    return getStaticReverseMap().get(registryId.entryId());
  }

  public static String getEntryIdFromAPLocationId(final Long locationId) {
    return getStaticMap().get(locationId);
  }
}
