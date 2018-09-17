package com.miningmark48.prefixation.base.prefix;

import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.util.text.TextFormatting;

public class Prefix extends BasePrefix {

    public Prefix(String name, float chance, TextFormatting color, AttributeModifier[] modifiers, String[] modifier_names) {
        this.setPrefixName(name);
        this.setChance(chance);
        this.setColor(color);
        this.setModifiers(modifiers, modifier_names);
    }

}
