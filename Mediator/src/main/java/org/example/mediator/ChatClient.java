package org.example.mediator;

public class ChatClient {
    private String username;
    private ChatMediator mediator;

    public ChatClient(String username, ChatMediator mediator) {
        this.username = username;
        this.mediator = mediator;
    }

    public String getUsername() {
        return username;
    }

    public void sendMessage(String message, String recipient) {
        mediator.sendMessage(this, message, recipient); // Pass sender, recipient, and message to the mediator
    }

    public void receiveMessage(String sender, String message) {
        System.out.println("[" + sender + "]: " + message);
    }
}
