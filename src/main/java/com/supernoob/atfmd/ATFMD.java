package com.supernoob.atfmd;

import com.supernoob.atfmd.config.ModConfig;
import com.supernoob.atfmd.object.ATFMDStructures;
import com.supernoob.atfmd.registry.ModItems;
import com.supernoob.atfmd.registry.ModLootTables;
import com.supernoob.atfmd.registry.ModSounds;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ATFMD implements ModInitializer {

    public static final String MOD_ID = "all_the_fan_made_discs";
    public static final Logger LOGGER = LogManager.getLogger();

    public static ModConfig CONFIG;

    public static final ItemGroup ATFMD_TAB = FabricItemGroupBuilder.create(
                    new Identifier(MOD_ID, "atfmd_tab"))
            .icon(() -> new ItemStack(ModItems.LUSH))
            .appendItems(stacks -> {
                stacks.add(new ItemStack(ModItems.TWELVE));
                stacks.add(new ItemStack(ModItems.FOURTEEN));
                stacks.add(new ItemStack(ModItems.FOURTEEN_REVAMPED));
                stacks.add(new ItemStack(ModItems.EIGHTEEN));
                stacks.add(new ItemStack(ModItems.ANTI));
                stacks.add(new ItemStack(ModItems.ARCADE));
                stacks.add(new ItemStack(ModItems.AXOLOTL));
                stacks.add(new ItemStack(ModItems.BEDROCK));
                stacks.add(new ItemStack(ModItems.BIRCH_BOP));
                stacks.add(new ItemStack(ModItems.BRAIN_SPLOSHED));
                stacks.add(new ItemStack(ModItems.BRICKS));
                stacks.add(new ItemStack(ModItems.CARROT));
                stacks.add(new ItemStack(ModItems.CHAOS));
                stacks.add(new ItemStack(ModItems.CHARR));
                stacks.add(new ItemStack(ModItems.CHICKENBOAT));
                stacks.add(new ItemStack(ModItems.CHILL));
                stacks.add(new ItemStack(ModItems.CHORUS));
                stacks.add(new ItemStack(ModItems.CLAY));
                stacks.add(new ItemStack(ModItems.CLOUD));
                stacks.add(new ItemStack(ModItems.CORAL_LULLABY));
                stacks.add(new ItemStack(ModItems.CRADLE));
                stacks.add(new ItemStack(ModItems.DEEP));
                stacks.add(new ItemStack(ModItems.DEEPSTATE));
                stacks.add(new ItemStack(ModItems.DESCENT));
                stacks.add(new ItemStack(ModItems.DRIFTER));
                stacks.add(new ItemStack(ModItems.ENDERWAVE));
                stacks.add(new ItemStack(ModItems.ETHERAL));
                stacks.add(new ItemStack(ModItems.EVOKER));
                stacks.add(new ItemStack(ModItems.FINALE));
                stacks.add(new ItemStack(ModItems.FLEDGLING));
                stacks.add(new ItemStack(ModItems.FLOAT));
                stacks.add(new ItemStack(ModItems.FORT_STRESS));
                stacks.add(new ItemStack(ModItems.FROZEN));
                stacks.add(new ItemStack(ModItems.GHOST));
                stacks.add(new ItemStack(ModItems.ICE));
                stacks.add(new ItemStack(ModItems.ICE_AND_RAIN));
                stacks.add(new ItemStack(ModItems.INDUSTRIAL_GREEN));
                stacks.add(new ItemStack(ModItems.INTO_THE_JUNGLE));
                stacks.add(new ItemStack(ModItems.JUKE));
                stacks.add(new ItemStack(ModItems.LUSH));
                stacks.add(new ItemStack(ModItems.MELLOWFRUIT));
                stacks.add(new ItemStack(ModItems.MOOBLOOM));
                stacks.add(new ItemStack(ModItems.MOONTHICAL));
                stacks.add(new ItemStack(ModItems.MUSHROOM));
                stacks.add(new ItemStack(ModItems.MUSHROOM_ISLAND));
                stacks.add(new ItemStack(ModItems.OCEAN_DISC));
                stacks.add(new ItemStack(ModItems.OMEN));
                stacks.add(new ItemStack(ModItems.OVER));
                stacks.add(new ItemStack(ModItems.ORESTEP));
                stacks.add(new ItemStack(ModItems.OXIDIZATION));
                stacks.add(new ItemStack(ModItems.PHANTOM));
                stacks.add(new ItemStack(ModItems.PILLAGED));
                stacks.add(new ItemStack(ModItems.PRISM));
                stacks.add(new ItemStack(ModItems.PRISMARINE));
                stacks.add(new ItemStack(ModItems.PUMPKIN));
                stacks.add(new ItemStack(ModItems.RANGE));
                stacks.add(new ItemStack(ModItems.REMNANT));
                stacks.add(new ItemStack(ModItems.SCOPOPHOBIA));
                stacks.add(new ItemStack(ModItems.SHOCK));
                stacks.add(new ItemStack(ModItems.SHULK));
                stacks.add(new ItemStack(ModItems.STEVE));
                stacks.add(new ItemStack(ModItems.STEW));
                stacks.add(new ItemStack(ModItems.STORM));
                stacks.add(new ItemStack(ModItems.STRING));
                stacks.add(new ItemStack(ModItems.TALL));
                stacks.add(new ItemStack(ModItems.TIME));
                stacks.add(new ItemStack(ModItems.TRICKS));
                stacks.add(new ItemStack(ModItems.TROUBLE_IN_THE_MANSION));
                stacks.add(new ItemStack(ModItems.UNDER_A_BEAUTIFULLY_DARK_SKY));
                stacks.add(new ItemStack(ModItems.VIBRATE));
                stacks.add(new ItemStack(ModItems.VOYAGE));
                stacks.add(new ItemStack(ModItems.WALDEINSAMKEIT));
                stacks.add(new ItemStack(ModItems.WANDERING_SOUL));
                stacks.add(new ItemStack(ModItems.WARPED));
                stacks.add(new ItemStack(ModItems.WEIRD));
                stacks.add(new ItemStack(ModItems.WITHERING));
                stacks.add(new ItemStack(ModItems.WOODLAND));
                stacks.add(new ItemStack(ModItems.WOZZY));
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

