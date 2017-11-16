package com.miningmark48.prefixmod.event;

import com.miningmark48.mininglib.utility.ModLogger;
import com.miningmark48.prefixmod.reference.prefixes.PrefixTypes;
import com.miningmark48.prefixmod.reference.prefixes.ToolPrefixes;
import com.miningmark48.prefixmod.reference.prefixes.WeaponPrefixes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import org.apache.commons.lang3.StringUtils;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Random;

public class EventOnCraft {

    @SubscribeEvent
    public void onCraft(PlayerEvent.ItemCraftedEvent event) {
        if (!event.player.getEntityWorld().isRemote) {
            ItemStack stack = event.crafting;
            Item item = stack.getItem();

            try {
                if (item instanceof ItemSword) {
                    handlePrefix(stack, PrefixTypes.WEAPON, WeaponPrefixes.prefixNameMap, WeaponPrefixes.modifierMap, WeaponPrefixes.modifierNameMap);
                } else if (item instanceof ItemPickaxe || item instanceof ItemSpade || item instanceof ItemAxe || item instanceof ItemHoe || item instanceof ItemShears) {
                    handlePrefix(stack, PrefixTypes.TOOL, ToolPrefixes.prefixNameMap, ToolPrefixes.modifierMap, ToolPrefixes.modifierNameMap);
                }
            } catch (NullPointerException | ConcurrentModificationException e) {
                ModLogger.fatal("Error occurred while adding prefix to item, please report to mod author.");
                e.printStackTrace();
            }

        }
    }

    private static void handlePrefix(ItemStack stack, PrefixTypes type, HashMap<Integer, Enum> prefixNameMap, HashMap<Integer, AttributeModifier[]> modifierMap, HashMap<Integer, String[]> modifierNameMap){
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

}
