package com.miningmark48.prefixation.tile.renderer;

import com.miningmark48.prefixation.block.BlockReforge;
import com.miningmark48.prefixation.tile.TileEntityReforge;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;

public class TileEntityReforgeRenderer extends TileEntitySpecialRenderer<TileEntityReforge> {

    @Override
    public void render(TileEntityReforge te, double x, double y, double z, float partialTicks, int destroyStage, float partial) {

        if (te != null){
            ItemStack stack = te.getStackInSlot(0).copy();
            EnumFacing facing = EnumFacing.NORTH;
            if (this.getWorld().getBlockState(te.getPos()).getBlock() instanceof BlockReforge) {
                facing = this.getWorld().getBlockState(te.getPos()).getValue(BlockReforge.FACING);
            }
            float facingIndex = getIndex(facing);

            if (!stack.isEmpty()){
                stack.setCount(1);

                //Anvil
                GlStateManager.pushMatrix();

                GlStateManager.translate(x + 0.5D, y + 0.5D, z + 0.5D);

                GlStateManager.scale(0.45D, 0.45D, 0.45D);

                double xBase1 = 0.25;
                double zBase1 = 0.25;
                double xOffset1 = (facingIndex == 1 ? 0 : (facingIndex == 2 ? xBase1 : (facingIndex == 3 ? 0 : (facingIndex == 4 ? -xBase1 : 0))));
                double yOffset1 = 0.145D;
                double zOffset1 = (facingIndex == 1 ? -zBase1 : (facingIndex == 2 ? 0 : (facingIndex == 3 ? zBase1 : (facingIndex == 4 ? 0 : 0))));

                GlStateManager.translate(xOffset1, yOffset1, zOffset1);

                GlStateManager.rotate(270, 1f, 0f, 0f);
                GlStateManager.rotate(180, 0f, 1f, 0f);
                GlStateManager.rotate(facingIndex * 360.0F / 4.0f, 0.0F, 0.0F, 1.0F);

                Minecraft.getMinecraft().getRenderItem().renderItem(stack, ItemCameraTransforms.TransformType.FIXED);

                GlStateManager.popMatrix();

            }

            //Rack 1
            GlStateManager.pushMatrix();

            GlStateManager.translate(x + 0.5D, y + 0.5D, z + 0.5D);

            GlStateManager.scale(0.45D, 0.45D, 0.45D);

            double xBase2 = 1.05;
            double x1Base2 = 0.9;
            double zbase2 = 0.9;
            double z1Base2 = 1.05;
            double xOffset2 = (facingIndex == 1 ? xBase2 : (facingIndex == 2 ? -x1Base2 : (facingIndex == 3 ? -xBase2 : (facingIndex == 4 ? x1Base2 : 0))));
            double yOffset2 = 0.345D;
            double zOffset2 = (facingIndex == 1 ? zbase2 : (facingIndex == 2 ? z1Base2 : (facingIndex == 3 ? -zbase2 : (facingIndex == 4 ? -z1Base2 : 0))));

            GlStateManager.translate(xOffset2, yOffset2, zOffset2);

            GlStateManager.rotate(facingIndex * 360.0F / 4.0f, 0f, 1f, 0f);
            GlStateManager.rotate(135, 0.0F, 0.0F, 1.0F);

            Minecraft.getMinecraft().getRenderItem().renderItem(new ItemStack(Items.GOLDEN_SWORD), ItemCameraTransforms.TransformType.FIXED);

            GlStateManager.popMatrix();

            //Rack 2
            GlStateManager.pushMatrix();

            GlStateManager.translate(x + 0.5D, y + 0.5D, z + 0.5D);

            GlStateManager.scale(0.45D, 0.45D, 0.45D);

            double xBase3 = -1.05;
            double x1Base3 = 0.865;
            double zbase3 = 0.95;
            double z1Base3 = -1.05;
            double xOffset3 = (facingIndex == 1 ? xBase3 : (facingIndex == 2 ? -x1Base3 : (facingIndex == 3 ? -xBase3 : (facingIndex == 4 ? x1Base3 : 0))));
            double yOffset3 = 0.5D;
            double zOffset3 = (facingIndex == 1 ? zbase3 : (facingIndex == 2 ? z1Base3 : (facingIndex == 3 ? -zbase3 : (facingIndex == 4 ? -z1Base3 : 0))));

            GlStateManager.translate(xOffset3, yOffset3, zOffset3);

            GlStateManager.rotate(facingIndex * 360.0F / 4.0f, 0f, 1f, 0f);
            GlStateManager.rotate(135, 0.0F, 0.0F, 1.0F);

            Minecraft.getMinecraft().getRenderItem().renderItem(new ItemStack(Items.DIAMOND_AXE), ItemCameraTransforms.TransformType.FIXED);

            GlStateManager.popMatrix();

            //Shelves
            for (int i = 0; i <= 2; i++) {
                for (int j = 0; j <= 1; j++) {

                    GlStateManager.pushMatrix();

                    GlStateManager.translate(x + 0.5D, y + 0.5D, z + 0.5D);

                    GlStateManager.scale(0.2D, 0.2D, 0.2D);

                    double xBase4 = i - 1;
                    double x1Base4 = 2.15;
                    double zbase4 = 2.15;
                    double z1Base4 = i - 1;
                    double xOffset4 = (facingIndex == 1 ? xBase4 : (facingIndex == 2 ? -x1Base4 : (facingIndex == 3 ? -xBase4 : (facingIndex == 4 ? x1Base4 : 0))));
                    double yOffset4 = (j % 2 == 1) ? (j + 1) : (j + .75);
                    double zOffset4 = (facingIndex == 1 ? zbase4 : (facingIndex == 2 ? z1Base4 : (facingIndex == 3 ? -zbase4 : (facingIndex == 4 ? -z1Base4 : 0))));

                    GlStateManager.translate(xOffset4, yOffset4, zOffset4);

                    GlStateManager.rotate((facingIndex * 360.0F / 4.0f) + 90, 0f, 1f, 0f);

                    Minecraft.getMinecraft().getRenderItem().renderItem(getItem(i, j), ItemCameraTransforms.TransformType.FIXED);

                    GlStateManager.popMatrix();
                }

            }

        }
    }

    private static ItemStack getItem(int index, int index2) {
        if (index2 == 0) {
            switch (index) {
                case 0:
                    return new ItemStack(Items.GOLDEN_CHESTPLATE);
                case 1:
                    return new ItemStack(Items.IRON_CHESTPLATE);
                case 2:
                    return new ItemStack(Items.DIAMOND_CHESTPLATE);
            }
        } else {
            switch (index) {
                case 0:
                    return new ItemStack(Items.DIAMOND_CHESTPLATE);
                case 1:
                    return new ItemStack(Items.GOLDEN_CHESTPLATE);
                case 2:
                    return new ItemStack(Items.IRON_CHESTPLATE);
            }
        }
        return new ItemStack(Items.CHAINMAIL_CHESTPLATE);
    }

    private static int getIndex(EnumFacing facing) {
        switch (facing) {
            case NORTH:
                return 1;
            case EAST:
                return 2;
            case SOUTH:
                return 3;
            case WEST:
                return 4;
        }
        return 1;
    }

}
