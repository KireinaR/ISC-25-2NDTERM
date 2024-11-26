package Java.Class12;

public class Question26 {
    // Data Members
    private int[] ele; // Array to hold integer elements
    private int cap; // Capacity of the array
    private int front; // Index of the front end
    private int rear; // Index of the rear end

    // Constructor to initialize cap, front, rear, and create the array
    public Question26(int max) {
        cap = max;
        front = -1; // Set to -1 to represent an empty state
        rear = -1; // Set to -1 to represent an empty state
        ele = new int[cap];
    }

    // Method to add an integer at the front end
    public void pushfront(int v) {
        // Check if the array is full from the front
        if ((front == 0 && rear == cap - 1) || (rear == (front - 1) % (cap - 1))) {
            System.out.println("Full from front");
            return;
        } else if (front == -1) { // If initially empty
            front = 0;
            rear = 0;
        } else if (front == 0) { // Wrap around to the end of the array
            front = cap - 1;
        } else {
            front--;
        }
        ele[front] = v;
    }

    // Method to remove and return an integer from the front end
    public int popfront() {
        if (front == -1) { // Check if the array is empty
            return -999;
        }

        int result = ele[front];
        if (front == rear) { // Single element condition
            front = -1;
            rear = -1;
        } else if (front == cap - 1) { // Wrap around if needed
            front = 0;
        } else {
            front++;
        }
        return result;
    }

    // Method to add an integer at the rear end
    public void pushrear(int v) {
        // Check if the array is full from the rear
        if ((front == 0 && rear == cap - 1) || (rear == (front - 1) % (cap - 1))) {
            System.out.println("Full from rear");
            return;
        } else if (front == -1) { // If initially empty
            front = 0;
            rear = 0;
        } else if (rear == cap - 1) { // Wrap around to the start of the array
            rear = 0;
        } else {
            rear++;
        }
        ele[rear] = v;
    }

    // Method to remove and return an integer from the rear end
    public int poprear() {
        if (front == -1) { // Check if the array is empty
            return -999;
        }

        int result = ele[rear];
        if (front == rear) { // Single element condition
            front = -1;
            rear = -1;
        } else if (rear == 0) { // Wrap around if needed
            rear = cap - 1;
        } else {
            rear--;
        }
        return result;
    }
}
