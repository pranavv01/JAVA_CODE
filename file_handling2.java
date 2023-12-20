import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.IOException;

public class file_handling2 {
    public static void main(String[] args) {
        String filePath = "first.txt"; // Specify the file name here

        try {
            int lineCount = countLines(filePath);
            System.out.println("Number of lines in " + filePath + ": " + lineCount);
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    private static int countLines(String filePath) throws IOException {
        int lineCount = 0;

        try (FileReader fileReader = new FileReader(filePath)) {
            int charRead;
            boolean isNewLine = true;

            while ((charRead = fileReader.read()) != -1) {
                if (isNewLine) {
                    lineCount++;
                    isNewLine = false;
                }

                if (charRead == '\n') {
                    isNewLine = true;
                }
            }
        }

        return lineCount;
    }
}
