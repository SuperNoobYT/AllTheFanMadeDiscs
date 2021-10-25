package com.supernoob.atfmd;

import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;

@Config(name = ATFMD.MOD_ID)
class ModConfig extends PartitioningSerializer.GlobalData {
    @ConfigEntry.Category("Height for Bedrock Disc Structures")
    @ConfigEntry.Gui.TransitiveObject
    config_field moduleA = new config_field();
}