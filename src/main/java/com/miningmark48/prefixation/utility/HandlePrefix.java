package com.miningmark48.prefixation.utility;

import com.google.common.collect.Multimap;
import com.miningmark48.mininglib.utility.ModLogger;
import com.miningmark48.mininglib.utility.ModTranslate;
import com.miningmark48.prefixation.init.ModTriggers;
import com.miningmark48.prefixation.reference.EnumPrefixTypes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Random;

public class HandlePrefix {

    public static void addPrefix(EntityPlayer player, ItemStack stack, EnumPrefixTypes type, HashMap<Integer, Enum> prefixNameMap, HashMap<Integer, AttributeModifier[]> modifierMap, HashMap<Integer, String[]> modifierNameMap){
        addPrefix(player, stack, type, prefixNameMap, modifierMap, modifierNameMap, EntityEquipmentSlot.MAINHAND);
    }

    public static void addPrefix(EntityPlayer player, ItemStack stack, EnumPrefixTypes type, HashMap<Integer, Enum> prefixNameMap, HashMap<Integer, AttributeModifier[]> modifierMap, HashMap<Integer, String[]> modifierNameMap, EntityEquipmentSlot slot){
        Random rand = new Random();
        int r = rand.nextInt(prefixNameMap.size());
        Enum prefix = prefixNameMap.get(r);

        String prefixName = StringUtils.capitalize(prefix.toString().toLowerCase());
        String displayName = ModTranslate.toLocal(String.format("prefix.%s.name", prefix.toString().toLowerCase()));
        stack.setStackDisplayName(displayName + " " + stack.getDisplayName());

        Multimap<String, AttributeModifier> priorAttributes = stack.getAttributeModifiers(slot);

        for (int i = 0; i <= modifierMap.get(r).length - 1; i++) {
            stack.addAttributeModifier(modifierNameMap.get(r)[i], modifierMap.get(r)[i], slot);
        }

        priorAttributes.forEach((name, attribute) -> stack.addAttributeModifier(name, attribute, slot));

        if (stack.getTagCompound() == null) {
            stack.setTagCompound(new NBTTagCompound());
        }
        stack.getTagCompound().setString("prefix", prefixName);
        stack.getTagCompound().setString("type", type.toString());

        if (!player.getEntityWorld().isRemote) handleAdvancement(player, prefixName);
    }

    public static void reforgePrefix(EntityPlayer player, ItemStack stack, EnumPrefixTypes type, HashMap<Integer, Enum> prefixNameMap, HashMap<Integer, AttributeModifier[]> modifierMap, HashMap<Integer, String[]> modifierNameMap){
        reforgePrefix(player, stack, type, prefixNameMap, modifierMap, modifierNameMap, EntityEquipmentSlot.MAINHAND);
    }

    public static void reforgePrefix(EntityPlayer player, ItemStack stack, EnumPrefixTypes type, HashMap<Integer, Enum> prefixNameMap, HashMap<Integer, AttributeModifier[]> modifierMap, HashMap<Integer, String[]> modifierNameMap, EntityEquipmentSlot slot){

        if (!stack.hasTagCompound()) {
            stack.setTagCompound(new NBTTagCompound());
        }

        stack.getTagCompound().removeTag("AttributeModifiers");
        stack.getTagCompound().removeTag("display");
        addPrefix(player, stack, type, prefixNameMap, modifierMap, modifierNameMap, slot);

    }

    private static void handleAdvancement(EntityPlayer player, String prefix) {
        ModTriggers.Advancements.prefix.trigger((EntityPlayerMP) player, prefix.toLowerCase());
    }

}
