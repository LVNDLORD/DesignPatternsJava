import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create directory structure
        Directory main = new Directory("All_Files");
        Directory documents = new Directory("Docs");
        Directory pictures = new Directory("Images");
        main.addElement(documents);
        main.addElement(pictures);


        File resume = new File("CV.pdf", 1.8);
        File coverLetter = new File("Cover_Letter.pdf", 2.6);
        documents.addElement(resume);
        documents.addElement(coverLetter);

        File photo1 = new File("loma.webp", 3.1);
        File passImg = new File("passikuva.webp", 3.9);
        pictures.addElement(photo1);
        pictures.addElement(passImg);

        // Apply size visitors
        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        main.accept(sizeVisitor);
        System.out.println("Total size of all files: " + sizeVisitor.getTotalSize() + " MB");

        // Apply type search visitors
        SearchVisitor searchVisitor = new SearchVisitor(".webp");
        main.accept(searchVisitor);
        List<File> webpFiles = searchVisitor.getFoundFiles();
        System.out.println(searchVisitor.getSearchPattern() + " files found:");
        for (File file : webpFiles) {
            System.out.println(file.getName());
        }
    }
}
