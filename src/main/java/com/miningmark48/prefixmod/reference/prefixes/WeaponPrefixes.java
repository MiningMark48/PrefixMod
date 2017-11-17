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

        int i = 0;
        addToMaps(i, Prefixes.LEGENDARY, new AttributeModifier[]{new AttributeModifier("generic.attackDamage", 15, 0), new AttributeModifier("generic.attackSpeed", 5, 0), new AttributeModifier("generic.movementSpeed", 0.3, 0)}, new String[]{"generic.attackDamage", "generic.attackSpeed", "generic.movementSpeed"});
        addToMaps(i++, Prefixes.LEGENDARY, new AttributeModifier[]{new AttributeModifier("generic.attackDamage", 20, 0), new AttributeModifier("generic.attackSpeed", 2, 0)}, new String[]{"generic.attackDamage", "generic.attackSpeed"});
        addToMaps(i++, Prefixes.GODLY, new AttributeModifier[]{new AttributeModifier("generic.attackDamage", 15, 0), new AttributeModifier("generic.movementSpeed", 0.15, 0)}, new String[]{"generic.attackDamage", "generic.movementSpeed"});
        addToMaps(i++, Prefixes.GODLY, new AttributeModifier[]{new AttributeModifier("generic.attackDamage", 15, 0), new AttributeModifier("generic.attackSpeed", -1, 0)}, new String[]{"generic.attackDamage", "generic.attackSpeed"});
        addToMaps(i++, Prefixes.QUICK, new AttributeModifier[]{new AttributeModifier("generic.attackSpeed", 8, 0), new AttributeModifier("generic.movementSpeed", 0.3, 0)}, new String[]{"generic.attackSpeed", "generic.movementSpeed"});
        addToMaps(i++, Prefixes.FRENZYING, new AttributeModifier[]{new AttributeModifier("generic.attackDamage", -7, 0), new AttributeModifier("generic.attackSpeed", 7, 0)}, new String[]{"generic.attackDamage", "generic.attackSpeed"});
        addToMaps(i++, Prefixes.FRENZYING, new AttributeModifier[]{new AttributeModifier("generic.attackDamage", -5, 0), new AttributeModifier("generic.attackSpeed", 5, 0)}, new String[]{"generic.attackDamage", "generic.attackSpeed"});
        addToMaps(i++, Prefixes.FRENZYING, new AttributeModifier[]{new AttributeModifier("generic.attackDamage", -3, 0), new AttributeModifier("generic.attackSpeed", 3, 0)}, new String[]{"generic.attackDamage", "generic.attackSpeed"});
        addToMaps(i++, Prefixes.ANNOYING, new AttributeModifier[]{new AttributeModifier("generic.attackDamage", -2, 0), new AttributeModifier("generic.attackSpeed", -1, 0)}, new String[]{"generic.attackDamage", "generic.attackSpeed"});
        addToMaps(i++, Prefixes.ANNOYING, new AttributeModifier[]{new AttributeModifier("generic.attackDamage", -1, 0), new AttributeModifier("generic.attackSpeed", -2, 0)}, new String[]{"generic.attackDamage", "generic.attackSpeed"});
        addToMaps(i++, Prefixes.SLUGGISH, new AttributeModifier[]{new AttributeModifier("generic.attackSpeed", -2, 0), new AttributeModifier("generic.movementSpeed", -0.1, 0)}, new String[]{"generic.attackSpeed", "generic.movementSpeed"});
        addToMaps(i++, Prefixes.SLUGGISH, new AttributeModifier[]{new AttributeModifier("generic.attackSpeed", -3, 0), new AttributeModifier("generic.movementSpeed", -0.05, 0)}, new String[]{"generic.attackSpeed", "generic.movementSpeed"});

        addPrefixColor(Prefixes.LEGENDARY, TextFormatting.GOLD);
        addPrefixColor(Prefixes.GODLY, TextFormatting.YELLOW);
        addPrefixColor(Prefixes.QUICK, TextFormatting.GREEN);
        addPrefixColor(Prefixes.FRENZYING, TextFormatting.LIGHT_PURPLE);
        addPrefixColor(Prefixes.ANNOYING, TextFormatting.RED);
        addPrefixColor(Prefixes.SLUGGISH, TextFormatting.DARK_RED);
    }

    public enum Prefixes {
        LEGENDARY,
        GODLY,
        QUICK,
        FRENZYING,
        ANNOYING,
        SLUGGISH
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

