import java.util.Scanner;

public class PasswordStrengthChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for password input
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // Check password strength based on criteria
        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasLowercase = !password.equals(password.toUpperCase());
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasSpecialChar = !password.matches("[A-Za-z0-9]*");

        int length = password.length();

        // Provide feedback on password strength
        System.out.println("Password Strength Analysis:");
        System.out.println("Length: " + length);
        System.out.println("Has Uppercase: " + hasUppercase);
        System.out.println("Has Lowercase: " + hasLowercase);
        System.out.println("Has Digit: " + hasDigit);
        System.out.println("Has Special Character: " + hasSpecialChar);

        // Determine overall password strength
        if (length >= 8 && hasUppercase && hasLowercase && hasDigit && hasSpecialChar) {
            System.out.println("Password is Strong!");
        } else if (length >= 6 && ((hasUppercase && hasLowercase) || (hasLowercase && hasDigit) || (hasUppercase && hasDigit))) {
            System.out.println("Password is Moderate!");
        } else {
            System.out.println("Password is Weak!");
        }

        scanner.close();
    }
}
