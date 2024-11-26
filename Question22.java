package Java.Class12;

import java.util.Scanner;

public class Question22 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter N (2 < N < 10): ");
        int n = scanner.nextInt();

        if (n <= 2 || n >= 10) {
            System.out.println("N should be between 3 and 9.");
            return;
        }

        int[][] grid = readGrid(scanner, n);

        if (isWondrousSquare(grid, n)) {
            System.out.println("YES IT REPRESENTS A WONDROUS SQUARE.");
        } else {
            System.out.println("NOT A WONDROUS SQUARE.");
        }

        System.out.println("PRIME ROW INDEX COLUMN INDEX");
        printPrimeNumbersWithIndices(grid, n);
    }

    private static int[][] readGrid(Scanner scanner, int n) {
        int[][] grid = new int[n][n];
        System.out.println("Enter the values in the grid:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        return grid;
    }

    private static boolean isWondrousSquare(int[][] grid, int n) {
        int requiredSum = calculateRequiredSum(n);

        return checkRows(grid, n, requiredSum) &&
                checkColumns(grid, n, requiredSum) &&
                checkUniqueNumbers(grid, n);
    }

    private static int calculateRequiredSum(int n) {
        return (int) (0.5 * n * (n * n + 1));
    }

    private static boolean checkRows(int[][] grid, int n, int requiredSum) {
        for (int i = 0; i < n; i++) {
            int rowSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += grid[i][j];
            }
            if (rowSum != requiredSum) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkColumns(int[][] grid, int n, int requiredSum) {
        for (int j = 0; j < n; j++) {
            int colSum = 0;
            for (int i = 0; i < n; i++) {
                colSum += grid[i][j];
            }
            if (colSum != requiredSum) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkUniqueNumbers(int[][] grid, int n) {
        boolean[] present = new boolean[n * n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = grid[i][j];
                if (value < 1 || value > n * n || present[value]) {
                    return false;
                }
                present[value] = true;
            }
        }
        return true;
    }

    private static void printPrimeNumbersWithIndices(int[][] grid, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isPrime(grid[i][j])) {
                    System.out.printf("%d %d %d%n", grid[i][j], i, j);
                }
            }
        }
    }

    private static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
