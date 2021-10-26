package com.supernoob.atfmd.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import me.shedaniel.clothconfig2.api.ConfigBuilder;

public class ModMenuIntegration implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        ConfigBuilder builder = ConfigBuilder.create();
        builder.setSavingRunnable(() -> {
            AutoConfig.register(ModConfig.class, Toml4jConfigSerializer::new);
            ModConfig config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
        });
        return parent -> AutoConfig.getConfigScreen(ModConfig.class, parent).get();
    }
}