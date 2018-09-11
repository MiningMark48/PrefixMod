package com.miningmark48.prefixation.event;

import com.miningmark48.mininglib.utility.ModLogger;
import com.miningmark48.mininglib.utility.ModTranslate;
import com.miningmark48.prefixation.init.prefixes.ArmorPrefixesHandler;
import com.miningmark48.prefixation.init.prefixes.WeaponPrefixesHandler;
import com.miningmark48.prefixation.reference.EnumPrefixTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class EventTooltip {

    @SubscribeEvent
    public void onTooltip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        if (stack.getTagCompound() != null) {
            if (!stack.getTagCompound().getString("prefix").isEmpty() && !stack.getTagCompound().getString("type").isEmpty()) {
                TextFormatting defaultColor = TextFormatting.GRAY;
                try {
                    switch (EnumPrefixTypes.valueOf(stack.getTagCompound().getString("type"))) {
                        case WEAPON:
                            TextFormatting colorWeapon = WeaponPrefixesHandler.colorMap.get(WeaponPrefixesHandler.Prefixes.valueOf(stack.getTagCompound().getString("prefix").toUpperCase()));
                            String tooltipWeapon = ModTranslate.toLocal(String.format("prefix.%s.name", stack.getTagCompound().getString("prefix")).toLowerCase());
                            event.getToolTip().add(1, (colorWeapon == null ? defaultColor : colorWeapon) + tooltipWeapon);
                            break;
                        case ARMOR:
                            TextFormatting colorTool = ArmorPrefixesHandler.colorMap.get(ArmorPrefixesHandler.Prefixes.valueOf(stack.getTagCompound().getString("prefix").toUpperCase()));
                            String tooltipTool = ModTranslate.toLocal(String.format("prefix.%s.name", stack.getTagCompound().getString("prefix")).toLowerCase());
                            event.getToolTip().add(1, (colorTool == null ? defaultColor : colorTool) + tooltipTool);
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
