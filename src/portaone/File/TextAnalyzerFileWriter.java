package portaone.File;

import java.io.FileWriter;
import java.io.IOException;

public class TextAnalyzerFileWriter {

    public static void saveResultToFile(String result, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(result);
        }
    }
}
