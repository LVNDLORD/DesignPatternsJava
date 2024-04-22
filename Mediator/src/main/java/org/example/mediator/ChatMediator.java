package org.example.mediator;

import java.util.HashMap;
import java.util.Map;

public class ChatMediator {
    private Map<String, ChatClient> clients;

    public ChatMediator() {
        clients = new HashMap<>();
    }

    public void registerClient(ChatClient client) {
        clients.put(client.getUsername(), client);
    }

    public ChatClient getClientByUsername(String username) {
        return clients.get(username);
    }

    public void sendMessage(ChatClient sender, String message, String recipient) {
        ChatClient receiver = clients.get(recipient);
        if (receiver != null) {
            receiver.receiveMessage(message, sender.getUsername());
        } else {
            // Handle case where recipient is not found
        }
    }
}


//package org.example.mediator;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class ChatMediator {
//    private Map<String, ChatClient> clients;
//
//    public ChatMediator() {
//        clients = new HashMap<>();
//    }
//
//    public void registerClient(ChatClient client) {
//        clients.put(client.getUsername(), client);
//    }
//
//    public ChatClient getClientByUsername(String username) {
//        return clients.get(username);
//    }
//
//    public void sendMessage(ChatClient sender, String message, String recipient) {
//        ChatClient receiver = clients.get(recipient);
//        if (receiver != null) {
//            receiver.receiveMessage(message, sender.getUsername());
//        } else {
//            // Handle case where recipient is not found
//        }
//    }
//}
