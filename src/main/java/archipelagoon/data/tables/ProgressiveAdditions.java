package archipelagoon.data.tables;

import legend.lodmod.LodAdditions;
import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class ProgressiveAdditions {
  private static final Map<Integer, Map<Integer, RegistryId>> CHARACTER_ADDITION_MAP = new LinkedHashMap<>();

  static {
    final Map<Integer, RegistryId> dart_additions = new LinkedHashMap<>();
    dart_additions.put(1, LodAdditions.DOUBLE_SLASH.getId());
    dart_additions.put(2, LodAdditions.VOLCANO.getId());
    dart_additions.put(3, LodAdditions.BURNING_RUSH.getId());
    dart_additions.put(4, LodAdditions.CRUSH_DANCE.getId());
    dart_additions.put(5, LodAdditions.MADNESS_HERO.getId());
    dart_additions.put(6, LodAdditions.MOON_STRIKE.getId());
    dart_additions.put(7, LodAdditions.BLAZING_DYNAMO.getId());
    CHARACTER_ADDITION_MAP.put(0, dart_additions);

    final Map<Integer, RegistryId> lavitz_additions = new LinkedHashMap<>();
    lavitz_additions.put(1, LodAdditions.HARPOON.getId());
    lavitz_additions.put(2, LodAdditions.SPINNING_CANE.getId());
    lavitz_additions.put(3, LodAdditions.ROD_TYPHOON.getId());
    lavitz_additions.put(4, LodAdditions.GUST_OF_WIND_DANCE.getId());
    lavitz_additions.put(5, LodAdditions.FLOWER_STORM.getId());
    CHARACTER_ADDITION_MAP.put(1, lavitz_additions);

    final Map<Integer, RegistryId> shana_additions = new LinkedHashMap<>();
    CHARACTER_ADDITION_MAP.put(2, shana_additions);

    final Map<Integer, RegistryId> rose_additions = new LinkedHashMap<>();
    rose_additions.put(1, LodAdditions.WHIP_SMACK.getId());
    rose_additions.put(2, LodAdditions.MORE_MORE.getId());
    rose_additions.put(3, LodAdditions.HARD_BLADE.getId());
    rose_additions.put(4, LodAdditions.DEMONS_DANCE.getId());
    CHARACTER_ADDITION_MAP.put(3, rose_additions);

    final Map<Integer, RegistryId> haschel_additions = new LinkedHashMap<>();
    haschel_additions.put(1, LodAdditions.DOUBLE_PUNCH.getId());
    haschel_additions.put(2, LodAdditions.FERRY_OF_STYX.getId());
    haschel_additions.put(3, LodAdditions.SUMMON_4_GODS.getId());
    haschel_additions.put(4, LodAdditions.FIVE_RING_SHATTERING.getId());
    haschel_additions.put(5, LodAdditions.HEX_HAMMER.getId());
    haschel_additions.put(6, LodAdditions.OMNI_SWEEP.getId());
    CHARACTER_ADDITION_MAP.put(4, haschel_additions);

    final Map<Integer, RegistryId> albert_additions = new LinkedHashMap<>();
    albert_additions.put(1, LodAdditions.ALBERT_HARPOON.getId());
    albert_additions.put(2, LodAdditions.ALBERT_SPINNING_CANE.getId());
    albert_additions.put(3, LodAdditions.ALBERT_ROD_TYPHOON.getId());
    albert_additions.put(4, LodAdditions.ALBERT_GUST_OF_WIND_DANCE.getId());
    albert_additions.put(5, LodAdditions.ALBERT_FLOWER_STORM.getId());
    CHARACTER_ADDITION_MAP.put(5, albert_additions);

    final Map<Integer, RegistryId> meru_additions = new LinkedHashMap<>();
    meru_additions.put(1, LodAdditions.DOUBLE_SMACK.getId());
    meru_additions.put(2, LodAdditions.HAMMER_SPIN.getId());
    meru_additions.put(3, LodAdditions.COOL_BOOGIE.getId());
    meru_additions.put(4, LodAdditions.CATS_CRADLE.getId());
    meru_additions.put(5, LodAdditions.PERKY_STEP.getId());
    CHARACTER_ADDITION_MAP.put(6, meru_additions);

    final Map<Integer, RegistryId> kongol_additions = new LinkedHashMap<>();
    kongol_additions.put(1, LodAdditions.PURSUIT.getId());
    kongol_additions.put(2, LodAdditions.INFERNO.getId());
    kongol_additions.put(3, LodAdditions.BONE_CRUSH.getId());
    CHARACTER_ADDITION_MAP.put(7, kongol_additions);

    final Map<Integer, RegistryId> miranda_additions = new LinkedHashMap<>();
    CHARACTER_ADDITION_MAP.put(8, miranda_additions);
  }

  private ProgressiveAdditions() {
  }

  public static Map<Integer, Map<Integer, RegistryId>> getStaticMap() {
    return Collections.unmodifiableMap(CHARACTER_ADDITION_MAP);
  }

  public static Map<Integer, RegistryId> getAdditionsForChar(final int charIndex) {
    return CHARACTER_ADDITION_MAP.get(charIndex);
  }
}
