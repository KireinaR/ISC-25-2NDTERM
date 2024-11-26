package Java.Class12;

import java.util.Scanner;

public class Question27 {
    // Data members
    private int[] arr;
    private int n;

    // Default constructor
    public Question27() {
        n = 0;
        arr = new int[50]; // Arbitrary large size to hold enough elements for demonstration
    }

    // Method to insert an element in ascending order
    public void insert(int value) {
        // Insert value in sorted order
        int i = n - 1;
        while (i >= 0 && arr[i] > value) {
            arr[i + 1] = arr[i];
            i--;
        }
        arr[i + 1] = value;
        n++;
    }

    // Method to insert multiple elements at once (for initial setup)
    public void insertMultiple(int[] values) {
        for (int value : values) {
            insert(value);
        }
    }

    // Method to display the contents of the array
    public void display() {
        System.out.print("Array elements: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Method to merge two sorted Question27 objects
    public Question27 merge(Question27 m) {
        Question27 result = new Question27();
        result.n = this.n + m.n;
        result.arr = new int[result.n];

        int i = 0, j = 0, k = 0;
        while (i < this.n && j < m.n) {
            if (this.arr[i] <= m.arr[j]) {
                result.arr[k++] = this.arr[i++];
            } else {
                result.arr[k++] = m.arr[j++];
            }
        }

        // Add remaining elements from either array
        while (i < this.n) {
            result.arr[k++] = this.arr[i++];
        }
        while (j < m.n) {
            result.arr[k++] = m.arr[j++];
        }

        return result;
    }

    // Main method for demonstration
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Question27 list1 = new Question27();
        Question27 list2 = new Question27();

        System.out.print("Enter number of elements for list1: ");
        int num1 = scanner.nextInt();
        System.out.println("Enter elements for list1 in any order:");
        for (int i = 0; i < num1; i++) {
            list1.insert(scanner.nextInt());
        }

        System.out.print("Enter number of elements for list2: ");
        int num2 = scanner.nextInt();
        System.out.println("Enter elements for list2 in any order:");
        for (int i = 0; i < num2; i++) {
            list2.insert(scanner.nextInt());
        }

        System.out.println("\nList 1:");
        list1.display();

        System.out.println("List 2:");
        list2.display();

        Question27 mergedList = list1.merge(list2);

        System.out.println("Merged List:");
        mergedList.display();

        scanner.close();
    }
}
