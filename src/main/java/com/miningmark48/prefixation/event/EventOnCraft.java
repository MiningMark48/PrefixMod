package com.miningmark48.prefixation.event;

import com.miningmark48.mininglib.utility.ModLogger;
import com.miningmark48.prefixation.init.prefixes.ArmorPrefixesHandler;
import com.miningmark48.prefixation.init.prefixes.WeaponPrefixesHandler;
import com.miningmark48.prefixation.reference.EnumPrefixTypes;
import com.miningmark48.prefixation.utility.HandlePrefix;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

import java.util.ConcurrentModificationException;

public class EventOnCraft {

    @SubscribeEvent
    public void onCraft(PlayerEvent.ItemCraftedEvent event) {
        ItemStack stack = event.crafting;
        Item item = stack.getItem();

        try {
            if (item instanceof ItemSword || item instanceof ItemAxe) {
                HandlePrefix.addPrefix(event.player, stack, EnumPrefixTypes.WEAPON, WeaponPrefixesHandler.prefixNameMap, WeaponPrefixesHandler.modifierMap, WeaponPrefixesHandler.modifierNameMap);
            } else if (item instanceof ItemArmor) {
                if (((ItemArmor) item).armorType == EntityEquipmentSlot.CHEST) {
                    HandlePrefix.addPrefix(event.player, stack, EnumPrefixTypes.ARMOR, ArmorPrefixesHandler.prefixNameMap, ArmorPrefixesHandler.modifierMap, ArmorPrefixesHandler.modifierNameMap, EntityEquipmentSlot.CHEST);
                }
            }
        } catch (NullPointerException | ConcurrentModificationException e) {
            ModLogger.fatal("Error occurred while adding prefix to item, please report to mod author.");
            e.printStackTrace();
        }
    }

}
