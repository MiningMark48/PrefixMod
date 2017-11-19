package com.miningmark48.prefixmod.utility;

import com.miningmark48.prefixmod.reference.EnumPrefixTypes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Random;

public class HandlePrefix {

    public static void addPrefix(ItemStack stack, EnumPrefixTypes type, HashMap<Integer, Enum> prefixNameMap, HashMap<Integer, AttributeModifier[]> modifierMap, HashMap<Integer, String[]> modifierNameMap){
        addPrefix(stack, type, prefixNameMap, modifierMap, modifierNameMap, EntityEquipmentSlot.MAINHAND);
    }

    public static void addPrefix(ItemStack stack, EnumPrefixTypes type, HashMap<Integer, Enum> prefixNameMap, HashMap<Integer, AttributeModifier[]> modifierMap, HashMap<Integer, String[]> modifierNameMap, EntityEquipmentSlot slot){
        Random rand = new Random();
        int r = rand.nextInt(prefixNameMap.size());
        Enum prefix = prefixNameMap.get(r);

        String prefixName = StringUtils.capitalize(prefix.toString().toLowerCase());
        stack.setStackDisplayName(prefixName + " " + stack.getDisplayName());

        for (int i = 0; i <= modifierMap.get(r).length - 1; i++) {
            stack.addAttributeModifier(modifierNameMap.get(r)[i],modifierMap.get(r)[i], slot);
        }

        if (stack.getTagCompound() == null) {
            stack.setTagCompound(new NBTTagCompound());
        }
        stack.getTagCompound().setString("prefix", prefixName);
        stack.getTagCompound().setString("type", type.toString());
    }

    public static void reforgePrefix(ItemStack stack, EnumPrefixTypes type, HashMap<Integer, Enum> prefixNameMap, HashMap<Integer, AttributeModifier[]> modifierMap, HashMap<Integer, String[]> modifierNameMap){
        reforgePrefix(stack, type, prefixNameMap, modifierMap, modifierNameMap, EntityEquipmentSlot.MAINHAND);
    }

    public static void reforgePrefix(ItemStack stack, EnumPrefixTypes type, HashMap<Integer, Enum> prefixNameMap, HashMap<Integer, AttributeModifier[]> modifierMap, HashMap<Integer, String[]> modifierNameMap, EntityEquipmentSlot slot){
        if (stack.hasTagCompound()) {
            stack.getTagCompound().removeTag("AttributeModifiers");
            stack.getTagCompound().removeTag("display");
            addPrefix(stack, type, prefixNameMap, modifierMap, modifierNameMap, slot);
        }
    }

}
