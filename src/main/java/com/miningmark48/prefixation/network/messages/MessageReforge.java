package com.miningmark48.prefixation.network.messages;

import com.miningmark48.prefixation.tile.TileEntityReforge;
import io.netty.buffer.ByteBuf;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageReforge implements IMessage, IMessageHandler<MessageReforge, IMessage> {

    private BlockPos pos;
    private NBTTagCompound tagCompound = new NBTTagCompound();

    public MessageReforge() {

    }

    public MessageReforge(BlockPos pos, NBTTagCompound tagCompound) {
        this.pos = pos;
        this.tagCompound = tagCompound;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.pos = BlockPos.fromLong(buf.readLong());
        this.tagCompound = ByteBufUtils.readTag(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeLong(this.pos.toLong());
        ByteBufUtils.writeTag(buf, this.tagCompound);
    }

    @Override
    public IMessage onMessage(MessageReforge message, MessageContext ctx) {

        World world = ctx.getServerHandler().player.world;
        TileEntity te = world.getTileEntity(message.pos);

        if (te instanceof TileEntityReforge){
            TileEntityReforge ted = (TileEntityReforge) te;

            te.writeToNBT(this.tagCompound);

            ted.markDirty();

        }

        return null;
    }

}
