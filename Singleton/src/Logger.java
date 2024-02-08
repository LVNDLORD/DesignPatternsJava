import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    private static Logger instance;
    private PrintWriter writer;
    private String fileName;

    private Logger(String fileName) {
        try {
            this.fileName = fileName;
            writer = new PrintWriter(new FileWriter(fileName, true), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger("log.txt");
        }
        return instance;
    }

    public void setFileName(String fileName) {
        if (writer != null) {
            writer.close();
        }
        try {
            this.fileName = fileName;
            writer = new PrintWriter(new FileWriter(fileName, true), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(String message) {
        writer.println(message);
    }

    public void close() {
        if (writer != null) {
            writer.close();
        }
    }
}
