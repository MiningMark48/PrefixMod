package com.miningmark48.prefixation.proxy;

import com.miningmark48.prefixation.init.ModRegistry;

public class ClientProxy extends CommonProxy{

    @Override
    public void init(){

    }

    @Override
    public void registerRenders() {
        ModRegistry.registerRenderBlocks();
    }
}
