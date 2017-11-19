package com.miningmark48.prefixmod.init.prefixes;

import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.util.text.TextFormatting;

import java.util.HashMap;

public class WeaponPrefixesHandler {

    public static HashMap<Integer, Enum> prefixNameMap = new HashMap<>();
    public static HashMap<Integer, AttributeModifier[]> modifierMap = new HashMap<>();
    public static HashMap<Integer, String[]> modifierNameMap = new HashMap<>();
    public static HashMap<Prefixes, TextFormatting> colorMap = new HashMap<>();

    public static void init() {
        clearMaps();

        int i = 0;
        addToMaps(i, Prefixes.LEGENDARY, new AttributeModifier[]{new AttributeModifier("generic.attackDamage", 15, 0), new AttributeModifier("generic.attackSpeed", 5, 0), new AttributeModifier("generic.movementSpeed", 0.3, 0)}, new String[]{"generic.attackDamage", "generic.attackSpeed", "generic.movementSpeed"});
        addToMaps(i++, Prefixes.LEGENDARY, new AttributeModifier[]{new AttributeModifier("generic.attackDamage", 20, 0), new AttributeModifier("generic.attackSpeed", 2, 0), new AttributeModifier("generic.luck", 3, 0)}, new String[]{"generic.attackDamage", "generic.attackSpeed", "generic.luck"});
        addToMaps(i++, Prefixes.GODLY, new AttributeModifier[]{new AttributeModifier("generic.attackDamage", 15, 0), new AttributeModifier("generic.movementSpeed", 0.15, 0), new AttributeModifier("generic.maxHealth", 5, 0)}, new String[]{"generic.attackDamage", "generic.movementSpeed", "generic.maxHealth"});
        addToMaps(i++, Prefixes.GODLY, new AttributeModifier[]{new AttributeModifier("generic.attackDamage", 15, 0), new AttributeModifier("generic.attackSpeed", -1, 0), new AttributeModifier("generic.luck", 2, 0)}, new String[]{"generic.attackDamage", "generic.attackSpeed", "generic.luck"});
        addToMaps(i++, Prefixes.QUICK, new AttributeModifier[]{new AttributeModifier("generic.attackSpeed", 8, 0), new AttributeModifier("generic.movementSpeed", 0.3, 0)}, new String[]{"generic.attackSpeed", "generic.movementSpeed"});
        addToMaps(i++, Prefixes.DEADLY, new AttributeModifier[]{new AttributeModifier("generic.attackDamage", 5, 0), new AttributeModifier("generic.attackSpeed", 2, 0)}, new String[]{"generic.attackDamage", "generic.attackSpeed"});
        addToMaps(i++, Prefixes.DEADLY, new AttributeModifier[]{new AttributeModifier("generic.attackDamage", 6, 0), new AttributeModifier("generic.attackSpeed", 3, 0)}, new String[]{"generic.attackDamage", "generic.attackSpeed"});
        addToMaps(i++, Prefixes.FRENZYING, new AttributeModifier[]{new AttributeModifier("generic.attackDamage", -7, 0), new AttributeModifier("generic.attackSpeed", 7, 0)}, new String[]{"generic.attackDamage", "generic.attackSpeed"});
        addToMaps(i++, Prefixes.FRENZYING, new AttributeModifier[]{new AttributeModifier("generic.attackDamage", -5, 0), new AttributeModifier("generic.attackSpeed", 5, 0)}, new String[]{"generic.attackDamage", "generic.attackSpeed"});
        addToMaps(i++, Prefixes.FRENZYING, new AttributeModifier[]{new AttributeModifier("generic.attackDamage", -3, 0), new AttributeModifier("generic.attackSpeed", 3, 0)}, new String[]{"generic.attackDamage", "generic.attackSpeed"});
        addToMaps(i++, Prefixes.ANNOYING, new AttributeModifier[]{new AttributeModifier("generic.attackDamage", -2, 0), new AttributeModifier("generic.attackSpeed", -1, 0)}, new String[]{"generic.attackDamage", "generic.attackSpeed"});
        addToMaps(i++, Prefixes.ANNOYING, new AttributeModifier[]{new AttributeModifier("generic.attackDamage", -1, 0), new AttributeModifier("generic.attackSpeed", -2, 0)}, new String[]{"generic.attackDamage", "generic.attackSpeed"});
        addToMaps(i++, Prefixes.SLUGGISH, new AttributeModifier[]{new AttributeModifier("generic.attackSpeed", -2, 0), new AttributeModifier("generic.movementSpeed", -0.05, 0)}, new String[]{"generic.attackSpeed", "generic.movementSpeed"});
        addToMaps(i++, Prefixes.SLUGGISH, new AttributeModifier[]{new AttributeModifier("generic.attackSpeed", -3, 0), new AttributeModifier("generic.movementSpeed", -0.025, 0)}, new String[]{"generic.attackSpeed", "generic.movementSpeed"});
        addToMaps(i++, Prefixes.LUCKY, new AttributeModifier[]{new AttributeModifier("generic.luck", 5, 0)}, new String[]{"generic.luck"});
        addToMaps(i++, Prefixes.LUCKY, new AttributeModifier[]{new AttributeModifier("generic.luck", 7, 0)}, new String[]{"generic.luck"});
        addToMaps(i++, Prefixes.FORTIFIED, new AttributeModifier[]{new AttributeModifier("generic.knockbackResistance", 3, 0), new AttributeModifier("generic.maxHealth", 2, 0)}, new String[]{"generic.knockbackResistance", "generic.maxHealth"});

        addPrefixColor(Prefixes.LEGENDARY, TextFormatting.GOLD);
        addPrefixColor(Prefixes.GODLY, TextFormatting.YELLOW);
        addPrefixColor(Prefixes.QUICK, TextFormatting.GREEN);
        addPrefixColor(Prefixes.DEADLY, TextFormatting.BLUE);
        addPrefixColor(Prefixes.FRENZYING, TextFormatting.LIGHT_PURPLE);
        addPrefixColor(Prefixes.ANNOYING, TextFormatting.RED);
        addPrefixColor(Prefixes.SLUGGISH, TextFormatting.DARK_RED);
        addPrefixColor(Prefixes.LUCKY, TextFormatting.DARK_GREEN);
        addPrefixColor(Prefixes.FORTIFIED, TextFormatting.DARK_BLUE);
    }

    public enum Prefixes {
        LEGENDARY,
        GODLY,
        QUICK,
        DEADLY,
        FRENZYING,
        ANNOYING,
        SLUGGISH,
        LUCKY,
        FORTIFIED
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

