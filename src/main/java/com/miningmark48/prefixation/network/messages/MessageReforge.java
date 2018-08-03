package com.miningmark48.prefixation.network.messages;

import com.miningmark48.mininglib.utility.ModLogger;
import com.miningmark48.prefixation.init.prefixes.ArmorPrefixesHandler;
import com.miningmark48.prefixation.init.prefixes.WeaponPrefixesHandler;
import com.miningmark48.prefixation.reference.EnumPrefixTypes;
import com.miningmark48.prefixation.tile.TileEntityReforge;
import com.miningmark48.prefixation.utility.HandlePrefix;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageReforge implements IMessage, IMessageHandler<MessageReforge, IMessage> {

    private int xpAmount;

    private BlockPos pos;

    public MessageReforge() {

    }

    public MessageReforge(BlockPos pos, int xpAmount) {
        this.pos = pos;
        this.xpAmount = xpAmount;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.pos = BlockPos.fromLong(buf.readLong());
        this.xpAmount = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeLong(this.pos.toLong());
        buf.writeInt(this.xpAmount);
    }

    @Override
    public IMessage onMessage(MessageReforge message, MessageContext ctx) {

        EntityPlayer player = ctx.getServerHandler().player;
        World world = player.getEntityWorld();
        TileEntity te = world.getTileEntity(message.pos);

        if (te instanceof TileEntityReforge){
            TileEntityReforge ted = (TileEntityReforge) te;
            ItemStack stack = ted.getStackInSlot(0);
            if (!stack.isEmpty()) {
                if (stack.getItem() instanceof ItemSword || stack.getItem() instanceof ItemAxe) {
                    HandlePrefix.reforgePrefix(player, stack, EnumPrefixTypes.WEAPON, WeaponPrefixesHandler.prefixNameMap, WeaponPrefixesHandler.modifierMap, WeaponPrefixesHandler.modifierNameMap);
                    if (!player.isCreative()) player.addExperienceLevel(-message.xpAmount);
                } else if (stack.getItem() instanceof ItemArmor) {
                    if (((ItemArmor) stack.getItem()).armorType.equals(EntityEquipmentSlot.CHEST)) {
                        HandlePrefix.reforgePrefix(player, stack, EnumPrefixTypes.ARMOR, ArmorPrefixesHandler.prefixNameMap, ArmorPrefixesHandler.modifierMap, ArmorPrefixesHandler.modifierNameMap, EntityEquipmentSlot.CHEST);
                        if (!player.isCreative()) player.addExperienceLevel(-message.xpAmount);
                    }
                }
                te.markDirty();
            }

        }

        return null;
    }

}
