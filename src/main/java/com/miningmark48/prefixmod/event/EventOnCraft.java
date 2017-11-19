package com.miningmark48.prefixmod.event;

import com.miningmark48.mininglib.utility.ModLogger;
import com.miningmark48.prefixmod.reference.prefixes.PrefixTypes;
import com.miningmark48.prefixmod.reference.prefixes.ToolPrefixes;
import com.miningmark48.prefixmod.reference.prefixes.WeaponPrefixes;
import com.miningmark48.prefixmod.utility.HandlePrefix;
import net.minecraft.item.*;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

import java.util.ConcurrentModificationException;

public class EventOnCraft {

    @SubscribeEvent
    public void onCraft(PlayerEvent.ItemCraftedEvent event) {
        if (!event.player.getEntityWorld().isRemote) {
            ItemStack stack = event.crafting;
            Item item = stack.getItem();

            try {
                if (item instanceof ItemSword) {
                    HandlePrefix.addPrefix(stack, PrefixTypes.WEAPON, WeaponPrefixes.prefixNameMap, WeaponPrefixes.modifierMap, WeaponPrefixes.modifierNameMap);
                } else if (item instanceof ItemPickaxe || item instanceof ItemSpade || item instanceof ItemAxe || item instanceof ItemHoe || item instanceof ItemShears) {
                    HandlePrefix.addPrefix(stack, PrefixTypes.TOOL, ToolPrefixes.prefixNameMap, ToolPrefixes.modifierMap, ToolPrefixes.modifierNameMap);
                }
            } catch (NullPointerException | ConcurrentModificationException e) {
                ModLogger.fatal("Error occurred while adding prefix to item, please report to mod author.");
                e.printStackTrace();
            }

        }
    }

}
