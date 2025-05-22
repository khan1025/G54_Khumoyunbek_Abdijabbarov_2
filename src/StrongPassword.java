import java.io.*;
import java.nio.file.*;
import java.util.regex.*;
import java.util.stream.Stream;

    public class StrongPassword{

        public static void main(String[] args) throws IOException {
            String folderPath = "C:/modul4/exam";
            String fileName = "Password.txt";

            Path filePath = findFile(Paths.get(folderPath), fileName);

            if (filePath != null) {
                System.out.println("Fayl topildi: " + filePath);

                Pattern strongPasswordPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$");

                try (BufferedReader reader = Files.newBufferedReader(filePath)) {
                    String line;

                    while ((line = reader.readLine()) != null) {
                        Matcher matcher = strongPasswordPattern.matcher(line);

                        if (matcher.matches()) {
                            System.out.println("Mustahkam parol: " + line);
                        }

                    }
                }

            } else {
                System.out.println("Bu joyda 'Password.txt' fayli topilmadi, iltimos qaytadan uriniib koring.");
            }
        }

        private static Path findFile(Path folder, String fileName) throws IOException {
            try (Stream<Path> paths = Files.walk(folder)) {
                return paths
                        .filter(Files::isRegularFile)
                        .filter(path -> path.getFileName().toString().equalsIgnoreCase(fileName))
                        .findFirst()
                        .orElse(null);
            }
        }
    }

