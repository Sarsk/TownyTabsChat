package com.sarsk.townytabschat.test;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ChatInjectTextCases {

    public ChatInjectTextCases() {

    }

    @SubscribeEvent
    public void onPlayerAttemptChat(ClientChatEvent event) {
        System.out.println("Chat message? : " + event.getMessage());

        // We got this! Cancel the chat msg
        if (event.getMessage().equals("/Test")) {
            // Cancel sending the event to the server
            event.setCanceled(true);
            // Send our test messages to the user
            sendClientMessageSet();
            // Send our test messages to the server
            sendServerMessageSet();
            // Inject the message into history
            Minecraft.getInstance().ingameGUI.getChatGUI().addToSentMessages(event.getMessage());
        }
    }

    //
    public static void sendClientMessageSet() {
        sendClientMessage("This is sendmessage example string.");
        sendClientMessage("Test 1");
        sendClientMessage("[Global] Sup?");
    }

    public static void sendServerMessageSet() {
        sendServerMessage("This is a message from the server!.");
        sendServerMessage("Test 1");
        sendServerMessage("[Global] Sup?");
    }


    private static void sendClientMessage(String msg) {
        Minecraft.getInstance().player.sendMessage(new StringTextComponent(msg));
    }

    private static void sendServerMessage(String msg) {
        // TODO: Messages back from the server
        //Minecraft.getInstance().player.sendMessage(new StringTextComponent(msg));
    }
}
