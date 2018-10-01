package com.miningmark48.prefixation.commands;

import com.miningmark48.prefixation.reference.EnumPrefixTypes;
import com.miningmark48.prefixation.init.prefixes.ArmorPrefixesHandler;
import com.miningmark48.prefixation.init.prefixes.WeaponPrefixesHandler;
import com.miningmark48.prefixation.utility.HandlePrefix;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class CommandReforge extends CommandBase {

    private final String prefix = "prefix";

    public CommandReforge(){

    }

    @Override
    public String getName() {
        return String.format("%s_reforge", prefix);
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return String.format("%s_reforge", prefix);
    }

    @Override
    public List<String> getAliases() {
        List<String> aliases = new ArrayList<>();
        aliases.add(String.format("%s_reforge", prefix));
        return aliases;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (sender instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) sender;
            ItemStack heldItem = player.getHeldItem(EnumHand.MAIN_HAND);
            if (!heldItem.isEmpty() && args.length >= 1) {
                if (args[0].equalsIgnoreCase("weapon")) {
                    HandlePrefix.reforgePrefix(player, heldItem, EnumPrefixTypes.WEAPON, WeaponPrefixesHandler.weapon_prefixes);
                    sender.sendMessage(new TextComponentString(TextFormatting.GREEN + "Reforged!"));
                } else if (args[0].equalsIgnoreCase("armor")) {
                    HandlePrefix.reforgePrefix(player, heldItem, EnumPrefixTypes.ARMOR, ArmorPrefixesHandler.armor_prefixes);
                    sender.sendMessage(new TextComponentString(TextFormatting.GREEN + "Reforged!"));
                } else {
                    player.sendMessage(new TextComponentString(TextFormatting.RED + "Error: Invalid args"));
                }
            } else {
                player.sendMessage(new TextComponentString(TextFormatting.RED + "Error: Empty hand or missing args"));
            }
        }

    }

    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos pos) {
        List<String> autocompletes = new ArrayList<>();
        autocompletes.add("weapon");
        autocompletes.add("armor");
        return autocompletes;
    }

    @Override
    public boolean isUsernameIndex(String[] args, int index) {
        return false;
    }

    @Override
    public int compareTo(ICommand o) {
        return 0;
    }

}
