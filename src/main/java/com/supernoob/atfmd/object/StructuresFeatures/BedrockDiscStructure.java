package com.supernoob.atfmd.object.StructuresFeatures;

import com.mojang.serialization.Codec;
import com.supernoob.atfmd.ATFMD;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.structure.PoolStructurePiece;
import net.minecraft.structure.PostPlacementProcessor;
import net.minecraft.structure.StructureGeneratorFactory;
import net.minecraft.structure.StructurePiecesGenerator;
import net.minecraft.structure.pool.StructurePoolBasedGenerator;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.Pool;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.chunk.VerticalBlockSample;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;
import org.apache.logging.log4j.Level;

import java.util.Optional;
import java.util.Random;

public class BedrockDiscStructure extends StructureFeature<StructurePoolFeatureConfig> {
    public BedrockDiscStructure(Codec<StructurePoolFeatureConfig> codec) {
        super(codec, BedrockDiscStructure::createPiecesGenerator, PostPlacementProcessor.EMPTY);
    }
    public static final Pool<SpawnSettings.SpawnEntry> STRUCTURE_MONSTERS = Pool.of(
    );

    public static final Pool<SpawnSettings.SpawnEntry> STRUCTURE_CREATURES = Pool.of(
    );

    public static int randomHeight() {
        Random random = new Random();
        int minY = ATFMD.CONFIG.stuff.Min_Y;
        int maxY = ATFMD.CONFIG.stuff.Max_Y;
        return random.nextInt(maxY - minY) + minY;
    }

    private static boolean isFeatureChunk(StructureGeneratorFactory.Context<StructurePoolFeatureConfig> context) {
        int y = BedrockDiscStructure.randomHeight();
        BlockPos spawnXZPosition = context.chunkPos().getCenterAtY(y);
        int x = spawnXZPosition.getX();
        int z = spawnXZPosition.getZ();
        int a = 0;
        for (int x1 = x - 8; x1 <= x + 8; x1++) {
            for (int y1 = y; y1 <= y + 4; y1++) {
                for (int z1 = z - 8; z1 <= z + 8; z1++) {
                    BlockPos centerchunk = new BlockPos(x1, y1, z1);
                    VerticalBlockSample columnOfBlocks = context.chunkGenerator().getColumnSample(x1, z1, context.world());
                    BlockState areablock = columnOfBlocks.getState(y1);
                    if (areablock.getBlock()==Blocks.AIR){
                        a++;
                    }
                }
            }
        }
        return a>5;
    }
    public static Optional<StructurePiecesGenerator<StructurePoolFeatureConfig>> createPiecesGenerator(StructureGeneratorFactory.Context<StructurePoolFeatureConfig> context) {
        if (!BedrockDiscStructure.isFeatureChunk(context)) {
            return Optional.empty();
        }

        StructurePoolFeatureConfig newConfig = new StructurePoolFeatureConfig(
                () -> context.registryManager().get(Registry.STRUCTURE_POOL_KEY)
                        .get(new Identifier(ATFMD.MOD_ID, "bedrock_disc/start_pool")),
                1
        );

        StructureGeneratorFactory.Context<StructurePoolFeatureConfig> newContext = new StructureGeneratorFactory.Context<>(
                context.chunkGenerator(),
                context.biomeSource(),
                context.seed(),
                context.chunkPos(),
                newConfig,
                context.world(),
                context.validBiome(),
                context.structureManager(),
                context.registryManager()
        );

        BlockPos blockpos = context.chunkPos().getCenterAtY(randomHeight());

        Optional<StructurePiecesGenerator<StructurePoolFeatureConfig>> structurePiecesGenerator =
                StructurePoolBasedGenerator.generate(
                        newContext,
                        PoolStructurePiece::new,
                        blockpos,
                        false,
                        false
                );

        if(structurePiecesGenerator.isPresent()) {
            ATFMD.LOGGER.log(Level.DEBUG, "Bedrock Disc at " + blockpos);
        }

        return structurePiecesGenerator;
    }
}