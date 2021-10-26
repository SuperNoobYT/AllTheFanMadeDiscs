  package com.supernoob.atfmd.registry;

  import com.supernoob.atfmd.ATFMD;
  import com.supernoob.atfmd.config.ModConfig;
  import com.supernoob.atfmd.mixin.StructuresConfigAccessor;
  import com.supernoob.atfmd.object.Structures.ATFMDConfiguredStructures;
  import com.supernoob.atfmd.object.Structures.ATFMDStructures;
  import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
  import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
  import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
  import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
  import net.minecraft.server.MinecraftServer;
  import net.minecraft.server.world.ServerWorld;
  import net.minecraft.util.Identifier;
  import net.minecraft.world.World;
  import net.minecraft.world.gen.chunk.StructureConfig;
  import net.minecraft.world.gen.feature.StructureFeature;

  import java.util.HashMap;
  import java.util.Map;

  public class ModStructures {
      @SuppressWarnings("deprecation")
      public static void init() {
          ATFMDStructures.setupAndRegisterStructureFeatures();
          ATFMDConfiguredStructures.registerConfiguredStructures();
          BiomeModifications.create(new Identifier(ATFMD.MOD_ID, "bedrock_disc_addition"))
                  .add(
                          ModificationPhase.ADDITIONS,
                          BiomeSelectors.all(),
                          context -> context.getGenerationSettings().addBuiltInStructure(ATFMDConfiguredStructures.CONFIGURED_BEDROCK_DISC));
      }

      public static void removeStructureSpawningFromSelectedDimension() {
          ServerWorldEvents.LOAD.register((MinecraftServer minecraftServer, ServerWorld serverWorld)->{
              Map<StructureFeature<?>, StructureConfig> tempMap = new HashMap<>(serverWorld.getChunkManager().getChunkGenerator().getStructuresConfig().getStructures());

              if(!serverWorld.getRegistryKey().equals(World.OVERWORLD)||!ModConfig.general_config.SpawnStructure){
                  tempMap.keySet().remove(ATFMDStructures.BEDROCK_DISC_STRUCTURE);
              }
              ((StructuresConfigAccessor)serverWorld.getChunkManager().getChunkGenerator().getStructuresConfig()).setStructures(tempMap);
          });
      }
  }