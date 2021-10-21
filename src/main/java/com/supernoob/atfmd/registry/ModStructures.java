  package com.supernoob.atfmd.registry;

  import com.supernoob.atfmd.ATFMD;
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
          /*
           * We setup and register our structures here.
           * You should always register your stuff to prevent mod compatibility issue down the line.
           */
          ATFMDStructures.setupAndRegisterStructureFeatures();
          ATFMDConfiguredStructures.registerConfiguredStructures();

          /*
           * This is the API you will use to add anything to any biome.
           * This includes spawns, changing the biome's looks, messing with its surfacebuilders,
           * adding carvers, spawning new features... etc
           *
           * Make sure you give this an identifier to make it clear later what mod did a change and why.
           * It'll help people look to see if your mod was removing something from biomes.
           * The biome modifier identifier might also be used by modpacks to disable mod's modifiers too for customization.
           */
          BiomeModifications.create(new Identifier(ATFMD.MOD_ID, "bedrock_disc_addition"))
                  .add(   // Describes what we are doing. SInce we are adding a structure, we choose ADDITIONS.
                          ModificationPhase.ADDITIONS,

                          // Add our structure to all biomes including other modded biomes.
                          // You can filter to certain biomes based on stuff like temperature, scale, precipitation, mod id.
                          BiomeSelectors.all(),

                          // context is basically the biome itself. This is where you do the changes to the biome.
                          // Here, we will add our ConfiguredStructureFeature to the biome.
                          context -> context.getGenerationSettings().addBuiltInStructure(ATFMDConfiguredStructures.CONFIGURED_BEDROCK_DISC));
      }

      public static void removeStructureSpawningFromSelectedDimension() {
          // Controls the dimension blacklisting
          ServerWorldEvents.LOAD.register((MinecraftServer minecraftServer, ServerWorld serverWorld)->{

              // Need temp map as some mods use custom chunk generators with immutable maps in themselves.
              Map<StructureFeature<?>, StructureConfig> tempMap = new HashMap<>(serverWorld.getChunkManager().getChunkGenerator().getStructuresConfig().getStructures());

              // Make absolutely sure modded dimension cannot spawn our structures.
              // New dimensions under the minecraft namespace will still get it (datapacks might do this)
              if(!serverWorld.getRegistryKey().equals(World.OVERWORLD)){
                  tempMap.keySet().remove(ATFMDStructures.BEDROCK_DISC_STRUCTURE);
              }

              // Set the new modified map of structure spacing to the dimension's chunkgenerator.
              ((StructuresConfigAccessor)serverWorld.getChunkManager().getChunkGenerator().getStructuresConfig()).setStructures(tempMap);
          });
      }
  }