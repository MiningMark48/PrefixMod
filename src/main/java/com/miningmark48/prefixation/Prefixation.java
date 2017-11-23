package com.miningmark48.prefixation;

import com.miningmark48.mininglib.utility.ModTranslate;
import com.miningmark48.prefixation.commands.CommandReforge;
import com.miningmark48.prefixation.event.EventOnCraft;
import com.miningmark48.prefixation.handler.ConfigurationHandler;
import com.miningmark48.prefixation.init.*;
import com.miningmark48.prefixation.init.prefixes.ArmorPrefixesHandler;
import com.miningmark48.prefixation.init.prefixes.WeaponPrefixesHandler;
import com.miningmark48.prefixation.proxy.CommonProxy;
import com.miningmark48.prefixation.reference.Reference;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod(
        modid = Reference.MOD_ID,
        name = Reference.MOD_NAME,
        version = Reference.VERSION,
        dependencies = Reference.MOD_DEPENDENCIES
)
public class Prefixation {

    @Mod.Instance(Reference.MOD_ID)
    public static Prefixation instance;

    @SidedProxy(clientSide=Reference.CLIENT_PROXY_CLASS, serverSide=Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        MinecraftForge.EVENT_BUS.register(new ConfigurationHandler());

        ModBlocks.init();
        ModTiles.init();
        ModRegistry.init();
        MinecraftForge.EVENT_BUS.register(new ModRegistry());

        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());

        WeaponPrefixesHandler.init();
        ArmorPrefixesHandler.init();

        ModNetworking.init();

        MinecraftForge.EVENT_BUS.register(new EventOnCraft());

        ModTriggers.init();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
        proxy.registerRenders();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    @Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
        //event.registerServerCommand(new CommandRefreshPrefixes());
        event.registerServerCommand(new CommandReforge());
    }

}
