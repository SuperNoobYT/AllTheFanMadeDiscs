package com.supernoob.atfmd.registry;

import com.supernoob.atfmd.ATFMD;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.loot.entry.LootTableEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModLootTables {

    public static final Identifier ABANDONED_MINESHAFT_ID = new Identifier("minecraft", "chests/abandoned_mineshaft");
    public static final Identifier STRING_LOOTTABLE_ID = new Identifier(ATFMD.MOD_ID, "chests/abandoned_mineshaft");
    public static final Identifier REMNANT_LOOTTABLE_ID = new Identifier(ATFMD.MOD_ID, "chests/bastion_treasure");
    public static final Identifier BASTION_TRASURE_ID = new Identifier("minecraft", "chests/bastion_treasure");
    public static final Identifier AXOLOTL_LOOTTABLE_ID = new Identifier(ATFMD.MOD_ID, "chests/buried_treasure");
    public static final Identifier BURIED_TRASURE_ID = new Identifier("minecraft", "chests/buried_treasure");
    public static final Identifier END_CITY_LOOTTABLE_ID = new Identifier(ATFMD.MOD_ID, "chests/end_city_treasure");
    public static final Identifier END_CITY_TRASURE_ID = new Identifier("minecraft", "chests/end_city_treasure");
    public static final Identifier IGLOO_LOOTTABLE_ID = new Identifier(ATFMD.MOD_ID, "chests/igloo_chest");
    public static final Identifier IGLOO_CHEST_ID = new Identifier("minecraft", "chests/igloo_chest");
    public static final Identifier FORT_STRESS_LOOTTABLE_ID = new Identifier(ATFMD.MOD_ID, "chests/nether_bridge");
    public static final Identifier NETHER_BRIDGE_ID = new Identifier("minecraft", "chests/nether_bridge");
    public static final Identifier PILLAGER_LOOTTABLE_ID = new Identifier(ATFMD.MOD_ID, "chests/pillager_outpost");
    public static final Identifier PILLAGER_OUTPOST_ID = new Identifier("minecraft", "chests/pillager_outpost");
    public static final Identifier SHIPWRECK_LOOTTABLE_ID = new Identifier(ATFMD.MOD_ID, "chests/shipwreck_treasure");
    public static final Identifier SHIPWRECK_TRASURE_ID = new Identifier("minecraft", "chests/shipwreck_treasure");
    public static final Identifier UNDERWATER_RUIN_LOOTTABLE_ID = new Identifier(ATFMD.MOD_ID, "chests/underwater_ruin_big");
    public static final Identifier UNDERWATER_RUIN_BIG_ID = new Identifier("minecraft", "chests/underwater_ruin_big");
    public static final Identifier MANSION_LOOTTABLE_ID = new Identifier(ATFMD.MOD_ID, "chests/woodland_mansion");
    public static final Identifier WOODLAND_MANSION_ID = new Identifier("minecraft", "chests/woodlandmansion");
    public static final Identifier ENDERWAVE_LOOTTABLE_ID = new Identifier(ATFMD.MOD_ID, "entities/ender_dragon");
    public static final Identifier ENDER_DRAGON_ID = new Identifier("minecraft", "entities/ender_dragon");
    public static final Identifier FINALE_LOOTTABLE_ID = new Identifier(ATFMD.MOD_ID, "entities/wither");
    public static final Identifier WITHER_ID = new Identifier("minecraft", "entities/wither");

    public static void init() {
        LootTableLoadingCallback.EVENT.register((resourceManager, manager, id, supplier, setter) -> {
            if (ABANDONED_MINESHAFT_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(LootTableEntry.builder(STRING_LOOTTABLE_ID));
                supplier.withPool(poolBuilder.build());
            }
            if (BURIED_TRASURE_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(LootTableEntry.builder(AXOLOTL_LOOTTABLE_ID));
                supplier.withPool(poolBuilder.build());
            }
            if (BASTION_TRASURE_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(LootTableEntry.builder(REMNANT_LOOTTABLE_ID));
                supplier.withPool(poolBuilder.build());
            }
            if (END_CITY_TRASURE_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(LootTableEntry.builder(END_CITY_LOOTTABLE_ID));
                supplier.withPool(poolBuilder.build());
            }
            if (IGLOO_CHEST_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(LootTableEntry.builder(IGLOO_LOOTTABLE_ID));
                supplier.withPool(poolBuilder.build());
            }
            if (NETHER_BRIDGE_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(LootTableEntry.builder(FORT_STRESS_LOOTTABLE_ID));
                supplier.withPool(poolBuilder.build());
            }
            if (PILLAGER_OUTPOST_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(LootTableEntry.builder(PILLAGER_LOOTTABLE_ID));
                supplier.withPool(poolBuilder.build());
            }
            if (SHIPWRECK_TRASURE_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(LootTableEntry.builder(SHIPWRECK_LOOTTABLE_ID));
                supplier.withPool(poolBuilder.build());
            }
            if (UNDERWATER_RUIN_BIG_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(LootTableEntry.builder(UNDERWATER_RUIN_LOOTTABLE_ID));
                supplier.withPool(poolBuilder.build());
            }
            if (WOODLAND_MANSION_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(LootTableEntry.builder(MANSION_LOOTTABLE_ID));
                supplier.withPool(poolBuilder.build());
            }
            if (ENDER_DRAGON_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(LootTableEntry.builder(ENDERWAVE_LOOTTABLE_ID));
                supplier.withPool(poolBuilder.build());
            }
            if (WITHER_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(LootTableEntry.builder(FINALE_LOOTTABLE_ID));
                supplier.withPool(poolBuilder.build());
            }
        });
    }
}