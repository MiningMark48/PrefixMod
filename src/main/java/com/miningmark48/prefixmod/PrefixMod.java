package com.miningmark48.prefixmod;

import com.miningmark48.prefixmod.commands.CommandReforge;
import com.miningmark48.prefixmod.commands.CommandRefreshPrefixes;
import com.miningmark48.prefixmod.event.EventOnCraft;
import com.miningmark48.prefixmod.event.EventTooltip;
import com.miningmark48.prefixmod.init.prefixes.WeaponPrefixesHandler;
import com.miningmark48.prefixmod.proxy.CommonProxy;
import com.miningmark48.prefixmod.reference.Reference;
import com.miningmark48.prefixmod.init.prefixes.ToolPrefixesHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(
        modid = Reference.MOD_ID,
        name = Reference.MOD_NAME,
        version = Reference.VERSION,
        dependencies = Reference.MOD_DEPENDENCIES
)
public class PrefixMod {

    @Mod.Instance(Reference.MOD_ID)
    public static PrefixMod instance;

    @SidedProxy(clientSide=Reference.CLIENT_PROXY_CLASS, serverSide=Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        WeaponPrefixesHandler.init();
        ToolPrefixesHandler.init();

        MinecraftForge.EVENT_BUS.register(new EventOnCraft());
        MinecraftForge.EVENT_BUS.register(new EventTooltip());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init();
    }

    @Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
        event.registerServerCommand(new CommandRefreshPrefixes());
        event.registerServerCommand(new CommandReforge());
    }

}
