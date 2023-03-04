package com.supernoob.atfmd.registry;

import com.supernoob.atfmd.ATFMD;
import com.supernoob.atfmd.object.items.MusicDisc;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.registry.Registry;

public class ModItems {

    public static final Item TWELVE = register("music_disc_12", ModSounds.SOUND_TWELVE);
    public static final Item FOURTEEN = register("music_disc_14", ModSounds.SOUND_FOURTEEN);
    public static final Item FOURTEEN_REVAMPED = register("music_disc_14_revamped", ModSounds.SOUND_FOURTEEN_REVAMPED);
    public static final Item EIGHTEEN = register("music_disc_18", ModSounds.SOUND_EIGHTEEN);
    public static final Item ANTI = register("music_disc_anti", ModSounds.SOUND_ANTI);
    public static final Item ARCADE = register("music_disc_arcade", ModSounds.SOUND_ARCADE);
    public static final Item AXOLOTL = register("music_disc_axolotl", ModSounds.SOUND_AXOLOTL);
    public static final Item BEDROCK = register("music_disc_bedrock", ModSounds.SOUND_BEDROCK);
    public static final Item BIRCH_BOP = register("music_disc_birch_bop", ModSounds.SOUND_BIRCH_BOP);
    public static final Item BRAIN_SPLOSHED = register("music_disc_brain_sploshed", ModSounds.SOUND_BRAIN_SPLOSHED);
    public static final Item BRICKS = register("music_disc_bricks", ModSounds.SOUND_BRICKS);
    public static final Item BRIGHTSIDE = register("music_disc_brightside", ModSounds.SOUND_BRIGHTSIDE);
    public static final Item CARROT = register("music_disc_carrot", ModSounds.SOUND_CARROT);
    public static final Item CHAOS = register("music_disc_chaos", ModSounds.SOUND_CHAOS);
    public static final Item CHARR = register("music_disc_charr", ModSounds.SOUND_CHARR);
    public static final Item CHICKENBOAT = register("music_disc_chickenboat", ModSounds.SOUND_CHICKENBOAT);
    public static final Item CHILL = register("music_disc_chill", ModSounds.SOUND_CHILL);
    public static final Item CHORUS = register("music_disc_chorus", ModSounds.SOUND_CHORUS);
    public static final Item CLAY = register("music_disc_clay", ModSounds.SOUND_CLAY);
    public static final Item CLOUD = register("music_disc_cloud", ModSounds.SOUND_CLOUD);
    public static final Item CORAL_LULLABY = register("music_disc_coral_lullaby", ModSounds.SOUND_CORAL_LULLABY);
    public static final Item CRADLE = register("music_disc_cradle", ModSounds.SOUND_CRADLE);
    public static final Item DEEP = register("music_disc_deep", ModSounds.SOUND_DEEP);
    public static final Item DESCENT = register("music_disc_descent", ModSounds.SOUND_DESCENT);
    public static final Item DOWNWARD = register("music_disc_downward", ModSounds.SOUND_DOWNWARD);
    public static final Item DRIFTER = register("music_disc_drifter", ModSounds.SOUND_DRIFTER);
    public static final Item ENDERWAVE = register("music_disc_enderwave", ModSounds.SOUND_ENDERWAVE);
    public static final Item ETHERAL = register("music_disc_etheral", ModSounds.SOUND_ETHERAL);
    public static final Item EVOKER = register("music_disc_evoker", ModSounds.SOUND_EVOKER);
    public static final Item FINALE = register("music_disc_finale", ModSounds.SOUND_FINALE);
    public static final Item FLEDGLING = register("music_disc_fledgling", ModSounds.SOUND_FLEDGLING);
    public static final Item FLOAT = register("music_disc_float", ModSounds.SOUND_FLOAT);
    public static final Item FORT_STRESS = register("music_disc_fort_stress", ModSounds.SOUND_FORT_STRESS);
    public static final Item FROZEN = register("music_disc_frozen", ModSounds.SOUND_FROZEN);
    public static final Item GHOST = register("music_disc_ghost", ModSounds.SOUND_GHOST);
    public static final Item ICE = register("music_disc_ice", ModSounds.SOUND_ICE);
    public static final Item ICE_AND_RAIN = register("music_disc_ice_and_rain", ModSounds.SOUND_ICE_AND_RAIN);
    public static final Item INDUSTRIAL_GREEN = register("music_disc_industrial_green", ModSounds.SOUND_INDUSTRIAL_GREEN);
    public static final Item INTO_THE_JUNGLE = register("music_disc_into_the_jungle", ModSounds.SOUND_INTO_THE_JUNGLE);
    public static final Item JUKE = register("music_disc_juke", ModSounds.SOUND_JUKE);
    public static final Item LUSH = register("music_disc_lush", ModSounds.SOUND_LUSH);
    public static final Item MELLOWFRUIT = register("music_disc_mellowfruit", ModSounds.SOUND_MELLOWFRUIT);
    public static final Item MOOBLOOM = register("music_disc_moobloom", ModSounds.SOUND_MOOBLOOM);
    public static final Item MOONTHICAL = register("music_disc_moonthical", ModSounds.SOUND_MOONTHICAL);
    public static final Item MUSHROOM = register("music_disc_mushroom", ModSounds.SOUND_MUSHROOM);
    public static final Item MUSHROOM_ISLAND = register("music_disc_mushroom_island", ModSounds.SOUND_MUSHROOM_ISLAND);
    public static final Item OCEAN_DISC = register("music_disc_ocean_disc", ModSounds.SOUND_OCEAN_DISC);
    public static final Item OMEN = register("music_disc_omen", ModSounds.SOUND_OMEN);
    public static final Item ORESTEP = register("music_disc_orestep", ModSounds.SOUND_ORESTEP);
    public static final Item OVER = register("music_disc_over", ModSounds.SOUND_OVER);
    public static final Item OXIDIZATION = register("music_disc_oxidization", ModSounds.SOUND_OXIDIZATION);
    public static final Item PHANTOM = register("music_disc_phantom", ModSounds.SOUND_PHANTOM);
    public static final Item PILLAGED = register("music_disc_pillaged", ModSounds.SOUND_PILLAGED);
    public static final Item PRISM = register("music_disc_prism", ModSounds.SOUND_PRISM);
    public static final Item PRISMARINE = register("music_disc_prismarine", ModSounds.SOUND_PRISMARINE);
    public static final Item PUMPKIN = register("music_disc_pumpkin", ModSounds.SOUND_PUMPKIN);
    public static final Item RANGE = register("music_disc_range", ModSounds.SOUND_RANGE);
    public static final Item REMNANT = register("music_disc_remnant", ModSounds.SOUND_REMNANT);
    public static final Item SCOPOPHOBIA = register("music_disc_scopophobia", ModSounds.SOUND_SCOPOPHOBIA);
    public static final Item SHOCK = register("music_disc_shock", ModSounds.SOUND_SHOCK);
    public static final Item SHULK = register("music_disc_shulk", ModSounds.SOUND_SHULK);
    public static final Item STEVE = register("music_disc_steve", ModSounds.SOUND_STEVE);
    public static final Item STEW = register("music_disc_stew", ModSounds.SOUND_STEW);
    public static final Item STORM = register("music_disc_storm", ModSounds.SOUND_STORM);
    public static final Item STRING = register("music_disc_string", ModSounds.SOUND_STRING);
    public static final Item TALL = register("music_disc_tall", ModSounds.SOUND_TALL);
    public static final Item TIME = register("music_disc_time", ModSounds.SOUND_TIME);
    public static final Item TRICKS = register("music_disc_tricks", ModSounds.SOUND_TRICKS);
    public static final Item TROUBLE_IN_THE_MANSION = register("music_disc_trouble_in_the_mansion", ModSounds.SOUND_TROUBLE_IN_THE_MANSION);
    public static final Item UNDER_A_BEAUTIFULLY_DARK_SKY = register("music_disc_under_a_beautifully_dark_sky", ModSounds.SOUND_UNDER_A_BEAUTIFULLY_DARK_SKY);
    public static final Item VIBRATE = register("music_disc_vibrate", ModSounds.SOUND_VIBRATE);
    public static final Item VOYAGE = register("music_disc_voyage", ModSounds.SOUND_VOYAGE);
    public static final Item WALDEINSAMKEIT = register("music_disc_waldeinsamkeit", ModSounds.SOUND_WALDEINSAMKEIT);
    public static final Item WANDERING_SOUL = register("music_disc_wandering_soul", ModSounds.SOUND_WANDERING_SOUL);
    public static final Item WARPED = register("music_disc_warped", ModSounds.SOUND_WARPED);
    public static final Item WEIRD = register("music_disc_weird", ModSounds.SOUND_WEIRD);
    public static final Item WITHERING = register("music_disc_withering", ModSounds.SOUND_WITHERING);
    public static final Item WOODLAND = register("music_disc_woodland", ModSounds.SOUND_WOODLAND);
    public static final Item WOZZY = register("music_disc_wozzy", ModSounds.SOUND_WOZZY);

    public static Item register(String id, SoundEvent sound) {
        Item.Settings settings = new Item.Settings().rarity(Rarity.RARE).maxCount(1);
        return Registry.register(Registries.ITEM, new Identifier(ATFMD.MOD_ID, id), new MusicDisc(14, sound, settings, 400));
    }

    public static void init() { }

}
