package com.supernoob.atfmd.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import net.minecraft.text.TranslatableText;

public class ModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        ConfigBuilder builder = ConfigBuilder.create()
                .setTitle(new TranslatableText("text.autoconfig.all_the_fan_made_discs.title"));
        ConfigCategory general = builder.getOrCreateCategory(new TranslatableText("text.autoconfig.all_the_fan_made_discs.general"));
        builder.setSavingRunnable(() ->  AutoConfig.register(ModConfig.class, Toml4jConfigSerializer::new));
        return parent -> AutoConfig.getConfigScreen(ModConfig.class, parent).get();
    }
}