package archipelagoon.ap.mapping.items;

import legend.lodmod.LodAdditions;
import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Additions {
  private static final Map<Long, String> ADDITION_MAP = new HashMap<>();
  private static final Map<String, Long> ADDITION_MAP_REVERSE = new HashMap<>();

  static {
    //    ADDITION_MAP.put(108_30001L, LodAdditions.dart_progressive_addition.getId().entryId());
    ADDITION_MAP.put(108_30002L, LodAdditions.DOUBLE_SLASH.getId().entryId());
    ADDITION_MAP.put(108_30003L, LodAdditions.VOLCANO.getId().entryId());
    ADDITION_MAP.put(108_30004L, LodAdditions.BURNING_RUSH.getId().entryId());
    ADDITION_MAP.put(108_30005L, LodAdditions.CRUSH_DANCE.getId().entryId());
    ADDITION_MAP.put(108_30006L, LodAdditions.MADNESS_HERO.getId().entryId());
    ADDITION_MAP.put(108_30007L, LodAdditions.MOON_STRIKE.getId().entryId());
    ADDITION_MAP.put(108_30008L, LodAdditions.BLAZING_DYNAMO.getId().entryId());

    //    ADDITION_MAP.put(108_30009L, LodAdditions.lavitz_progressive_addition.getId().entryId());
    ADDITION_MAP.put(108_30010L, LodAdditions.HARPOON.getId().entryId());
    ADDITION_MAP.put(108_30011L, LodAdditions.SPINNING_CANE.getId().entryId());
    ADDITION_MAP.put(108_30012L, LodAdditions.ROD_TYPHOON.getId().entryId());
    ADDITION_MAP.put(108_30013L, LodAdditions.GUST_OF_WIND_DANCE.getId().entryId());
    ADDITION_MAP.put(108_30014L, LodAdditions.FLOWER_STORM.getId().entryId());

    //    ADDITION_MAP.put(108_30015L, LodAdditions.rose_progressive_addition.getId().entryId());
    ADDITION_MAP.put(108_30016L, LodAdditions.WHIP_SMACK.getId().entryId());
    ADDITION_MAP.put(108_30017L, LodAdditions.MORE_MORE.getId().entryId());
    ADDITION_MAP.put(108_30018L, LodAdditions.HARD_BLADE.getId().entryId());
    ADDITION_MAP.put(108_30019L, LodAdditions.DEMONS_DANCE.getId().entryId());

    //    ADDITION_MAP.put(108_30020L, LodAdditions.haschel_progressive_addition.getId().entryId());
    ADDITION_MAP.put(108_30021L, LodAdditions.DOUBLE_PUNCH.getId().entryId());
    ADDITION_MAP.put(108_30022L, LodAdditions.FERRY_OF_STYX.getId().entryId());
    ADDITION_MAP.put(108_30023L, LodAdditions.SUMMON_4_GODS.getId().entryId());
    ADDITION_MAP.put(108_30024L, LodAdditions.FIVE_RING_SHATTERING.getId().entryId());
    ADDITION_MAP.put(108_30025L, LodAdditions.HEX_HAMMER.getId().entryId());
    ADDITION_MAP.put(108_30026L, LodAdditions.OMNI_SWEEP.getId().entryId());

    //    ADDITION_MAP.put(108_30027L, LodAdditions.albert_progressive_addition.getId().entryId());
    ADDITION_MAP.put(108_30028L, LodAdditions.ALBERT_HARPOON.getId().entryId());
    ADDITION_MAP.put(108_30029L, LodAdditions.ALBERT_SPINNING_CANE.getId().entryId());
    ADDITION_MAP.put(108_30030L, LodAdditions.ALBERT_ROD_TYPHOON.getId().entryId());
    ADDITION_MAP.put(108_30031L, LodAdditions.ALBERT_GUST_OF_WIND_DANCE.getId().entryId());
    ADDITION_MAP.put(108_30032L, LodAdditions.ALBERT_FLOWER_STORM.getId().entryId());

    //    ADDITION_MAP.put(108_30033L, LodAdditions.meru_progressive_addition.getId().entryId());
    ADDITION_MAP.put(108_30034L, LodAdditions.DOUBLE_SMACK.getId().entryId());
    ADDITION_MAP.put(108_30035L, LodAdditions.HAMMER_SPIN.getId().entryId());
    ADDITION_MAP.put(108_30036L, LodAdditions.COOL_BOOGIE.getId().entryId());
    ADDITION_MAP.put(108_30037L, LodAdditions.CATS_CRADLE.getId().entryId());
    ADDITION_MAP.put(108_30038L, LodAdditions.PERKY_STEP.getId().entryId());

    //    ADDITION_MAP.put(108_30039L, LodAdditions.kongol_progressive_addition.getId().entryId());
    ADDITION_MAP.put(108_30040L, LodAdditions.PURSUIT.getId().entryId());
    ADDITION_MAP.put(108_30041L, LodAdditions.INFERNO.getId().entryId());
    ADDITION_MAP.put(108_30042L, LodAdditions.BONE_CRUSH.getId().entryId());


    for(final Map.Entry<Long, String> entry : ADDITION_MAP.entrySet()) {
      ADDITION_MAP_REVERSE.put(entry.getValue(), entry.getKey());
    }

    assert ADDITION_MAP.size() == ADDITION_MAP_REVERSE.size();
  }

  private Additions() {
  }

  public static Map<Long, String> getStaticMap() {
    return Collections.unmodifiableMap(ADDITION_MAP);
  }

  private static Map<String, Long> getStaticReverseMap() {
    return Collections.unmodifiableMap(ADDITION_MAP_REVERSE);
  }

  public static Long getAPItemIdFromRegistryId(final RegistryId registryId) {
    return getStaticReverseMap().get(registryId.entryId());
  }

  public static String getEntryIdFromAPItemId(final Long itemId) {
    return getStaticMap().get(itemId);
  }
}
