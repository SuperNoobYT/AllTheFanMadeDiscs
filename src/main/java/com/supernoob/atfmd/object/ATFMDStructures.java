package com.supernoob.atfmd.object;

import com.supernoob.atfmd.ATFMD;
import com.supernoob.atfmd.object.StructuresFeatures.BedrockDiscStructure;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.structure.StructureType;
    public class ATFMDStructures {

        public static StructureType<BedrockDiscStructure> BEDROCK_DISC;

        public static void registerStructureFeatures() {
            BEDROCK_DISC = Registry.register(Registry.STRUCTURE_TYPE, new Identifier(ATFMD.MOD_ID, "sky_structures"), () -> BedrockDiscStructure.CODEC);
        }
    }
