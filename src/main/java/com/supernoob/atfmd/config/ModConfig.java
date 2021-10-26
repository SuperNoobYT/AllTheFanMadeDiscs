package com.supernoob.atfmd.config;

import com.supernoob.atfmd.ATFMD;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;

@Config(name = ATFMD.MOD_ID)
@Config.Gui.Background("minecraft:textures/block/jukebox_side.png")
public class ModConfig implements ConfigData {
    @ConfigEntry.Category("Height for Bedrock Disc Structures [WIP]")
    @ConfigEntry.Gui.CollapsibleObject
    public StructureConfig stuff = new StructureConfig();

    @Config(name = "Strucutre spawn")
    public class StructureConfig {

        public int Max_Y = 13;
        public int Min_Y = 6;
        public boolean SpawnStructure = true;
    }
    public static void init() {
        AutoConfig.register(ModConfig.class, Toml4jConfigSerializer::new);
        ATFMD.CONFIG = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
    }
}