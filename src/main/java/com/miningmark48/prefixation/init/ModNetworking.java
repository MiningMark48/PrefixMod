package com.miningmark48.prefixation.init;

import com.miningmark48.prefixation.network.messages.MessageReforge;
import com.miningmark48.prefixation.reference.Reference;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class ModNetworking {

    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);

    public static void init(){
        INSTANCE.registerMessage(MessageReforge.class, MessageReforge.class, 0, Side.SERVER);
    }

}
