package archipelagoon.ap.mapping.locations;

import legend.lodmod.LodEncounters;
import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class Enemies {
  private static final Map<Long, String> ENEMY_LOCATIONS = new LinkedHashMap<>();
  private static final Map<String, Long> ENEMY_LOCATIONS_REVERSE = new LinkedHashMap<>();

  static {
    ENEMY_LOCATIONS.put(108_70001L, LodEncounters.ENCOUNTER_SELES_COMMANDER.getId().entryId());
    ENEMY_LOCATIONS.put(108_70002L, LodEncounters.ENCOUNTER_FRUEGEL_HELLENA_WARDEN_HELLENA_WARDEN_SENIOR_WARDEN_SENIOR_WARDEN.getId().entryId());
    ENEMY_LOCATIONS.put(108_70003L, LodEncounters.ENCOUNTER_UROBOLUS.getId().entryId());
    ENEMY_LOCATIONS.put(108_70004L, LodEncounters.ENCOUNTER_SANDORA_ELITE_SANDORA_ELITE_SANDORA_ELITE.getId().entryId());
    ENEMY_LOCATIONS.put(108_70005L, LodEncounters.ENCOUNTER_KONGOL.getId().entryId());
    ENEMY_LOCATIONS.put(108_70006L, LodEncounters.ENCOUNTER_VIRAGE_HEAD_VIRAGE_BODY_VIRAGE_ARM_.getId().entryId());
    ENEMY_LOCATIONS.put(108_70007L, LodEncounters.ENCOUNTER_FIRE_BIRD.getId().entryId());
    ENEMY_LOCATIONS.put(108_70008L, LodEncounters.ENCOUNTER_FEYRBRAND_GREHAM.getId().entryId());
    ENEMY_LOCATIONS.put(108_70009L, LodEncounters.ENCOUNTER_DRAKE_THE_BANDIT.getId().entryId());
    ENEMY_LOCATIONS.put(108_70010L, LodEncounters.ENCOUNTER_SHIRLEY_SHANA_ALBERT.getId().entryId());
    ENEMY_LOCATIONS.put(108_70011L, LodEncounters.ENCOUNTER_GORGAGA.getId().entryId());
    ENEMY_LOCATIONS.put(108_70012L, LodEncounters.ENCOUNTER_SERFIUS.getId().entryId());
    ENEMY_LOCATIONS.put(108_70013L, LodEncounters.ENCOUNTER_DANTON.getId().entryId());
    ENEMY_LOCATIONS.put(108_70014L, LodEncounters.ENCOUNTER_ATLOW.getId().entryId());
    ENEMY_LOCATIONS.put(108_70015L, LodEncounters.ENCOUNTER_LLOYD.getId().entryId());
    ENEMY_LOCATIONS.put(108_70016L, LodEncounters.ENCOUNTER_FRUEGEL_RODRIGUEZ_GUFTAS.getId().entryId());
    ENEMY_LOCATIONS.put(108_70017L, LodEncounters.ENCOUNTER_KONGOL_1.getId().entryId());
    ENEMY_LOCATIONS.put(108_70018L, LodEncounters.ENCOUNTER_EMPEROR_DOEL_DRAGOON_DOEL.getId().entryId());
    ENEMY_LOCATIONS.put(108_70019L, LodEncounters.ENCOUNTER_MAPPI_CRAFTY_THIEF_CRAFTY_THIEF.getId().entryId());
    ENEMY_LOCATIONS.put(108_70020L, LodEncounters.ENCOUNTER_VIRAGE_HEAD_VIRAGE_BODY_VIRAGE_ARM_VIRAGE_ARM_.getId().entryId());
    ENEMY_LOCATIONS.put(108_70021L, LodEncounters.ENCOUNTER_MAPPI_GEHRICH.getId().entryId());
    ENEMY_LOCATIONS.put(108_70022L, LodEncounters.ENCOUNTER_LENUS.getId().entryId());
    ENEMY_LOCATIONS.put(108_70023L, LodEncounters.ENCOUNTER_GHOST_COMMANDER_GHOST_KNIGHT_GHOST_KNIGHT_GHOST_KNIGHT_GHOST_KNIGHT.getId().entryId());
    ENEMY_LOCATIONS.put(108_70024L, LodEncounters.ENCOUNTER_LENUS_REGOLE.getId().entryId());
    ENEMY_LOCATIONS.put(108_70025L, LodEncounters.ENCOUNTER_S_VIRAGE_HEAD_S_VIRAGE_BODY_S_VIRAGE_ARM_.getId().entryId());
    ENEMY_LOCATIONS.put(108_70026L, LodEncounters.ENCOUNTER_GRAND_JEWEL.getId().entryId());
    ENEMY_LOCATIONS.put(108_70027L, LodEncounters.ENCOUNTER_DIVINE_DRAGON_DIVINE_CANNON_DIVINE_BALL.getId().entryId());
    ENEMY_LOCATIONS.put(108_70028L, LodEncounters.ENCOUNTER_WINDIGO.getId().entryId());
    ENEMY_LOCATIONS.put(108_70029L, LodEncounters.ENCOUNTER_LLOYD_DUMMY_LLOYD.getId().entryId());
    ENEMY_LOCATIONS.put(108_70030L, LodEncounters.ENCOUNTER_POLTER_HELM_POLTER_ARMOR_POLTER_SWORD.getId().entryId());
    ENEMY_LOCATIONS.put(108_70031L, LodEncounters.ENCOUNTER_LAST_KRAKEN.getId().entryId());
    ENEMY_LOCATIONS.put(108_70032L, LodEncounters.ENCOUNTER_MAGICIAN_FAUST_MAZO_MAZO_MAZO_MAZO.getId().entryId());
    ENEMY_LOCATIONS.put(108_70033L, LodEncounters.ENCOUNTER_BELZAC.getId().entryId());
    ENEMY_LOCATIONS.put(108_70034L, LodEncounters.ENCOUNTER_DAMIA.getId().entryId());
    ENEMY_LOCATIONS.put(108_70035L, LodEncounters.ENCOUNTER_KANZAS.getId().entryId());
    ENEMY_LOCATIONS.put(108_70036L, LodEncounters.ENCOUNTER_SYUVEIL.getId().entryId());
    ENEMY_LOCATIONS.put(108_70037L, LodEncounters.ENCOUNTER_VECTOR_SELEBUS_KUBILA.getId().entryId());
    ENEMY_LOCATIONS.put(108_70038L, LodEncounters.ENCOUNTER_GHOSTFB_DRAGON_SPIRIT.getTranslationKey());
    ENEMY_LOCATIONS.put(108_70039L, LodEncounters.ENCOUNTER_GHOST_REGOLE_DRAGON_SPIRIT.getId().entryId());
    ENEMY_LOCATIONS.put(108_70040L, LodEncounters.ENCOUNTER_DIVINE_DRAGOON_GHOST_DRAGON_SPIRIT.getId().entryId());
    ENEMY_LOCATIONS.put(108_70041L, LodEncounters.ENCOUNTER_ZACKWELL_LAVITZS_SPIRIT.getId().entryId());
    ENEMY_LOCATIONS.put(108_70042L, LodEncounters.ENCOUNTER_CATERPILLAR_PUPA_IMAGO.getId().entryId());
    ENEMY_LOCATIONS.put(108_70043L, LodEncounters.ENCOUNTER_MICHAEL_MICHAEL_CORE_.getId().entryId());
    ENEMY_LOCATIONS.put(108_70044L, LodEncounters.ENCOUNTER_S_VIRAGE_HEAD_S_VIRAGE_ARM_S_VIRAGE_BODY_.getId().entryId());
    ENEMY_LOCATIONS.put(108_70045L, LodEncounters.ENCOUNTER_ZIEG_FELD_MISSING.getId().entryId());
    ENEMY_LOCATIONS.put(108_70046L, LodEncounters.ENCOUNTER_MELBU_FRAHMA.getId().entryId());
    ENEMY_LOCATIONS.put(108_70047L, LodEncounters.ENCOUNTER_JIANGO.getId().entryId());
    ENEMY_LOCATIONS.put(108_70048L, LodEncounters.ENCOUNTER_KAMUY.getId().entryId());
    ENEMY_LOCATIONS.put(108_70049L, LodEncounters.ENCOUNTER_SANDORA_SOLDIER_COMMANDER_SANDORA_SOLDIER.getId().entryId());
    ENEMY_LOCATIONS.put(108_70050L, LodEncounters.ENCOUNTER_SANDORA_ELITE.getId().entryId());

    for(final Map.Entry<Long, String> entry : ENEMY_LOCATIONS.entrySet()) {
      ENEMY_LOCATIONS_REVERSE.put(entry.getValue(), entry.getKey());
    }
    assert ENEMY_LOCATIONS.size() == ENEMY_LOCATIONS_REVERSE.size();
  }

  private Enemies() {
  }

  public static Map<Long, String> getStaticMap() {
    return Collections.unmodifiableMap(ENEMY_LOCATIONS);
  }

  public static Map<String, Long> getStaticReverseMap() {
    return Collections.unmodifiableMap(ENEMY_LOCATIONS_REVERSE);
  }

  public static Long getAPLocationIdFromRegistryId(final RegistryId registryId) {
    return getStaticReverseMap().get(registryId.entryId());
  }

  public static String getEntryIdFromAPLocationId(final Long locationId) {
    return getStaticMap().get(locationId);
  }
}
