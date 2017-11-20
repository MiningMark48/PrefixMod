package com.miningmark48.prefixation.init.prefixes;

import com.miningmark48.prefixation.reference.EnumAttributes;
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
        addToMaps(i, Prefixes.LEGENDARY, new AttributeModifier[]{new AttributeModifier(EnumAttributes.ATTACK_DAMAGE.getUnlocalized(), 15, 0), new AttributeModifier(EnumAttributes.ATTACK_SPEED.getUnlocalized(), 5, 0), new AttributeModifier(EnumAttributes.MOVEMENT_SPEED.getUnlocalized(), 0.3, 0)}, new String[]{EnumAttributes.ATTACK_DAMAGE.getUnlocalized(), EnumAttributes.ATTACK_SPEED.getUnlocalized(), EnumAttributes.MOVEMENT_SPEED.getUnlocalized()});
        addToMaps(i++, Prefixes.LEGENDARY, new AttributeModifier[]{new AttributeModifier(EnumAttributes.ATTACK_DAMAGE.getUnlocalized(), 20, 0), new AttributeModifier(EnumAttributes.ATTACK_SPEED.getUnlocalized(), 2, 0), new AttributeModifier(EnumAttributes.LUCK.getUnlocalized(), 3, 0)}, new String[]{EnumAttributes.ATTACK_DAMAGE.getUnlocalized(), EnumAttributes.ATTACK_SPEED.getUnlocalized(), EnumAttributes.LUCK.getUnlocalized()});
        addToMaps(i++, Prefixes.GODLY, new AttributeModifier[]{new AttributeModifier(EnumAttributes.ATTACK_DAMAGE.getUnlocalized(), 15, 0), new AttributeModifier(EnumAttributes.MOVEMENT_SPEED.getUnlocalized(), 0.15, 0), new AttributeModifier(EnumAttributes.MAX_HEALTH.getUnlocalized(), 5, 0)}, new String[]{EnumAttributes.ATTACK_DAMAGE.getUnlocalized(), EnumAttributes.MOVEMENT_SPEED.getUnlocalized(), EnumAttributes.MAX_HEALTH.getUnlocalized()});
        addToMaps(i++, Prefixes.GODLY, new AttributeModifier[]{new AttributeModifier(EnumAttributes.ATTACK_DAMAGE.getUnlocalized(), 15, 0), new AttributeModifier(EnumAttributes.ATTACK_SPEED.getUnlocalized(), -1, 0), new AttributeModifier(EnumAttributes.LUCK.getUnlocalized(), 2, 0)}, new String[]{EnumAttributes.ATTACK_DAMAGE.getUnlocalized(), EnumAttributes.ATTACK_SPEED.getUnlocalized(), EnumAttributes.LUCK.getUnlocalized()});
        addToMaps(i++, Prefixes.QUICK, new AttributeModifier[]{new AttributeModifier(EnumAttributes.ATTACK_SPEED.getUnlocalized(), 8, 0), new AttributeModifier(EnumAttributes.MOVEMENT_SPEED.getUnlocalized(), 0.3, 0)}, new String[]{EnumAttributes.ATTACK_SPEED.getUnlocalized(), EnumAttributes.MOVEMENT_SPEED.getUnlocalized()});
        addToMaps(i++, Prefixes.DEADLY, new AttributeModifier[]{new AttributeModifier(EnumAttributes.ATTACK_DAMAGE.getUnlocalized(), 5, 0), new AttributeModifier(EnumAttributes.ATTACK_SPEED.getUnlocalized(), 2, 0)}, new String[]{EnumAttributes.ATTACK_DAMAGE.getUnlocalized(), EnumAttributes.ATTACK_SPEED.getUnlocalized()});
        addToMaps(i++, Prefixes.DEADLY, new AttributeModifier[]{new AttributeModifier(EnumAttributes.ATTACK_DAMAGE.getUnlocalized(), 6, 0), new AttributeModifier(EnumAttributes.ATTACK_SPEED.getUnlocalized(), 3, 0)}, new String[]{EnumAttributes.ATTACK_DAMAGE.getUnlocalized(), EnumAttributes.ATTACK_SPEED.getUnlocalized()});
        addToMaps(i++, Prefixes.FRENZYING, new AttributeModifier[]{new AttributeModifier(EnumAttributes.ATTACK_DAMAGE.getUnlocalized(), -7, 0), new AttributeModifier(EnumAttributes.ATTACK_SPEED.getUnlocalized(), 7, 0)}, new String[]{EnumAttributes.ATTACK_DAMAGE.getUnlocalized(), EnumAttributes.ATTACK_SPEED.getUnlocalized()});
        addToMaps(i++, Prefixes.FRENZYING, new AttributeModifier[]{new AttributeModifier(EnumAttributes.ATTACK_DAMAGE.getUnlocalized(), -5, 0), new AttributeModifier(EnumAttributes.ATTACK_SPEED.getUnlocalized(), 5, 0)}, new String[]{EnumAttributes.ATTACK_DAMAGE.getUnlocalized(), EnumAttributes.ATTACK_SPEED.getUnlocalized()});
        addToMaps(i++, Prefixes.FRENZYING, new AttributeModifier[]{new AttributeModifier(EnumAttributes.ATTACK_DAMAGE.getUnlocalized(), -3, 0), new AttributeModifier(EnumAttributes.ATTACK_SPEED.getUnlocalized(), 3, 0)}, new String[]{EnumAttributes.ATTACK_DAMAGE.getUnlocalized(), EnumAttributes.ATTACK_SPEED.getUnlocalized()});
        addToMaps(i++, Prefixes.ANNOYING, new AttributeModifier[]{new AttributeModifier(EnumAttributes.ATTACK_DAMAGE.getUnlocalized(), -2, 0), new AttributeModifier(EnumAttributes.ATTACK_SPEED.getUnlocalized(), -1, 0)}, new String[]{EnumAttributes.ATTACK_DAMAGE.getUnlocalized(), EnumAttributes.ATTACK_SPEED.getUnlocalized()});
        addToMaps(i++, Prefixes.ANNOYING, new AttributeModifier[]{new AttributeModifier(EnumAttributes.ATTACK_DAMAGE.getUnlocalized(), -1, 0), new AttributeModifier(EnumAttributes.ATTACK_SPEED.getUnlocalized(), -2, 0)}, new String[]{EnumAttributes.ATTACK_DAMAGE.getUnlocalized(), EnumAttributes.ATTACK_SPEED.getUnlocalized()});
        addToMaps(i++, Prefixes.SLUGGISH, new AttributeModifier[]{new AttributeModifier(EnumAttributes.ATTACK_SPEED.getUnlocalized(), -2, 0), new AttributeModifier(EnumAttributes.MOVEMENT_SPEED.getUnlocalized(), -0.05, 0)}, new String[]{EnumAttributes.ATTACK_SPEED.getUnlocalized(), EnumAttributes.MOVEMENT_SPEED.getUnlocalized()});
        addToMaps(i++, Prefixes.SLUGGISH, new AttributeModifier[]{new AttributeModifier(EnumAttributes.ATTACK_SPEED.getUnlocalized(), -3, 0), new AttributeModifier(EnumAttributes.MOVEMENT_SPEED.getUnlocalized(), -0.025, 0)}, new String[]{EnumAttributes.ATTACK_SPEED.getUnlocalized(), EnumAttributes.MOVEMENT_SPEED.getUnlocalized()});
        addToMaps(i++, Prefixes.LUCKY, new AttributeModifier[]{new AttributeModifier(EnumAttributes.LUCK.getUnlocalized(), 5, 0)}, new String[]{EnumAttributes.LUCK.getUnlocalized()});
        addToMaps(i++, Prefixes.LUCKY, new AttributeModifier[]{new AttributeModifier(EnumAttributes.LUCK.getUnlocalized(), 7, 0)}, new String[]{EnumAttributes.LUCK.getUnlocalized()});
        addToMaps(i++, Prefixes.FORTIFIED, new AttributeModifier[]{new AttributeModifier(EnumAttributes.KNOCKBACK_RESISTANCE.getUnlocalized(), 3, 0), new AttributeModifier(EnumAttributes.MAX_HEALTH.getUnlocalized(), 2, 0)}, new String[]{EnumAttributes.KNOCKBACK_RESISTANCE.getUnlocalized(), EnumAttributes.MAX_HEALTH.getUnlocalized()});

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

