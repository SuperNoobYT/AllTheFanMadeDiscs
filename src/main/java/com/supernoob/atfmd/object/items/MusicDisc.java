package com.supernoob.atfmd.object.items;

import net.minecraft.item.MusicDiscItem;
import net.minecraft.sound.SoundEvent;


public class MusicDisc extends MusicDiscItem {

    public MusicDisc(int comparatorOutput, SoundEvent sound, Settings settings, int lengthInSeconds) {
        super(comparatorOutput, sound, settings, lengthInSeconds);
    }
}