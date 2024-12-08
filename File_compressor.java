import java.io.*;// for file operations
import java.util.*;//for user interactive inputs

public class File_compressor {

    public static void compressFile(String inputFile, String outputFile) {
        try (FileInputStream input = new FileInputStream(inputFile);
                FileOutputStream output = new FileOutputStream(outputFile)) {

            int currentChar, prevChar = -1;
            int count = 0;

            while ((currentChar = input.read()) != -1) {
                if (currentChar == prevChar) {
                    count++;
                    if (count == 255) {
                        output.write(prevChar);
                        output.write(count);
                        count = 0;
                    }
                } else {
                    if (prevChar != -1) {
                        output.write(prevChar);
                        output.write(count);
                    }
                    prevChar = currentChar;
                    count = 1;
                }
            }

            if (prevChar != -1) {
                output.write(prevChar);
                output.write(count);
            }

            System.out.println("File compressed successfully!");

        } catch (IOException e) {
            System.err.println("Error during file compression: " + e.getMessage());
        }
    }

    // Method to decompress the file
    public static void main(String[] args) {
        char choice;
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Choose operatrion Compression - C and Decompression -D (C/D) : ");
            choice = sc.next().charAt(0);
            if (choice == 'c' || choice == 'C') {
                String inputFile = "input.txt";// file should be given by user
                String compressedFile = "compressed.bin";// this get created by itself in the same directory

                String directoryPath = "D:\\Java";// in which directory compress file should be created

                File file = new File(directoryPath + File.separator + compressedFile);

                try {
                    if (file.createNewFile()) {
                        System.out.println("File created: " + file.getName());
                    } else {
                        System.out.println("File already exists.");
                    }
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }

                System.out.println("Compressing file...");
                compressFile(inputFile, compressedFile);
            } else if (choice == 'd' || choice == 'D') {
                String inputFile = "compressed.bin";// file should be given by user
                String decompressedFile = "decompressed.txt";// this get created by itself in the same directory

                String directoryPath = "D:\\Java";// in which directory decompress file should be created

                File file = new File(directoryPath + File.separator + decompressedFile);

                try {
                    if (file.createNewFile()) {
                        System.out.println("File created: " + file.getName());
                    } else {
                        System.out.println("File already exists.");
                    }
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
                System.out.println("Decompressing file...");
                decompressFile(inputFile, decompressedFile);
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Invalid choice");
        } finally {
        }

    }
}
