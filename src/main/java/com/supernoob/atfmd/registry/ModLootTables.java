package com.supernoob.atfmd.registry;

import com.supernoob.atfmd.ATFMD;
import net.minecraft.util.Identifier;
import com.supernoob.atfmd.object.LootTable;

public class ModLootTables {

    public static final Identifier ABANDONED_MINESHAFT_ID = new Identifier("minecraft", "chests/abandoned_mineshaft");
    public static final Identifier STRING_LOOTTABLE_ID = new Identifier(ATFMD.MOD_ID, "chests/abandoned_mineshaft");
    public static final Identifier ANCIENT_CITY_ID = new Identifier("minecraft", "chests/ancient_city");
    public static final Identifier DESCENT_LOOTTABLE_ID = new Identifier(ATFMD.MOD_ID, "chests/ancient_city");
    public static final Identifier REMNANT_LOOTTABLE_ID = new Identifier(ATFMD.MOD_ID, "chests/bastion_treasure");
    public static final Identifier BASTION_TRASURE_ID = new Identifier("minecraft", "chests/bastion_treasure");
    public static final Identifier AXOLOTL_LOOTTABLE_ID = new Identifier(ATFMD.MOD_ID, "chests/buried_treasure");
    public static final Identifier BURIED_TRASURE_ID = new Identifier("minecraft", "chests/buried_treasure");
    public static final Identifier END_CITY_LOOTTABLE_ID = new Identifier(ATFMD.MOD_ID, "chests/end_city_treasure");
    public static final Identifier END_CITY_TRASURE_ID = new Identifier("minecraft", "chests/end_city_treasure");
    public static final Identifier FORT_STRESS_LOOTTABLE_ID = new Identifier(ATFMD.MOD_ID, "chests/nether_bridge");
    public static final Identifier NETHER_BRIDGE_ID = new Identifier("minecraft", "chests/nether_bridge");
    public static final Identifier IGLOO_LOOTTABLE_ID = new Identifier(ATFMD.MOD_ID, "chests/igloo_chest");
    public static final Identifier IGLOO_CHEST_ID = new Identifier("minecraft", "chests/igloo_chest");
    public static final Identifier JUNGLE_TEMPLE_LOOTTABLE_ID = new Identifier(ATFMD.MOD_ID, "chests/jungle_temple");
    public static final Identifier JUNGLE_TEMPLE_CHEST_ID = new Identifier("minecraft", "chests/jungle_temple");
    public static final Identifier PHANTOM_LOOTTABLE_ID = new Identifier(ATFMD.MOD_ID, "entities/phantom");
    public static final Identifier PHANTOM_ID = new Identifier("minecraft", "entities/phantom");
    public static final Identifier PILLAGER_LOOTTABLE_ID = new Identifier(ATFMD.MOD_ID, "chests/pillager_outpost");
    public static final Identifier PILLAGER_OUTPOST_ID = new Identifier("minecraft", "chests/pillager_outpost");
    public static final Identifier SHIPWRECK_LOOTTABLE_ID = new Identifier(ATFMD.MOD_ID, "chests/shipwreck_treasure");
    public static final Identifier SHIPWRECK_TRASURE_ID = new Identifier("minecraft", "chests/shipwreck_treasure");
    public static final Identifier UNDERWATER_RUIN_LOOTTABLE_ID = new Identifier(ATFMD.MOD_ID, "chests/underwater_ruin_big");
    public static final Identifier UNDERWATER_RUIN_BIG_ID = new Identifier("minecraft", "chests/underwater_ruin_big");
    public static final Identifier MANSION_LOOTTABLE_ID = new Identifier(ATFMD.MOD_ID, "chests/woodland_mansion");
    public static final Identifier WOODLAND_MANSION_ID = new Identifier("minecraft", "chests/woodland_mansion");
    public static final Identifier ENDERWAVE_LOOTTABLE_ID = new Identifier(ATFMD.MOD_ID, "entities/ender_dragon");
    public static final Identifier ENDER_DRAGON_ID = new Identifier("minecraft", "entities/ender_dragon");
    public static final Identifier FINALE_LOOTTABLE_ID = new Identifier(ATFMD.MOD_ID, "entities/wither");
    public static final Identifier WITHER_ID = new Identifier("minecraft", "entities/wither");
    public static final Identifier FOURTEEN_REVAMP_LOOTTABLE_ID = new Identifier(ATFMD.MOD_ID, "entities/zombie");
    public static final Identifier ZOMBIE_ID = new Identifier("minecraft", "entities/zombie");
    public static final Identifier PRISMARINE_LOOTTABLE_ID = new Identifier(ATFMD.MOD_ID, "entities/elder_guardian");
    public static final Identifier ELDER_GUARDIAN_ID = new Identifier("minecraft", "entities/elder_guardian");
    public static final Identifier TRICKS_LOOTTABLE_ID = new Identifier(ATFMD.MOD_ID, "entities/witch");
    public static final Identifier WITCH_ID = new Identifier("minecraft", "entities/witch");
    public static final Identifier VIBRATE_LOOTTABLE_ID = new Identifier(ATFMD.MOD_ID, "entities/warden");
    public static final Identifier WARDEN_ID = new Identifier("minecraft", "entities/warden");
    public static final Identifier THE_LOST_SOUL_LOOTTABLE_ID = new Identifier(ATFMD.MOD_ID, "entities/ghast");
    public static final Identifier GHAST_ID = new Identifier("minecraft", "entities/ghast");
    public static final Identifier CARROT_LOOTTABLE_ID = new Identifier(ATFMD.MOD_ID, "blocks/carrots");
    public static final Identifier CARROTS_ID = new Identifier("minecraft", "blocks/carrots");

    public static void init() {
        LootTable.ModifyLootTable(ABANDONED_MINESHAFT_ID, STRING_LOOTTABLE_ID);
        LootTable.ModifyLootTable(ANCIENT_CITY_ID, DESCENT_LOOTTABLE_ID);
        LootTable.ModifyLootTable(BASTION_TRASURE_ID, REMNANT_LOOTTABLE_ID);
        LootTable.ModifyLootTable(BURIED_TRASURE_ID, AXOLOTL_LOOTTABLE_ID);
        LootTable.ModifyLootTable(END_CITY_TRASURE_ID, END_CITY_LOOTTABLE_ID);
        LootTable.ModifyLootTable(IGLOO_CHEST_ID, IGLOO_LOOTTABLE_ID);
        LootTable.ModifyLootTable(JUNGLE_TEMPLE_CHEST_ID, JUNGLE_TEMPLE_LOOTTABLE_ID);
        LootTable.ModifyLootTable(NETHER_BRIDGE_ID, FORT_STRESS_LOOTTABLE_ID);
        LootTable.ModifyLootTable(PHANTOM_ID, PHANTOM_LOOTTABLE_ID);
        LootTable.ModifyLootTable(PILLAGER_OUTPOST_ID, PILLAGER_LOOTTABLE_ID);
        LootTable.ModifyLootTable(SHIPWRECK_TRASURE_ID, SHIPWRECK_LOOTTABLE_ID);
        LootTable.ModifyLootTable(UNDERWATER_RUIN_BIG_ID, UNDERWATER_RUIN_LOOTTABLE_ID);
        LootTable.ModifyLootTable(WOODLAND_MANSION_ID, MANSION_LOOTTABLE_ID);
        LootTable.ModifyLootTable(ENDER_DRAGON_ID, ENDERWAVE_LOOTTABLE_ID);
        LootTable.ModifyLootTable(WITHER_ID, FINALE_LOOTTABLE_ID);
        LootTable.ModifyLootTable(ZOMBIE_ID, FOURTEEN_REVAMP_LOOTTABLE_ID);
        LootTable.ModifyLootTable(ELDER_GUARDIAN_ID, PRISMARINE_LOOTTABLE_ID);
        LootTable.ModifyLootTable(WITCH_ID, TRICKS_LOOTTABLE_ID);
        LootTable.ModifyLootTable(WARDEN_ID, VIBRATE_LOOTTABLE_ID);
        LootTable.ModifyLootTable(WARDEN_ID, VIBRATE_LOOTTABLE_ID);
        LootTable.ModifyLootTable(GHAST_ID, THE_LOST_SOUL_LOOTTABLE_ID);
        LootTable.ModifyLootTable(CARROTS_ID, CARROT_LOOTTABLE_ID);
    }
}