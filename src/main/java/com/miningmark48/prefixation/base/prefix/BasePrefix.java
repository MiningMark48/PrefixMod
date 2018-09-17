package com.miningmark48.prefixation.base.prefix;

import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.util.text.TextFormatting;

public abstract class BasePrefix implements IPrefix {

    private static String prefix_name;
    private static float chance;
    private static TextFormatting color = TextFormatting.AQUA;
    private static AttributeModifier[] modifiers;
    private static String[] modifier_names;

    @Override
    public void setPrefixName(String name) {
        BasePrefix.prefix_name = name.toLowerCase();
    }

    @Override
    public void setChance(float chance) {
        BasePrefix.chance = chance;
        if (BasePrefix.chance > 1f) {
            BasePrefix.chance = 1f;
        }
    }

    @Override
    public void setColor(TextFormatting color) {
        BasePrefix.color = color;
    }

    @Override
    public void setModifiers(AttributeModifier[] modifiers, String[] names) {
        BasePrefix.modifiers = modifiers;
        BasePrefix.modifier_names = names;
    }

    @Override
    public String getPrefixName() {
        return prefix_name;
    }

    @Override
    public float getChance() {
        return chance;
    }

    @Override
    public TextFormatting getColor() {
        return color;
    }

    @Override
    public AttributeModifier[] getModifiers() {
        return modifiers;
    }

    @Override
    public String[] getModifierNames() {
        return modifier_names;
    }
}
