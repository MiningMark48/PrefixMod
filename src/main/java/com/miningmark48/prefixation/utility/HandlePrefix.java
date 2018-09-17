package com.miningmark48.prefixation.utility;

import com.google.common.collect.Multimap;
import com.miningmark48.mininglib.utility.ModLogger;
import com.miningmark48.mininglib.utility.ModTranslate;
import com.miningmark48.prefixation.base.prefix.BasePrefix;
import com.miningmark48.prefixation.init.ModTriggers;
import com.miningmark48.prefixation.reference.EnumPrefixTypes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import org.apache.commons.lang3.StringUtils;
import scala.Int;

import java.util.HashMap;
import java.util.Random;

public class HandlePrefix {

    public static void addPrefix(EntityPlayer player, ItemStack stack, EnumPrefixTypes type, HashMap<Integer, BasePrefix> prefix_map){
        addPrefix(player, stack, type, EntityEquipmentSlot.MAINHAND, prefix_map);
    }

    public static void addPrefix(EntityPlayer player, ItemStack stack, EnumPrefixTypes type, EntityEquipmentSlot slot, HashMap<Integer, BasePrefix> prefix_map) {
        Random rand = new Random();
        int r = rand.nextInt(prefix_map.size());
        BasePrefix prefix = prefix_map.get(r);

        String prefixName = StringUtils.capitalize(prefix.getPrefixName());
        String displayName = ModTranslate.toLocal(String.format("prefix.%s.name", prefixName.toLowerCase()));
        stack.setStackDisplayName(displayName + " " + stack.getDisplayName());

        Multimap<String, AttributeModifier> priorAttributes = stack.getAttributeModifiers(slot);

        for (int i = 0; i <= prefix.getModifiers().length - 1; i++) {
            stack.addAttributeModifier(prefix.getModifierNames()[i], prefix.getModifiers()[i], slot);
        }

        priorAttributes.forEach((name, attribute) -> stack.addAttributeModifier(name, attribute, slot));

        if (stack.getTagCompound() == null) {
            stack.setTagCompound(new NBTTagCompound());
        }
        stack.getTagCompound().setString("prefix", prefixName);
        stack.getTagCompound().setInteger("prefix_index", r);
        stack.getTagCompound().setString("type", type.toString());

        if (!player.getEntityWorld().isRemote) handleAdvancement(player, prefixName);
    }

    public static void reforgePrefix(EntityPlayer player, ItemStack stack, EnumPrefixTypes type, HashMap<Integer, BasePrefix> prefix_map){
        reforgePrefix(player, stack, type, EntityEquipmentSlot.MAINHAND, prefix_map);
    }

    public static void reforgePrefix(EntityPlayer player, ItemStack stack, EnumPrefixTypes type, EntityEquipmentSlot slot, HashMap<Integer, BasePrefix> prefix_map) {

        if (!stack.hasTagCompound()) {
            stack.setTagCompound(new NBTTagCompound());
        }

        stack.getTagCompound().removeTag("AttributeModifiers");
        stack.getTagCompound().removeTag("display");
        addPrefix(player, stack, type, slot, prefix_map);

    }

    private static void handleAdvancement(EntityPlayer player, String prefix) {
        ModTriggers.Advancements.prefix.trigger((EntityPlayerMP) player, prefix.toLowerCase());
    }

}
