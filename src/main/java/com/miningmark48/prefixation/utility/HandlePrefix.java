package com.miningmark48.prefixation.utility;

import com.google.common.collect.Iterators;
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
import net.minecraft.util.ReportedException;
import net.minecraftforge.fml.common.Mod;
import org.apache.commons.lang3.StringUtils;
import scala.Array;
import scala.Int;

import java.util.*;

public class HandlePrefix {

    public static void addPrefix(EntityPlayer player, ItemStack stack, EnumPrefixTypes type, ArrayList<BasePrefix> prefix_map){
        addPrefix(player, stack, type, EntityEquipmentSlot.MAINHAND, prefix_map);
    }

    public static void addPrefix(EntityPlayer player, ItemStack stack, EnumPrefixTypes type, EntityEquipmentSlot slot, ArrayList<BasePrefix> prefix_map) {
        Random rand = new Random();
        BasePrefix prefix = getPrefix(rand, prefix_map);

        String prefixName = StringUtils.capitalize(prefix.getPrefixName());

        Multimap<String, AttributeModifier> priorAttributes = new ItemStack(stack.getItem()).getAttributeModifiers(slot);
        for (int i = 0; i <= prefix.getModifiers().length - 1; i++) {
            stack.addAttributeModifier(prefix.getModifierNames()[i], prefix.getModifiers()[i], slot);
        }

        priorAttributes.forEach((name, attribute) -> stack.addAttributeModifier(name, attribute, slot));

        if (!stack.hasTagCompound()) {
            stack.setTagCompound(new NBTTagCompound());
        }
        assert stack.getTagCompound() != null;
        stack.getTagCompound().setString("prefix", prefixName);
        stack.getTagCompound().setInteger("prefix_index", prefix_map.indexOf(prefix));
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

    @SuppressWarnings("Duplicates")
    private static BasePrefix getPrefix(Random rand, ArrayList<BasePrefix> prefix_map) {
        try {
            int start = rand.nextInt(prefix_map.size());
            BasePrefix prefix;
            int prefix_chance;
            int randNum = 1;
            ListIterator i = prefix_map.listIterator(start);
            if (i.hasNext()) i.next();
            while (i.hasNext()) {
                prefix = (BasePrefix) i.next();
                prefix_chance = calculateChance(prefix.getChance());
                if (prefix_chance != 0) {
                    randNum = rand.nextInt(100);
                }
                if ((randNum > (prefix_chance))) {
                    return prefix;
                }
            }
            Iterator k = Iterators.limit(prefix_map.iterator(), start + 1);
            while (k.hasNext()) {
                prefix = (BasePrefix) k.next();
                prefix_chance = calculateChance(prefix.getChance());
                if (prefix_chance != 0) {
                    randNum = rand.nextInt(100);
                }
                if ((randNum > (prefix_chance))) {
                    return prefix;
                }
            }
            return prefix_map.get(rand.nextInt(prefix_map.size()));
        } catch (ConcurrentModificationException | ReportedException e) {
            return prefix_map.get(rand.nextInt(prefix_map.size()));
        }
    }

    private static int calculateChance(float prefix_chance) {
        return Math.round(100 * prefix_chance);
    }

    private static void handleAdvancement(EntityPlayer player, String prefix) {
        ModTriggers.Advancements.prefix.trigger((EntityPlayerMP) player, prefix.toLowerCase());
    }

}
