package archipelagoon.ap.mapping.items;

import archipelagoon.APGoods;
import legend.lodmod.LodGoods;
import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Goods {
  private static final Map<Long, String> GOOD_MAP = new HashMap<>();
  private static final Map<String, Long> GOOD_MAP_REVERSE = new HashMap<>();

  static {
    GOOD_MAP.put(108_20001L, LodGoods.RED_DRAGOON_SPIRIT.getId().toString());
    GOOD_MAP.put(108_20002L, LodGoods.BLUE_DRAGOON_SPIRIT.getId().toString());
    GOOD_MAP.put(108_20003L, LodGoods.JADE_DRAGOON_SPIRIT.getId().toString());
    GOOD_MAP.put(108_20004L, LodGoods.GOLD_DRAGOON_SPIRIT.getId().toString());
    GOOD_MAP.put(108_20005L, LodGoods.VIOLET_DRAGOON_SPIRIT.getId().toString());
    GOOD_MAP.put(108_20006L, LodGoods.SILVER_DRAGOON_SPIRIT.getId().toString());
    GOOD_MAP.put(108_20007L, LodGoods.DARK_DRAGOON_SPIRIT.getId().toString());
    GOOD_MAP.put(108_20008L, LodGoods.DIVINE_DRAGOON_SPIRIT.getId().toString());

    GOOD_MAP.put(108_20009L, LodGoods.WAR_BULLETIN.getId().toString());
    GOOD_MAP.put(108_20010L, LodGoods.FATHERS_STONE.getId().toString());
    GOOD_MAP.put(108_20011L, LodGoods.PRISON_KEY.getId().toString());
    GOOD_MAP.put(108_20012L, LodGoods.AXE_FROM_THE_SHACK.getId().toString());
    GOOD_MAP.put(108_20013L, LodGoods.GOOD_SPIRITS.getId().toString());
    GOOD_MAP.put(108_20014L, LodGoods.SHINY_BAG.getId().toString());
    GOOD_MAP.put(108_20015L, LodGoods.WATER_BOTTLE.getId().toString());
    GOOD_MAP.put(108_20016L, LodGoods.LIFE_WATER.getId().toString());
    GOOD_MAP.put(108_20017L, LodGoods.MAGIC_OIL.getId().toString());
    GOOD_MAP.put(108_20018L, LodGoods.YELLOW_STONE.getId().toString());
    GOOD_MAP.put(108_20019L, LodGoods.BLUE_STONE.getId().toString());
    GOOD_MAP.put(108_20020L, LodGoods.RED_STONE.getId().toString());
    GOOD_MAP.put(108_20021L, LodGoods.LETTER_FROM_LYNN.getId().toString());
    GOOD_MAP.put(108_20022L, LodGoods.PASS_FOR_VALLEY.getId().toString());
    GOOD_MAP.put(108_20023L, LodGoods.KATES_BOUQUET.getId().toString());
    GOOD_MAP.put(108_20024L, LodGoods.KEY_TO_SHIP.getId().toString());
    GOOD_MAP.put(108_20025L, LodGoods.BOAT_LICENSE.getId().toString());
    GOOD_MAP.put(108_20026L, LodGoods.DRAGON_BLOCKER.getId().toString());
    GOOD_MAP.put(108_20027L, LodGoods.MOON_GEM.getId().toString());
    GOOD_MAP.put(108_20028L, LodGoods.MOON_DAGGER.getId().toString());
    GOOD_MAP.put(108_20029L, LodGoods.MOON_MIRROR.getId().toString());
    GOOD_MAP.put(108_20030L, LodGoods.OMEGA_BOMB.getId().toString());
    GOOD_MAP.put(108_20031L, LodGoods.OMEGA_MASTER.getId().toString());
    GOOD_MAP.put(108_20032L, APGoods.LAW_MAKING_LICENSE.getId().toString());
    GOOD_MAP.put(108_20033L, APGoods.LAW_LAUNCHING_LICENSE.getId().toString());
    GOOD_MAP.put(108_20034L, LodGoods.GOLD_DRAGOON_SPIRIT_2.getId().toString());
    GOOD_MAP.put(108_20035L, LodGoods.MAGIC_SHINY_BAG.getId().toString());
    GOOD_MAP.put(108_20036L, LodGoods.VANISHING_STONE.getId().toString());
    GOOD_MAP.put(108_20037L, LodGoods.LAVITZS_PICTURE.getId().toString());

    for(final Map.Entry<Long, String> entry : GOOD_MAP.entrySet()) {
      GOOD_MAP_REVERSE.put(entry.getValue(), entry.getKey());
    }
    assert GOOD_MAP.size() == GOOD_MAP_REVERSE.size();
  }

  private Goods() {
  }

  public static Map<Long, String> getStaticMap() {
    return Collections.unmodifiableMap(GOOD_MAP);
  }

  private static Map<String, Long> getStaticReverseMap() {
    return Collections.unmodifiableMap(GOOD_MAP_REVERSE);
  }

  public static Long getAPItemIdFromRegistryId(final RegistryId registryId) {
    return getStaticReverseMap().get(registryId.toString());
  }

  public static String getRegistryIdFromAPItemId(final Long itemId) {
    return getStaticMap().get(itemId);
  }
}
