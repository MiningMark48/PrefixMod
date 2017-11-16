package com.miningmark48.prefixmod.reference.prefixes;

import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.util.text.TextFormatting;

import java.util.HashMap;

public class WeaponPrefixes {

    public static HashMap<Integer, Enum> prefixNameMap = new HashMap<>();
    public static HashMap<Integer, AttributeModifier[]> modifierMap = new HashMap<>();
    public static HashMap<Integer, String[]> modifierNameMap = new HashMap<>();
    public static HashMap<Prefixes, TextFormatting> colorMap = new HashMap<>();

    public static void init() {
        clearMaps();

        addToMaps(0, Prefixes.LEGENDARY, new AttributeModifier[]{new AttributeModifier("generic.attackDamage", 15, 0), new AttributeModifier("generic.movementSpeed", 0.2, 0)}, new String[]{"generic.attackDamage", "generic.movementSpeed"});
        addToMaps(1, Prefixes.LEGENDARY, new AttributeModifier[]{new AttributeModifier("generic.attackDamage", 25, 0)}, new String[]{"generic.attackDamage"});
        addToMaps(2, Prefixes.GODLY, new AttributeModifier[]{new AttributeModifier("generic.attackDamage", 10, 0)}, new String[]{"generic.attackDamage"});
        addToMaps(3, Prefixes.DEADLY, new AttributeModifier[]{new AttributeModifier("generic.attackDamage", 5, 0)}, new String[]{"generic.attackDamage"});
        addToMaps(4, Prefixes.QUICK, new AttributeModifier[]{new AttributeModifier("generic.attackSpeed", 1, 0)}, new String[]{"generic.attackSpeed"});

        addPrefixColor(Prefixes.LEGENDARY, TextFormatting.GOLD);
        addPrefixColor(Prefixes.GODLY, TextFormatting.YELLOW);
        addPrefixColor(Prefixes.DEADLY, TextFormatting.RED);
        addPrefixColor(Prefixes.QUICK, TextFormatting.GREEN);
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

    private static void addToMaps(int index, Prefixes prefix, AttributeModifier[] modifiers, String[] attributeNames){
        prefixNameMap.put(index, prefix);
        modifierMap.put(index, modifiers);
        modifierNameMap.put(index, attributeNames);
    }

    private static void addPrefixColor(Prefixes prefix, TextFormatting color) {
        colorMap.put(prefix, color);
    }

}

