package com.miningmark48.prefixation.handler;

import com.miningmark48.mininglib.utility.ModTranslate;
import com.miningmark48.prefixation.reference.Reference;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

public class ConfigurationHandler {

    public static Configuration configuration;

    public static boolean reforge_enabled;
    public static int reforge_experience_use_amount;

    public static void init(File configFile){

        if (configuration == null){
            configuration = new Configuration(configFile);
            loadConfiguration();
        }

    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event){

        if (event.getModID().equalsIgnoreCase(Reference.MOD_ID)){
            loadConfiguration();
        }

    }

    private static void loadConfiguration(){

        reforge_enabled = configuration.getBoolean(ModTranslate.toLocal("config.reforge_enabled.title"), Configuration.CATEGORY_GENERAL, true, ModTranslate.toLocal("config.reforge_enabled.desc"));
        reforge_experience_use_amount = configuration.getInt(ModTranslate.toLocal("config.reforge_experience_use_amount.title"), Configuration.CATEGORY_GENERAL, 2, 0, Integer.MAX_VALUE, ModTranslate.toLocal("config.reforge_experience_use_amount.desc"));

        if (configuration.hasChanged()){
            configuration.save();
        }

    }

}
