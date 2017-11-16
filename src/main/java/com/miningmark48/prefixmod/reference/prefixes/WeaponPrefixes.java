package com.miningmark48.prefixmod.reference.prefixes;

import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.util.text.TextFormatting;

import java.util.HashMap;

public class WeaponPrefixes {

    public static HashMap<Prefixes, AttributeModifier[]> modifierMap = new HashMap<>();
    public static HashMap<Prefixes, String[]> modifierNameMap = new HashMap<>();
    public static HashMap<Prefixes, TextFormatting> colorMap = new HashMap<>();

    public static void init() {
        modifierMap.clear();
        modifierNameMap.clear();
        colorMap.clear();

        addToMaps(Prefixes.LEGENDARY, new AttributeModifier[]{new AttributeModifier("generic.attackDamage", 15, 0), new AttributeModifier("generic.movementSpeed", 0.2, 0)}, new String[]{"generic.attackDamage", "generic.movementSpeed"}, TextFormatting.GOLD);
        addToMaps(Prefixes.GODLY, new AttributeModifier[]{new AttributeModifier("generic.attackDamage", 10, 0)}, new String[]{"generic.attackDamage"}, TextFormatting.YELLOW);
        addToMaps(Prefixes.DEADLY, new AttributeModifier[]{new AttributeModifier("generic.attackDamage", 5, 0)}, new String[]{"generic.attackDamage"}, TextFormatting.RED);
        addToMaps(Prefixes.QUICK, new AttributeModifier[]{new AttributeModifier("generic.attackSpeed", 1, 0)}, new String[]{"generic.attackSpeed"});

    }

    private static void addToMaps(Prefixes prefix, AttributeModifier[] modifiers, String[] attributeNames){
        modifierMap.put(prefix, modifiers);
        modifierNameMap.put(prefix, attributeNames);
        colorMap.put(prefix, TextFormatting.DARK_AQUA);
    }

    private static void addToMaps(Prefixes prefix, AttributeModifier[] modifiers, String[] attributeNames, TextFormatting color){
        modifierMap.put(prefix, modifiers);
        modifierNameMap.put(prefix, attributeNames);
        colorMap.put(prefix, color);
    }

    public enum Prefixes {
        LEGENDARY,
        GODLY,
        DEADLY,
        QUICK
    }

}

