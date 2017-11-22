package com.miningmark48.prefixation.proxy;

import com.miningmark48.prefixation.init.ModRegistry;
import com.miningmark48.prefixation.tile.TileEntityReforge;
import com.miningmark48.prefixation.tile.renderer.TileEntityReforgeRenderer;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy{

    @Override
    public void init(){

    }

    @Override
    public void registerRenders() {
        ModRegistry.registerRenderBlocks();

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityReforge.class, new TileEntityReforgeRenderer());
    }
}
