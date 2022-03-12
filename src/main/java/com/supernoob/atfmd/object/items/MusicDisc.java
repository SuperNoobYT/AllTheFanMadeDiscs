package com.supernoob.atfmd.object.items;

import com.supernoob.atfmd.ATFMD;
import com.supernoob.atfmd.mixin.StructureFeatureAccessor;
import com.supernoob.atfmd.object.StructuresFeatures.BedrockDiscStructure;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.StructureFeature;


public class MusicDisc extends MusicDiscItem {

    public MusicDisc(int comparatorOutput, SoundEvent sound, Settings settings) {
        super(comparatorOutput, sound, settings);
    }
}