package com.miningmark48.prefixation.init.prefixes;

import com.miningmark48.prefixation.base.prefix.BasePrefix;
import com.miningmark48.prefixation.base.prefix.Prefix;
import com.miningmark48.prefixation.handler.ConfigurationHandler;
import com.miningmark48.prefixation.reference.EnumAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.util.text.TextFormatting;

import java.util.ArrayList;
import java.util.HashMap;

public class ArmorPrefixesHandler {

    public static ArrayList<BasePrefix> armor_prefixes = new ArrayList<>();

    public static void init() {
        armor_prefixes.clear();

        registerPrefix(new Prefix("lucky", ConfigurationHandler.chance_armor_lucky, TextFormatting.DARK_GREEN, new AttributeModifier[]{new AttributeModifier(EnumAttributes.LUCK.getUnlocalized(), 5, 0)}, new String[]{EnumAttributes.LUCK.getUnlocalized()}));
        registerPrefix(new Prefix("lucky", ConfigurationHandler.chance_armor_lucky, TextFormatting.DARK_GREEN, new AttributeModifier[]{new AttributeModifier(EnumAttributes.LUCK.getUnlocalized(), 7, 0)}, new String[]{EnumAttributes.LUCK.getUnlocalized()}));
        registerPrefix(new Prefix("quick", ConfigurationHandler.chance_armor_quick, TextFormatting.GREEN, new AttributeModifier[]{new AttributeModifier(EnumAttributes.ATTACK_SPEED.getUnlocalized(), 8, 0), new AttributeModifier(EnumAttributes.MOVEMENT_SPEED.getUnlocalized(), 0.3, 0)}, new String[]{EnumAttributes.ATTACK_SPEED.getUnlocalized(), EnumAttributes.MOVEMENT_SPEED.getUnlocalized()}));
        registerPrefix(new Prefix("light", ConfigurationHandler.chance_armor_light, TextFormatting.AQUA, new AttributeModifier[]{new AttributeModifier(EnumAttributes.MOVEMENT_SPEED.getUnlocalized(), 0.015, 0), new AttributeModifier(EnumAttributes.ARMOR_TOUGHNESS.getUnlocalized(), -2, 0), new AttributeModifier(EnumAttributes.KNOCKBACK_RESISTANCE.getUnlocalized(), -2, 0)}, new String[]{EnumAttributes.MOVEMENT_SPEED.getUnlocalized(), EnumAttributes.ARMOR_TOUGHNESS.getUnlocalized(), EnumAttributes.KNOCKBACK_RESISTANCE.getUnlocalized()}));
        registerPrefix(new Prefix("heavy", ConfigurationHandler.chance_armor_heavy, TextFormatting.DARK_PURPLE, new AttributeModifier[]{new AttributeModifier(EnumAttributes.MOVEMENT_SPEED.getUnlocalized(), -0.015, 0), new AttributeModifier(EnumAttributes.ARMOR_TOUGHNESS.getUnlocalized(), 2, 0), new AttributeModifier(EnumAttributes.KNOCKBACK_RESISTANCE.getUnlocalized(), 2, 0)}, new String[]{EnumAttributes.MOVEMENT_SPEED.getUnlocalized(), EnumAttributes.ARMOR_TOUGHNESS.getUnlocalized(), EnumAttributes.KNOCKBACK_RESISTANCE.getUnlocalized()}));
        registerPrefix(new Prefix("durable", ConfigurationHandler.chance_armor_durable, TextFormatting.DARK_BLUE, new AttributeModifier[]{new AttributeModifier(EnumAttributes.ARMOR_TOUGHNESS.getUnlocalized(), 6, 0)}, new String[]{EnumAttributes.ARMOR_TOUGHNESS.getUnlocalized()}));
        registerPrefix(new Prefix("godly", ConfigurationHandler.chance_armor_godly, TextFormatting.YELLOW, new AttributeModifier[]{new AttributeModifier(EnumAttributes.ARMOR_TOUGHNESS.getUnlocalized(), 4, 0), new AttributeModifier(EnumAttributes.MAX_HEALTH.getUnlocalized(), 2, 0), new AttributeModifier(EnumAttributes.ATTACK_DAMAGE.getUnlocalized(), 2, 0)}, new String[]{EnumAttributes.ARMOR_TOUGHNESS.getUnlocalized(), EnumAttributes.MAX_HEALTH.getUnlocalized(), EnumAttributes.ATTACK_DAMAGE.getUnlocalized()}));
        registerPrefix(new Prefix("legendary", ConfigurationHandler.chance_armor_legendary, TextFormatting.GOLD, new AttributeModifier[]{new AttributeModifier(EnumAttributes.ARMOR.getUnlocalized(), 4, 0), new AttributeModifier(EnumAttributes.ARMOR_TOUGHNESS.getUnlocalized(), 2, 0), new AttributeModifier(EnumAttributes.MAX_HEALTH.getUnlocalized(), 4, 0), new AttributeModifier(EnumAttributes.ATTACK_DAMAGE.getUnlocalized(), 4, 0)},  new String[]{EnumAttributes.ARMOR.getUnlocalized(), EnumAttributes.ARMOR_TOUGHNESS.getUnlocalized(), EnumAttributes.MAX_HEALTH.getUnlocalized(), EnumAttributes.ATTACK_DAMAGE.getUnlocalized()}));
    }

    private static void registerPrefix(BasePrefix prefix) {
        armor_prefixes.add(prefix);
    }

}
