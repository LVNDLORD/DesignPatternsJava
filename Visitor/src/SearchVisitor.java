import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {
    private List<File> foundFiles;
    private String searchPattern;

    public SearchVisitor(String searchPattern) {
        this.searchPattern = searchPattern;
        foundFiles = new ArrayList<>();
    }

    public String getSearchPattern() {
        return searchPattern;
    }

    @Override
    public void visit(File file) {
        if (file.getName().contains(searchPattern)) {
            foundFiles.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        // Directory doesn't match search pattern
    }

    public List<File> getFoundFiles() {
        return foundFiles;
    }
}
