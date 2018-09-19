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

    //Prefixes
        //Weapons
    public static float chance_weapons_fortified;
    public static float chance_weapons_lucky;
    public static float chance_weapons_sluggish;
    public static float chance_weapons_annoying;
    public static float chance_weapons_frenzying;
    public static float chance_weapons_deadly;
    public static float chance_weapons_quick;
    public static float chance_weapons_godly;
    public static float chance_weapons_legendary;
        //Armor
    public static float chance_armor_lucky;
    public static float chance_armor_quick;
    public static float chance_armor_light;
    public static float chance_armor_heavy;
    public static float chance_armor_durable;
    public static float chance_armor_godly;
    public static float chance_armor_legendary;

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

        //Categories
        configuration.addCustomCategoryComment(ModTranslate.toLocal("config.category.chances.weapons.title"), ModTranslate.toLocal("config.category.chances.weapons.desc"));
        configuration.addCustomCategoryComment(ModTranslate.toLocal("config.category.chances.armor.title"), ModTranslate.toLocal("config.category.chances.armor.desc"));
        configuration.setCategoryRequiresMcRestart(ModTranslate.toLocal("config.category.chances.weapons.title"), true);
        configuration.setCategoryRequiresMcRestart(ModTranslate.toLocal("config.category.chances.armor.title"), true);

        reforge_enabled = configuration.getBoolean(ModTranslate.toLocal("config.reforge_enabled.title"), Configuration.CATEGORY_GENERAL, true, ModTranslate.toLocal("config.reforge_enabled.desc"));
        reforge_experience_use_amount = configuration.getInt(ModTranslate.toLocal("config.reforge_experience_use_amount.title"), Configuration.CATEGORY_GENERAL, 2, 0, Integer.MAX_VALUE, ModTranslate.toLocal("config.reforge_experience_use_amount.desc"));

        //Prefixes
            //Weapons
        chance_weapons_fortified = configuration.getFloat(ModTranslate.toLocal("config.chances.weapons.fortified.title"), ModTranslate.toLocal("config.category.chances.weapons.title"), 0.9f, 0f, 1f, ModTranslate.toLocal("config.chances.weapons.desc"));
        chance_weapons_lucky = configuration.getFloat(ModTranslate.toLocal("config.chances.weapons.lucky.title"), ModTranslate.toLocal("config.category.chances.weapons.title"), 0.8f, 0f, 1f, ModTranslate.toLocal("config.chances.weapons.desc"));
        chance_weapons_sluggish = configuration.getFloat(ModTranslate.toLocal("config.chances.weapons.sluggish.title"), ModTranslate.toLocal("config.category.chances.weapons.title"), 0.7f, 0f, 1f, ModTranslate.toLocal("config.chances.weapons.desc"));
        chance_weapons_annoying = configuration.getFloat(ModTranslate.toLocal("config.chances.weapons.annoying.title"), ModTranslate.toLocal("config.category.chances.weapons.title"), 0.6f, 0f, 1f, ModTranslate.toLocal("config.chances.weapons.desc"));
        chance_weapons_frenzying = configuration.getFloat(ModTranslate.toLocal("config.chances.weapons.frenzying.title"), ModTranslate.toLocal("config.category.chances.weapons.title"), 0.5f, 0f, 1f, ModTranslate.toLocal("config.chances.weapons.desc"));
        chance_weapons_deadly = configuration.getFloat(ModTranslate.toLocal("config.chances.weapons.deadly.title"), ModTranslate.toLocal("config.category.chances.weapons.title"), 0.4f, 0f, 1f, ModTranslate.toLocal("config.chances.weapons.desc"));
        chance_weapons_quick = configuration.getFloat(ModTranslate.toLocal("config.chances.weapons.quick.title"), ModTranslate.toLocal("config.category.chances.weapons.title"), 0.3f, 0f, 1f, ModTranslate.toLocal("config.chances.weapons.desc"));
        chance_weapons_godly = configuration.getFloat(ModTranslate.toLocal("config.chances.weapons.godly.title"), ModTranslate.toLocal("config.category.chances.weapons.title"), 0.2f, 0f, 1f, ModTranslate.toLocal("config.chances.weapons.desc"));
        chance_weapons_legendary = configuration.getFloat(ModTranslate.toLocal("config.chances.weapons.legendary.title"), ModTranslate.toLocal("config.category.chances.weapons.title"), 0.1f, 0f, 1f, ModTranslate.toLocal("config.chances.weapons.desc"));
            //Armor
        chance_armor_lucky = configuration.getFloat(ModTranslate.toLocal("config.chances.armor.lucky.title"), ModTranslate.toLocal("config.category.chances.armor.title"), 0.9f, 0f, 1f, ModTranslate.toLocal("config.chances.armor.desc"));
        chance_armor_quick = configuration.getFloat(ModTranslate.toLocal("config.chances.armor.quick.title"), ModTranslate.toLocal("config.category.chances.armor.title"), 0.8f, 0f, 1f, ModTranslate.toLocal("config.chances.armor.desc"));
        chance_armor_light = configuration.getFloat(ModTranslate.toLocal("config.chances.armor.light.title"), ModTranslate.toLocal("config.category.chances.armor.title"), 0.7f, 0f, 1f, ModTranslate.toLocal("config.chances.armor.desc"));
        chance_armor_heavy = configuration.getFloat(ModTranslate.toLocal("config.chances.armor.heavy.title"), ModTranslate.toLocal("config.category.chances.armor.title"), 0.6f, 0f, 1f, ModTranslate.toLocal("config.chances.armor.desc"));
        chance_armor_durable = configuration.getFloat(ModTranslate.toLocal("config.chances.armor.durable.title"), ModTranslate.toLocal("config.category.chances.armor.title"), 0.5f, 0f, 1f, ModTranslate.toLocal("config.chances.armor.desc"));
        chance_armor_godly = configuration.getFloat(ModTranslate.toLocal("config.chances.armor.godly.title"), ModTranslate.toLocal("config.category.chances.armor.title"), 0.4f, 0f, 1f, ModTranslate.toLocal("config.chances.armor.desc"));
        chance_armor_legendary = configuration.getFloat(ModTranslate.toLocal("config.chances.armor.legendary.title"), ModTranslate.toLocal("config.category.chances.armor.title"), 0.2f, 0f, 1f, ModTranslate.toLocal("config.chances.armor.desc"));

        if (configuration.hasChanged()){
            configuration.save();
        }

    }

}
