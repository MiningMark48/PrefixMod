package com.miningmark48.prefixation.base.prefix;

import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.util.text.TextFormatting;

public interface IPrefix {

    void setPrefixName(String name);
    void setChance(float chance);
    void setColor(TextFormatting color);
    void setModifiers(AttributeModifier[] modifiers, String[] names);
    String getPrefixName();
    float getChance();
    TextFormatting getColor();
    AttributeModifier[] getModifiers();
    String[] getModifierNames();

}
