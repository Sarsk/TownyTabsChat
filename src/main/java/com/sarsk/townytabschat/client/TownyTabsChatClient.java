package com.sarsk.townytabschat.client;

import com.sarsk.townytabschat.client.render.DVEntityRendering;
import com.sarsk.townytabschat.client.render.DVTileEntityRendering;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.IngameGui;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/*
 * Class descriptions:
 *   TownyTabsChatClient - Top level class for Client side logic. Sets up project components and hooks
 *   GuiNotif - Test class to draw text to the screen
 *   TabsChatGui - Chat Gui extension
 *     The Minecraft ChatGui is the text box that lists chat messages and a scroll bar
 *     Add Tabs for various chat channels and private messages
 *     Alter contents on the fly to display only the selected channel messages
 *   TabsChatScreen - Chat Screen extension
 *     The Minecraft ChatScreen is the text box that accepts user input to send a chat msg
 *     Extend the Screen to intercept the user text, and add chat channel prefix'
 */
public class TownyTabsChatClient
{
	static TabsChatGui tabsChatGui;

	public static void initialization(FMLClientSetupEvent event)
	{
		DVTileEntityRendering.initialization();
		DVEntityRendering.initialization();
		//MinecraftForge.EVENT_BUS.register(new TabsChatScreen("Test"));

		// Replace the Minecraft Chat GUI
		tabsChatGui = new TabsChatGui(Minecraft.getInstance());
		hookIntoChat(Minecraft.getInstance().ingameGUI, tabsChatGui);
	}

	@SubscribeEvent
	public void onRenderGui(RenderGameOverlayEvent.Post event)
	{
		//TODO: Why are we returning if not exp? Copied from an example?
		if (event.getType() != RenderGameOverlayEvent.ElementType.EXPERIENCE) return;

		// TODO: GuiNotif only when needed
		new GuiNotif(Minecraft.getInstance());
	}

	@SuppressWarnings("MixinClassReference")
	private static void hookIntoChat(IngameGui guiIngame, TabsChatGui tabsChatGui) {

		//TODO: TabbyChat had this comparison backwards. Let them know?
		//TODO: What am I missing in my accesstransformer.cfg? Would rather use AT vs reflection

		try {
			if (guiIngame.getChatGUI().getClass().isAssignableFrom(tabsChatGui.getClass())) {
				// Use reflection, to replace the private final NewChatGui persistantChatGUI with
				// our own TabsChatGui instance

				// Locate the persistantChatGUI field
				Field privatePersistantChatGUIField = net.minecraft.client.gui.IngameGui.class.getDeclaredField("persistantChatGUI");
				privatePersistantChatGUIField.setAccessible(true);

				// Remove the 'final' modifier
				Field modifiersField = Field.class.getDeclaredField("modifiers");
				modifiersField.setAccessible(true);
				modifiersField.setInt(modifiersField, modifiersField.getModifiers() & ~Modifier.FINAL);

				// Apply the change
				privatePersistantChatGUIField.set(guiIngame, tabsChatGui);
				System.out.println("Successfully hooked into chat.");
			} else {
				System.out.println("Error: We failed to make our chat a child of NewChatGui");
			}
		} catch (Exception e) {
			System.out.println("Error: Unable to hook into chat.  This is bad. Exception: " + e.getMessage());
		}
	}
}