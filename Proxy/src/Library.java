import java.util.HashMap;

public class Library {
    private HashMap<String, Document> documents;

    public Library() {
        this.documents = new HashMap<>();
    }

    public void addDocument(Document document) {
        documents.put(document.getId(), document);
    }

    public Document getDocument(String id) {
        return documents.get(id);
    }
}