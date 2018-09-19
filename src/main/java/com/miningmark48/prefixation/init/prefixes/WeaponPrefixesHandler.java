package com.miningmark48.prefixation.init.prefixes;

import com.miningmark48.mininglib.utility.ModLogger;
import com.miningmark48.prefixation.base.prefix.BasePrefix;
import com.miningmark48.prefixation.base.prefix.Prefix;
import com.miningmark48.prefixation.handler.ConfigurationHandler;
import com.miningmark48.prefixation.reference.EnumAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.util.text.TextFormatting;
import scala.Int;

import javax.security.auth.login.Configuration;
import java.util.ArrayList;
import java.util.HashMap;

public class WeaponPrefixesHandler {

    public static ArrayList<BasePrefix> weapon_prefixes = new ArrayList<>();

    public static void init() {
        weapon_prefixes.clear();

        registerPrefix(new Prefix("fortified", ConfigurationHandler.chance_weapons_fortified, TextFormatting.DARK_BLUE, new AttributeModifier[]{new AttributeModifier(EnumAttributes.KNOCKBACK_RESISTANCE.getUnlocalized(), 3, 0), new AttributeModifier(EnumAttributes.MAX_HEALTH.getUnlocalized(), 2, 0)}, new String[]{EnumAttributes.KNOCKBACK_RESISTANCE.getUnlocalized(), EnumAttributes.MAX_HEALTH.getUnlocalized()}));
        registerPrefix(new Prefix("lucky", ConfigurationHandler.chance_weapons_lucky, TextFormatting.DARK_GREEN, new AttributeModifier[]{new AttributeModifier(EnumAttributes.LUCK.getUnlocalized(), 5, 0)}, new String[]{EnumAttributes.LUCK.getUnlocalized()}));
        registerPrefix(new Prefix("lucky", ConfigurationHandler.chance_weapons_lucky, TextFormatting.DARK_GREEN, new AttributeModifier[]{new AttributeModifier(EnumAttributes.LUCK.getUnlocalized(), 7, 0)}, new String[]{EnumAttributes.LUCK.getUnlocalized()}));
        registerPrefix(new Prefix("sluggish", ConfigurationHandler.chance_weapons_sluggish, TextFormatting.DARK_RED, new AttributeModifier[]{new AttributeModifier(EnumAttributes.ATTACK_SPEED.getUnlocalized(), -2, 0), new AttributeModifier(EnumAttributes.MOVEMENT_SPEED.getUnlocalized(), -0.05, 0)}, new String[]{EnumAttributes.ATTACK_SPEED.getUnlocalized(), EnumAttributes.MOVEMENT_SPEED.getUnlocalized()}));
        registerPrefix(new Prefix("sluggish", ConfigurationHandler.chance_weapons_sluggish, TextFormatting.DARK_RED, new AttributeModifier[]{new AttributeModifier(EnumAttributes.ATTACK_SPEED.getUnlocalized(), -3, 0), new AttributeModifier(EnumAttributes.MOVEMENT_SPEED.getUnlocalized(), -0.025, 0)}, new String[]{EnumAttributes.ATTACK_SPEED.getUnlocalized(), EnumAttributes.MOVEMENT_SPEED.getUnlocalized()}));
        registerPrefix(new Prefix("annoying", ConfigurationHandler.chance_weapons_annoying, TextFormatting.RED, new AttributeModifier[]{new AttributeModifier(EnumAttributes.ATTACK_DAMAGE.getUnlocalized(), -2, 0), new AttributeModifier(EnumAttributes.ATTACK_SPEED.getUnlocalized(), -1, 0)}, new String[]{EnumAttributes.ATTACK_DAMAGE.getUnlocalized(), EnumAttributes.ATTACK_SPEED.getUnlocalized()}));
        registerPrefix(new Prefix("annoying", ConfigurationHandler.chance_weapons_annoying, TextFormatting.RED, new AttributeModifier[]{new AttributeModifier(EnumAttributes.ATTACK_DAMAGE.getUnlocalized(), -1, 0), new AttributeModifier(EnumAttributes.ATTACK_SPEED.getUnlocalized(), -2, 0)}, new String[]{EnumAttributes.ATTACK_DAMAGE.getUnlocalized(), EnumAttributes.ATTACK_SPEED.getUnlocalized()}));
        registerPrefix(new Prefix("frenzying", ConfigurationHandler.chance_weapons_frenzying, TextFormatting.LIGHT_PURPLE, new AttributeModifier[]{new AttributeModifier(EnumAttributes.ATTACK_DAMAGE.getUnlocalized(), -7, 0), new AttributeModifier(EnumAttributes.ATTACK_SPEED.getUnlocalized(), 7, 0)}, new String[]{EnumAttributes.ATTACK_DAMAGE.getUnlocalized(), EnumAttributes.ATTACK_SPEED.getUnlocalized()}));
        registerPrefix(new Prefix("frenzying", ConfigurationHandler.chance_weapons_frenzying, TextFormatting.LIGHT_PURPLE, new AttributeModifier[]{new AttributeModifier(EnumAttributes.ATTACK_DAMAGE.getUnlocalized(), -5, 0), new AttributeModifier(EnumAttributes.ATTACK_SPEED.getUnlocalized(), 5, 0)}, new String[]{EnumAttributes.ATTACK_DAMAGE.getUnlocalized(), EnumAttributes.ATTACK_SPEED.getUnlocalized()}));
        registerPrefix(new Prefix("frenzying", ConfigurationHandler.chance_weapons_frenzying, TextFormatting.LIGHT_PURPLE, new AttributeModifier[]{new AttributeModifier(EnumAttributes.ATTACK_DAMAGE.getUnlocalized(), -3, 0), new AttributeModifier(EnumAttributes.ATTACK_SPEED.getUnlocalized(), 3, 0)}, new String[]{EnumAttributes.ATTACK_DAMAGE.getUnlocalized(), EnumAttributes.ATTACK_SPEED.getUnlocalized()}));
        registerPrefix(new Prefix("deadly", ConfigurationHandler.chance_weapons_deadly, TextFormatting.BLUE, new AttributeModifier[]{new AttributeModifier(EnumAttributes.ATTACK_DAMAGE.getUnlocalized(), 5, 0), new AttributeModifier(EnumAttributes.ATTACK_SPEED.getUnlocalized(), 2, 0)}, new String[]{EnumAttributes.ATTACK_DAMAGE.getUnlocalized(), EnumAttributes.ATTACK_SPEED.getUnlocalized()}));
        registerPrefix(new Prefix("deadly", ConfigurationHandler.chance_weapons_deadly, TextFormatting.BLUE, new AttributeModifier[]{new AttributeModifier(EnumAttributes.ATTACK_DAMAGE.getUnlocalized(), 6, 0), new AttributeModifier(EnumAttributes.ATTACK_SPEED.getUnlocalized(), 3, 0)}, new String[]{EnumAttributes.ATTACK_DAMAGE.getUnlocalized(), EnumAttributes.ATTACK_SPEED.getUnlocalized()}));
        registerPrefix(new Prefix("quick", ConfigurationHandler.chance_weapons_quick, TextFormatting.GREEN, new AttributeModifier[]{new AttributeModifier(EnumAttributes.ATTACK_SPEED.getUnlocalized(), 8, 0), new AttributeModifier(EnumAttributes.MOVEMENT_SPEED.getUnlocalized(), 0.3, 0)}, new String[]{EnumAttributes.ATTACK_SPEED.getUnlocalized(), EnumAttributes.MOVEMENT_SPEED.getUnlocalized()}));
        registerPrefix(new Prefix("godly", ConfigurationHandler.chance_weapons_godly, TextFormatting.YELLOW, new AttributeModifier[]{new AttributeModifier(EnumAttributes.ATTACK_DAMAGE.getUnlocalized(), 15, 0), new AttributeModifier(EnumAttributes.MOVEMENT_SPEED.getUnlocalized(), 0.15, 0), new AttributeModifier(EnumAttributes.MAX_HEALTH.getUnlocalized(), 5, 0)}, new String[]{EnumAttributes.ATTACK_DAMAGE.getUnlocalized(), EnumAttributes.MOVEMENT_SPEED.getUnlocalized(), EnumAttributes.MAX_HEALTH.getUnlocalized()}));
        registerPrefix(new Prefix("godly", ConfigurationHandler.chance_weapons_godly, TextFormatting.YELLOW, new AttributeModifier[]{new AttributeModifier(EnumAttributes.ATTACK_DAMAGE.getUnlocalized(), 15, 0), new AttributeModifier(EnumAttributes.ATTACK_SPEED.getUnlocalized(), -1, 0), new AttributeModifier(EnumAttributes.LUCK.getUnlocalized(), 2, 0)}, new String[]{EnumAttributes.ATTACK_DAMAGE.getUnlocalized(), EnumAttributes.ATTACK_SPEED.getUnlocalized(), EnumAttributes.LUCK.getUnlocalized()}));
        registerPrefix(new Prefix("legendary", ConfigurationHandler.chance_weapons_legendary, TextFormatting.GOLD, new AttributeModifier[]{new AttributeModifier(EnumAttributes.ATTACK_DAMAGE.getUnlocalized(), 15, 0), new AttributeModifier(EnumAttributes.ATTACK_SPEED.getUnlocalized(), 5, 0), new AttributeModifier(EnumAttributes.MOVEMENT_SPEED.getUnlocalized(), 0.3, 0)}, new String[]{EnumAttributes.ATTACK_DAMAGE.getUnlocalized(), EnumAttributes.ATTACK_SPEED.getUnlocalized(), EnumAttributes.MOVEMENT_SPEED.getUnlocalized()}));
        registerPrefix(new Prefix("legendary", ConfigurationHandler.chance_weapons_legendary, TextFormatting.GOLD, new AttributeModifier[]{new AttributeModifier(EnumAttributes.ATTACK_DAMAGE.getUnlocalized(), 20, 0), new AttributeModifier(EnumAttributes.ATTACK_SPEED.getUnlocalized(), 2, 0), new AttributeModifier(EnumAttributes.LUCK.getUnlocalized(), 3, 0)}, new String[]{EnumAttributes.ATTACK_DAMAGE.getUnlocalized(), EnumAttributes.ATTACK_SPEED.getUnlocalized(), EnumAttributes.LUCK.getUnlocalized()}));
    }

    private static void registerPrefix(BasePrefix prefix) {
        weapon_prefixes.add(prefix);
        ModLogger.info("Registered " + prefix.getPrefixName() + " at " + weapon_prefixes.indexOf(prefix) + " with chance " + prefix.getChance());
    }

}

