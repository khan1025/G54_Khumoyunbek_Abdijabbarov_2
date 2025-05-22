import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CustomLogFormatter extends Formatter {

            private static final DateTimeFormatter dateFormatter =
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            @Override
            public String format(LogRecord record) {
                StringBuilder sb = new StringBuilder();
                String date = LocalDateTime.now().format(dateFormatter);
                sb.append(date).append(" ");
                sb.append(record.getLevel()).append(" ");
                sb.append(record.getSourceClassName()).append(": ");
                sb.append(formatMessage(record)).append("\n");
                if (record.getThrown() != null) {
                    Throwable t = record.getThrown();
                    for (StackTraceElement element : t.getStackTrace()) {
                        sb.append("\tat ").append(element).append("\n");
                    }
                }
                return sb.toString();
            }
}