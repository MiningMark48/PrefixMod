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
import net.minecraftforge.fml.common.Mod;
import org.apache.commons.lang3.StringUtils;
import scala.Array;
import scala.Int;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class HandlePrefix {

    private static int chance_counter = 0;

    public static void addPrefix(EntityPlayer player, ItemStack stack, EnumPrefixTypes type, ArrayList<BasePrefix> prefix_map){
        addPrefix(player, stack, type, EntityEquipmentSlot.MAINHAND, prefix_map);
    }

    public static void addPrefix(EntityPlayer player, ItemStack stack, EnumPrefixTypes type, EntityEquipmentSlot slot, ArrayList<BasePrefix> prefix_map) {
        Random rand = new Random();
        int r = rand.nextInt(prefix_map.size());
        BasePrefix prefix = prefix_map.get(r);

        //Prefix Chance
//        float prefix_chance = prefix.getChance();
//        int prefix_chance_rand = rand.nextInt(Math.round(prefix_chance * 100));
//        if (prefix_chance_rand != 0 && chance_counter <= 2) {
//            chance_counter++;
//            stack.getAttributeModifiers(slot).clear();
//            if (!player.world.isRemote) reforgePrefix(player, stack, type, slot, prefix_map);
//            ModLogger.info("Failed!");
//        }
//        chance_counter = 0;

        String prefixName = StringUtils.capitalize(prefix.getPrefixName());

        Multimap<String, AttributeModifier> priorAttributes = new ItemStack(stack.getItem()).getAttributeModifiers(slot);
        for (int i = 0; i <= prefix.getModifiers().length - 1; i++) {
            stack.addAttributeModifier(prefix.getModifierNames()[i], prefix.getModifiers()[i], slot);
        }

        priorAttributes.forEach((name, attribute) ->  {
            stack.addAttributeModifier(name, attribute, slot);
            ModLogger.info(name + " " + attribute.getAmount());
        });

        if (!stack.hasTagCompound()) {
            stack.setTagCompound(new NBTTagCompound());
        }
        assert stack.getTagCompound() != null;
        stack.getTagCompound().setString("prefix", prefixName);
        stack.getTagCompound().setInteger("prefix_index", r);
        stack.getTagCompound().setString("type", type.toString());

        if (!player.getEntityWorld().isRemote) handleAdvancement(player, prefixName);
    }

    public static void reforgePrefix(EntityPlayer player, ItemStack stack, EnumPrefixTypes type, ArrayList<BasePrefix> prefix_map){
        reforgePrefix(player, stack, type, EntityEquipmentSlot.MAINHAND, prefix_map);
    }

    public static void reforgePrefix(EntityPlayer player, ItemStack stack, EnumPrefixTypes type, EntityEquipmentSlot slot, ArrayList<BasePrefix> prefix_map) {

        if (!stack.hasTagCompound()) {
            stack.setTagCompound(new NBTTagCompound());
        }

        assert stack.getTagCompound() != null;
        stack.getTagCompound().removeTag("AttributeModifiers");

        addPrefix(player, stack, type, slot, prefix_map);
    }

    private static void handleAdvancement(EntityPlayer player, String prefix) {
        ModTriggers.Advancements.prefix.trigger((EntityPlayerMP) player, prefix.toLowerCase());
    }

}
