package com.supernoob.atfmd;

import com.supernoob.atfmd.config.ModConfig;
import com.supernoob.atfmd.object.ATFMDStructures;
import com.supernoob.atfmd.registry.ModItems;
import com.supernoob.atfmd.registry.ModLootTables;
import com.supernoob.atfmd.registry.ModSounds;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ATFMD implements ModInitializer {

    public static final String MOD_ID = "all_the_fan_made_discs";
    public static final Logger LOGGER = LogManager.getLogger();

    public static ModConfig CONFIG;

    public static final ItemGroup ATFMD_TAB = FabricItemGroup.builder()
            .displayName(Text.literal("ATFMD"))
            .icon(() -> new ItemStack(ModItems.LUSH))
            .entries((context, entries) -> {
                entries.add(ModItems.TWELVE);
                entries.add(ModItems.FOURTEEN);
                entries.add(ModItems.FOURTEEN_REVAMPED);
                entries.add(ModItems.EIGHTEEN);
                entries.add(ModItems.ANTI);
                entries.add(ModItems.ARCADE);
                entries.add(ModItems.AXOLOTL);
                entries.add(ModItems.BEDROCK);
                entries.add(ModItems.BIRCH_BOP);
                entries.add(ModItems.BRAIN_SPLOSHED);
                entries.add(ModItems.BRICKS);
                entries.add(ModItems.BRIGHTSIDE);
                entries.add(ModItems.CARROT);
                entries.add(ModItems.CHAOS);
                entries.add(ModItems.CHARR);
                entries.add(ModItems.CHICKENBOAT);
                entries.add(ModItems.CHILL);
                entries.add(ModItems.CHORUS);
                entries.add(ModItems.CLAY);
                entries.add(ModItems.CLOUD);
                entries.add(ModItems.CORAL_LULLABY);
                entries.add(ModItems.CRADLE);
                entries.add(ModItems.DEEP);
                entries.add(ModItems.DESCENT);
                entries.add(ModItems.DOWNWARD);
                entries.add(ModItems.DRIFTER);
                entries.add(ModItems.ENDERWAVE);
                entries.add(ModItems.ETHERAL);
                entries.add(ModItems.EVOKER);
                entries.add(ModItems.FINALE);
                entries.add(ModItems.FLEDGLING);
                entries.add(ModItems.FLOAT);
                entries.add(ModItems.FORT_STRESS);
                entries.add(ModItems.FROZEN);
                entries.add(ModItems.GHOST);
                entries.add(ModItems.ICE);
                entries.add(ModItems.ICE_AND_RAIN);
                entries.add(ModItems.INDUSTRIAL_GREEN);
                entries.add(ModItems.INTO_THE_JUNGLE);
                entries.add(ModItems.JUKE);
                entries.add(ModItems.LUSH);
                entries.add(ModItems.MELLOWFRUIT);
                entries.add(ModItems.MOOBLOOM);
                entries.add(ModItems.MOONTHICAL);
                entries.add(ModItems.MUSHROOM);
                entries.add(ModItems.MUSHROOM_ISLAND);
                entries.add(ModItems.OCEAN_DISC);
                entries.add(ModItems.OMEN);
                entries.add(ModItems.ORESTEP);
                entries.add(ModItems.OVER);
                entries.add(ModItems.OXIDIZATION);
                entries.add(ModItems.PHANTOM);
                entries.add(ModItems.PILLAGED);
                entries.add(ModItems.PRISM);
                entries.add(ModItems.PRISMARINE);
                entries.add(ModItems.PUMPKIN);
                entries.add(ModItems.RANGE);
                entries.add(ModItems.REMNANT);
                entries.add(ModItems.SCOPOPHOBIA);
                entries.add(ModItems.SHOCK);
                entries.add(ModItems.SHULK);
                entries.add(ModItems.STEVE);
                entries.add(ModItems.STEW);
                entries.add(ModItems.STORM);
                entries.add(ModItems.STRING);
                entries.add(ModItems.TALL);
                entries.add(ModItems.THE_LOST_SOUL);
                entries.add(ModItems.TIME);
                entries.add(ModItems.TRICKS);
                entries.add(ModItems.TROUBLE_IN_THE_MANSION);
                entries.add(ModItems.UNDER_A_BEAUTIFULLY_DARK_SKY);
                entries.add(ModItems.VIBRATE);
                entries.add(ModItems.VOYAGE);
                entries.add(ModItems.WALDEINSAMKEIT);
                entries.add(ModItems.WANDERING_SOUL);
                entries.add(ModItems.WARPED);
                entries.add(ModItems.WEIRD);
                entries.add(ModItems.WITHERING);
                entries.add(ModItems.WOODLAND);
                entries.add(ModItems.WOZZY);
            })
            .build();
    @Override
    public void onInitialize() {
        ATFMDStructures.registerStructureFeatures();
        ModItems.init();
        ModSounds.init();
        ModLootTables.init();
        ModConfig.init();
    }
}

