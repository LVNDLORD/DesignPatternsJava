public class ContactRequestHandler extends FeedbackHandler {
    @Override
    public void handleFeedback(Message message) {
        if (message.getMessageType() == MessageType.CONTACT_REQUEST) {
            System.out.println("Contact request forwarded to customer service for sender: " + message.getMessageContent());
        } else if (nextHandler != null) {
            nextHandler.handleFeedback(message);
        }
    }
}
