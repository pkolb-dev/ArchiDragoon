package archipelagoon.ap.mapping.items;

import legend.lodmod.LodAdditions;
import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public final class Additions {
  private static final Map<Long, String> ADDITION_MAP = new HashMap<>();
  private static final Map<String, Long> ADDITION_MAP_REVERSE = new HashMap<>();
  private static final Map<Integer, Long> PROGRESSIVE_ADDITION_MAP = new LinkedHashMap<>();

  static {
    ADDITION_MAP.put(108_30002L, LodAdditions.DOUBLE_SLASH.getId().toString());
    ADDITION_MAP.put(108_30003L, LodAdditions.VOLCANO.getId().toString());
    ADDITION_MAP.put(108_30004L, LodAdditions.BURNING_RUSH.getId().toString());
    ADDITION_MAP.put(108_30005L, LodAdditions.CRUSH_DANCE.getId().toString());
    ADDITION_MAP.put(108_30006L, LodAdditions.MADNESS_HERO.getId().toString());
    ADDITION_MAP.put(108_30007L, LodAdditions.MOON_STRIKE.getId().toString());
    ADDITION_MAP.put(108_30008L, LodAdditions.BLAZING_DYNAMO.getId().toString());

    ADDITION_MAP.put(108_30010L, LodAdditions.HARPOON.getId().toString());
    ADDITION_MAP.put(108_30011L, LodAdditions.SPINNING_CANE.getId().toString());
    ADDITION_MAP.put(108_30012L, LodAdditions.ROD_TYPHOON.getId().toString());
    ADDITION_MAP.put(108_30013L, LodAdditions.GUST_OF_WIND_DANCE.getId().toString());
    ADDITION_MAP.put(108_30014L, LodAdditions.FLOWER_STORM.getId().toString());

    ADDITION_MAP.put(108_30016L, LodAdditions.WHIP_SMACK.getId().toString());
    ADDITION_MAP.put(108_30017L, LodAdditions.MORE_MORE.getId().toString());
    ADDITION_MAP.put(108_30018L, LodAdditions.HARD_BLADE.getId().toString());
    ADDITION_MAP.put(108_30019L, LodAdditions.DEMONS_DANCE.getId().toString());

    ADDITION_MAP.put(108_30021L, LodAdditions.DOUBLE_PUNCH.getId().toString());
    ADDITION_MAP.put(108_30022L, LodAdditions.FERRY_OF_STYX.getId().toString());
    ADDITION_MAP.put(108_30023L, LodAdditions.SUMMON_4_GODS.getId().toString());
    ADDITION_MAP.put(108_30024L, LodAdditions.FIVE_RING_SHATTERING.getId().toString());
    ADDITION_MAP.put(108_30025L, LodAdditions.HEX_HAMMER.getId().toString());
    ADDITION_MAP.put(108_30026L, LodAdditions.OMNI_SWEEP.getId().toString());

    ADDITION_MAP.put(108_30028L, LodAdditions.ALBERT_HARPOON.getId().toString());
    ADDITION_MAP.put(108_30029L, LodAdditions.ALBERT_SPINNING_CANE.getId().toString());
    ADDITION_MAP.put(108_30030L, LodAdditions.ALBERT_ROD_TYPHOON.getId().toString());
    ADDITION_MAP.put(108_30031L, LodAdditions.ALBERT_GUST_OF_WIND_DANCE.getId().toString());
    ADDITION_MAP.put(108_30032L, LodAdditions.ALBERT_FLOWER_STORM.getId().toString());

    ADDITION_MAP.put(108_30034L, LodAdditions.DOUBLE_SMACK.getId().toString());
    ADDITION_MAP.put(108_30035L, LodAdditions.HAMMER_SPIN.getId().toString());
    ADDITION_MAP.put(108_30036L, LodAdditions.COOL_BOOGIE.getId().toString());
    ADDITION_MAP.put(108_30037L, LodAdditions.CATS_CRADLE.getId().toString());
    ADDITION_MAP.put(108_30038L, LodAdditions.PERKY_STEP.getId().toString());

    ADDITION_MAP.put(108_30040L, LodAdditions.PURSUIT.getId().toString());
    ADDITION_MAP.put(108_30041L, LodAdditions.INFERNO.getId().toString());
    ADDITION_MAP.put(108_30042L, LodAdditions.BONE_CRUSH.getId().toString());

    for(final Map.Entry<Long, String> entry : ADDITION_MAP.entrySet()) {
      ADDITION_MAP_REVERSE.put(entry.getValue(), entry.getKey());
    }

    assert ADDITION_MAP.size() == ADDITION_MAP_REVERSE.size();

    PROGRESSIVE_ADDITION_MAP.put(0, 108_30001L);
    PROGRESSIVE_ADDITION_MAP.put(1, 108_30009L);
    PROGRESSIVE_ADDITION_MAP.put(3, 108_30015L);
    PROGRESSIVE_ADDITION_MAP.put(4, 108_30020L);
    PROGRESSIVE_ADDITION_MAP.put(5, 108_30027L);
    PROGRESSIVE_ADDITION_MAP.put(6, 108_30033L);
    PROGRESSIVE_ADDITION_MAP.put(7, 108_30039L);
  }

  private Additions() {
  }

  public static Map<Long, String> getStaticMap() {
    return Collections.unmodifiableMap(ADDITION_MAP);
  }

  private static Map<String, Long> getStaticReverseMap() {
    return Collections.unmodifiableMap(ADDITION_MAP_REVERSE);
  }

  private static Map<Integer, Long> getProgressiveStaticMap() {
    return Collections.unmodifiableMap(PROGRESSIVE_ADDITION_MAP);
  }

  public static Long getAPItemIdFromCharacterIndex(final int characterIndex) {
    if(PROGRESSIVE_ADDITION_MAP.containsKey(characterIndex)) {
      return PROGRESSIVE_ADDITION_MAP.get(characterIndex);
    }
    return null;
  }

  public static Integer getCharacterIndexFromAPItemId(final Long apItemId) {
    if(!PROGRESSIVE_ADDITION_MAP.containsValue(apItemId)) {
      return -1;
    }

    for(final Map.Entry<Integer, Long> entry : PROGRESSIVE_ADDITION_MAP.entrySet()) {
      if(Objects.equals(entry.getValue(), apItemId)) {
        return entry.getKey();
      }
    }

    return -1;
  }

  public static Long getAPItemIdFromRegistryId(final RegistryId registryId) {
    return getStaticReverseMap().get(registryId.toString());
  }

  public static String getRegistryIdFromAPItemId(final Long itemId) {
    return getStaticMap().get(itemId);
  }
}
