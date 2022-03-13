package com.supernoob.atfmd.object.StructuresFeatures;

import com.supernoob.atfmd.ATFMD;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.structure.*;
import net.minecraft.structure.pool.StructurePoolBasedGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.chunk.VerticalBlockSample;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;
import org.apache.logging.log4j.Level;

import java.util.Optional;
import java.util.Random;

public class BedrockDiscStructure extends StructureFeature<StructurePoolFeatureConfig> {

    public BedrockDiscStructure() {
        super(StructurePoolFeatureConfig.CODEC, BedrockDiscStructure::createPiecesGenerator, PostPlacementProcessor.EMPTY);
    }
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
        for (int x1 = x - 9; x1 <= x + 9; x1++) {
            for (int y1 = y; y1 <= y + 4; y1++) {
                for (int z1 = z - 9; z1 <= z + 9; z1++) {
                    VerticalBlockSample columnOfBlocks = context.chunkGenerator().getColumnSample(x1, z1, context.world());
                    BlockState areablock = columnOfBlocks.getState(y1);
                    if (areablock.getBlock()== Blocks.AIR){
                        a++;
                    }
                }
            }
        }
        return a>3;
    }
    public static Optional<StructurePiecesGenerator<StructurePoolFeatureConfig>> createPiecesGenerator(StructureGeneratorFactory.Context<StructurePoolFeatureConfig> context) {
        if (!BedrockDiscStructure.isFeatureChunk(context)) {
            return Optional.empty();
        }
        BlockPos blockpos = context.chunkPos().getCenterAtY(0);
        blockpos = blockpos.up(randomHeight());

        Optional<StructurePiecesGenerator<StructurePoolFeatureConfig>> structurePiecesGenerator =
                StructurePoolBasedGenerator.generate(
                        context, // Used for JigsawPlacement to get all the proper behaviors done.
                        PoolStructurePiece::new, // Needed in order to create a list of jigsaw pieces when making the structure's layout.
                        blockpos, // Position of the structure. Y value is ignored if last parameter is set to true.
                        false,  // Special boundary adjustments for villages. It's... hard to explain. Keep this false and make your pieces not be partially intersecting.
                        // Either not intersecting or fully contained will make children pieces spawn just fine. It's easier that way.
                        false // Place at heightmap (top land). Set this to false for structure to be place at the passed in blockpos's Y value instead.
                        // Definitely keep this false when placing structures in the nether as otherwise, heightmap placing will put the structure on the Bedrock roof.
                );
        if(structurePiecesGenerator.isPresent()) {
            ATFMD.LOGGER.log(Level.DEBUG, "Bedrock disc", blockpos);
        }
        return structurePiecesGenerator;
    }
}