package org.example.mediator;

public class ChatClientController {
    private ChatClient client;
    private ChatGUI gui;

    public ChatClientController(ChatClient client, ChatGUI gui) {
        this.client = client;
        this.gui = gui;
    }

    public void sendMessage(String message, String sender, String recipient) {
        client.sendMessage(message, recipient);
        // Update UI to display sent message
        gui.displaySentMessage(message, sender, recipient);
    }

    public void receiveMessage(String message, String sender, String recipient) {
        // Update UI to display received message
        gui.displayReceivedMessage(message, sender, recipient);
    }
}


//package org.example.mediator;
//
//public class ChatClientController {
//    private ChatClient client;
//    private ChatGUI gui;
//
//    public ChatClientController(ChatClient client, ChatGUI gui) {
//        this.client = client;
//        this.gui = gui;
//    }
//
//    public void sendMessage(String message, String sender, String recipient) {
//        client.sendMessage(message, recipient);
//        // Update UI to display sent message
//        gui.displaySentMessage(message, sender, recipient);
//    }
//
//    public void receiveMessage(String message, String sender, String recipient) {
//        // Update UI to display received message
//        gui.displayReceivedMessage(message, sender, recipient);
//    }
//}
//
