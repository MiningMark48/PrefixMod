package com.miningmark48.prefixmod.init.prefixes;

import com.miningmark48.prefixmod.reference.EnumAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.util.text.TextFormatting;

import java.util.HashMap;

public class ArmorPrefixesHandler {

    public static HashMap<Integer, Enum> prefixNameMap = new HashMap<>();
    public static HashMap<Integer, AttributeModifier[]> modifierMap = new HashMap<>();
    public static HashMap<Integer, String[]> modifierNameMap = new HashMap<>();
    public static HashMap<ArmorPrefixesHandler.Prefixes, TextFormatting> colorMap = new HashMap<>();

    public static void init() {
        clearMaps();

        int i = 0;
        addToMaps(i, Prefixes.LEGENDARY, new AttributeModifier[]{new AttributeModifier(EnumAttributes.ARMOR.getUnlocalized(), 4, 0), new AttributeModifier(EnumAttributes.ARMOR_TOUGHNESS.getUnlocalized(), 2, 0), new AttributeModifier(EnumAttributes.MAX_HEALTH.getUnlocalized(), 4, 0), new AttributeModifier(EnumAttributes.ATTACK_DAMAGE.getUnlocalized(), 4, 0)}, new String[]{EnumAttributes.ARMOR.getUnlocalized(), EnumAttributes.ARMOR_TOUGHNESS.getUnlocalized(), EnumAttributes.MAX_HEALTH.getUnlocalized(), EnumAttributes.ATTACK_DAMAGE.getUnlocalized()});
        addToMaps(i++, Prefixes.GODLY, new AttributeModifier[]{new AttributeModifier(EnumAttributes.ARMOR_TOUGHNESS.getUnlocalized(), 4, 0), new AttributeModifier(EnumAttributes.MAX_HEALTH.getUnlocalized(), 2, 0), new AttributeModifier(EnumAttributes.ATTACK_DAMAGE.getUnlocalized(), 2, 0)}, new String[]{EnumAttributes.ARMOR_TOUGHNESS.getUnlocalized(), EnumAttributes.MAX_HEALTH.getUnlocalized(), EnumAttributes.ATTACK_DAMAGE.getUnlocalized()});
        addToMaps(i++, Prefixes.DURABLE, new AttributeModifier[]{new AttributeModifier(EnumAttributes.ARMOR_TOUGHNESS.getUnlocalized(), 6, 0)}, new String[]{EnumAttributes.ARMOR_TOUGHNESS.getUnlocalized()});
        addToMaps(i++, Prefixes.HEAVY, new AttributeModifier[]{new AttributeModifier(EnumAttributes.MOVEMENT_SPEED.getUnlocalized(), -0.015, 0), new AttributeModifier(EnumAttributes.ARMOR_TOUGHNESS.getUnlocalized(), 2, 0), new AttributeModifier(EnumAttributes.KNOCKBACK_RESISTANCE.getUnlocalized(), 2, 0)}, new String[]{EnumAttributes.MOVEMENT_SPEED.getUnlocalized(), EnumAttributes.ARMOR_TOUGHNESS.getUnlocalized(), EnumAttributes.KNOCKBACK_RESISTANCE.getUnlocalized()});
        addToMaps(i++, Prefixes.LIGHT, new AttributeModifier[]{new AttributeModifier(EnumAttributes.MOVEMENT_SPEED.getUnlocalized(), 0.015, 0), new AttributeModifier(EnumAttributes.ARMOR_TOUGHNESS.getUnlocalized(), -2, 0), new AttributeModifier(EnumAttributes.KNOCKBACK_RESISTANCE.getUnlocalized(), -2, 0)}, new String[]{EnumAttributes.MOVEMENT_SPEED.getUnlocalized(), EnumAttributes.ARMOR_TOUGHNESS.getUnlocalized(), EnumAttributes.KNOCKBACK_RESISTANCE.getUnlocalized()});

        addPrefixColor(Prefixes.LEGENDARY, TextFormatting.GOLD);
        addPrefixColor(Prefixes.GODLY, TextFormatting.YELLOW);
        addPrefixColor(Prefixes.DURABLE, TextFormatting.DARK_BLUE);
        addPrefixColor(Prefixes.HEAVY, TextFormatting.DARK_PURPLE);
        addPrefixColor(Prefixes.LIGHT, TextFormatting.AQUA);
    }

    public enum Prefixes {
        LEGENDARY,
        GODLY,
        DURABLE,
        HEAVY,
        LIGHT
    }

    private static void clearMaps(){
        prefixNameMap.clear();
        modifierMap.clear();
        modifierNameMap.clear();
        colorMap.clear();
    }

    private static void addToMaps(int index, ArmorPrefixesHandler.Prefixes prefix, AttributeModifier[] modifiers, String[] attributeNames){
        prefixNameMap.put(index, prefix);
        modifierMap.put(index, modifiers);
        modifierNameMap.put(index, attributeNames);
    }

    private static void addPrefixColor(ArmorPrefixesHandler.Prefixes prefix, TextFormatting color) {
        colorMap.put(prefix, color);
    }

}
