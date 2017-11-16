package com.miningmark48.prefixmod.event;

import com.miningmark48.prefixmod.reference.prefixes.ToolPrefixes;
import com.miningmark48.prefixmod.reference.prefixes.WeaponPrefixes;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import org.apache.commons.lang3.StringUtils;

import java.util.Random;

public class EventOnCraft {

    @SubscribeEvent
    public void onCraft(PlayerEvent.ItemCraftedEvent event) {
        if (!event.player.getEntityWorld().isRemote) {
            Random rand = new Random();
            ItemStack stack = event.crafting;
            Item item = stack.getItem();

            if (item instanceof ItemSword) {
                WeaponPrefixes.Prefixes prefix = WeaponPrefixes.Prefixes.values()[rand.nextInt(WeaponPrefixes.Prefixes.values().length)];

                String prefixName = StringUtils.capitalize(prefix.toString().toLowerCase());
                stack.setStackDisplayName(prefixName + " " + stack.getDisplayName());

                for (int i = 0; i <= WeaponPrefixes.modifierMap.get(prefix).length - 1; i++) {
                    stack.addAttributeModifier(WeaponPrefixes.modifierNameMap.get(prefix)[i], WeaponPrefixes.modifierMap.get(prefix)[i], EntityEquipmentSlot.MAINHAND);
                }

                if (stack.getTagCompound() == null) {
                    stack.setTagCompound(new NBTTagCompound());
                }
                stack.getTagCompound().setString("prefix", prefixName);

            } else if (item instanceof ItemPickaxe || item instanceof ItemSpade || item instanceof ItemAxe || item instanceof ItemHoe || item instanceof ItemShears) {
                ToolPrefixes.Prefixes prefix = ToolPrefixes.Prefixes.values()[rand.nextInt(ToolPrefixes.Prefixes.values().length)];

                String prefixName = StringUtils.capitalize(prefix.toString().toLowerCase());
                stack.setStackDisplayName(prefixName + " " + stack.getDisplayName());

                for (int i = 0; i <= ToolPrefixes.modifierMap.get(prefix).length - 1; i++) {
                    stack.addAttributeModifier(ToolPrefixes.modifierNameMap.get(prefix)[i], ToolPrefixes.modifierMap.get(prefix)[i], EntityEquipmentSlot.MAINHAND);
                }

                if (stack.getTagCompound() == null) {
                    stack.setTagCompound(new NBTTagCompound());
                }
                stack.getTagCompound().setString("prefix", prefixName);

            }

        }
    }

}
