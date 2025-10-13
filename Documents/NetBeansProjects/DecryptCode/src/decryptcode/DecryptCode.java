
package decryptcode;

        
        import java.util.Scanner;

public class DecryptCode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Take a single positive integer
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        // Step 1: Extract the first digit
        int numDigits = (int) Math.log10(number); // Find the number of digits - 1
        int firstDigit = number / (int) Math.pow(10, numDigits); // Extract the first digit

        // Step 2: Extract the last digit
        int lastDigit = number % 10; // Extract the last digit

        // Step 3: Calculate the product of the first and last digit
        int product = firstDigit * lastDigit;

        // Step 4: Extract the second digit and second-last digit
        int secondDigit = (number / (int) Math.pow(10, numDigits - 1)) % 10; // Extract the second digit
        int secondLastDigit = (number / 10) % 10; // Extract the second last digit

        // Step 5: Calculate the sum of the second and second-last digit
        int sumDigits = secondDigit + secondLastDigit;

        // Step 6: Create the final code by concatenating the product and sum
        String finalCode = String.valueOf(product) + String.valueOf(sumDigits);

        // Output: Display the decrypted code
        System.out.println("The decrypted code is: " + finalCode);

        // Close the scanner
        scanner.close();
    }
}

        