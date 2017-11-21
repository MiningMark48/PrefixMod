package com.miningmark48.prefixation.init;

import com.miningmark48.prefixation.client.gui.GuiReforge;
import com.miningmark48.prefixation.container.ContainerReforge;
import com.miningmark48.prefixation.tile.TileEntityReforge;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

    public static int gui_id_reforge = 0;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);


        if (ID == gui_id_reforge){
            return new ContainerReforge(player.inventory, (TileEntityReforge) te);
        }

        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);

        if (ID == gui_id_reforge){
            return new GuiReforge(player.inventory, (TileEntityReforge) te, player);
        }

        return null;
    }

}
