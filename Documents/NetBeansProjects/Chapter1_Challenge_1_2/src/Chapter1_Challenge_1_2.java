
public class LotteryAnalysis {
    public static void main(String[] args) {
        // Step 1: Initialize the array with winning numbers
        String[] winningNumbers = {"12-34-56-78-90", "33-44-11-66-22", "01-02-03-04-05"};
        
        // Variables to track the highest average and corresponding winning number
        String winningNumber = "";
        double highestAverage = 0.0;

        // Step 2: Analyze each winning number
        for (String number : winningNumbers) {
            // Remove dashes
            String continuousString = number.replace("-", "");
            
            // Create an array of integers from the string
            int[] digits = new int[continuousString.length()];
            for (int i = 0; i < continuousString.length(); i++) {
                digits[i] = Character.getNumericValue(continuousString.charAt(i));
            }

            // Calculate the sum and average of the digits
            int sum = 0;
            for (int digit : digits) {
                sum += digit;
            }
            double average = (double) sum / digits.length;

            // Print analysis for each ticket
            System.out.printf("Analyzing: %s%n", number);
            System.out.printf("Digit Sum: %d, Digit Average: %.1f%n", sum, average);

            // Step 3: Check for the highest average
            if (average > highestAverage) {
                highestAverage = average;
                winningNumber = number;
            }
        }

        // Step 4: Announce the winning number with the highest average
        System.out.printf("The winning number with the highest average is: %s with an average of %.1f%n", winningNumber, highestAverage);
    }
}
