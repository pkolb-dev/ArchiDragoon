package archipelagoon.ap.mapping.locations;

import legend.lodmod.LodAdditions;
import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class Additions {
  private static final Map<Long, String> ADDITION_LOCATIONS = new LinkedHashMap<>();
  private static final Map<String, Long> ADDITION_LOCATIONS_REVERSE = new LinkedHashMap<>();

  static {
    //    ADDITION_LOCATIONS.put(10860000L, LodAdditions.DOUBLE_SLASH.getId().toString());
    ADDITION_LOCATIONS.put(10860001L, LodAdditions.VOLCANO.getId().toString());
    ADDITION_LOCATIONS.put(10860002L, LodAdditions.BURNING_RUSH.getId().toString());
    ADDITION_LOCATIONS.put(10860003L, LodAdditions.CRUSH_DANCE.getId().toString());
    ADDITION_LOCATIONS.put(10860004L, LodAdditions.MADNESS_HERO.getId().toString());
    ADDITION_LOCATIONS.put(10860005L, LodAdditions.MOON_STRIKE.getId().toString());
    ADDITION_LOCATIONS.put(10860006L, LodAdditions.BLAZING_DYNAMO.getId().toString());

    //    ADDITION_LOCATIONS.put(108_60016L, LodAdditions.WHIP_SMACK.getId().toString());
    ADDITION_LOCATIONS.put(108_60011L, LodAdditions.MORE_MORE.getId().toString());
    ADDITION_LOCATIONS.put(108_60012L, LodAdditions.HARD_BLADE.getId().toString());
    ADDITION_LOCATIONS.put(108_60013L, LodAdditions.DEMONS_DANCE.getId().toString());

    //    ADDITION_LOCATIONS.put(108_60010L, LodAdditions.HARPOON.getId().toString());
    ADDITION_LOCATIONS.put(108_60021L, LodAdditions.SPINNING_CANE.getId().toString());
    ADDITION_LOCATIONS.put(108_60022L, LodAdditions.ROD_TYPHOON.getId().toString());
    ADDITION_LOCATIONS.put(108_60023L, LodAdditions.GUST_OF_WIND_DANCE.getId().toString());
    ADDITION_LOCATIONS.put(108_60024L, LodAdditions.FLOWER_STORM.getId().toString());

    //    ADDITION_LOCATIONS.put(108_60028L, LodAdditions.ALBERT_HARPOON.getId().toString());
    ADDITION_LOCATIONS.put(108_60031L, LodAdditions.ALBERT_SPINNING_CANE.getId().toString());
    ADDITION_LOCATIONS.put(108_60032L, LodAdditions.ALBERT_ROD_TYPHOON.getId().toString());
    ADDITION_LOCATIONS.put(108_60033L, LodAdditions.ALBERT_GUST_OF_WIND_DANCE.getId().toString());
    ADDITION_LOCATIONS.put(108_60034L, LodAdditions.ALBERT_FLOWER_STORM.getId().toString());

    //    ADDITION_LOCATIONS.put(108_60021L, LodAdditions.DOUBLE_PUNCH.getId().toString());
    ADDITION_LOCATIONS.put(108_60041L, LodAdditions.FERRY_OF_STYX.getId().toString());
    ADDITION_LOCATIONS.put(108_60042L, LodAdditions.SUMMON_4_GODS.getId().toString());
    ADDITION_LOCATIONS.put(108_60043L, LodAdditions.FIVE_RING_SHATTERING.getId().toString());
    ADDITION_LOCATIONS.put(108_60044L, LodAdditions.HEX_HAMMER.getId().toString());
    ADDITION_LOCATIONS.put(108_60045L, LodAdditions.OMNI_SWEEP.getId().toString());

    //    ADDITION_LOCATIONS.put(108_60034L, LodAdditions.DOUBLE_SMACK.getId().toString());
    ADDITION_LOCATIONS.put(108_60051L, LodAdditions.HAMMER_SPIN.getId().toString());
    ADDITION_LOCATIONS.put(108_60052L, LodAdditions.COOL_BOOGIE.getId().toString());
    ADDITION_LOCATIONS.put(108_60053L, LodAdditions.CATS_CRADLE.getId().toString());
    ADDITION_LOCATIONS.put(108_60054L, LodAdditions.PERKY_STEP.getId().toString());

    //    ADDITION_LOCATIONS.put(108_60040L, LodAdditions.PURSUIT.getId().toString());
    ADDITION_LOCATIONS.put(108_60061L, LodAdditions.INFERNO.getId().toString());
    ADDITION_LOCATIONS.put(108_60062L, LodAdditions.BONE_CRUSH.getId().toString());

    for(final Map.Entry<Long, String> entry : ADDITION_LOCATIONS.entrySet()) {
      ADDITION_LOCATIONS_REVERSE.put(entry.getValue(), entry.getKey());
    }
    assert ADDITION_LOCATIONS.size() == ADDITION_LOCATIONS_REVERSE.size();
  }

  private Additions() {
  }

  public static Map<Long, String> getStaticMap() {
    return Collections.unmodifiableMap(ADDITION_LOCATIONS);
  }

  private static Map<String, Long> getStaticReverseMap() {
    return Collections.unmodifiableMap(ADDITION_LOCATIONS_REVERSE);
  }

  public static Long getAPLocationIdFromRegistryId(final RegistryId registryId) {
    return getStaticReverseMap().get(registryId.toString());
  }

  public static String getRegistryIdFromAPLocationId(final Long locationId) {
    return getStaticMap().get(locationId);
  }
}
