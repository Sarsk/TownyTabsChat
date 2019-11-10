package com.sarsk.townytabschat.client;

import com.google.common.collect.Lists;
import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ChatLine;
import net.minecraft.client.gui.NewChatGui;
import net.minecraft.entity.player.ChatVisibility;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;

import java.util.List;
import javax.annotation.Nullable;

/*
 * Child class of NewChatGui, which include chat tabs
 */
public class TabsChatGui extends NewChatGui {
    Minecraft mc;

    // TODO: Multiple chat lines, stored in channels
    private final List<ChatLine> chatLines = Lists.newArrayList();

    public TabsChatGui(Minecraft mcIn) {
        super(mcIn);
        this.mc = mcIn;
    }


    @Override
    public void render(int updateCounter) {
        super.render(updateCounter);

        if (this.mc.gameSettings.chatVisibility != ChatVisibility.HIDDEN ) {
                //&&               super.getChatOpen()) {

            int chatHeight = getChatHeight();
            System.out.println("Rendering TabsChatGui! Height " + chatHeight);
/*
            double lvt_5_1_ = this.getScale();
            int lvt_7_1_ = MathHelper.ceil((double)this.getChatWidth() / lvt_5_1_);*/
            GlStateManager.pushMatrix();

            int scaled_width = mc.mainWindow.getScaledWidth();
            int scaled_height = mc.mainWindow.getScaledHeight();
            this.mc.fontRenderer.drawString("TabsChatGui", scaled_width / 2, (scaled_height / 2) - 4, Integer.parseInt("FFAA00", 16));
/*
            //GlStateManager.translatef(2.0F, 8.0F, 0.0F);
            GlStateManager.scaled(lvt_5_1_, lvt_5_1_, 1.0D);
            double lvt_8_1_ = this.mc.gameSettings.chatOpacity * 0.8999999761581421D + 0.10000000149011612D;
            double lvt_10_1_ = this.mc.gameSettings.accessibilityTextBackgroundOpacity;
            fill(2, 100, 1, 100, 13421772);
*/
            GlStateManager.popMatrix();
        }
    }
/*
    private static double func_212915_c(int p_212915_0_) {
        double d0 = (double)p_212915_0_ / 200.0D;
        d0 = 1.0D - d0;
        d0 = d0 * 10.0D;
        d0 = MathHelper.clamp(d0, 0.0D, 1.0D);
        d0 = d0 * d0;
        return d0;
    }*/

    /**
     * Clears the chat.
     */
    @Override
    public void clearChatMessages(boolean p_146231_1_) {
        super.clearChatMessages(p_146231_1_);
    }

    @Override
    public void printChatMessage(ITextComponent chatComponent) {
        super.printChatMessageWithOptionalDeletion(chatComponent, 0);
    }

    /**
     * prints the ChatComponent to Chat. If the ID is not 0, deletes an existing Chat Line of that ID from the GUI
     */
    @Override
    public void printChatMessageWithOptionalDeletion(ITextComponent chatComponent, int chatLineId) {
        //TODO: Filter here into channels
        System.out.println("Added chat message (" + chatComponent.getString() + ")");
        super.printChatMessageWithOptionalDeletion(chatComponent, chatLineId);
    }
/*
    private void setChatLine(ITextComponent chatComponent, int chatLineId, int updateCounter, boolean displayOnly) {


    }*/

    @Override
    public void refreshChat() {
        super.refreshChat();
    }

    /**
     * Gets the list of messages previously sent through the chat GUI
     */
    @Override
    public List<String> getSentMessages() {
        return super.getSentMessages();
    }

    /**
     * Adds this string to the list of sent messages, for recall using the up/down arrow keys
     */
    @Override
    public void addToSentMessages(String message) {
        super.addToSentMessages(message);
    }

    /**
     * Resets the chat scroll (executed when the GUI is closed, among others)
     */
    @Override
    public void resetScroll() {
        super.resetScroll();
    }

    @Override
    public void func_194813_a(double p_194813_1_) {
        super.func_194813_a(p_194813_1_);
    }

    @Nullable
    @Override
    public ITextComponent getTextComponent(double p_194817_1_, double p_194817_3_) {
        return super.getTextComponent(p_194817_1_, p_194817_3_);
    }

    /**
     * Returns true if the chat GUI is open
     */
    @Override
    public boolean getChatOpen() {
        return super.getChatOpen();
    }

    /**
     * finds and deletes a Chat line by ID
     */
    @Override
    public void deleteChatLine(int id) {
        super.deleteChatLine(id);
    }

    @Override
    public int getChatWidth() {
        return super.getChatWidth();
    }

    @Override
    public int getChatHeight() {
        return super.getChatHeight();
    }

    @Override
    public double getScale() {
        return super.getScale();
    }

    public static int calculateChatboxWidth(double p_194814_0_) {
        return NewChatGui.calculateChatboxWidth(p_194814_0_);
    }

    public static int calculateChatboxHeight(double p_194816_0_) {
        return NewChatGui.calculateChatboxHeight(p_194816_0_);
    }

    @Override
    public int getLineCount() {
        return super.getLineCount();
    }
}
