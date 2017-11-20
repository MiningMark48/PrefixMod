package com.miningmark48.prefixation.commands;

import com.miningmark48.prefixation.init.prefixes.ArmorPrefixesHandler;
import com.miningmark48.prefixation.init.prefixes.WeaponPrefixesHandler;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class CommandRefreshPrefixes extends CommandBase {

    private final String prefix = "prefix";

    public CommandRefreshPrefixes(){

    }

    @Override
    public String getName() {
        return String.format("%s_refresh", prefix);
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return String.format("%s_refresh", prefix);
    }

    @Override
    public List<String> getAliases() {
        List<String> aliases = new ArrayList<>();
        aliases.add(String.format("%s_refresh", prefix));
        return aliases;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        sender.sendMessage(new TextComponentString(TextFormatting.RED + "Refreshing prefixes... potential lag incoming!"));
        WeaponPrefixesHandler.init();
        ArmorPrefixesHandler.init();
        sender.sendMessage(new TextComponentString(TextFormatting.GREEN + "Prefixes refreshed!"));
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos pos) {
        return null;
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
