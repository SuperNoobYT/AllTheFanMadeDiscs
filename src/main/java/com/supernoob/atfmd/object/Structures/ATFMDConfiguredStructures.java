package com.supernoob.atfmd.object.Structures;

import com.supernoob.atfmd.ATFMD;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;

public class ATFMDConfiguredStructures {
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_BEDROCK_DISC = ATFMDStructures.BEDROCK_DISC_STRUCTURE.configure(DefaultFeatureConfig.DEFAULT);

    public static void registerConfiguredStructures() {
        Registry<ConfiguredStructureFeature<?, ?>> registry = BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE;
        Registry.register(registry, new Identifier(ATFMD.MOD_ID, "configured_bedrock_disc"), CONFIGURED_BEDROCK_DISC);
    }
}
