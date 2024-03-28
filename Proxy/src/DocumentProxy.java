public class DocumentProxy implements Document {
    private Document document;
    private AccessControlService accessControlService;

    public DocumentProxy(Document document) {
        this.document = document;
        this.accessControlService = AccessControlService.getInstance();
    }

    @Override
    public String getId() {
        return document.getId();
    }

    @Override
    public String getCreationDate() {
        return document.getCreationDate();
    }

    public String getContent(User user) throws AccessDeniedException {
        if (document instanceof RealDocument) {
            RealDocument realDocument = (RealDocument) document;
            if (accessControlService.isAllowed(realDocument.getId(), user.getUsername())) {
                return realDocument.getContent();
            } else {
                throw new AccessDeniedException("Access to document id " + realDocument.getId() +
                        " denied for user: " + user.getUsername() + ". Check user permission for requested content.");
            }
        }
        return null;
    }
}

