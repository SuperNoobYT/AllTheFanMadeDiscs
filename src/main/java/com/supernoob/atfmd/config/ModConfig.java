package com.supernoob.atfmd.config;

import com.supernoob.atfmd.ATFMD;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = ATFMD.MOD_ID)
public
class ModConfig implements ConfigData {
    @ConfigEntry.Gui.CollapsibleObject
    InnerStuff stuff = new InnerStuff();
    public static class InnerStuff {
        public static int Max_Y = 13;
        public static int Min_Y = 6;
        public static boolean SpawnStructure = true;
    }
}
