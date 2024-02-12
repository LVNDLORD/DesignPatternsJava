import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FilePrinter extends PrinterDecorator {

    public FilePrinter(Printer printer) {
        super(printer);
    }

    String fileName = "outputFile.txt";

    @Override
    public void print(String input) {
        File file = new File(fileName);
        try (OutputStream outputStream = new FileOutputStream(fileName, true)) {
            byte[] bytes = (input + System.lineSeparator()).getBytes();
            outputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


