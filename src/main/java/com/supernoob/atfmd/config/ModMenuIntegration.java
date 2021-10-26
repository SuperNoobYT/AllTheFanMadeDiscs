package com.supernoob.atfmd.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.clothconfig2.api.ConfigBuilder;

public class ModMenuIntegration implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        ConfigBuilder builder = ConfigBuilder.create();
        builder.setSavingRunnable(() -> ModConfig.init());
        return parent -> AutoConfig.getConfigScreen(ModConfig.class, parent).get();
    }
}