package com.supernoob.atfmd.object;

import net.fabricmc.fabric.api.loot.v2.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.LootTableEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.util.Identifier;

public class LootTable {

    public static void ModifyLootTable(Identifier baseloottable, Identifier addedloottable) {
        LootTableEvents.MODIFY.register((resourceManager, manager, id, supplier, setter) -> {
            if (baseloottable.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.copyOf(LootPool.builder().build())
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(LootTableEntry.builder(addedloottable));
                supplier.build();
            }
        });
    }
}
