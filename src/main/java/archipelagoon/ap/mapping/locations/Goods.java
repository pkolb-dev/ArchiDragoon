package archipelagoon.ap.mapping.locations;

import legend.lodmod.LodGoods;
import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class Goods {
  private static final Map<Long, String> GOOD_LOCATIONS = new LinkedHashMap<>();
  private static final Map<String, Long> GOOD_LOCATIONS_REVERSE = new LinkedHashMap<>();

  static {
    GOOD_LOCATIONS.put(108_80001L, LodGoods.RED_DRAGOON_SPIRIT.getId().toString());
    GOOD_LOCATIONS.put(108_80002L, LodGoods.BLUE_DRAGOON_SPIRIT.getId().toString());
    GOOD_LOCATIONS.put(108_80003L, LodGoods.JADE_DRAGOON_SPIRIT.getId().toString());
    GOOD_LOCATIONS.put(108_80004L, LodGoods.GOLD_DRAGOON_SPIRIT.getId().toString());
    GOOD_LOCATIONS.put(108_80005L, LodGoods.VIOLET_DRAGOON_SPIRIT.getId().toString());
    GOOD_LOCATIONS.put(108_80006L, LodGoods.SILVER_DRAGOON_SPIRIT.getId().toString());
    GOOD_LOCATIONS.put(108_80007L, LodGoods.DARK_DRAGOON_SPIRIT.getId().toString());
    GOOD_LOCATIONS.put(108_80008L, LodGoods.DIVINE_DRAGOON_SPIRIT.getId().toString());
    GOOD_LOCATIONS.put(108_80009L, LodGoods.WAR_BULLETIN.getId().toString());
    GOOD_LOCATIONS.put(108_80010L, LodGoods.FATHERS_STONE.getId().toString());
    GOOD_LOCATIONS.put(108_80011L, LodGoods.PRISON_KEY.getId().toString());
    GOOD_LOCATIONS.put(108_80012L, LodGoods.AXE_FROM_THE_SHACK.getId().toString());
    GOOD_LOCATIONS.put(108_80013L, LodGoods.GOOD_SPIRITS.getId().toString());
    GOOD_LOCATIONS.put(108_80014L, LodGoods.SHINY_BAG.getId().toString());
    GOOD_LOCATIONS.put(108_80015L, LodGoods.WATER_BOTTLE.getId().toString());
    GOOD_LOCATIONS.put(108_80016L, LodGoods.LIFE_WATER.getId().toString());
    GOOD_LOCATIONS.put(108_80017L, LodGoods.MAGIC_OIL.getId().toString());
    GOOD_LOCATIONS.put(108_80018L, LodGoods.YELLOW_STONE.getId().toString());
    GOOD_LOCATIONS.put(108_80019L, LodGoods.BLUE_STONE.getId().toString());
    GOOD_LOCATIONS.put(108_80020L, LodGoods.RED_STONE.getId().toString());
    GOOD_LOCATIONS.put(108_80021L, LodGoods.LETTER_FROM_LYNN.getId().toString());
    GOOD_LOCATIONS.put(108_80022L, LodGoods.PASS_FOR_VALLEY.getId().toString());
    GOOD_LOCATIONS.put(108_80023L, LodGoods.KATES_BOUQUET.getId().toString());
    GOOD_LOCATIONS.put(108_80024L, LodGoods.KEY_TO_SHIP.getId().toString());
    GOOD_LOCATIONS.put(108_80025L, LodGoods.BOAT_LICENSE.getId().toString());
    GOOD_LOCATIONS.put(108_80026L, LodGoods.DRAGON_BLOCKER.getId().toString());
    GOOD_LOCATIONS.put(108_80027L, LodGoods.MOON_GEM.getId().toString());
    GOOD_LOCATIONS.put(108_80028L, LodGoods.MOON_DAGGER.getId().toString());
    GOOD_LOCATIONS.put(108_80029L, LodGoods.MOON_MIRROR.getId().toString());
    GOOD_LOCATIONS.put(108_80030L, LodGoods.OMEGA_BOMB.getId().toString());
    GOOD_LOCATIONS.put(108_80031L, LodGoods.OMEGA_MASTER.getId().toString());
    GOOD_LOCATIONS.put(108_80032L, LodGoods.LAW_MAKER.getId().toString());
    GOOD_LOCATIONS.put(108_80033L, LodGoods.LAW_OUTPUT.getId().toString());
    GOOD_LOCATIONS.put(108_80034L, LodGoods.GOLD_DRAGOON_SPIRIT_2.getId().toString());
    GOOD_LOCATIONS.put(108_80035L, LodGoods.MAGIC_SHINY_BAG.getId().toString());
    GOOD_LOCATIONS.put(108_80036L, LodGoods.VANISHING_STONE.getId().toString());
    GOOD_LOCATIONS.put(108_80037L, LodGoods.LAVITZS_PICTURE.getId().toString());

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
    return getStaticReverseMap().get(registryId.toString());
  }

  public static String getRegistryIdFromAPLocationId(final Long locationId) {
    return getStaticMap().get(locationId);
  }
}
