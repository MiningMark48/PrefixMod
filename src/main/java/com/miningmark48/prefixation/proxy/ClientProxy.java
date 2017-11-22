package com.miningmark48.prefixation.proxy;

import com.miningmark48.prefixation.event.EventTooltip;
import com.miningmark48.prefixation.init.ModRegistry;
import com.miningmark48.prefixation.tile.TileEntityReforge;
import com.miningmark48.prefixation.tile.renderer.TileEntityReforgeRenderer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

public class ClientProxy extends CommonProxy{

    @Override
    public void init(FMLInitializationEvent event){

    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new EventTooltip());
    }

    @Override
    public void registerRenders() {
        ModRegistry.registerRenderBlocks();

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityReforge.class, new TileEntityReforgeRenderer());
    }
}
