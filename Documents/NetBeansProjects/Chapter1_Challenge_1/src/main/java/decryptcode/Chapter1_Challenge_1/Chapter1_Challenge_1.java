/**
 /* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Chapter1_Challenge_1;

  //  public static void main(String[] args) {

    public class Chapter1_Challenge_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Step 1: Take input
        System.out.print("Enter a positive integer: ");
        while (!input.hasNextInt()) {
            System.out.println("That's not a valid integer. Please enter a positive integer.");
            input.next(); // Clear invalid input
        }
        
        int num = input.nextInt();
        
        // Validate that the number is positive
        if (num <= 0) {
            System.out.println("Please enter a positive integer.");
            input.close();
            return; // Exit if not positive
        }
        
        // Step 2: Find number of digits
        int digits = (int) Math.log10(num) + 1;
        
        // Handle single-digit case
        if (digits == 1) {
            System.out.println("The decrypted code cannot be computed for a single-digit number.");
            input.close();
            return; // Exit for single-digit numbers
        }
        
        // Step 3: Extract first digit
        int firstDigit = (int) (num / Math.pow(10, digits - 1));
        
        // Step 4: Extract last digit
        int lastDigit = num % 10;
        
        // Step 5: Extract second digit (from left)
        int secondDigit = (int) (num / Math.pow(10, digits - 2)) % 10;
        
        // Step 6: Extract second-last digit (from right)
        int secondLastDigit = (num / 10) % 10;
        
        // Step 7: Calculate product and sum
        int product = firstDigit * lastDigit;
        int sum = secondDigit + secondLastDigit;
        
        // Step 8: Create final code by concatenating product and sum
        String finalCode = Integer.toString(product) + Integer.toString(sum);
        
        // Step 9: Display result
        System.out.println("The decrypted code is: " + finalCode);
        
        input.close();
    }
}
