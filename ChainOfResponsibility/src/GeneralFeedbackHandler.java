public class GeneralFeedbackHandler extends FeedbackHandler {
    @Override
    public void handleFeedback(Message message) {
        if (message.getMessageType() == MessageType.GENERAL_FEEDBACK) {
            System.out.println("General feedback analyzed and responded to for sender: " + message.getMessageContent());
        } else if (nextHandler != null) {
            nextHandler.handleFeedback(message);
        }
    }
}
