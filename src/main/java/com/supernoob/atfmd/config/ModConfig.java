package com.supernoob.atfmd.config;

import com.supernoob.atfmd.ATFMD;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = ATFMD.MOD_ID)
@Config.Gui.Background("minecraft:textures/block/jukebox_side.png")
public class ModConfig implements ConfigData {
    @ConfigEntry.Category("Height for Bedrock Disc Structures [WIP]")
    @ConfigEntry.Gui.CollapsibleObject
    general_config stuff = new general_config();

    @Config(name = "module_a")
    public class general_config {

        public static int Max_Y = 13;
        public static int Min_Y = 6;
        public static boolean SpawnStructure = true;
    }

}
