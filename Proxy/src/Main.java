public class Main {
    public static void main(String[] args) {
        Document document1 = new RealDocument("5", "11_01_2023", "New project plan");
        Document document2 = new RealDocument("104", "26_03_2024", "Sprint 4 review report");

        Library library = new Library();
        library.addDocument(document1);
        library.addDocument(document2);

        User user1 = new User("Alex");
        User user2 = new User("Linus");

        // Grant access to documents
        AccessControlService accessControlService = AccessControlService.getInstance();
        accessControlService.grantAccess("5", "Alex");
        accessControlService.grantAccess("104", "Linus");


        try {
            DocumentProxy proxy1 = new DocumentProxy(library.getDocument("5"));
            System.out.println("Access to document id " + proxy1.getId() + " granted for user: " + user1.getUsername() +
                    ". Document content: " + proxy1.getContent(user1));
            // printing descriptive output for clarity. Only needed is "proxy1.getContent(user1)"
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }

        try {
            DocumentProxy proxy2 = new DocumentProxy(library.getDocument("104"));
            System.out.println("Access to document id " + proxy2.getId() + " granted for user: " + user1.getUsername() +
                    ". Document content: " + proxy2.getContent(user1));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }

        try {
            DocumentProxy proxy3 = new DocumentProxy(library.getDocument("104"));
            System.out.println("Access to document id " + proxy3.getId() + " granted for user: " + user2.getUsername() +
                    ". Document content: " + proxy3.getContent(user2));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }

    }
}
