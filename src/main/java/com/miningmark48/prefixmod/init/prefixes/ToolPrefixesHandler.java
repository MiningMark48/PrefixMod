package com.miningmark48.prefixmod.init.prefixes;

import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.util.text.TextFormatting;

import java.util.HashMap;

public class ToolPrefixesHandler {

    public static HashMap<Integer, Enum> prefixNameMap = new HashMap<>();
    public static HashMap<Integer, AttributeModifier[]> modifierMap = new HashMap<>();
    public static HashMap<Integer, String[]> modifierNameMap = new HashMap<>();
    public static HashMap<ToolPrefixesHandler.Prefixes, TextFormatting> colorMap = new HashMap<>();

    public static void init() {
        clearMaps();

        int i = 0;
        addToMaps(i, ToolPrefixesHandler.Prefixes.LEGENDARY, new AttributeModifier[]{new AttributeModifier("generic.attackDamage", 15, 0), new AttributeModifier("generic.movementSpeed", 0.2, 0)}, new String[]{"generic.attackDamage", "generic.movementSpeed"});
        addToMaps(i++, ToolPrefixesHandler.Prefixes.LEGENDARY, new AttributeModifier[]{new AttributeModifier("generic.attackDamage", 25, 0)}, new String[]{"generic.attackDamage"});
        addToMaps(i++, ToolPrefixesHandler.Prefixes.GODLY, new AttributeModifier[]{new AttributeModifier("generic.attackDamage", 10, 0)}, new String[]{"generic.attackDamage"});
        addToMaps(i++, ToolPrefixesHandler.Prefixes.DEADLY, new AttributeModifier[]{new AttributeModifier("generic.attackDamage", 5, 0)}, new String[]{"generic.attackDamage"});
        addToMaps(i++, ToolPrefixesHandler.Prefixes.QUICK, new AttributeModifier[]{new AttributeModifier("generic.attackSpeed", 1, 0)}, new String[]{"generic.attackSpeed"});

        addPrefixColor(ToolPrefixesHandler.Prefixes.LEGENDARY, TextFormatting.GOLD);
        addPrefixColor(ToolPrefixesHandler.Prefixes.GODLY, TextFormatting.YELLOW);
        addPrefixColor(ToolPrefixesHandler.Prefixes.DEADLY, TextFormatting.RED);
        addPrefixColor(ToolPrefixesHandler.Prefixes.QUICK, TextFormatting.GREEN);
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

    private static void addToMaps(int index, ToolPrefixesHandler.Prefixes prefix, AttributeModifier[] modifiers, String[] attributeNames){
        prefixNameMap.put(index, prefix);
        modifierMap.put(index, modifiers);
        modifierNameMap.put(index, attributeNames);
    }

    private static void addPrefixColor(ToolPrefixesHandler.Prefixes prefix, TextFormatting color) {
        colorMap.put(prefix, color);
    }

}
