package com.sarsk.townytabschat.client;

import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/* TODO: Do we also need to replace the ChatScreen with our own implementation, to change
    the chat prefix on the fly? If yes, here's some code to start

    Code logic from Minecraft.java :: processKeyBinds()

      boolean flag2 = this.gameSettings.chatVisibility != ChatVisibility.HIDDEN;
      if (flag2) {
         while(this.gameSettings.keyBindChat.isPressed()) {
            this.displayGuiScreen(new ChatScreen(""));
         }

         if (this.currentScreen == null && this.loadingGui == null && this.gameSettings.keyBindCommand.isPressed()) {
            this.displayGuiScreen(new ChatScreen("/"));
         }
      }
 */

/*
 * Tabbed Chat Screen, based off Minecraft ChatScreen
 *   TabsChatScreen - Chat Screen extension
 *     The Minecraft ChatScreen is the text box that accepts user input to send a chat msg
 *     Extend the Screen to intercept the user text, and add chat channel prefix'
 */
@OnlyIn(Dist.CLIENT)
public class TabsChatScreen extends ChatScreen {

        public TabsChatScreen(String defaultText) {
            super(defaultText);
        }

        // protected void init() {

        // public void resize(Minecraft p_resize_1_, int p_resize_2_, int p_resize_3_) {

        // public void removed() {

        // public void tick() {

        // private void func_212997_a(String p_212997_1_) {

        @Override
        public boolean keyPressed(int p_keyPressed_1_, int p_keyPressed_2_, int p_keyPressed_3_) {
            return super.keyPressed(p_keyPressed_1_, p_keyPressed_2_, p_keyPressed_3_);
        }

        // public void showSuggestions() {

        // private static int getLastWordIndex(String p_208603_0_) {

        // private void updateSuggestion() {

        // private void updateUsageInfo() {

        //private String formatMessage(String p_195130_1_, int p_195130_2_) {


        //public static String func_212336_a(ParseResults<ISuggestionProvider> p_212336_0_, String p_212336_1_, int p_212336_2_) {

        @Override
        public boolean mouseScrolled(double p_mouseScrolled_1_, double p_mouseScrolled_3_, double p_mouseScrolled_5_) {
            return super.mouseScrolled(p_mouseScrolled_1_, p_mouseScrolled_3_, p_mouseScrolled_5_);
        }

        @Override
        public boolean mouseClicked(double p_mouseClicked_1_, double p_mouseClicked_3_, int p_mouseClicked_5_) {
            return super.mouseClicked(p_mouseClicked_1_, p_mouseClicked_3_, p_mouseClicked_5_);
        }

        //protected void insertText(String p_insertText_1_, boolean p_insertText_2_) {

        /**
         * input is relative and is applied directly to the sentHistoryCursor so -1 is the previous message, 1 is the next
         * message from the current cursor position
         */
        // public void getSentHistory(int msgPos) {

        @Override
        public void render(int p_render_1_, int p_render_2_, float p_render_3_) {
            super.render(p_render_1_, p_render_2_, p_render_3_);
        }

        //public boolean isPauseScreen() {

        //private void fillNodeUsage(TextFormatting p_195132_1_) {

        //private static String calculateSuggestionSuffix(String p_208602_0_, String p_208602_1_) {

        //private void setChatLine(String p_208604_1_) {

    }