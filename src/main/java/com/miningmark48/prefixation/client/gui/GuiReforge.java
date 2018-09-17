package com.miningmark48.prefixation.client.gui;

import com.miningmark48.mininglib.utility.ModLogger;
import com.miningmark48.mininglib.utility.ModTranslate;
import com.miningmark48.prefixation.container.ContainerReforge;
import com.miningmark48.prefixation.handler.ConfigurationHandler;
import com.miningmark48.prefixation.init.ModNetworking;
import com.miningmark48.prefixation.init.prefixes.ArmorPrefixesHandler;
import com.miningmark48.prefixation.init.prefixes.WeaponPrefixesHandler;
import com.miningmark48.prefixation.network.messages.MessageReforge;
import com.miningmark48.prefixation.reference.EnumPrefixTypes;
import com.miningmark48.prefixation.reference.Reference;
import com.miningmark48.prefixation.tile.TileEntityReforge;
import com.miningmark48.prefixation.utility.Colors;
import com.miningmark48.prefixation.utility.GuiUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
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

    private int xpAmount = ConfigurationHandler.reforge_experience_use_amount;

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

        buttonReforge = new GuiButton(0, getGuiLeft() + 58, getGuiTop() + 52, 60, 20, ModTranslate.toLocal("gui.reforge.button.reforge"));
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

        ItemStack stack = this.te.getStackInSlot(0);
        if (!stack.isEmpty() && stack.hasTagCompound()){
            String prefix = ModTranslate.toLocal(String.format("prefix.%s.name", stack.getTagCompound().getString("prefix")).toLowerCase());

            int color = 0x404040;
            if (!stack.hasTagCompound()) {
                stack.setTagCompound(new NBTTagCompound());
            }

            try {
                assert stack.getTagCompound() != null;
                switch (EnumPrefixTypes.valueOf(stack.getTagCompound().getString("type"))) {
                    case WEAPON:
                        TextFormatting colorWeapon = WeaponPrefixesHandler.weapon_prefixes.get(stack.getTagCompound().getInteger("prefix_index")).getColor();
                        color = Colors.getHexidecimal(colorWeapon.getColorIndex());
                        break;
                    case ARMOR:
                        TextFormatting colorArmor = ArmorPrefixesHandler.armor_prefixes.get(stack.getTagCompound().getInteger("prefix_index")).getColor();
                        color = Colors.getHexidecimal(colorArmor.getColorIndex());
                        break;
                    default:
                        break;
                }
            } catch (IllegalArgumentException e) {
                color = 0x404040;
            }

            //this.fontRenderer.drawString(prefix, GuiUtils.getXCenter(prefix, this.fontRenderer, 85),  25, color);
            this.fontRenderer.drawString(prefix, GuiUtils.getXCenter(prefix, this.fontRenderer, xSize),  42, color);

        }

        renderTooltips(mouseX, mouseY);

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
        //ModLogger.info("X: " + (mouseX - getGuiLeft()) + " Y: " + (mouseY - getGuiTop()));
        if (this.isMouseOver(mouseX, mouseY, 150, 6, 165, 21)) {
            List<String> text = new ArrayList<String>();
            text.add(TextFormatting.BOLD + "" + TextFormatting.UNDERLINE + ModTranslate.toLocal("tooltip.gui.reforge.info.header"));
            text.add(ModTranslate.toLocal("tooltip.gui.reforge.info.line1"));
            text.add(ModTranslate.toLocal("tooltip.gui.reforge.info.line2"));
            if (!this.player.isCreative()) {
                text.add("");
                text.add(String.format(ModTranslate.toLocal("tooltip.gui.reforge.info.line3"), xpAmount, xpAmount == 1 ? "" : "s"));
            }
            net.minecraftforge.fml.client.config.GuiUtils.drawHoveringText(text, mouseX - ((this.width - this.xSize) / 2), mouseY - ((this.height - this.ySize) / 2), mc.displayWidth, mc.displayHeight, -1, mc.fontRenderer);
        } else if (this.isMouseOver(mouseX, mouseY, 58, 54, 118, 71)) {
            List<String> text = new ArrayList<String>();
            int color = TextFormatting.RED.getColorIndex();
            if (canReforge()) {
                color = TextFormatting.GREEN.getColorIndex();
            }
            if (!this.player.isCreative()) {
                text.add(TextFormatting.fromColorIndex(color) + String.format(ModTranslate.toLocal("gui.reforge.xp_cost"), xpAmount));
            } else {
                return;
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
