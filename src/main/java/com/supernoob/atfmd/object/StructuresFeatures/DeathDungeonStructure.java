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
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.HeightLimitView;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.chunk.VerticalBlockSample;
import net.minecraft.world.gen.heightprovider.HeightProvider;
import net.minecraft.world.gen.structure.Structure;
import net.minecraft.world.gen.structure.StructureType;

import java.util.Optional;

public class DeathDungeonStructure extends Structure {

    public static final Codec<DeathDungeonStructure> CODEC = RecordCodecBuilder.<DeathDungeonStructure>mapCodec(instance ->
            instance.group(DeathDungeonStructure.configCodecBuilder(instance),
                    StructurePool.REGISTRY_CODEC.fieldOf("start_pool").forGetter(structure -> structure.startPool),
                    Identifier.CODEC.optionalFieldOf("start_jigsaw_name").forGetter(structure -> structure.startJigsawName),
                    Codec.intRange(0, 30).fieldOf("size").forGetter(structure -> structure.size),
                    HeightProvider.CODEC.fieldOf("start_height").forGetter(structure -> structure.startHeight),
                    Heightmap.Type.CODEC.optionalFieldOf("project_start_to_heightmap").forGetter(structure -> structure.projectStartToHeightmap),
                    Codec.intRange(1, 128).fieldOf("max_distance_from_center").forGetter(structure -> structure.maxDistanceFromCenter)
            ).apply(instance, DeathDungeonStructure::new)).codec();

    private final RegistryEntry<StructurePool> startPool;
    private final Optional<Identifier> startJigsawName;
    private final int size;
    private final HeightProvider startHeight;
    private final Optional<Heightmap.Type> projectStartToHeightmap;
    private final int maxDistanceFromCenter;

    public DeathDungeonStructure(Config config,
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

    @Override
    public Optional<StructurePosition> getStructurePosition(Context context) {
        int y = ATFMD.CONFIG.stuff.Min_Y;
        BlockPos spawnXZPosition = context.chunkPos().getCenterAtY(y);
        int x = spawnXZPosition.getX();
        int z = spawnXZPosition.getZ();
        VerticalBlockSample columnOfBlocks = context.chunkGenerator().getColumnSample(x,z,HeightLimitView.create(-63,256),context.noiseConfig());

        while (y <= 120) {
            y++;
            BlockState areablock = columnOfBlocks.getState(y);
            if (areablock.getBlock() == Blocks.AIR) {
                break;
            }
        }
        if (y > 120) {
            return Optional.empty();
        }
        BlockPos blockpos = context.chunkPos().getCenterAtY(0);
        blockpos = blockpos.up(y);

        Optional<StructurePosition> structurePiecesGenerator =
                StructurePoolBasedGenerator.generate(
                        context,
                        this.startPool,
                        this.startJigsawName,
                        this.size,
                        blockpos,
                        false,
                        this.projectStartToHeightmap,
                        this.maxDistanceFromCenter);

        return structurePiecesGenerator;
    }

    @Override
    public StructureType<?> getType() {
        return ATFMDStructures.DEATH_DUNGEON;
    }
}