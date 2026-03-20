//This code is made by Emmitt Murray. It is a stack of dollars in a drawer without using the library java methods.
import java.util.Scanner;

public class DollarStack {
    private int[] stack;
    private int top;
    private int capacity;

    public DollarStack(int capacity) {
        this.capacity = capacity;
        this.stack = new int[capacity];
        this.top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push.");
            return;
        }
        stack[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return Integer.MIN_VALUE;
        }
        return stack[top--];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("Stack (top to bottom):");
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DollarStack ds = new DollarStack(100);

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1) Push a dollar value onto the stack");
            System.out.println("2) Pop (remove) the top dollar");
            System.out.println("3) Pop N dollars");
            System.out.println("4) Display stack");
            System.out.println("5) Exit");
            System.out.print("Enter choice: ");

            String line = sc.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Try again.");
                continue;
            }

            if (choice == 1) {
                System.out.print("Enter dollar value to push (e.g. 5): ");
                try {
                    int val = Integer.parseInt(sc.nextLine().trim());
                    ds.push(val);
                    System.out.println("Pushed: " + val);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number.");
                }
            } else if (choice == 2) {
                int v = ds.pop();
                if (v != Integer.MIN_VALUE) System.out.println("Popped: " + v);
            } else if (choice == 3) {
                System.out.print("How many to pop? ");
                try {
                    int n = Integer.parseInt(sc.nextLine().trim());
                    for (int i = 0; i < n; i++) {
                        int v = ds.pop();
                        if (v == Integer.MIN_VALUE) break;
                        System.out.println("Popped: " + v);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number.");
                }
            } else if (choice == 4) {
                ds.display();
            } else if (choice == 5) {
                System.out.println("Exiting.");
                break;
            } else {
                System.out.println("Unknown option.");
            }
        }

        sc.close();
    }

}
