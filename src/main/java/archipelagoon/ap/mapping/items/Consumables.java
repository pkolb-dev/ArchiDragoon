package archipelagoon.ap.mapping.items;

import legend.lodmod.LodItems;
import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Consumables {
  private static final Map<Long, String> CONSUMABLE_MAP = new HashMap<>();
  private static final Map<String, Long> CONSUMABLE_MAP_REVERSE = new HashMap<>();

  static {
    CONSUMABLE_MAP.put(108_00001L, LodItems.ANGELS_PRAYER.getId().entryId());
    CONSUMABLE_MAP.put(108_00002L, LodItems.HEALING_POTION.getId().entryId());
    CONSUMABLE_MAP.put(108_00003L, LodItems.HEALING_FOG.getId().entryId());
    CONSUMABLE_MAP.put(108_00004L, LodItems.HEALING_BREEZE.getId().entryId());
    CONSUMABLE_MAP.put(108_00005L, LodItems.HEALING_RAIN.getId().entryId());
    CONSUMABLE_MAP.put(108_00006L, LodItems.MOON_SERENADE.getId().entryId());
    CONSUMABLE_MAP.put(108_00007L, LodItems.SUN_RHAPSODY.getId().entryId());
    CONSUMABLE_MAP.put(108_00008L, LodItems.SPIRIT_POTION.getId().entryId());
    CONSUMABLE_MAP.put(108_00009L, LodItems.BODY_PURIFIER.getId().entryId());
    CONSUMABLE_MAP.put(108_00010L, LodItems.DEPETRIFIER.getId().entryId());
    CONSUMABLE_MAP.put(108_00011L, LodItems.MIND_PURIFIER.getId().entryId());
    CONSUMABLE_MAP.put(108_00012L, LodItems.RECOVERY_BALL.getId().entryId());

    CONSUMABLE_MAP.put(108_00013L, LodItems.BLACK_RAIN.getId().entryId());
    CONSUMABLE_MAP.put(108_00014L, LodItems.BURN_OUT.getId().entryId());
    CONSUMABLE_MAP.put(108_00015L, LodItems.BURNING_WAVE.getId().entryId());
    CONSUMABLE_MAP.put(108_00016L, LodItems.DANCING_RAY.getId().entryId());
    CONSUMABLE_MAP.put(108_00017L, LodItems.DARK_MIST.getId().entryId());
    CONSUMABLE_MAP.put(108_00018L, LodItems.DETONATE_ROCK.getId().entryId());
    CONSUMABLE_MAP.put(108_00019L, LodItems.DOWN_BURST.getId().entryId());
    CONSUMABLE_MAP.put(108_00020L, LodItems.FATAL_BLIZZARD.getId().entryId());
    CONSUMABLE_MAP.put(108_00021L, LodItems.FLASH_HALL.getId().entryId());
    CONSUMABLE_MAP.put(108_00022L, LodItems.FROZEN_JET.getId().entryId());
    CONSUMABLE_MAP.put(108_00023L, LodItems.GRAVITY_GRABBER.getId().entryId());
    CONSUMABLE_MAP.put(108_00024L, LodItems.GUSHING_MAGMA.getId().entryId());
    CONSUMABLE_MAP.put(108_00025L, LodItems.METEOR_FALL.getId().entryId());
    CONSUMABLE_MAP.put(108_00026L, LodItems.NIGHT_RAID.getId().entryId());
    CONSUMABLE_MAP.put(108_00027L, LodItems.PELLET.getId().entryId());
    CONSUMABLE_MAP.put(108_00028L, LodItems.PSYCHE_BOMB.getId().entryId());
    CONSUMABLE_MAP.put(108_00029L, LodItems.PSYCHE_BOMB_X.getId().entryId());
    CONSUMABLE_MAP.put(108_00030L, LodItems.RAVE_TWISTER.getId().entryId());
    CONSUMABLE_MAP.put(108_00031L, LodItems.SPARK_NET.getId().entryId());
    CONSUMABLE_MAP.put(108_00032L, LodItems.SPEAR_FROST.getId().entryId());
    CONSUMABLE_MAP.put(108_00033L, LodItems.SPECTRAL_FLASH.getId().entryId());
    CONSUMABLE_MAP.put(108_00034L, LodItems.SPINNING_GALE.getId().entryId());
    CONSUMABLE_MAP.put(108_00035L, LodItems.THUNDERBOLT.getId().entryId());
    CONSUMABLE_MAP.put(108_00036L, LodItems.TRANS_LIGHT.getId().entryId());
    CONSUMABLE_MAP.put(108_00037L, LodItems.ATTACK_BALL.getId().entryId());

    CONSUMABLE_MAP.put(108_00038L, LodItems.CHARM_POTION.getId().entryId());
    CONSUMABLE_MAP.put(108_00039L, LodItems.MAGIC_SIG_STONE.getId().entryId());
    CONSUMABLE_MAP.put(108_00040L, LodItems.MIDNIGHT_TERROR.getId().entryId());
    CONSUMABLE_MAP.put(108_00041L, LodItems.PANDEMONIUM.getId().entryId());
    CONSUMABLE_MAP.put(108_00042L, LodItems.PANIC_BELL.getId().entryId());
    CONSUMABLE_MAP.put(108_00043L, LodItems.POISON_NEEDLE.getId().entryId());
    CONSUMABLE_MAP.put(108_00044L, LodItems.SACHET.getId().entryId());
    CONSUMABLE_MAP.put(108_00045L, LodItems.SMOKE_BALL.getId().entryId());
    CONSUMABLE_MAP.put(108_00046L, LodItems.STUNNING_HAMMER.getId().entryId());
    CONSUMABLE_MAP.put(108_00047L, LodItems.TOTAL_VANISHING.getId().entryId());


    for(final Map.Entry<Long, String> entry : CONSUMABLE_MAP.entrySet()) {
      CONSUMABLE_MAP_REVERSE.put(entry.getValue(), entry.getKey());
    }
    assert CONSUMABLE_MAP.size() == CONSUMABLE_MAP_REVERSE.size();
  }

  private Consumables() {
  }

  public static Map<Long, String> getStaticMap() {
    return Collections.unmodifiableMap(CONSUMABLE_MAP);
  }

  private static Map<String, Long> getStaticReverseMap() {
    return Collections.unmodifiableMap(CONSUMABLE_MAP_REVERSE);
  }

  public static Long getAPItemIdFromRegistryId(final RegistryId registryId) {
    return getStaticReverseMap().get(registryId.entryId());
  }

  public static String entryIdFromAPItemId(final Long itemId) {
    return getStaticMap().get(itemId);
  }
}
