package com.miningmark48.prefixation.init.prefixes;

import com.miningmark48.prefixation.base.prefix.BasePrefix;
import com.miningmark48.prefixation.base.prefix.Prefix;
import com.miningmark48.prefixation.reference.EnumAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.util.text.TextFormatting;

import java.util.HashMap;

public class ArmorPrefixesHandler {

    public static HashMap<Integer, BasePrefix> prefixes = new HashMap<>();

    public static void init() {
        prefixes.clear();
        int i = 0;

        registerPrefix(i, new Prefix("legendary", 0.1f, TextFormatting.GOLD, new AttributeModifier[]{new AttributeModifier(EnumAttributes.ARMOR.getUnlocalized(), 4, 0), new AttributeModifier(EnumAttributes.ARMOR_TOUGHNESS.getUnlocalized(), 2, 0), new AttributeModifier(EnumAttributes.MAX_HEALTH.getUnlocalized(), 4, 0), new AttributeModifier(EnumAttributes.ATTACK_DAMAGE.getUnlocalized(), 4, 0)},  new String[]{EnumAttributes.ARMOR.getUnlocalized(), EnumAttributes.ARMOR_TOUGHNESS.getUnlocalized(), EnumAttributes.MAX_HEALTH.getUnlocalized(), EnumAttributes.ATTACK_DAMAGE.getUnlocalized()}));

//        addToMaps(i, Prefixes.LEGENDARY, new AttributeModifier[]{new AttributeModifier(EnumAttributes.ARMOR.getUnlocalized(), 4, 0), new AttributeModifier(EnumAttributes.ARMOR_TOUGHNESS.getUnlocalized(), 2, 0), new AttributeModifier(EnumAttributes.MAX_HEALTH.getUnlocalized(), 4, 0), new AttributeModifier(EnumAttributes.ATTACK_DAMAGE.getUnlocalized(), 4, 0)}, new String[]{EnumAttributes.ARMOR.getUnlocalized(), EnumAttributes.ARMOR_TOUGHNESS.getUnlocalized(), EnumAttributes.MAX_HEALTH.getUnlocalized(), EnumAttributes.ATTACK_DAMAGE.getUnlocalized()});
//        addToMaps(i++, Prefixes.GODLY, new AttributeModifier[]{new AttributeModifier(EnumAttributes.ARMOR_TOUGHNESS.getUnlocalized(), 4, 0), new AttributeModifier(EnumAttributes.MAX_HEALTH.getUnlocalized(), 2, 0), new AttributeModifier(EnumAttributes.ATTACK_DAMAGE.getUnlocalized(), 2, 0)}, new String[]{EnumAttributes.ARMOR_TOUGHNESS.getUnlocalized(), EnumAttributes.MAX_HEALTH.getUnlocalized(), EnumAttributes.ATTACK_DAMAGE.getUnlocalized()});
//        addToMaps(i++, Prefixes.DURABLE, new AttributeModifier[]{new AttributeModifier(EnumAttributes.ARMOR_TOUGHNESS.getUnlocalized(), 6, 0)}, new String[]{EnumAttributes.ARMOR_TOUGHNESS.getUnlocalized()});
//        addToMaps(i++, Prefixes.HEAVY, new AttributeModifier[]{new AttributeModifier(EnumAttributes.MOVEMENT_SPEED.getUnlocalized(), -0.015, 0), new AttributeModifier(EnumAttributes.ARMOR_TOUGHNESS.getUnlocalized(), 2, 0), new AttributeModifier(EnumAttributes.KNOCKBACK_RESISTANCE.getUnlocalized(), 2, 0)}, new String[]{EnumAttributes.MOVEMENT_SPEED.getUnlocalized(), EnumAttributes.ARMOR_TOUGHNESS.getUnlocalized(), EnumAttributes.KNOCKBACK_RESISTANCE.getUnlocalized()});
//        addToMaps(i++, Prefixes.LIGHT, new AttributeModifier[]{new AttributeModifier(EnumAttributes.MOVEMENT_SPEED.getUnlocalized(), 0.015, 0), new AttributeModifier(EnumAttributes.ARMOR_TOUGHNESS.getUnlocalized(), -2, 0), new AttributeModifier(EnumAttributes.KNOCKBACK_RESISTANCE.getUnlocalized(), -2, 0)}, new String[]{EnumAttributes.MOVEMENT_SPEED.getUnlocalized(), EnumAttributes.ARMOR_TOUGHNESS.getUnlocalized(), EnumAttributes.KNOCKBACK_RESISTANCE.getUnlocalized()});
//        addToMaps(i++, Prefixes.QUICK, new AttributeModifier[]{new AttributeModifier(EnumAttributes.ATTACK_SPEED.getUnlocalized(), 8, 0), new AttributeModifier(EnumAttributes.MOVEMENT_SPEED.getUnlocalized(), 0.3, 0)}, new String[]{EnumAttributes.ATTACK_SPEED.getUnlocalized(), EnumAttributes.MOVEMENT_SPEED.getUnlocalized()});
//        addToMaps(i++, Prefixes.LUCKY, new AttributeModifier[]{new AttributeModifier(EnumAttributes.LUCK.getUnlocalized(), 5, 0)}, new String[]{EnumAttributes.LUCK.getUnlocalized()});
//        addToMaps(i++, Prefixes.LUCKY, new AttributeModifier[]{new AttributeModifier(EnumAttributes.LUCK.getUnlocalized(), 7, 0)}, new String[]{EnumAttributes.LUCK.getUnlocalized()});
//
//        addPrefixColor(Prefixes.LEGENDARY, TextFormatting.GOLD);
//        addPrefixColor(Prefixes.GODLY, TextFormatting.YELLOW);
//        addPrefixColor(Prefixes.DURABLE, TextFormatting.DARK_BLUE);
//        addPrefixColor(Prefixes.HEAVY, TextFormatting.DARK_PURPLE);
//        addPrefixColor(Prefixes.LIGHT, TextFormatting.AQUA);
//        addPrefixColor(Prefixes.QUICK, TextFormatting.GREEN);
//        addPrefixColor(Prefixes.LUCKY, TextFormatting.DARK_GREEN);
    }

    private static void registerPrefix(int index, BasePrefix prefix) {
        prefixes.put(index, prefix);
    }

}
