import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Logger {
    private static final String LOG_FILE_NAME = "log.txt";

    public static void LogSession() {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(LOG_FILE_NAME, true));
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            writer.write("Program started at: " + timestamp);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Failed to log program start: " + e.getMessage());
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.err.println("Failed to close writer: " + e.getMessage());
                }
            }
        }
    }
}