import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogExample {
    private static final Logger logger = Logger.getLogger(LogExample.class.getName());
    static {
        try {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd_HH.mm"));
            String fileName = timestamp + ".log";
            FileHandler fileHandler = new FileHandler(fileName, true);
            fileHandler.setFormatter(new CustomLogFormatter());
            logger.addHandler(fileHandler);
            logger.setUseParentHandlers(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        logger.info("Bu oddiy log xabari");
        logger.warning("Bu ogohlantiruvchi log xabari");
        try {
            throw new RuntimeException("Xatolik yuz berdi!");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Xatolik logi", e);
        }
    }
}
