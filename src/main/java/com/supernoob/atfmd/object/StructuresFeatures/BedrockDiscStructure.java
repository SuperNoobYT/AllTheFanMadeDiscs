package com.supernoob.atfmd.object.StructuresFeatures;

import com.mojang.serialization.Codec;
import com.supernoob.atfmd.ATFMD;
import net.minecraft.structure.MarginedStructureStart;
import net.minecraft.structure.PoolStructurePiece;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.StructurePiece;
import net.minecraft.structure.pool.StructurePoolBasedGenerator;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.HeightLimitView;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;
import org.apache.logging.log4j.Level;

import java.util.Random;

public class BedrockDiscStructure extends StructureFeature<DefaultFeatureConfig> {
    public BedrockDiscStructure(Codec<DefaultFeatureConfig> codec) {super(codec);}

    @Override
    public StructureStartFactory<DefaultFeatureConfig> getStructureStartFactory() {
        return BedrockDiscStructure.Start::new;
    }
    public static int randomHeight() {
        Random random = new Random();
        int minY = ATFMD.CONFIG.stuff.Min_Y;
        int maxY = ATFMD.CONFIG.stuff.Max_Y;
        return random.nextInt(maxY - minY) + minY;
    }

    public static class Start extends MarginedStructureStart<DefaultFeatureConfig> {
        public Start(StructureFeature<DefaultFeatureConfig> structureIn, ChunkPos chunkPos, int referenceIn, long seedIn) {
            super(structureIn, chunkPos, referenceIn, seedIn);
        }
        @Override
        public void init(DynamicRegistryManager dynamicRegistryManager, ChunkGenerator chunkGenerator, StructureManager structureManager, ChunkPos chunkPos, Biome biome, DefaultFeatureConfig defaultFeatureConfig, HeightLimitView heightLimitView) {
            int x = chunkPos.x * 16;
            int z = chunkPos.z * 16;
            int y = BedrockDiscStructure.randomHeight();
                BlockPos centerPos = new BlockPos.Mutable(x, y, z);
                    StructurePoolFeatureConfig structureSettingsAndStartPool = new StructurePoolFeatureConfig(() -> dynamicRegistryManager.get(Registry.STRUCTURE_POOL_KEY)
                            .get(new Identifier(ATFMD.MOD_ID, "bedrock_disc/start_pool")),
                            1);

                    StructurePoolBasedGenerator.generate(
                            dynamicRegistryManager,
                            structureSettingsAndStartPool,
                            PoolStructurePiece::new,
                            chunkGenerator,
                            structureManager,
                            centerPos,
                            this,
                            this.random,
                            false,
                            false,
                            heightLimitView);

                    this.children.forEach(piece -> piece.translate(0, 0, 0));

                    Vec3i structureCenter = this.children.get(0).getBoundingBox().getCenter();
                    int xOffset = centerPos.getX() - structureCenter.getX();
                    int zOffset = centerPos.getZ() - structureCenter.getZ();
                    for (StructurePiece structurePiece : this.children) {
                        structurePiece.translate(xOffset, 0, zOffset);
                    }

                    this.setBoundingBoxFromChildren();

                ATFMD.LOGGER.log(Level.DEBUG, "Bedrock Disc at " +
                            this.children.get(0).getBoundingBox().getMinX() + " " +
                            this.children.get(0).getBoundingBox().getMinY() + " " +
                            this.children.get(0).getBoundingBox().getMinZ());
                }
        }
    }