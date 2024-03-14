public class Main {
    public static void main(String[] args) {

        FeedbackHandler compensationHandler = new CompensationClaimHandler();
        FeedbackHandler contactHandler = new ContactRequestHandler();
        FeedbackHandler developmentHandler = new DevelopmentSuggestionHandler();
        FeedbackHandler generalHandler = new GeneralFeedbackHandler();

        compensationHandler.setNextHandler(contactHandler);
        contactHandler.setNextHandler(developmentHandler);
        developmentHandler.setNextHandler(generalHandler);

        Message compensationClaim = new Message(MessageType.COMPENSATION_CLAIM, "Claim details", "customer1@example.com");
        Message contactRequest = new Message(MessageType.CONTACT_REQUEST, "I would like to request some information about the product ...", "customer2@example.com");
        Message developmentSuggestion = new Message(MessageType.DEVELOPMENT_SUGGESTION, "I have a suggestion you may be interested in", "developer3@example.com");
        Message generalFeedback = new Message(MessageType.GENERAL_FEEDBACK, "Awful service", "customer4@example.com");

        compensationHandler.handleFeedback(compensationClaim);
        compensationHandler.handleFeedback(contactRequest);
        compensationHandler.handleFeedback(developmentSuggestion);
        compensationHandler.handleFeedback(generalFeedback);
    }
}
