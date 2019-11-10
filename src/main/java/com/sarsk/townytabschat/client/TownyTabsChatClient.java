package com.sarsk.townytabschat.client;

import com.sarsk.townytabschat.client.render.DVEntityRendering;
import com.sarsk.townytabschat.client.render.DVTileEntityRendering;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class TownyTabsChatClient
{
	public static void initialization(FMLClientSetupEvent event)
	{
		DVTileEntityRendering.initialization();
		DVEntityRendering.initialization();
		//MinecraftForge.EVENT_BUS.register(new DVMusicHandler());

		//TODO: Is this how we access the original chat gui to replace it?
		// Minecraft.getInstance().ingameGUI.getChatGUI()
	}

	@SubscribeEvent
	public void onRenderGui(RenderGameOverlayEvent.Post event)
	{
		if (event.getType() != RenderGameOverlayEvent.ElementType.EXPERIENCE) return;

		new GuiNotif(Minecraft.getInstance());
	}
}