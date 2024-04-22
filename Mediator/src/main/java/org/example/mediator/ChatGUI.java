package org.example.mediator;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

public class ChatGUI extends Application {
    private ChatClientController controller;
    private ObservableList<String> userList;
    private ComboBox<String> senderComboBox;
    private ComboBox<String> recipientComboBox;
    private TextArea chatArea; // Declare chatArea as a class member

    @Override
    public void start(Stage primaryStage) {
        // Initialize UI components
        chatArea = new TextArea(); // Initialize chatArea here
        TextField messageField = new TextField();
        senderComboBox = new ComboBox<>();
        recipientComboBox = new ComboBox<>();
        Button sendButton = new Button("Send");

        // Set up event handling
        sendButton.setOnAction(e -> {
            String message = messageField.getText();
            String sender = senderComboBox.getValue(); // Get the selected sender
            String recipient = recipientComboBox.getValue();
            controller.sendMessage(message, sender, recipient); // Pass message, sender, and recipient
            messageField.clear();
        });

        // Layout
        VBox root = new VBox(chatArea, senderComboBox, recipientComboBox, messageField, sendButton);
        Scene scene = new Scene(root, 400, 300);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Chat Client");

        // Add predefined users to ComboBoxes
        List<String> usernames = Arrays.asList("Andrii", "Sofi", "Mikael");
        setSenderList(usernames);
        setRecipientList(usernames, "");

        // Initialize the controller
        ChatMediator mediator = new ChatMediator();
        ChatClient client = new ChatClient("YourUsername", mediator);
        controller = new ChatClientController(client, this);

        // Show GUI
        primaryStage.show();
    }

    public void setController(ChatClientController controller) {
        this.controller = controller;
    }

    public void setUserList(ObservableList<String> userList) {
        this.userList = userList;
    }

    public void setSenderList(List<String> senders) {
        ObservableList<String> senderOptions = FXCollections.observableArrayList(senders);
        senderComboBox.setItems(senderOptions);
    }

    public void setRecipientList(List<String> recipients, String sender) {
        ObservableList<String> recipientOptions = FXCollections.observableArrayList();
        for (String recipient : recipients) {
            if (!recipient.equals(sender)) {
                recipientOptions.add(recipient);
            }
        }
        recipientComboBox.setItems(recipientOptions);
    }

    public void displaySentMessage(String message, String sender, String recipient) {
        // Update UI to display sent message
        chatArea.appendText("[" + sender + " to " + recipient + "]: " + message + "\n");
    }

    public void displayReceivedMessage(String message, String sender, String recipient) {
        // Update UI to display received message
        chatArea.appendText("[" + sender + " to " + recipient + "]: " + message + "\n");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
