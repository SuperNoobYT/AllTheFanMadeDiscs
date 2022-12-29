package com.supernoob.atfmd.object;

import com.supernoob.atfmd.ATFMD;
import com.supernoob.atfmd.object.StructuresFeatures.BedrockDiscStructure;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.structure.StructureType;
    public class ATFMDStructures {

        public static StructureType<BedrockDiscStructure> BEDROCK_DISC;

        public static void registerStructureFeatures() {
            BEDROCK_DISC = Registry.register(Registries.STRUCTURE_TYPE, new Identifier(ATFMD.MOD_ID, "bedrock_disc_structures"), () -> BedrockDiscStructure.CODEC);
        }
    }