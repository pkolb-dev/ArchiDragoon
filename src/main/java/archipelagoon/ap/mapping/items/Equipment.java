package archipelagoon.ap.mapping.items;

import legend.lodmod.LodEquipment;
import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Equipment {
  private static final Map<Long, String> EQUIPMENT_MAP = new HashMap<>();
  private static final Map<String, Long> EQUIPMENT_MAP_REVERSE = new HashMap<>();

  static {
    EQUIPMENT_MAP.put(108_10001L, LodEquipment.ACTIVE_RING.getId().toString());
    EQUIPMENT_MAP.put(108_10002L, LodEquipment.AMULET.getId().toString());
    EQUIPMENT_MAP.put(108_10003L, LodEquipment.ANGEL_ROBE.getId().toString());
    EQUIPMENT_MAP.put(108_10004L, LodEquipment.ANGEL_SCARF.getId().toString());
    EQUIPMENT_MAP.put(108_10005L, LodEquipment.ARMET.getId().toString());
    EQUIPMENT_MAP.put(108_10006L, LodEquipment.ARMOR_OF_LEGEND.getId().toString());
    EQUIPMENT_MAP.put(108_10007L, LodEquipment.ARMOR_OF_YORE.getId().toString());
    EQUIPMENT_MAP.put(108_10008L, LodEquipment.ARROW_OF_FORCE.getId().toString());
    EQUIPMENT_MAP.put(108_10009L, LodEquipment.ATTACK_BADGE.getId().toString());
    EQUIPMENT_MAP.put(108_10010L, LodEquipment.AXE.getId().toString());

    EQUIPMENT_MAP.put(108_10011L, LodEquipment.BANDANA.getId().toString());
    EQUIPMENT_MAP.put(108_10012L, LodEquipment.BANDITS_RING.getId().toString());
    EQUIPMENT_MAP.put(108_10013L, LodEquipment.BANDITS_SHOES.getId().toString());
    EQUIPMENT_MAP.put(108_10014L, LodEquipment.BASHER.getId().toString());
    EQUIPMENT_MAP.put(108_10015L, LodEquipment.BASTARD_SWORD.getId().toString());
    EQUIPMENT_MAP.put(108_10016L, LodEquipment.BATTLE_AXE.getId().toString());
    EQUIPMENT_MAP.put(108_10017L, LodEquipment.BEAST_FANG.getId().toString());
    EQUIPMENT_MAP.put(108_10018L, LodEquipment.BEMUSING_ARROW.getId().toString());
    EQUIPMENT_MAP.put(108_10019L, LodEquipment.BLUE_DG_ARMOR.getId().toString());
    EQUIPMENT_MAP.put(108_10020L, LodEquipment.BLUE_SEA_STONE.getId().toString());
    EQUIPMENT_MAP.put(108_10021L, LodEquipment.BRACELET.getId().toString());
    EQUIPMENT_MAP.put(108_10022L, LodEquipment.BRASS_KNUCKLE.getId().toString());
    EQUIPMENT_MAP.put(108_10023L, LodEquipment.BRAVERY_AMULET.getId().toString());
    EQUIPMENT_MAP.put(108_10024L, LodEquipment.BREAST_PLATE.getId().toString());
    EQUIPMENT_MAP.put(108_10025L, LodEquipment.BROAD_SWORD.getId().toString());

    EQUIPMENT_MAP.put(108_10026L, LodEquipment.CAPE.getId().toString());
    EQUIPMENT_MAP.put(108_10027L, LodEquipment.CHAIN_MAIL.getId().toString());
    EQUIPMENT_MAP.put(108_10028L, LodEquipment.CLAYMORE.getId().toString());
    EQUIPMENT_MAP.put(108_10029L, LodEquipment.CLOTHES.getId().toString());
    EQUIPMENT_MAP.put(108_10030L, LodEquipment.COMBAT_SHOES.getId().toString());

    EQUIPMENT_MAP.put(108_10031L, LodEquipment.DANCERS_RING.getId().toString());
    EQUIPMENT_MAP.put(108_10032L, LodEquipment.DANCERS_SHOES.getId().toString());
    EQUIPMENT_MAP.put(108_10033L, LodEquipment.DANCING_DAGGER.getId().toString());
    EQUIPMENT_MAP.put(108_10034L, LodEquipment.DARK_DG_ARMOR.getId().toString());
    EQUIPMENT_MAP.put(108_10035L, LodEquipment.DARKNESS_STONE.getId().toString());
    EQUIPMENT_MAP.put(108_10036L, LodEquipment.DEMON_STILETTO.getId().toString());
    EQUIPMENT_MAP.put(108_10037L, LodEquipment.DESTONE_AMULET.getId().toString());
    EQUIPMENT_MAP.put(108_10038L, LodEquipment.DESTROYER_MACE.getId().toString());
    EQUIPMENT_MAP.put(108_10039L, LodEquipment.DETONATE_ARROW.getId().toString());
    EQUIPMENT_MAP.put(108_10040L, LodEquipment.DIAMOND_CLAW.getId().toString());
    EQUIPMENT_MAP.put(108_10041L, LodEquipment.DISCIPLE_VEST.getId().toString());
    EQUIPMENT_MAP.put(108_10042L, LodEquipment.DRAGON_BUSTER.getId().toString());
    EQUIPMENT_MAP.put(108_10043L, LodEquipment.DRAGON_HELM.getId().toString());
    EQUIPMENT_MAP.put(108_10044L, LodEquipment.DRAGON_SHIELD.getId().toString());

    EQUIPMENT_MAP.put(108_10045L, LodEquipment.ELUDE_CLOAK.getId().toString());
    EQUIPMENT_MAP.put(108_10046L, LodEquipment.EMERALD_EARRING.getId().toString());
    EQUIPMENT_MAP.put(108_10047L, LodEquipment.ENERGY_GIRDLE.getId().toString());

    EQUIPMENT_MAP.put(108_10048L, LodEquipment.FAIRY_SWORD.getId().toString());
    EQUIPMENT_MAP.put(108_10049L, LodEquipment.FAKE_POWER_WRIST.getId().toString());
    EQUIPMENT_MAP.put(108_10050L, LodEquipment.FAKE_SHIELD.getId().toString());
    EQUIPMENT_MAP.put(108_10051L, LodEquipment.FALCHION.getId().toString());
    EQUIPMENT_MAP.put(108_10052L, LodEquipment.FELT_HAT.getId().toString());
    EQUIPMENT_MAP.put(108_10053L, LodEquipment.FLAMBERGE.getId().toString());

    EQUIPMENT_MAP.put(108_10054L, LodEquipment.GIGANTO_ARMOR.getId().toString());
    EQUIPMENT_MAP.put(108_10055L, LodEquipment.GIGANTO_HELM.getId().toString());
    EQUIPMENT_MAP.put(108_10056L, LodEquipment.GIGANTO_RING.getId().toString());
    EQUIPMENT_MAP.put(108_10057L, LodEquipment.GLADIUS.getId().toString());
    EQUIPMENT_MAP.put(108_10058L, LodEquipment.GLAIVE.getId().toString());
    EQUIPMENT_MAP.put(108_10059L, LodEquipment.GOLD_DG_ARMOR.getId().toString());
    EQUIPMENT_MAP.put(108_10060L, LodEquipment.GOLDEN_STONE.getId().toString());
    EQUIPMENT_MAP.put(108_10061L, LodEquipment.GREAT_AXE.getId().toString());
    EQUIPMENT_MAP.put(108_10062L, LodEquipment.GUARD_BADGE.getId().toString());

    EQUIPMENT_MAP.put(108_10063L, LodEquipment.HALBERD.getId().toString());
    EQUIPMENT_MAP.put(108_10064L, LodEquipment.HEAT_BLADE.getId().toString());
    EQUIPMENT_MAP.put(108_10065L, LodEquipment.HEAVY_MACE.getId().toString());
    EQUIPMENT_MAP.put(108_10066L, LodEquipment.HOLY_ANKH.getId().toString());

    EQUIPMENT_MAP.put(108_10067L, LodEquipment.INDORAS_AXE.getId().toString());
    EQUIPMENT_MAP.put(108_10068L, LodEquipment.IRON_KNEEPIECE.getId().toString());
    EQUIPMENT_MAP.put(108_10069L, LodEquipment.IRON_KNUCKLE.getId().toString());

    EQUIPMENT_MAP.put(108_10070L, LodEquipment.JADE_DG_ARMOR.getId().toString());
    EQUIPMENT_MAP.put(108_10071L, LodEquipment.JADE_STONE.getId().toString());
    EQUIPMENT_MAP.put(108_10072L, LodEquipment.JEWELED_CROWN.getId().toString());

    EQUIPMENT_MAP.put(108_10073L, LodEquipment.KNIGHT_HELM.getId().toString());
    EQUIPMENT_MAP.put(108_10074L, LodEquipment.KNIGHT_SHIELD.getId().toString());

    EQUIPMENT_MAP.put(108_10075L, LodEquipment.LANCE.getId().toString());
    EQUIPMENT_MAP.put(108_10076L, LodEquipment.LEATHER_ARMOR.getId().toString());
    EQUIPMENT_MAP.put(108_10077L, LodEquipment.LEATHER_BOOTS.getId().toString());
    EQUIPMENT_MAP.put(108_10078L, LodEquipment.LEATHER_JACKET.getId().toString());
    EQUIPMENT_MAP.put(108_10079L, LodEquipment.LEATHER_SHOES.getId().toString());
    EQUIPMENT_MAP.put(108_10080L, LodEquipment.LEGEND_CASQUE.getId().toString());
    EQUIPMENT_MAP.put(108_10081L, LodEquipment.LION_FUR.getId().toString());
    EQUIPMENT_MAP.put(108_10082L, LodEquipment.LONG_BOW.getId().toString());

    EQUIPMENT_MAP.put(108_10083L, LodEquipment.MACE.getId().toString());
    EQUIPMENT_MAP.put(108_10084L, LodEquipment.MAGE_RING.getId().toString());
    EQUIPMENT_MAP.put(108_10085L, LodEquipment.MAGIC_EGO_BELL.getId().toString());
    EQUIPMENT_MAP.put(108_10086L, LodEquipment.MAGICAL_GREAVES.getId().toString());
    EQUIPMENT_MAP.put(108_10087L, LodEquipment.MAGICAL_HAT.getId().toString());
    EQUIPMENT_MAP.put(108_10088L, LodEquipment.MAGICAL_RING.getId().toString());
    EQUIPMENT_MAP.put(108_10089L, LodEquipment.MASTERS_VEST.getId().toString());
    EQUIPMENT_MAP.put(108_10090L, LodEquipment.MIND_CRUSH.getId().toString());
    EQUIPMENT_MAP.put(108_10091L, LodEquipment.MORNING_STAR.getId().toString());

    EQUIPMENT_MAP.put(108_10092L, LodEquipment.PANIC_GUARD.getId().toString());
    EQUIPMENT_MAP.put(108_10093L, LodEquipment.PARTISAN.getId().toString());
    EQUIPMENT_MAP.put(108_10094L, LodEquipment.PHANTOM_SHIELD.getId().toString());
    EQUIPMENT_MAP.put(108_10095L, LodEquipment.PHOENIX_PLUME.getId().toString());
    EQUIPMENT_MAP.put(108_10096L, LodEquipment.PHYSICAL_RING.getId().toString());
    EQUIPMENT_MAP.put(108_10097L, LodEquipment.PLATE_MAIL.getId().toString());
    EQUIPMENT_MAP.put(108_10098L, LodEquipment.PLATINUM_COLLAR.getId().toString());
    EQUIPMENT_MAP.put(108_10099L, LodEquipment.POISON_GUARD.getId().toString());
    EQUIPMENT_MAP.put(108_10100L, LodEquipment.POWER_WRIST.getId().toString());
    EQUIPMENT_MAP.put(108_10101L, LodEquipment.PRETTY_HAMMER.getId().toString());
    EQUIPMENT_MAP.put(108_10102L, LodEquipment.PROTECTOR.getId().toString());

    EQUIPMENT_MAP.put(108_10103L, LodEquipment.RAINBOW_DRESS.getId().toString());
    EQUIPMENT_MAP.put(108_10104L, LodEquipment.RAINBOW_EARRING.getId().toString());
    EQUIPMENT_MAP.put(108_10105L, LodEquipment.RAPIER.getId().toString());
    EQUIPMENT_MAP.put(108_10106L, LodEquipment.RED_DG_ARMOR.getId().toString());
    EQUIPMENT_MAP.put(108_10107L, LodEquipment.RED_EYE_STONE.getId().toString());
    EQUIPMENT_MAP.put(108_10108L, LodEquipment.ROBE.getId().toString());
    EQUIPMENT_MAP.put(108_10109L, LodEquipment.ROSES_HAIR_BAND.getId().toString());
    EQUIPMENT_MAP.put(108_10110L, LodEquipment.RUBY_RING.getId().toString());

    EQUIPMENT_MAP.put(108_10111L, LodEquipment.SAGES_CLOAK.getId().toString());
    EQUIPMENT_MAP.put(108_10112L, LodEquipment.SAINT_ARMOR.getId().toString());
    EQUIPMENT_MAP.put(108_10113L, LodEquipment.SALLET.getId().toString());
    EQUIPMENT_MAP.put(108_10114L, LodEquipment.SAPPHIRE_PIN.getId().toString());
    EQUIPMENT_MAP.put(108_10115L, LodEquipment.SATORI_VEST.getId().toString());
    EQUIPMENT_MAP.put(108_10116L, LodEquipment.SCALE_ARMOR.getId().toString());
    EQUIPMENT_MAP.put(108_10117L, LodEquipment.SHADOW_CUTTER.getId().toString());
    EQUIPMENT_MAP.put(108_10118L, LodEquipment.SHORT_BOW.getId().toString());
    EQUIPMENT_MAP.put(108_10119L, LodEquipment.SILVER_DG_ARMOR.getId().toString());
    EQUIPMENT_MAP.put(108_10120L, LodEquipment.SILVER_STONE.getId().toString());
    EQUIPMENT_MAP.put(108_10121L, LodEquipment.SILVER_VEST.getId().toString());
    EQUIPMENT_MAP.put(108_10122L, LodEquipment.SOFT_BOOTS.getId().toString());
    EQUIPMENT_MAP.put(108_10123L, LodEquipment.SOUL_EATER.getId().toString());
    EQUIPMENT_MAP.put(108_10124L, LodEquipment.SOUL_HEADBAND.getId().toString());
    EQUIPMENT_MAP.put(108_10125L, LodEquipment.SPARKLE_ARROW.getId().toString());
    EQUIPMENT_MAP.put(108_10126L, LodEquipment.SPARKLE_DRESS.getId().toString());
    EQUIPMENT_MAP.put(108_10127L, LodEquipment.SPEAR.getId().toString());
    EQUIPMENT_MAP.put(108_10128L, LodEquipment.SPEAR_OF_TERROR.getId().toString());
    EQUIPMENT_MAP.put(108_10129L, LodEquipment.SPIRIT_CLOAK.getId().toString());
    EQUIPMENT_MAP.put(108_10130L, LodEquipment.SPIRIT_RING.getId().toString());
    EQUIPMENT_MAP.put(108_10131L, LodEquipment.SPIRITUAL_RING.getId().toString());
    EQUIPMENT_MAP.put(108_10132L, LodEquipment.STARDUST_BOOTS.getId().toString());
    EQUIPMENT_MAP.put(108_10133L, LodEquipment.STUN_GUARD.getId().toString());

    EQUIPMENT_MAP.put(108_10134L, LodEquipment.TALISMAN.getId().toString());
    EQUIPMENT_MAP.put(108_10135L, LodEquipment.THERAPY_RING.getId().toString());
    EQUIPMENT_MAP.put(108_10136L, LodEquipment.THUNDER_FIST.getId().toString());
    EQUIPMENT_MAP.put(108_10137L, LodEquipment.TIARA.getId().toString());
    EQUIPMENT_MAP.put(108_10138L, LodEquipment.TOMAHAWK.getId().toString());
    EQUIPMENT_MAP.put(108_10139L, LodEquipment.TWISTER_GLAIVE.getId().toString());

    EQUIPMENT_MAP.put(108_10140L, LodEquipment.ULTIMATE_WARGOD.getId().toString());

    EQUIPMENT_MAP.put(108_10141L, LodEquipment.VIOLET_DG_ARMOR.getId().toString());
    EQUIPMENT_MAP.put(108_10142L, LodEquipment.VIOLET_STONE.getId().toString());
    EQUIPMENT_MAP.put(108_10143L, LodEquipment.VIRULENT_ARROW.getId().toString());

    EQUIPMENT_MAP.put(108_10144L, LodEquipment.WAR_HAMMER.getId().toString());
    EQUIPMENT_MAP.put(108_10145L, LodEquipment.WARGOD_CALLING.getId().toString());
    EQUIPMENT_MAP.put(108_10146L, LodEquipment.WARGODS_AMULET.getId().toString());
    EQUIPMENT_MAP.put(108_10147L, LodEquipment.WARGODS_SASH.getId().toString());
    EQUIPMENT_MAP.put(108_10148L, LodEquipment.WARRIOR_DRESS.getId().toString());

    for(final Map.Entry<Long, String> entry : EQUIPMENT_MAP.entrySet()) {
      EQUIPMENT_MAP_REVERSE.put(entry.getValue(), entry.getKey());
    }
    assert EQUIPMENT_MAP.size() == EQUIPMENT_MAP_REVERSE.size();
  }

  private Equipment() {
  }

  public static Map<Long, String> getStaticMap() {
    return Collections.unmodifiableMap(EQUIPMENT_MAP);
  }

  private static Map<String, Long> getStaticReverseMap() {
    return Collections.unmodifiableMap(EQUIPMENT_MAP_REVERSE);
  }

  public static Long getAPItemIdFromRegistryId(final RegistryId registryId) {
    return getStaticReverseMap().get(registryId.toString());
  }

  public static String getRegistryIdFromAPItemId(final Long itemId) {
    return getStaticMap().get(itemId);
  }
}
