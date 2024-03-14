public class DevelopmentSuggestionHandler extends FeedbackHandler {
    @Override
    public void handleFeedback(Message message) {
        if (message.getMessageType() == MessageType.DEVELOPMENT_SUGGESTION) {
            System.out.println("Development suggestion logged and prioritized for sender: " + message.getMessageContent());
        } else if (nextHandler != null) {
            nextHandler.handleFeedback(message);
        }
    }
}
