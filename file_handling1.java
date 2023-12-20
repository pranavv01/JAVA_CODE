import java.io.File;

public class file_handling1 {
    public static void main(String[] args) {
        // Specify the directory to search in and the target file extension
        String directoryPath = "E:\\"; // Change this to the directory path you want to search in
        String targetExtension = "example.txt"; // Change this to the file extension you're looking for

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                System.out.println("Files with extension " + targetExtension + " in " + directoryPath + ":");
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(targetExtension)) {
                        System.out.println(file.getName());
                    }
                }
            } else {
                System.out.println("No files found in " + directoryPath);
            }
        } else {
            System.out.println("Directory not found or is not a valid directory.");
}}
}