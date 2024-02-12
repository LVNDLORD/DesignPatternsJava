import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Printer printer = new BasicPrinter();
        printer.print("Hello World!");

        Printer printer2 = new EncryptedPrinter(new BasicPrinter());
        printer2.print("Hello World!");

    }
}
