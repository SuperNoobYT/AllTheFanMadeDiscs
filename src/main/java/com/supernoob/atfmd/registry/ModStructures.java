  package com.supernoob.atfmd.registry;

  import com.supernoob.atfmd.ATFMD;
  import com.supernoob.atfmd.object.Structures.ATFMDConfiguredStructures;
  import com.supernoob.atfmd.object.Structures.ATFMDStructures;
  import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
  import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
  import net.fabricmc.fabric.api.event.Event;
  import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
  import net.fabricmc.fabric.impl.structure.FabricStructureImpl;
  import net.fabricmc.fabric.mixin.structure.StructuresConfigAccessor;
  import net.minecraft.server.MinecraftServer;
  import net.minecraft.server.world.ServerWorld;
  import net.minecraft.util.Identifier;
  import net.minecraft.util.registry.BuiltinRegistries;
  import net.minecraft.util.registry.Registry;
  import net.minecraft.util.registry.RegistryKey;
  import net.minecraft.world.World;
  import net.minecraft.world.biome.Biome;
  import net.minecraft.world.gen.chunk.FlatChunkGenerator;
  import net.minecraft.world.gen.chunk.StructureConfig;
  import net.minecraft.world.gen.chunk.StructuresConfig;
  import net.minecraft.world.gen.feature.StructureFeature;

  import java.util.HashMap;
  import java.util.Map;

  public class ModStructures {
      public static void init() {

          ATFMDStructures.setupAndRegisterStructureFeatures();
          ATFMDConfiguredStructures.registerConfiguredStructures();
          addStructureSpawningToDimensionsAndBiomes();
      }

      public static void addStructureSpawningToDimensionsAndBiomes() {

          BiomeModifications.addStructure(
                  BiomeSelectors.categories(
                          Biome.Category.DESERT,
                          Biome.Category.EXTREME_HILLS,
                          Biome.Category.FOREST,
                          Biome.Category.ICY,
                          Biome.Category.JUNGLE,
                          Biome.Category.PLAINS,
                          Biome.Category.SAVANNA,
                          Biome.Category.TAIGA,
                          Biome.Category.OCEAN,
                          Biome.Category.MOUNTAIN,
                          Biome.Category.MESA,
                          Biome.Category.SWAMP,
                          Biome.Category.UNDERGROUND,
                          Biome.Category.MUSHROOM,
                          Biome.Category.RIVER),
                  RegistryKey.of(
                          Registry.CONFIGURED_STRUCTURE_FEATURE_KEY,
                          BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE.getId(ATFMDConfiguredStructures.CONFIGURED_BEDROCK_DISC_STRUCTURE))
          );

       Identifier runAfterFabricAPIPhase = new Identifier(ATFMD.MOD_ID, "run_after_fabric_api");
       ServerWorldEvents.LOAD.addPhaseOrdering(Event.DEFAULT_PHASE, runAfterFabricAPIPhase);

        ServerWorldEvents.LOAD.register(runAfterFabricAPIPhase, (MinecraftServer minecraftServer, ServerWorld serverWorld) -> {
           if (serverWorld.getChunkManager().getChunkGenerator() instanceof FlatChunkGenerator && serverWorld.getRegistryKey().equals(World.OVERWORLD)) {
               return;
          }

          StructuresConfig worldStructureConfig = serverWorld.getChunkManager().getChunkGenerator().getStructuresConfig();

            Map<StructureFeature<?>, StructureConfig> tempMap = new HashMap<>(worldStructureConfig.getStructures());

            if(serverWorld.getRegistryKey().equals(World.OVERWORLD)) {
                tempMap.put(ATFMDStructures.BEDROCK_DISC_STRUCTURE, FabricStructureImpl.STRUCTURE_TO_CONFIG_MAP.get(ATFMDStructures.BEDROCK_DISC_STRUCTURE));
            }
            else {
                tempMap.remove(ATFMDStructures.BEDROCK_DISC_STRUCTURE);
            }

            ((StructuresConfigAccessor)worldStructureConfig).setStructures(tempMap);

        });
      }
  }