package com.miningmark48.prefixation.init;

import com.miningmark48.prefixation.block.BlockReforge;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

public class ModBlocks {

    public static Block reforge;

    public static void init() {
        reforge = new BlockReforge().setUnlocalizedName("reforge").setRegistryName("reforge").setCreativeTab(CreativeTabs.TOOLS);
    }

}
