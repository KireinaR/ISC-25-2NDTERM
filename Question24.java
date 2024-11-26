package Java.Class12;

import java.util.Scanner;

public class Question24 {

    static int p, q;

    static void accept() {
        Scanner sc = new Scanner(System.in);
        System.out.print("P = ");
        p = sc.nextInt();
        System.out.println();
        System.out.print("Q = ");
        q = sc.nextInt();
        System.out.println();
        sc.close();
    }

    public static boolean isKaprekar(int n) {
        // Step 1: Calculate the square of the number
        int square = n * n;

        // Step 2: Convert the square to a string for splitting
        String squareStr = Integer.toString(square);

        // Step 3: Split the square into two parts
        int len = squareStr.length();
        int rightPart = Integer.parseInt(squareStr.substring(len / 2)); // Right part (from the middle to the end)
        int leftPart = len > 1 ? Integer.parseInt(squareStr.substring(0, len / 2)) : 0; // Left part (from the start to
                                                                                        // the middle)

        // Step 4: Check if the sum of the two parts equals the original number
        return (leftPart + rightPart) == n;
    }

    static void exec() {
        accept();
        System.out.println("THE KAPREKAR NUMBERS ARE:");
        for (int i = p; i <= q; i++) {
            if (isKaprekar(i))
                System.out.print(i + "  ");
        }
    }

    public static void main(String[] args) {
        exec();
    }

}
