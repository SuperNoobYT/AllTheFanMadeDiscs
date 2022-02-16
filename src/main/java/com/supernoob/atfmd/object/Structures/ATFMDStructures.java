package com.supernoob.atfmd.object.Structures;

import com.supernoob.atfmd.object.StructuresFeatures.BedrockDiscStructure;
import com.supernoob.atfmd.ATFMD;
import net.fabricmc.fabric.api.structure.v1.FabricStructureBuilder;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.chunk.StructureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;


public class ATFMDStructures {
    public static StructureFeature<StructurePoolFeatureConfig> BEDROCK_DISC_STRUCTURE = new BedrockDiscStructure(StructurePoolFeatureConfig.CODEC);

    public static void setupAndRegisterStructureFeatures() {

            FabricStructureBuilder.create(new Identifier(ATFMD.MOD_ID, "bedrock_disc"), BEDROCK_DISC_STRUCTURE)

                    .step(GenerationStep.Feature.UNDERGROUND_STRUCTURES)

                    .defaultConfig(new StructureConfig(
                            11,
                            8,
                            879787145))
                    .register();
    }
}
