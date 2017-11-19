package com.miningmark48.prefixmod.utility;

import com.miningmark48.prefixmod.reference.prefixes.PrefixTypes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Random;

public class HandlePrefix {

    public static void addPrefix(ItemStack stack, PrefixTypes type, HashMap<Integer, Enum> prefixNameMap, HashMap<Integer, AttributeModifier[]> modifierMap, HashMap<Integer, String[]> modifierNameMap){
        Random rand = new Random();
        int r = rand.nextInt(prefixNameMap.size());
        Enum prefix = prefixNameMap.get(r);

        String prefixName = StringUtils.capitalize(prefix.toString().toLowerCase());
        stack.setStackDisplayName(prefixName + " " + stack.getDisplayName());

        for (int i = 0; i <= modifierMap.get(r).length - 1; i++) {
            stack.addAttributeModifier(modifierNameMap.get(r)[i],modifierMap.get(r)[i], EntityEquipmentSlot.MAINHAND);
        }

        if (stack.getTagCompound() == null) {
            stack.setTagCompound(new NBTTagCompound());
        }
        stack.getTagCompound().setString("prefix", prefixName);
        stack.getTagCompound().setString("type", type.toString());
    }

    public static void reforgePrefix(ItemStack stack, PrefixTypes type, HashMap<Integer, Enum> prefixNameMap, HashMap<Integer, AttributeModifier[]> modifierMap, HashMap<Integer, String[]> modifierNameMap){
        if (stack.hasTagCompound()) {
            stack.getTagCompound().removeTag("AttributeModifiers");
            stack.getTagCompound().removeTag("display");
            addPrefix(stack, type, prefixNameMap, modifierMap, modifierNameMap);
        }
    }

}
