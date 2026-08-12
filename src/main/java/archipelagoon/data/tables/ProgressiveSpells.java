package archipelagoon.data.tables;

import legend.lodmod.LodSpells;
import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class ProgressiveSpells {
  private static final Map<Integer, Map<Integer, RegistryId>> CHARACTER_SPELL_MAP = new LinkedHashMap<>();

  static {
    final Map<Integer, RegistryId> dart_spells = new LinkedHashMap<>();
    dart_spells.put(1, LodSpells.FLAMESHOT.getId());
    dart_spells.put(2, LodSpells.EXPLOSION.getId());
    dart_spells.put(3, LodSpells.FINAL_BURST.getId());
    dart_spells.put(4, LodSpells.RED_EYED_DRAGON.getId());
    dart_spells.put(5, LodSpells.DIVINE_DG_BALL.getId());
    dart_spells.put(6, LodSpells.DIVINE_DG_CANNON.getId());

    CHARACTER_SPELL_MAP.put(0, dart_spells);

    final Map<Integer, RegistryId> lavitz_spells = new LinkedHashMap<>();
    lavitz_spells.put(1, LodSpells.WING_BLASTER.getId());
    lavitz_spells.put(2, LodSpells.BLOSSOM_STORM.getId());
    lavitz_spells.put(3, LodSpells.GASPLESS.getId());
    lavitz_spells.put(4, LodSpells.JADE_DRAGON.getId());
    CHARACTER_SPELL_MAP.put(1, lavitz_spells);

    final Map<Integer, RegistryId> shana_spells = new LinkedHashMap<>();
    shana_spells.put(1, LodSpells.MOON_LIGHT.getId());
    shana_spells.put(2, LodSpells.STAR_CHILDREN.getId());
    shana_spells.put(3, LodSpells.GATES_OF_HEAVEN.getId());
    shana_spells.put(4, LodSpells.WHITE_SILVER_DRAGON.getId());
    CHARACTER_SPELL_MAP.put(2, shana_spells);

    final Map<Integer, RegistryId> rose_spells = new LinkedHashMap<>();
    rose_spells.put(1, LodSpells.ASTRAL_DRAIN.getId());
    rose_spells.put(2, LodSpells.DEATH_DIMENSION.getId());
    rose_spells.put(3, LodSpells.DEMONS_GATE.getId());
    rose_spells.put(4, LodSpells.DARK_DRAGON.getId());
    CHARACTER_SPELL_MAP.put(3, rose_spells);

    final Map<Integer, RegistryId> haschel_spells = new LinkedHashMap<>();
    haschel_spells.put(1, LodSpells.ATOMIC_MIND.getId());
    haschel_spells.put(2, LodSpells.THUNDER_KID.getId());
    haschel_spells.put(3, LodSpells.THUNDER_GOD.getId());
    haschel_spells.put(4, LodSpells.VIOLET_DRAGON.getId());
    CHARACTER_SPELL_MAP.put(4, haschel_spells);

    final Map<Integer, RegistryId> albert_spells = new LinkedHashMap<>();
    albert_spells.put(1, LodSpells.ALBERT_WING_BLASTER.getId());
    albert_spells.put(2, LodSpells.ROSE_STORM.getId());
    albert_spells.put(3, LodSpells.ALBERT_GASPLESS.getId());
    albert_spells.put(4, LodSpells.JADE_DRAGON.getId());
    CHARACTER_SPELL_MAP.put(5, albert_spells);

    final Map<Integer, RegistryId> meru_spells = new LinkedHashMap<>();
    meru_spells.put(1, LodSpells.FREEZING_RING.getId());
    meru_spells.put(2, LodSpells.RAINBOW_BREATH.getId());
    meru_spells.put(3, LodSpells.DIAMOND_DUST.getId());
    meru_spells.put(4, LodSpells.BLUE_SEA_DRAGON.getId());
    CHARACTER_SPELL_MAP.put(6, meru_spells);

    final Map<Integer, RegistryId> kongol_spells = new LinkedHashMap<>();
    kongol_spells.put(1, LodSpells.GRAND_STREAM.getId());
    kongol_spells.put(2, LodSpells.METEOR_STRIKE.getId());
    kongol_spells.put(3, LodSpells.GOLDEN_DRAGON.getId());
    CHARACTER_SPELL_MAP.put(7, kongol_spells);

    final Map<Integer, RegistryId> miranda_spells = new LinkedHashMap<>();
    miranda_spells.put(1, LodSpells.MIRANDA_MOON_LIGHT.getId());
    miranda_spells.put(2, LodSpells.MIRANDA_STAR_CHILDREN.getId());
    miranda_spells.put(3, LodSpells.MIRANDA_GATES_OF_HEAVEN.getId());
    miranda_spells.put(4, LodSpells.WHITE_SILVER_DRAGON.getId());
    CHARACTER_SPELL_MAP.put(8, miranda_spells);
  }

  private ProgressiveSpells() {
  }

  public static Map<Integer, Map<Integer, RegistryId>> getStaticMap() {
    return Collections.unmodifiableMap(CHARACTER_SPELL_MAP);
  }

  public static Map<Integer, RegistryId> getSpellsForChar(final int charIndex) {
    return CHARACTER_SPELL_MAP.get(charIndex);
  }
}


