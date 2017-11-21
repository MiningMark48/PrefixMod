package com.miningmark48.prefixation.network.messages;

import com.miningmark48.mininglib.utility.ModLogger;
import com.miningmark48.prefixation.tile.TileEntityReforge;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageExperience implements IMessage, IMessageHandler<MessageExperience, IMessage> {

    private int experience;

    public MessageExperience() {

    }

    public MessageExperience(int xp) {
        this.experience = xp;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.experience = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(this.experience);
    }

    @Override
    public IMessage onMessage(MessageExperience message, MessageContext ctx) {

        ctx.getServerHandler().player.experienceLevel = message.experience;

        return null;
    }

}
