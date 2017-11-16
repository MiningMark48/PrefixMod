package com.miningmark48.prefixmod.event;

import com.miningmark48.mininglib.utility.ModLogger;
import com.miningmark48.prefixmod.reference.prefixes.PrefixTypes;
import com.miningmark48.prefixmod.reference.prefixes.ToolPrefixes;
import com.miningmark48.prefixmod.reference.prefixes.WeaponPrefixes;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventTooltip {

    @SubscribeEvent
    public void onTooltip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        if (stack.getTagCompound() != null) {
            if (!stack.getTagCompound().getString("prefix").isEmpty() && !stack.getTagCompound().getString("type").isEmpty()) {
                try {
                    switch (PrefixTypes.valueOf(stack.getTagCompound().getString("type"))) {
                        case WEAPON:
                            event.getToolTip().add(1, WeaponPrefixes.colorMap.get(WeaponPrefixes.Prefixes.valueOf(stack.getTagCompound().getString("prefix").toUpperCase())) + stack.getTagCompound().getString("prefix"));
                            break;
                        case TOOL:
                            event.getToolTip().add(1, ToolPrefixes.colorMap.get(ToolPrefixes.Prefixes.valueOf(stack.getTagCompound().getString("prefix").toUpperCase())) + stack.getTagCompound().getString("prefix"));
                            break;
                        default:
                            ModLogger.error("Modifier tooltip could not be loaded! Please report to mod author. | ERROR CODE 1");
                            break;
                    }

                } catch (IllegalArgumentException e) {
                    ModLogger.error("Modifier tooltip could not be loaded! Please report to mod author. | ERROR CODE 2");
                    e.printStackTrace();
                }
            }
        }
    }

}
