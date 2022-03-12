package com.supernoob.atfmd.object;

import com.supernoob.atfmd.ATFMD;
import com.supernoob.atfmd.mixin.StructureFeatureAccessor;
import com.supernoob.atfmd.object.StructuresFeatures.BedrockDiscStructure;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.StructureFeature;
    public class ATFMDStructures {

        public static StructureFeature<?> BEDROCK_DISC = new BedrockDiscStructure();

        public static void registerStructureFeatures() {
            StructureFeatureAccessor.callRegister(ATFMD.MOD_ID + ":underground_structures", BEDROCK_DISC, GenerationStep.Feature.UNDERGROUND_STRUCTURES);
        }
    }
