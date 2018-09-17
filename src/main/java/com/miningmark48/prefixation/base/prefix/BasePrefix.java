package com.miningmark48.prefixation.base.prefix;

import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.util.text.TextFormatting;

public abstract class BasePrefix implements IPrefix {

    private String prefix_name;
    private float chance;
    private TextFormatting color = TextFormatting.AQUA;
    private AttributeModifier[] modifiers;
    private String[] modifier_names;

    @Override
    public void setPrefixName(String name) {
        prefix_name = name.toLowerCase();
    }

    @Override
    public void setChance(float chance) {
        this.chance = chance;
        if (chance > 1f) {
            this.chance = 1f;
        }
    }

    @Override
    public void setColor(TextFormatting color) {
        this.color = color;
    }

    @Override
    public void setModifiers(AttributeModifier[] modifiers, String[] names) {
        this.modifiers = modifiers;
        this.modifier_names = names;
    }

    @Override
    public String getPrefixName() {
        return this.prefix_name;
    }

    @Override
    public float getChance() {
        return this.chance;
    }

    @Override
    public TextFormatting getColor() {
        return this.color;
    }

    @Override
    public AttributeModifier[] getModifiers() {
        return this.modifiers;
    }

    @Override
    public String[] getModifierNames() {
        return this.modifier_names;
    }
}
