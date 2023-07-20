package portaone.File;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextAnalyzerFileReader {

    public static String readTextFromFile(String filePath) throws IOException {
        StringBuilder text = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line).append("\n");
            }
        }
        return text.toString();
    }
}