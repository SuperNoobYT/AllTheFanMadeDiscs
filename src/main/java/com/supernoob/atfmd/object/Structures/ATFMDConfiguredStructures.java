package com.supernoob.atfmd.object.Structures;

import com.supernoob.atfmd.ATFMD;
import net.minecraft.structure.PlainsVillageData;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;

public class ATFMDConfiguredStructures {
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_BEDROCK_DISC_STRUCTURE = ATFMDStructures.BEDROCK_DISC_STRUCTURE
            .configure(new StructurePoolFeatureConfig(() -> PlainsVillageData.STRUCTURE_POOLS, 0));

    public static void registerConfiguredStructures() {
        Registry<ConfiguredStructureFeature<?, ?>> registry = BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE;
        Registry.register(registry, new Identifier(ATFMD.MOD_ID, "configured_bedrock_disc_structure"), CONFIGURED_BEDROCK_DISC_STRUCTURE);
    }
}
