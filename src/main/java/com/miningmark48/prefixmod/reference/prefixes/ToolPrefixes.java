package com.miningmark48.prefixmod.reference.prefixes;

import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.util.text.TextFormatting;

import java.util.HashMap;

public class ToolPrefixes {

    public static HashMap<Integer, ToolPrefixes.Prefixes> prefixNameMap = new HashMap<>();
    public static HashMap<Integer, AttributeModifier[]> modifierMap = new HashMap<>();
    public static HashMap<Integer, String[]> modifierNameMap = new HashMap<>();
    public static HashMap<ToolPrefixes.Prefixes, TextFormatting> colorMap = new HashMap<>();

    public static void init() {
        clearMaps();

        addToMaps(0, ToolPrefixes.Prefixes.LEGENDARY, new AttributeModifier[]{new AttributeModifier("generic.attackDamage", 15, 0), new AttributeModifier("generic.movementSpeed", 0.2, 0)}, new String[]{"generic.attackDamage", "generic.movementSpeed"});
        addToMaps(1, ToolPrefixes.Prefixes.LEGENDARY, new AttributeModifier[]{new AttributeModifier("generic.attackDamage", 25, 0)}, new String[]{"generic.attackDamage"});
        addToMaps(2, ToolPrefixes.Prefixes.GODLY, new AttributeModifier[]{new AttributeModifier("generic.attackDamage", 10, 0)}, new String[]{"generic.attackDamage"});
        addToMaps(3, ToolPrefixes.Prefixes.DEADLY, new AttributeModifier[]{new AttributeModifier("generic.attackDamage", 5, 0)}, new String[]{"generic.attackDamage"});
        addToMaps(4, ToolPrefixes.Prefixes.QUICK, new AttributeModifier[]{new AttributeModifier("generic.attackSpeed", 1, 0)}, new String[]{"generic.attackSpeed"});

        addPrefixColor(ToolPrefixes.Prefixes.LEGENDARY, TextFormatting.GOLD);
        addPrefixColor(ToolPrefixes.Prefixes.GODLY, TextFormatting.YELLOW);
        addPrefixColor(ToolPrefixes.Prefixes.DEADLY, TextFormatting.RED);
        addPrefixColor(ToolPrefixes.Prefixes.QUICK, TextFormatting.GREEN);
    }

    public enum Prefixes {
        LEGENDARY,
        GODLY,
        DEADLY,
        QUICK
    }

    private static void clearMaps(){
        prefixNameMap.clear();
        modifierMap.clear();
        modifierNameMap.clear();
        colorMap.clear();
    }

    private static void addToMaps(int index, ToolPrefixes.Prefixes prefix, AttributeModifier[] modifiers, String[] attributeNames){
        prefixNameMap.put(index, prefix);
        modifierMap.put(index, modifiers);
        modifierNameMap.put(index, attributeNames);
    }

    private static void addPrefixColor(ToolPrefixes.Prefixes prefix, TextFormatting color) {
        colorMap.put(prefix, color);
    }

}
