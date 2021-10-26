package com.supernoob.atfmd.object.StructuresFeatures;

import com.mojang.serialization.Codec;
import com.supernoob.atfmd.ATFMD;
import com.supernoob.atfmd.config.ModConfig;
import net.minecraft.block.BlockState;
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
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.gen.ChunkRandom;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.VerticalBlockSample;
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
    @Override
    protected boolean shouldStartAt(ChunkGenerator chunkGenerator, BiomeSource biomeSource, long seed, ChunkRandom chunkRandom, ChunkPos chunkPos, Biome biome, ChunkPos chunkPos2, DefaultFeatureConfig featureConfig, HeightLimitView heightLimitView) {
        BlockPos centerOfChunk = new BlockPos(chunkPos.x * 16, randomHeight(), chunkPos.z * 16);
        int landHeight = chunkGenerator.getHeightInGround(centerOfChunk.getX(), centerOfChunk.getZ(), Heightmap.Type.WORLD_SURFACE_WG, heightLimitView);
        VerticalBlockSample columnOfBlocks = chunkGenerator.getColumnSample(centerOfChunk.getX(), centerOfChunk.getZ(), heightLimitView);
        BlockState topBlock = columnOfBlocks.getState(centerOfChunk.up(landHeight));
        return topBlock.getFluidState().isEmpty();
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
                int a = 0;
                for(int x1 = x-5; x1<=x+5; x1++){
                    for(int y1 = y; y1<=y+4; y1++){
                        for(int z1 = z-5; z1<=z+5; z1++){
                            BlockPos centerchunk = new BlockPos(x1,y1,z1);
                            VerticalBlockSample columnofblock1 = chunkGenerator.getColumnSample(x1, z1, heightLimitView);
                            BlockState areablock = columnofblock1.getState(centerchunk.up(y1));
                            if(!areablock.getFluidState().isEmpty()){
                                a++;
                            }
                        }
                    }
                }

                if(a==0) {
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

                    this.children.forEach(piece -> piece.translate(0, 1, 0));

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
}