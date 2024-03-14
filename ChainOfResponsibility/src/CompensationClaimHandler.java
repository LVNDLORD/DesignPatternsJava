public class CompensationClaimHandler extends FeedbackHandler {
    @Override
    public void handleFeedback(Message message) {
        if (message.getMessageType() == MessageType.COMPENSATION_CLAIM) {
            System.out.println("Compensation claim handled for sender: " + message.getMessageContent());
        } else if (nextHandler != null) {
            nextHandler.handleFeedback(message);
        }
    }
}
