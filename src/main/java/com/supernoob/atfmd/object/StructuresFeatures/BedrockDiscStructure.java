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

public class BedrockDiscStructure extends StructureFeature<StructurePoolFeatureConfig> {

    public BedrockDiscStructure() {
        super(StructurePoolFeatureConfig.CODEC, BedrockDiscStructure::createPiecesGenerator, PostPlacementProcessor.EMPTY);
    }

    public static Optional<StructurePiecesGenerator<StructurePoolFeatureConfig>> createPiecesGenerator(StructureGeneratorFactory.Context<StructurePoolFeatureConfig> context) {
        int y = ATFMD.CONFIG.stuff.Min_Y;
        BlockPos spawnXZPosition = context.chunkPos().getCenterAtY(y);
        int x = spawnXZPosition.getX();
        int z = spawnXZPosition.getZ();
        VerticalBlockSample columnOfBlocks = context.chunkGenerator().getColumnSample(x, z, context.world());
        while (y <= ATFMD.CONFIG.stuff.Max_Y) {
            y++;
            BlockState areablock = columnOfBlocks.getState(y);
            if (areablock.getBlock() == Blocks.AIR) {
                break;
            }
        }
        if (y > ATFMD.CONFIG.stuff.Max_Y) {
            return Optional.empty();
        }
        BlockPos blockpos = context.chunkPos().getCenterAtY(0);
        blockpos = blockpos.up(y);

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
        if (structurePiecesGenerator.isPresent()) {
            ATFMD.LOGGER.log(Level.DEBUG, "Bedrock disc", blockpos);
        }
        return structurePiecesGenerator;
    }
}