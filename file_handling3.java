import java.io.FileReader;
import java.io.IOException;

public class file_handling3 {
    public static void main(String[] args) {
        String filePath = "first.txt"; // Specify the file name here
        String searchWord = "patil"; // Specify the search word here

        try {
            int wordCount = searchAndCountWords(filePath, searchWord);
            System.out.println("The word \"" + searchWord + "\" appears " + wordCount + " times in the file.");
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    private static int searchAndCountWords(String filePath, String searchWord) throws IOException {
        int wordCount = 0;
        int wordIndex = 0;
        char[] searchWordChars = searchWord.toCharArray();
        int searchWordLength = searchWordChars.length;

        try (FileReader fileReader = new FileReader(filePath)) {
            int charRead;

            while ((charRead = fileReader.read()) != -1) {
                char c = (char) charRead;

                if (c == searchWordChars[wordIndex]) {
                    wordIndex++;
                    if (wordIndex == searchWordLength) {
                        wordCount++;
                        wordIndex = 0;  // Reset for the next word search
                    }
                } else {
                    wordIndex = 0;  // Reset if character doesn't match the current search word
                }
            }
        }

        return wordCount;
    }
}
