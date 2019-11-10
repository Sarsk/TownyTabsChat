package com.sarsk.townytabschat.client;


import net.minecraft.client.Minecraft;
//TODO: Example of how MC draws the player list on screen: import net.minecraft.client.gui.overlay.PlayerTabOverlayGui;

import net.minecraft.client.gui.AbstractGui;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

//TODO: Inherit from NewChatGui?

@OnlyIn(Dist.CLIENT)
public class GuiNotif extends AbstractGui
{
    String text = "Hello world!";

    public GuiNotif(Minecraft mc)
    {
        super();
        if (mc == null) {
            System.out.println("Null mc!");
            return;
        }/*
        if (mc.currentScreen == null) {
            System.out.println("Null mc current screen!");
            return;
        }*/
        int scaled_width = mc.mainWindow.getScaledWidth();
        int scaled_height = mc.mainWindow.getScaledHeight();
        drawCenteredString(mc.fontRenderer, text, scaled_width / 2, (scaled_height / 2) - 4, Integer.parseInt("FFAA00", 16));
        drawCenteredString(mc.fontRenderer, "At 0,0", 0, 0 - 4, Integer.parseInt("FFAA00", 16));
    }
}
