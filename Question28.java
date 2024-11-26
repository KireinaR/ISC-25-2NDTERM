package Java.Class12;

import java.util.Scanner;

public class Question28 {
    private int n; // The number to be checked

    // Method to accept the number from the user
    public void storenum(int number) {
        this.n = number;
    }

    // Method to check if the number is a Keith number
    public boolean checkKeith() {
        // Convert the number to its digits and store them in an array
        String numStr = Integer.toString(n);
        int numDigits = numStr.length();
        int[] sequence = new int[50]; // Allocate a larger array for the sequence
        for (int i = 0; i < numDigits; i++) {
            sequence[i] = Character.getNumericValue(numStr.charAt(i));
        }

        int currentLength = numDigits;
        int nextTerm;

        // Generate terms in the sequence until a term >= n is found
        while (true) {
            nextTerm = 0;
            // Sum the last 'numDigits' elements in the array
            for (int i = currentLength - numDigits; i < currentLength; i++) {
                nextTerm += sequence[i];
            }

            if (nextTerm == n) { // If the next term matches n, it's a Keith number
                return true;
            }
            if (nextTerm > n) { // If the next term exceeds n, it's not a Keith number
                return false;
            }

            // Add next term to sequence
            sequence[currentLength++] = nextTerm;
        }
    }

    // Method to display all Keith numbers between x and y (inclusive)
    public void findKeithNums(int x, int y) {
        System.out.println("Keith numbers between " + x + " and " + y + ":");
        boolean found = false;
        for (int i = x; i <= y; i++) {
            storenum(i); // Set the current number
            if (checkKeith()) { // Check if it's a Keith number
                System.out.print(i + " ");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No Keith numbers found in this range.");
        } else {
            System.out.println(); // New line after displaying numbers
        }
    }

    // Main method to demonstrate functionality
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Question28 keithNumber = new Question28();

        // Accept a number from the user and check if it's a Keith number
        System.out.print("Enter a number to check if it's a Keith number: ");
        int number = scanner.nextInt();
        keithNumber.storenum(number);
        if (keithNumber.checkKeith()) {
            System.out.println(number + " is a Keith number.");
        } else {
            System.out.println(number + " is not a Keith number.");
        }

        // Accept range from the user and display all Keith numbers in that range
        System.out.print("Enter the start of the range: ");
        int start = scanner.nextInt();
        System.out.print("Enter the end of the range: ");
        int end = scanner.nextInt();
        keithNumber.findKeithNums(start, end);

        scanner.close();
    }
}
