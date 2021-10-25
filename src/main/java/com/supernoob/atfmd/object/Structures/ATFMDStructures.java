package com.supernoob.atfmd.object.Structures;

import com.supernoob.atfmd.ATFMD;
import com.supernoob.atfmd.object.StructuresFeatures.BedrockDiscStructure;
import net.fabricmc.fabric.api.structure.v1.FabricStructureBuilder;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.chunk.StructureConfig;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;

public class ATFMDStructures {
    public static StructureFeature<DefaultFeatureConfig> BEDROCK_DISC_STRUCTURE = new BedrockDiscStructure(DefaultFeatureConfig.CODEC);

    public static void setupAndRegisterStructureFeatures() {

        FabricStructureBuilder.create(new Identifier(ATFMD.MOD_ID, "bedrock_disc"), BEDROCK_DISC_STRUCTURE)

                .step(GenerationStep.Feature.UNDERGROUND_STRUCTURES)

                .defaultConfig(new StructureConfig(
                        10,
                        4,
                        879787145))

                .superflatFeature(BEDROCK_DISC_STRUCTURE.configure(FeatureConfig.DEFAULT))
                .register();
    }
}
