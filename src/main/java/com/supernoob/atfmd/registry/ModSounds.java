package com.supernoob.atfmd.registry;

import com.supernoob.atfmd.ATFMD;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModSounds {

    public static final SoundEvent SOUND_TWELVE = register("12");
    public static final SoundEvent SOUND_FOURTEEN = register("14");
    public static final SoundEvent SOUND_FOURTEEN_REVAMPED = register("14_revamped");
    public static final SoundEvent SOUND_EIGHTEEN = register("18");
    public static final SoundEvent SOUND_ANTI = register("anti");
    public static final SoundEvent SOUND_ARCADE = register("arcade");
    public static final SoundEvent SOUND_AXOLOTL = register("axolotl");
    public static final SoundEvent SOUND_BEDROCK = register("bedrock");
    public static final SoundEvent SOUND_BIRCH_BOP = register("birch_bop");
    public static final SoundEvent SOUND_BRAIN_SPLOSHED = register("brain_sploshed");
    public static final SoundEvent SOUND_BRICKS = register("bricks");
    public static final SoundEvent SOUND_BRIGHTSIDE = register("brightside");
    public static final SoundEvent SOUND_CARROT = register("carrot");
    public static final SoundEvent SOUND_CHAOS = register("chaos");
    public static final SoundEvent SOUND_CHARR = register("charr");
    public static final SoundEvent SOUND_CHICKENBOAT = register("chickenboat");
    public static final SoundEvent SOUND_CHILL = register("chill");
    public static final SoundEvent SOUND_CHORUS = register("chorus");
    public static final SoundEvent SOUND_CLAY = register("clay");
    public static final SoundEvent SOUND_CLOUD = register("cloud");
    public static final SoundEvent SOUND_CORAL_LULLABY = register("coral_lullaby");
    public static final SoundEvent SOUND_CRADLE = register("cradle");
    public static final SoundEvent SOUND_DEEP = register("deep");
    public static final SoundEvent SOUND_DOWNWARD = register("downward");
    public static final SoundEvent SOUND_DESCENT = register("descent");
    public static final SoundEvent SOUND_DRIFTER = register("drifter");
    public static final SoundEvent SOUND_ENDERWAVE = register("enderwave");
    public static final SoundEvent SOUND_ETHERAL = register("etheral");
    public static final SoundEvent SOUND_EVOKER = register("evoker");
    public static final SoundEvent SOUND_FINALE = register("finale");
    public static final SoundEvent SOUND_FLEDGLING = register("fledgling");
    public static final SoundEvent SOUND_FLOAT = register("float");
    public static final SoundEvent SOUND_FORT_STRESS = register("fort_stress");
    public static final SoundEvent SOUND_FROZEN = register("frozen");
    public static final SoundEvent SOUND_GHOST = register("ghost");
    public static final SoundEvent SOUND_ICE = register("ice");
    public static final SoundEvent SOUND_ICE_AND_RAIN = register("ice_and_rain");
    public static final SoundEvent SOUND_INDUSTRIAL_GREEN = register("industrial_green");
    public static final SoundEvent SOUND_INTO_THE_JUNGLE = register("into_the_jungle");
    public static final SoundEvent SOUND_JUKE = register("juke");
    public static final SoundEvent SOUND_LUSH = register("lush");
    public static final SoundEvent SOUND_MELLOWFRUIT = register("mellowfruit");
    public static final SoundEvent SOUND_MOOBLOOM = register("moobloom");
    public static final SoundEvent SOUND_MOONTHICAL = register("moonthical");
    public static final SoundEvent SOUND_MUSHROOM = register("mushroom");
    public static final SoundEvent SOUND_MUSHROOM_ISLAND = register("mushroom_island");
    public static final SoundEvent SOUND_OCEAN_DISC = register("ocean_disc");
    public static final SoundEvent SOUND_OMEN = register("omen");
    public static final SoundEvent SOUND_ORESTEP = register("orestep");
    public static final SoundEvent SOUND_OVER = register("over");
    public static final SoundEvent SOUND_OXIDIZATION = register("oxidization");
    public static final SoundEvent SOUND_PHANTOM = register("phantom");
    public static final SoundEvent SOUND_PILLAGED = register("pillaged");
    public static final SoundEvent SOUND_PRISM = register("prism");
    public static final SoundEvent SOUND_PRISMARINE = register("prismarine");
    public static final SoundEvent SOUND_PUMPKIN = register("pumpkin");
    public static final SoundEvent SOUND_RANGE = register("range");
    public static final SoundEvent SOUND_REMNANT = register("remnant");
    public static final SoundEvent SOUND_SCOPOPHOBIA = register("scopophobia");
    public static final SoundEvent SOUND_SHOCK = register("shock");
    public static final SoundEvent SOUND_SHULK = register("shulk");
    public static final SoundEvent SOUND_STEVE = register("steve");
    public static final SoundEvent SOUND_STEW = register("stew");
    public static final SoundEvent SOUND_STORM = register("storm");
    public static final SoundEvent SOUND_STRING = register("string");
    public static final SoundEvent SOUND_TALL = register("tall");
    public static final SoundEvent SOUND_THE_LOST_SOUL = register("the_lost_soul");
    public static final SoundEvent SOUND_TIME = register("time");
    public static final SoundEvent SOUND_TRICKS = register("tricks");
    public static final SoundEvent SOUND_TROUBLE_IN_THE_MANSION = register("trouble_in_the_mansion");
    public static final SoundEvent SOUND_UNDER_A_BEAUTIFULLY_DARK_SKY = register("under_a_beautifully_dark_sky");
    public static final SoundEvent SOUND_VIBRATE = register("vibrate");
    public static final SoundEvent SOUND_VOYAGE = register("voyage");
    public static final SoundEvent SOUND_WALDEINSAMKEIT = register("waldeinsamkeit");
    public static final SoundEvent SOUND_WANDERING_SOUL = register("wandering_soul");
    public static final SoundEvent SOUND_WARPED = register("warped");
    public static final SoundEvent SOUND_WEIRD = register("weird");
    public static final SoundEvent SOUND_WITHERING = register("withering");
    public static final SoundEvent SOUND_WOODLAND = register("woodland");
    public static final SoundEvent SOUND_WOZZY = register("wozzy");

    public static SoundEvent register(String name) {
        Identifier id = new Identifier(ATFMD.MOD_ID, name);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }

    public static void init() { }

}
