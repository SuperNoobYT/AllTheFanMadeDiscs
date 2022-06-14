package com.supernoob.atfmd.object.StructuresFeatures;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.supernoob.atfmd.ATFMD;
import com.supernoob.atfmd.object.ATFMDStructures;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolBasedGenerator;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.HeightLimitView;
import net.minecraft.world.Heightmap;
import net.minecraft.world.World;
import net.minecraft.world.gen.HeightContext;
import net.minecraft.world.gen.chunk.VerticalBlockSample;
import net.minecraft.world.gen.heightprovider.HeightProvider;
import net.minecraft.world.gen.noise.NoiseConfig;
import net.minecraft.world.gen.structure.Structure;
import net.minecraft.world.gen.structure.StructureType;

import java.util.Optional;

public class BedrockDiscStructure extends Structure {

    public static final Codec<BedrockDiscStructure> CODEC = RecordCodecBuilder.<BedrockDiscStructure>mapCodec(instance ->
            instance.group(BedrockDiscStructure.configCodecBuilder(instance),
                    StructurePool.REGISTRY_CODEC.fieldOf("start_pool").forGetter(structure -> structure.startPool),
                    Identifier.CODEC.optionalFieldOf("start_jigsaw_name").forGetter(structure -> structure.startJigsawName),
                    Codec.intRange(0, 30).fieldOf("size").forGetter(structure -> structure.size),
                    HeightProvider.CODEC.fieldOf("start_height").forGetter(structure -> structure.startHeight),
                    Heightmap.Type.CODEC.optionalFieldOf("project_start_to_heightmap").forGetter(structure -> structure.projectStartToHeightmap),
                    Codec.intRange(1, 128).fieldOf("max_distance_from_center").forGetter(structure -> structure.maxDistanceFromCenter)
            ).apply(instance, BedrockDiscStructure::new)).codec();

    private final RegistryEntry<StructurePool> startPool;
    private final Optional<Identifier> startJigsawName;
    private final int size;
    private final HeightProvider startHeight;
    private final Optional<Heightmap.Type> projectStartToHeightmap;
    private final int maxDistanceFromCenter;

    public BedrockDiscStructure(Structure.Config config,
                         RegistryEntry<StructurePool> startPool,
                         Optional<Identifier> startJigsawName,
                         int size,
                         HeightProvider startHeight,
                         Optional<Heightmap.Type> projectStartToHeightmap,
                         int maxDistanceFromCenter)
    {
        super(config);
        this.startPool = startPool;
        this.startJigsawName = startJigsawName;
        this.size = size;
        this.startHeight = startHeight;
        this.projectStartToHeightmap = projectStartToHeightmap;
        this.maxDistanceFromCenter = maxDistanceFromCenter;
    }

    private static boolean extraSpawningChecks(Structure.Context context) {
        // Grabs the chunk position we are at
        ChunkPos chunkpos = context.chunkPos();

        // Checks to make sure our structure does not spawn above land that's higher than y = 150
        // to demonstrate how this method is good for checking extra conditions for spawning
        return context.chunkGenerator().getHeightInGround(
                chunkpos.getStartX(),
                chunkpos.getStartZ(),
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                context.world(),
                context.noiseConfig()) < 150;
    }
    @Override
    public Optional<Structure.StructurePosition> getStructurePosition(Structure.Context context) {
        int y = ATFMD.CONFIG.stuff.Min_Y;
        BlockPos spawnXZPosition = context.chunkPos().getCenterAtY(y);
        int x = spawnXZPosition.getX();
        int z = spawnXZPosition.getZ();
        VerticalBlockSample columnOfBlocks = context.chunkGenerator().getColumnSample(x,z,HeightLimitView.create(-64,256),context.noiseConfig());

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

        Optional<StructurePosition> structurePiecesGenerator =
                StructurePoolBasedGenerator.generate(
                        context, // Used for StructurePoolBasedGenerator to get all the proper behaviors done.
                        this.startPool, // The starting pool to use to create the structure layout from
                        this.startJigsawName, // Can be used to only spawn from one Jigsaw block. But we don't need to worry about this.
                        this.size, // How deep a branch of pieces can go away from center piece. (5 means branches cannot be longer than 5 pieces from center piece)
                        blockpos, // Where to spawn the structure.
                        false, // "useExpansionHack" This is for legacy villages to generate properly. You should keep this false always.
                        this.projectStartToHeightmap, // Adds the terrain height's y value to the passed in blockpos's y value. (This uses WORLD_SURFACE_WG heightmap which stops at top water too)
                        // Here, blockpos's y value is 60 which means the structure spawn 60 blocks above terrain height.
                        // Set this to false for structure to be place only at the passed in blockpos's Y value instead.
                        // Definitely keep this false when placing structures in the nether as otherwise, heightmap placing will put the structure on the Bedrock roof.
                        this.maxDistanceFromCenter); // Maximum limit for how far pieces can spawn from center. You cannot set this bigger than 128 or else pieces gets cutoff.

        /*
         * Note, you are always free to make your own StructurePoolBasedGenerator class and implementation of how the structure
         * should generate. It is tricky but extremely powerful if you are doing something that vanilla's jigsaw system cannot do.
         * Such as for example, forcing 3 pieces to always spawn every time, limiting how often a piece spawns, or remove the intersection limitation of pieces.
         */

        // Return the pieces generator that is now set up so that the game runs it when it needs to create the layout of structure pieces.
        return structurePiecesGenerator;
    }

    @Override
    public StructureType<?> getType() {
        return ATFMDStructures.BEDROCK_DISC; // Helps the game know how to turn this structure back to json to save to chunks
    }
}