import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileEncryptionDecryption {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for encryption or decryption
        System.out.print("Choose an operation (encrypt/decrypt): ");
        String operation = scanner.next().toLowerCase();

        // Prompt user for input file name or path
        System.out.print("Enter input file name or path: ");
        String inputFile = scanner.next();

        // Prompt user for output file name
        System.out.print("Enter output file name: ");
        String outputFile = scanner.next();

        try {
            if (operation.equals("encrypt")) {
                encryptFile(inputFile, outputFile);
                System.out.println("Encryption completed. Encrypted content saved to " + outputFile);
            } else if (operation.equals("decrypt")) {
                decryptFile(inputFile, outputFile);
                System.out.println("Decryption completed. Decrypted content saved to " + outputFile);
            } else {
                System.out.println("Invalid operation. Please choose 'encrypt' or 'decrypt'.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static void encryptFile(String inputFile, String outputFile) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String encryptedLine = encrypt(line);
                writer.write(encryptedLine);
                writer.newLine();
            }
        }
    }

    private static void decryptFile(String inputFile, String outputFile) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String decryptedLine = decrypt(line);
                writer.write(decryptedLine);
                writer.newLine();
            }
        }
    }

    private static String encrypt(String input) {
        // Simple encryption: shift each character by 1 position forward in the ASCII table
        StringBuilder encryptedText = new StringBuilder();
        for (char c : input.toCharArray()) {
            encryptedText.append((char) (c + 1));
        }
        return encryptedText.toString();
    }

    private static String decrypt(String input) {
        // Decrypting the encrypted text by shifting each character 1 position backward in the ASCII table
        StringBuilder decryptedText = new StringBuilder();
        for (char c : input.toCharArray()) {
            decryptedText.append((char) (c - 1));
        }
        return decryptedText.toString();
    }
}
