package com.supernoob.atfmd.object;

import com.supernoob.atfmd.ATFMD;
import com.supernoob.atfmd.object.StructuresFeatures.BedrockDiscStructure;
import com.supernoob.atfmd.object.StructuresFeatures.DeathDungeonStructure;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.structure.StructureType;
    public class ATFMDStructures {
        public static StructureType<BedrockDiscStructure> BEDROCK_DISC;
        public static StructureType<DeathDungeonStructure> DEATH_DUNGEON;

        public static void registerStructureFeatures() {
        BEDROCK_DISC = Registry.register(Registry.STRUCTURE_TYPE, new Identifier(com.supernoob.atfmd.ATFMD.MOD_ID, "bedrock_disc_structures"), () -> BedrockDiscStructure.CODEC);
            DEATH_DUNGEON = Registry.register(Registry.STRUCTURE_TYPE, new Identifier(ATFMD.MOD_ID, "death_dungeon_structures"), () -> DeathDungeonStructure.CODEC);
        }
    }