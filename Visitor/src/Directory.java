import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystemElement {
    private List<FileSystemElement> elements;
    private String name;

    public Directory(String name) {
        this.name = name;
        elements = new ArrayList<>();
    }

    public void addElement(FileSystemElement element) {
        elements.add(element);
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
        for (FileSystemElement element : elements) {
            element.accept(visitor);
        }
    }
}

