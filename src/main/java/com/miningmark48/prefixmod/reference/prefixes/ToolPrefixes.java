package com.miningmark48.prefixmod.reference.prefixes;

import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.util.text.TextFormatting;

import java.util.HashMap;

public class ToolPrefixes {

    public static HashMap<Prefixes, AttributeModifier[]> modifierMap = new java.util.HashMap<>();
    public static HashMap<ToolPrefixes.Prefixes, String[]> modifierNameMap = new HashMap<>();
    public static HashMap<ToolPrefixes.Prefixes, TextFormatting> colorMap = new HashMap<>();

    public static void init() {
        modifierMap.clear();
        modifierNameMap.clear();
        colorMap.clear();

        addToMaps(ToolPrefixes.Prefixes.GODLY, new AttributeModifier[]{new AttributeModifier("generic.attackDamage", 15, 0)}, new String[]{"generic.attackDamage"});
        addToMaps(ToolPrefixes.Prefixes.QUICK, new AttributeModifier[]{new AttributeModifier("generic.attackSpeed", 1, 0)}, new String[]{"generic.attackSpeed"});

    }

    private static void addToMaps(ToolPrefixes.Prefixes prefix, AttributeModifier[] modifiers, String[] attributeNames){
        modifierMap.put(prefix, modifiers);
        modifierNameMap.put(prefix, attributeNames);
        colorMap.put(prefix, TextFormatting.DARK_AQUA);
    }

    private static void addToMaps(ToolPrefixes.Prefixes prefix, AttributeModifier[] modifiers, String[] attributeNames, TextFormatting color){
        modifierMap.put(prefix, modifiers);
        modifierNameMap.put(prefix, attributeNames);
        colorMap.put(prefix, color);
    }

    public enum Prefixes {
        GODLY,
        QUICK
    }

}
