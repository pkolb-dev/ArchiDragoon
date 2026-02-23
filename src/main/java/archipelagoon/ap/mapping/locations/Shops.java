package archipelagoon.ap.mapping.locations;

import legend.lodmod.LodShops;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class Shops {
  private static final Map<String, Map<Integer, Long>> SHOP_LOCATIONS = new LinkedHashMap<>();

  static {
    final Map<Integer, Long> baleEquipmentShop = new LinkedHashMap<>();
    baleEquipmentShop.put(0, 108_50001L);
    baleEquipmentShop.put(1, 108_50002L);
    baleEquipmentShop.put(2, 108_50003L);
    baleEquipmentShop.put(3, 108_50004L);
    baleEquipmentShop.put(4, 108_50005L);
    baleEquipmentShop.put(5, 108_50006L);
    baleEquipmentShop.put(6, 108_50007L);
    baleEquipmentShop.put(7, 108_50008L);
    baleEquipmentShop.put(8, 108_50009L);
    baleEquipmentShop.put(9, 108_50010L);
    SHOP_LOCATIONS.put(LodShops.BALE_EQUIPMENT_SHOP.getId().entryId(), baleEquipmentShop);

    final Map<Integer, Long> serdioItemShop = new LinkedHashMap<>();
    serdioItemShop.put(0, 108_50011L);
    serdioItemShop.put(1, 108_50012L);
    serdioItemShop.put(2, 108_50013L);
    serdioItemShop.put(3, 108_50014L);
    serdioItemShop.put(4, 108_50015L);
    serdioItemShop.put(5, 108_50016L);
    serdioItemShop.put(6, 108_50017L);
    SHOP_LOCATIONS.put(LodShops.SERDIO_ITEM_SHOP.getId().entryId(), serdioItemShop);

    final Map<Integer, Long> lohanEquipmentShop = new LinkedHashMap<>();
    lohanEquipmentShop.put(0, 108_50018L);
    lohanEquipmentShop.put(1, 108_50019L);
    lohanEquipmentShop.put(2, 108_50020L);
    lohanEquipmentShop.put(3, 108_50021L);
    lohanEquipmentShop.put(4, 108_50022L);
    lohanEquipmentShop.put(5, 108_50023L);
    lohanEquipmentShop.put(6, 108_50024L);
    lohanEquipmentShop.put(7, 108_50025L);
    lohanEquipmentShop.put(8, 108_50026L);
    lohanEquipmentShop.put(9, 108_50027L);
    lohanEquipmentShop.put(10, 108_50028L);
    lohanEquipmentShop.put(11, 108_50029L);
    SHOP_LOCATIONS.put(LodShops.LOHAN_EQUIPMENT_SHOP.getId().entryId(), lohanEquipmentShop);

    final Map<Integer, Long> lohanItemShop = new LinkedHashMap<>();
    lohanItemShop.put(0, 108_50030L);
    lohanItemShop.put(1, 108_50031L);
    lohanItemShop.put(2, 108_50032L);
    lohanItemShop.put(3, 108_50033L);
    lohanItemShop.put(4, 108_50034L);
    lohanItemShop.put(5, 108_50035L);
    lohanItemShop.put(6, 108_50036L);
    lohanItemShop.put(7, 108_50037L);
    SHOP_LOCATIONS.put(LodShops.LOHAN_ITEM_SHOP.getId().entryId(), lohanItemShop);

    final Map<Integer, Long> kazasEquipmentShop = new LinkedHashMap<>();
    kazasEquipmentShop.put(0, 108_50038L);
    kazasEquipmentShop.put(1, 108_50039L);
    kazasEquipmentShop.put(2, 108_50040L);
    kazasEquipmentShop.put(3, 108_50041L);
    SHOP_LOCATIONS.put(LodShops.KAZAS_EQUIPMENT_SHOP.getId().entryId(), kazasEquipmentShop);

    final Map<Integer, Long> kazasFortItemShop = new LinkedHashMap<>();
    kazasFortItemShop.put(0, 108_50042L);
    kazasFortItemShop.put(1, 108_50043L);
    kazasFortItemShop.put(2, 108_50044L);
    kazasFortItemShop.put(3, 108_50045L);
    kazasFortItemShop.put(4, 108_50046L);
    SHOP_LOCATIONS.put(LodShops.KAZAS_FORT_ITEM_SHOP.getId().entryId(), kazasFortItemShop);

    final Map<Integer, Long> fletzEquipmentShop = new LinkedHashMap<>();
    fletzEquipmentShop.put(0, 108_50047L);
    fletzEquipmentShop.put(1, 108_50048L);
    fletzEquipmentShop.put(2, 108_50049L);
    fletzEquipmentShop.put(3, 108_50050L);
    fletzEquipmentShop.put(4, 108_50051L);
    fletzEquipmentShop.put(5, 108_50052L);
    fletzEquipmentShop.put(6, 108_50053L);
    fletzEquipmentShop.put(7, 108_50054L);
    fletzEquipmentShop.put(8, 108_50055L);
    fletzEquipmentShop.put(9, 108_50056L);
    SHOP_LOCATIONS.put(LodShops.FLETZ_EQUIPMENT_SHOP.getId().entryId(), fletzEquipmentShop);


    final Map<Integer, Long> fletzItemShop = new LinkedHashMap<>();
    fletzItemShop.put(0, 108_50057L);
    fletzItemShop.put(1, 108_50058L);
    fletzItemShop.put(2, 108_50059L);
    fletzItemShop.put(3, 108_50060L);
    fletzItemShop.put(4, 108_50061L);
    fletzItemShop.put(5, 108_50062L);
    fletzItemShop.put(6, 108_50063L);
    fletzItemShop.put(7, 108_50064L);
    fletzItemShop.put(8, 108_50065L);
    SHOP_LOCATIONS.put(LodShops.FLETZ_ITEM_SHOP.getId().entryId(), fletzItemShop);

    final Map<Integer, Long> donauEquipmentShop = new LinkedHashMap<>();
    donauEquipmentShop.put(0, 108_50066L);
    donauEquipmentShop.put(1, 108_50067L);
    SHOP_LOCATIONS.put(LodShops.DONAU_EQUIPMENT_SHOP.getId().entryId(), donauEquipmentShop);

    final Map<Integer, Long> donauItemShop = new LinkedHashMap<>();
    donauItemShop.put(0, 108_50068L);
    donauItemShop.put(1, 108_50069L);
    donauItemShop.put(2, 108_50070L);
    donauItemShop.put(3, 108_50071L);
    donauItemShop.put(4, 108_50072L);
    donauItemShop.put(5, 108_50073L);
    SHOP_LOCATIONS.put(LodShops.DONAU_ITEM_SHOP.getId().entryId(), donauItemShop);

    final Map<Integer, Long> queenFuryEquipmentShop = new LinkedHashMap<>();
    queenFuryEquipmentShop.put(0, 108_50074L);
    queenFuryEquipmentShop.put(1, 108_50075L);
    queenFuryEquipmentShop.put(2, 108_50076L);
    queenFuryEquipmentShop.put(3, 108_50077L);
    queenFuryEquipmentShop.put(4, 108_50078L);
    SHOP_LOCATIONS.put(LodShops.QUEEN_FURY_EQUIPMENT_SHOP.getId().entryId(), queenFuryEquipmentShop);

    final Map<Integer, Long> queenFuryItemShop = new LinkedHashMap<>();
    queenFuryItemShop.put(0, 108_50079L);
    queenFuryItemShop.put(1, 108_50080L);
    queenFuryItemShop.put(2, 108_50081L);
    queenFuryItemShop.put(3, 108_50082L);
    queenFuryItemShop.put(4, 108_50083L);
    queenFuryItemShop.put(5, 108_50084L);
    queenFuryItemShop.put(6, 108_50085L);
    queenFuryItemShop.put(7, 108_50086L);
    SHOP_LOCATIONS.put(LodShops.QUEEN_FURY_ITEM_SHOP.getId().entryId(), queenFuryItemShop);

    final Map<Integer, Long> fuenoEquipmentShop = new LinkedHashMap<>();
    fuenoEquipmentShop.put(0, 108_50087L);
    fuenoEquipmentShop.put(1, 108_50088L);
    fuenoEquipmentShop.put(2, 108_50089L);
    fuenoEquipmentShop.put(3, 108_50090L);
    fuenoEquipmentShop.put(4, 108_50091L);
    fuenoEquipmentShop.put(5, 108_50092L);
    SHOP_LOCATIONS.put(LodShops.FUENO_EQUIPMENT_SHOP.getId().entryId(), fuenoEquipmentShop);

    final Map<Integer, Long> fuenoItemShop = new LinkedHashMap<>();
    fuenoItemShop.put(0, 108_50093L);
    fuenoItemShop.put(1, 108_50094L);
    fuenoItemShop.put(2, 108_50095L);
    fuenoItemShop.put(3, 108_50096L);
    fuenoItemShop.put(4, 108_50097L);
    fuenoItemShop.put(5, 108_50098L);
    fuenoItemShop.put(6, 108_50099L);
    fuenoItemShop.put(7, 108_50100L);
    SHOP_LOCATIONS.put(LodShops.FUENO_ITEM_SHOP.getId().entryId(), fuenoItemShop);

    final Map<Integer, Long> furniEquipmentShop = new LinkedHashMap<>();
    furniEquipmentShop.put(0, 108_50101L);
    furniEquipmentShop.put(1, 108_50102L);
    furniEquipmentShop.put(2, 108_50103L);
    furniEquipmentShop.put(3, 108_50104L);
    furniEquipmentShop.put(4, 108_50105L);
    furniEquipmentShop.put(5, 108_50106L);
    SHOP_LOCATIONS.put(LodShops.FURNI_EQUIPMENT_SHOP.getId().entryId(), furniEquipmentShop);

    final Map<Integer, Long> furniItemShop = new LinkedHashMap<>();
    furniItemShop.put(0, 108_50107L);
    furniItemShop.put(1, 108_50108L);
    furniItemShop.put(2, 108_50109L);
    furniItemShop.put(3, 108_50110L);
    furniItemShop.put(4, 108_50111L);
    SHOP_LOCATIONS.put(LodShops.FURNI_ITEM_SHOP.getId().entryId(), furniItemShop);

    final Map<Integer, Long> deningradEquipmentShop = new LinkedHashMap<>();
    deningradEquipmentShop.put(0, 108_50112L);
    deningradEquipmentShop.put(1, 108_50113L);
    deningradEquipmentShop.put(2, 108_50114L);
    deningradEquipmentShop.put(3, 108_50115L);
    deningradEquipmentShop.put(4, 108_50116L);
    deningradEquipmentShop.put(5, 108_50117L);
    deningradEquipmentShop.put(6, 108_50118L);
    deningradEquipmentShop.put(7, 108_50119L);
    deningradEquipmentShop.put(8, 108_50120L);
    deningradEquipmentShop.put(9, 108_50121L);
    deningradEquipmentShop.put(11, 108_50122L);
    deningradEquipmentShop.put(12, 108_50123L);
    SHOP_LOCATIONS.put(LodShops.DENINGRAD_EQUIPMENT_SHOP.getId().entryId(), deningradEquipmentShop);

    final Map<Integer, Long> deningradItemShop = new LinkedHashMap<>();
    deningradItemShop.put(0, 108_50124L);
    deningradItemShop.put(1, 108_50125L);
    deningradItemShop.put(2, 108_50126L);
    deningradItemShop.put(3, 108_50127L);
    deningradItemShop.put(4, 108_50128L);
    deningradItemShop.put(5, 108_50129L);
    deningradItemShop.put(6, 108_50130L);
    deningradItemShop.put(7, 108_50131L);
    deningradItemShop.put(8, 108_50132L);
    deningradItemShop.put(9, 108_50133L);
    SHOP_LOCATIONS.put(LodShops.DENINGRAD_ITEM_SHOP.getId().entryId(), deningradItemShop);

    final Map<Integer, Long> winglyForestEquipmentShop = new LinkedHashMap<>();
    winglyForestEquipmentShop.put(0, 108_50134L);
    winglyForestEquipmentShop.put(1, 108_50135L);
    winglyForestEquipmentShop.put(2, 108_50136L);
    winglyForestEquipmentShop.put(3, 108_50137L);
    SHOP_LOCATIONS.put(LodShops.WINGLY_FOREST_EQUIPMENT_SHOP.getId().entryId(), winglyForestEquipmentShop);

    final Map<Integer, Long> winglyForestItemShop = new LinkedHashMap<>();
    winglyForestItemShop.put(0, 108_50138L);
    winglyForestItemShop.put(1, 108_50139L);
    winglyForestItemShop.put(2, 108_50140L);
    winglyForestItemShop.put(3, 108_50141L);
    winglyForestItemShop.put(4, 108_50142L);
    winglyForestItemShop.put(5, 108_50143L);
    winglyForestItemShop.put(6, 108_50144L);
    winglyForestItemShop.put(7, 108_50145L);
    SHOP_LOCATIONS.put(LodShops.WINGLY_FOREST_ITEM_SHOP.getId().entryId(), winglyForestItemShop);

    final Map<Integer, Long> vellwebEquipmentShop = new LinkedHashMap<>();
    vellwebEquipmentShop.put(0, 108_50146L);
    vellwebEquipmentShop.put(1, 108_50147L);
    vellwebEquipmentShop.put(2, 108_50148L);
    vellwebEquipmentShop.put(3, 108_50149L);
    vellwebEquipmentShop.put(4, 108_50150L);
    SHOP_LOCATIONS.put(LodShops.VELLWEB_EQUIPMENT_SHOP.getId().entryId(), vellwebEquipmentShop);

    final Map<Integer, Long> vellwebItemShop = new LinkedHashMap<>();
    vellwebItemShop.put(0, 108_50151L);
    vellwebItemShop.put(1, 108_50152L);
    vellwebItemShop.put(2, 108_50153L);
    vellwebItemShop.put(3, 108_50154L);
    vellwebItemShop.put(4, 108_50155L);
    vellwebItemShop.put(5, 108_50156L);
    vellwebItemShop.put(6, 108_50157L);
    SHOP_LOCATIONS.put(LodShops.VELLWEB_ITEM_SHOP.getId().entryId(), vellwebItemShop);

    final Map<Integer, Long> ularaEquipmentShop = new LinkedHashMap<>();
    ularaEquipmentShop.put(0, 108_50158L);
    ularaEquipmentShop.put(1, 108_50159L);
    ularaEquipmentShop.put(2, 108_50160L);
    ularaEquipmentShop.put(3, 108_50161L);
    ularaEquipmentShop.put(4, 108_50162L);
    ularaEquipmentShop.put(5, 108_50163L);
    ularaEquipmentShop.put(6, 108_50164L);
    ularaEquipmentShop.put(7, 108_50165L);
    ularaEquipmentShop.put(8, 108_50166L);
    SHOP_LOCATIONS.put(LodShops.ULARA_EQUIPMENT_SHOP.getId().entryId(), ularaEquipmentShop);

    final Map<Integer, Long> ularaItemShop = new LinkedHashMap<>();
    ularaItemShop.put(0, 108_50167L);
    ularaItemShop.put(1, 108_50168L);
    ularaItemShop.put(2, 108_50169L);
    ularaItemShop.put(3, 108_50170L);
    ularaItemShop.put(4, 108_50171L);
    ularaItemShop.put(5, 108_50172L);
    ularaItemShop.put(6, 108_50173L);
    ularaItemShop.put(7, 108_50174L);
    ularaItemShop.put(8, 108_50175L);
    ularaItemShop.put(9, 108_50176L);
    ularaItemShop.put(11, 108_50177L);
    SHOP_LOCATIONS.put(LodShops.ULARA_ITEM_SHOP.getId().entryId(), ularaItemShop);

    final Map<Integer, Long> rougeEquipmentShop = new LinkedHashMap<>();
    rougeEquipmentShop.put(0, 108_50178L);
    rougeEquipmentShop.put(1, 108_50179L);
    rougeEquipmentShop.put(2, 108_50180L);
    SHOP_LOCATIONS.put(LodShops.ROUGE_EQUIPMENT_SHOP.getId().entryId(), rougeEquipmentShop);

    final Map<Integer, Long> rougeItemShop = new LinkedHashMap<>();
    rougeItemShop.put(0, 108_50181L);
    rougeItemShop.put(1, 108_50182L);
    rougeItemShop.put(2, 108_50183L);
    rougeItemShop.put(3, 108_50184L);
    rougeItemShop.put(4, 108_50185L);
    rougeItemShop.put(5, 108_50186L);
    rougeItemShop.put(6, 108_50187L);
    SHOP_LOCATIONS.put(LodShops.ROUGE_ITEM_SHOP.getId().entryId(), rougeItemShop);

    final Map<Integer, Long> moonEquipmentShop = new LinkedHashMap<>();
    moonEquipmentShop.put(0, 108_50188L);
    moonEquipmentShop.put(1, 108_50189L);
    moonEquipmentShop.put(2, 108_50190L);
    moonEquipmentShop.put(3, 108_50191L);
    moonEquipmentShop.put(4, 108_50192L);
    moonEquipmentShop.put(5, 108_50193L);
    moonEquipmentShop.put(6, 108_50194L);
    moonEquipmentShop.put(7, 108_50195L);
    moonEquipmentShop.put(8, 108_50196L);
    moonEquipmentShop.put(9, 108_50197L);
    moonEquipmentShop.put(11, 108_50198L);
    moonEquipmentShop.put(12, 108_50199L);
    moonEquipmentShop.put(13, 108_50200L);
    moonEquipmentShop.put(14, 108_50201L);
    moonEquipmentShop.put(15, 108_50202L);
    moonEquipmentShop.put(16, 108_50203L);
    SHOP_LOCATIONS.put(LodShops.MOON_EQUIPMENT_SHOP.getId().entryId(), moonEquipmentShop);

    final Map<Integer, Long> moonItemShop = new LinkedHashMap<>();
    moonItemShop.put(0, 108_50204L);
    moonItemShop.put(1, 108_50205L);
    moonItemShop.put(2, 108_50206L);
    moonItemShop.put(3, 108_50207L);
    moonItemShop.put(4, 108_50208L);
    moonItemShop.put(5, 108_50209L);
    moonItemShop.put(6, 108_50210L);
    moonItemShop.put(7, 108_50211L);
    moonItemShop.put(8, 108_50212L);
    SHOP_LOCATIONS.put(LodShops.MOON_ITEM_SHOP.getId().entryId(), moonItemShop);

    final Map<Integer, Long> hellena01ItemShop = new LinkedHashMap<>();
    hellena01ItemShop.put(0, 108_50213L);
    hellena01ItemShop.put(1, 108_50214L);
    hellena01ItemShop.put(2, 108_50215L);
    SHOP_LOCATIONS.put(LodShops.HELLENA_01_ITEM_SHOP.getId().entryId(), hellena01ItemShop);

    final Map<Integer, Long> kashuaEquipmentShop = new LinkedHashMap<>();
    kashuaEquipmentShop.put(0, 108_50216L);
    kashuaEquipmentShop.put(1, 108_50217L);
    kashuaEquipmentShop.put(2, 108_50218L);
    kashuaEquipmentShop.put(3, 108_50219L);
    kashuaEquipmentShop.put(4, 108_50220L);
    kashuaEquipmentShop.put(5, 108_50221L);
    kashuaEquipmentShop.put(6, 108_50222L);
    SHOP_LOCATIONS.put(LodShops.KASHUA_EQUIPMENT_SHOP.getId().entryId(), kashuaEquipmentShop);

    final Map<Integer, Long> kashuaItemShop = new LinkedHashMap<>();
    kashuaItemShop.put(0, 108_50223L);
    kashuaItemShop.put(1, 108_50224L);
    kashuaItemShop.put(2, 108_50225L);
    kashuaItemShop.put(3, 108_50226L);
    kashuaItemShop.put(4, 108_50227L);
    kashuaItemShop.put(5, 108_50228L);
    SHOP_LOCATIONS.put(LodShops.KASHUA_ITEM_SHOP.getId().entryId(), kashuaItemShop);

    final Map<Integer, Long> fletzAccessoryShop = new LinkedHashMap<>();
    fletzAccessoryShop.put(0, 108_50229L);
    fletzAccessoryShop.put(1, 108_50230L);
    fletzAccessoryShop.put(2, 108_50231L);
    fletzAccessoryShop.put(3, 108_50232L);
    SHOP_LOCATIONS.put(LodShops.FLETZ_ACCESSORY_SHOP.getId().entryId(), fletzAccessoryShop);

    final Map<Integer, Long> forestItemShop = new LinkedHashMap<>();
    forestItemShop.put(0, 108_50233L);
    forestItemShop.put(1, 108_50234L);
    forestItemShop.put(2, 108_50235L);
    forestItemShop.put(3, 108_50236L);
    SHOP_LOCATIONS.put(LodShops.FOREST_ITEM_SHOP.getId().entryId(), forestItemShop);

    final Map<Integer, Long> kazasFortEquipmentShop = new LinkedHashMap<>();
    kazasFortEquipmentShop.put(0, 108_50237L);
    kazasFortEquipmentShop.put(1, 108_50238L);
    SHOP_LOCATIONS.put(LodShops.KAZAS_FORT_EQUIPMENT_SHOP.getId().entryId(), kazasFortEquipmentShop);

    final Map<Integer, Long> volcanoItemShop = new LinkedHashMap<>();
    volcanoItemShop.put(0, 108_50239L);
    volcanoItemShop.put(1, 108_50240L);
    volcanoItemShop.put(2, 108_50241L);
    volcanoItemShop.put(3, 108_50242L);
    volcanoItemShop.put(4, 108_50243L);
    volcanoItemShop.put(5, 108_50244L);
    volcanoItemShop.put(6, 108_50245L);
    SHOP_LOCATIONS.put(LodShops.VOLCANO_ITEM_SHOP.getId().entryId(), volcanoItemShop);

    final Map<Integer, Long> zenebatosEquipmentShop = new LinkedHashMap<>();
    zenebatosEquipmentShop.put(0, 108_50246L);
    zenebatosEquipmentShop.put(1, 108_50247L);
    zenebatosEquipmentShop.put(2, 108_50248L);
    zenebatosEquipmentShop.put(3, 108_50249L);
    zenebatosEquipmentShop.put(4, 108_50250L);
    zenebatosEquipmentShop.put(5, 108_50251L);
    zenebatosEquipmentShop.put(6, 108_50252L);
    zenebatosEquipmentShop.put(7, 108_50253L);
    zenebatosEquipmentShop.put(8, 108_50254L);
    SHOP_LOCATIONS.put(LodShops.ZENEBATOS_EQUIPMENT_SHOP.getId().entryId(), zenebatosEquipmentShop);

    final Map<Integer, Long> zenebatosItemShop = new LinkedHashMap<>();
    zenebatosItemShop.put(0, 108_50255L);
    zenebatosItemShop.put(1, 108_50256L);
    zenebatosItemShop.put(2, 108_50257L);
    zenebatosItemShop.put(3, 108_50258L);
    zenebatosItemShop.put(4, 108_50259L);
    zenebatosItemShop.put(5, 108_50260L);
    zenebatosItemShop.put(6, 108_50261L);
    zenebatosItemShop.put(7, 108_50262L);
    SHOP_LOCATIONS.put(LodShops.ZENEBATOS_ITEM_SHOP.getId().entryId(), zenebatosItemShop);

    final Map<Integer, Long> hellena02ItemShop = new LinkedHashMap<>();
    hellena02ItemShop.put(0, 108_50263L);
    hellena02ItemShop.put(1, 108_50264L);
    hellena02ItemShop.put(2, 108_50265L);
    hellena02ItemShop.put(3, 108_50266L);
    hellena02ItemShop.put(4, 108_50267L);
    hellena02ItemShop.put(5, 108_50268L);
    SHOP_LOCATIONS.put(LodShops.HELLENA_02_ITEM_SHOP.getId().entryId(), hellena02ItemShop);

    final Map<Integer, Long> blackCastleItemShop = new LinkedHashMap<>();
    blackCastleItemShop.put(0, 108_50269L);
    blackCastleItemShop.put(1, 108_50270L);
    blackCastleItemShop.put(2, 108_50271L);
    blackCastleItemShop.put(3, 108_50272L);
    blackCastleItemShop.put(4, 108_50273L);
    blackCastleItemShop.put(5, 108_50274L);
    blackCastleItemShop.put(6, 108_50275L);
    SHOP_LOCATIONS.put(LodShops.BLACK_CASTLE_ITEM_SHOP.getId().entryId(), blackCastleItemShop);
  }

  private Shops() {
  }

  public static Map<String, Map<Integer, Long>> getStaticMap() {
    return Collections.unmodifiableMap(SHOP_LOCATIONS);
  }

  public static List<Long> getLocationIds() {
    return SHOP_LOCATIONS.values().stream()
      .flatMap(locationMap -> locationMap.values().stream()).toList();
  }

  public static Collection<Long> getShopLocationIds(final String shopId) {
    return SHOP_LOCATIONS.get(shopId).values();
  }

  public static Long getLocationId(final String shopId, final int slotIndex) {
    final Map<Integer, Long> slots = SHOP_LOCATIONS.get(shopId);
    if(slots == null) {
      return null;
    }
    return slots.get(slotIndex);
  }

  public static Map<Long, String> getStaticFlatMap() {
    final Map<Long, String> locationMap = new LinkedHashMap<>();
    for(final Map.Entry<String, Map<Integer, Long>> shopInfo : SHOP_LOCATIONS.entrySet()) {
      for(final Map.Entry<Integer, Long> slotInfo : shopInfo.getValue().entrySet()) {
        locationMap.put(slotInfo.getValue(), shopInfo.getKey());
      }
    }

    return Collections.unmodifiableMap(locationMap);
  }
}
