package com.miningmark48.prefixation.client.gui;

import com.miningmark48.prefixation.container.ContainerReforge;
import com.miningmark48.prefixation.init.ModNetworking;
import com.miningmark48.prefixation.network.messages.MessageReforge;
import com.miningmark48.prefixation.reference.Reference;
import com.miningmark48.prefixation.tile.TileEntityReforge;
import com.miningmark48.prefixation.utility.GuiUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import org.lwjgl.opengl.GL11;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GuiReforge extends GuiContainer {

    private static String texture = Reference.MOD_ID + ":textures/gui/reforge.png";

    private IInventory playerInv;
    private EntityPlayer player;
    private TileEntityReforge te;

    private GuiButton buttonReforge;

    private int xpAmount = 2;

    public GuiReforge(IInventory playerInv, TileEntityReforge te, EntityPlayer player) {
        super(new ContainerReforge(playerInv, te));
        this.xSize = 176;
        this.ySize = 160;

        this.playerInv = playerInv;
        this.player = player;
        this.te = te;

    }

    @Override
    public void initGui() {
        super.initGui();

        buttonReforge = new GuiButton(0, getGuiLeft() + 58, getGuiTop() + 52, 60, 20, "Reforge");
        buttonReforge.enabled = canReforge();

        this.buttonList.add(buttonReforge);

    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {

        if (button.mousePressed(Minecraft.getMinecraft(), button.x, button.y)) {
            ModNetworking.INSTANCE.sendToServer(new MessageReforge(this.te.getPos(), this.xpAmount));
            player.playSound(SoundEvents.BLOCK_ANVIL_USE, 1.0f, 1.0f);
        }

    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GL11.glColor4f(1F, 1F, 1F, 1F);
        this.mc.getTextureManager().bindTexture(new ResourceLocation(texture));
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);

        this.drawTexturedModalRect(getGuiLeft() + 153, getGuiTop() + 6, 177, 1, 15, 15);
    }

    @Override
    protected  void drawGuiContainerForegroundLayer(int mouseX, int mouseY){

        String s = this.te.getDisplayName().getUnformattedComponentText();
        int x = GuiUtils.getXCenter(s, this.fontRenderer, xSize);
        this.fontRenderer.drawString(s, x, 5, 0x404040);

        renderTooltips(mouseX, mouseY);

        if (!this.player.isCreative()) {
            int color = 0xCC0000;
            if (canReforge()) {
                color = 0x078007;
            }

            String xpText = String.format("XP Cost: %sL", xpAmount);
            int x2 = GuiUtils.getXCenter(xpText, this.fontRenderer, xSize);
            this.fontRenderer.drawString(xpText, x2 + 1, 43, 0x404040);
            this.fontRenderer.drawString(xpText, x2, 42, color);
        }

        if (canReforge()) {
            buttonReforge.enabled = true;
        } else {
            buttonReforge.enabled = false;
        }

    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    private void renderTooltips(int mouseX, int mouseY){
        if (this.isMouseOver(mouseX, mouseY, 150, 6, 165, 21)) {
            List<String> text = new ArrayList<String>();
            text.add(TextFormatting.BOLD + "" + TextFormatting.UNDERLINE + "Info");
            text.add("Put an item into the slot and click \"Reforge\"");
            text.add("to reforge the item to have a new prefix.");
            if (!this.player.isCreative()) {
                text.add("");
                text.add(String.format("Requires %s level%s of experience.", xpAmount, xpAmount == 1 ? "" : "s"));
            }
            net.minecraftforge.fml.client.config.GuiUtils.drawHoveringText(text, mouseX - ((this.width - this.xSize) / 2), mouseY - ((this.height - this.ySize) / 2), mc.displayWidth, mc.displayHeight, -1, mc.fontRenderer);
        }
    }

    private boolean isMouseOver(int mouseX, int mouseY, int minX, int minY, int maxX, int maxY){
        int actualX = mouseX - ((this.width - this.xSize) / 2);
        int actualY = mouseY - ((this.height - this.ySize) / 2);
        return (actualX >= minX) && (actualX <= maxX) && (actualY >= minY) && (actualY <= maxY);
    }

    private boolean canReforge() {
        return  this.player.isCreative() || this.player.experienceLevel >= xpAmount;
    }

}
