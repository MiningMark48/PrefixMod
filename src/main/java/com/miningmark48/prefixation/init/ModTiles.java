package com.miningmark48.prefixation.init;

import com.miningmark48.prefixation.tile.TileEntityReforge;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModTiles {

    public static void init() {
        GameRegistry.registerTileEntity(TileEntityReforge.class, "reforge");
    }

}
