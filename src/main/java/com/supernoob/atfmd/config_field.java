package com.supernoob.atfmd;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = "Height for Bedrock Disc Structures")
public class config_field implements ConfigData {
    public static short BedrockDisc_MinY = 6;
    public static short BedrockDisc_MaxY = 13;
}
