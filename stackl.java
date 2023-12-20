import java.util.Scanner;

class stackl {
    private int maxSize;
    private int top;
    private int[] stackArray;

    public stackl(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public void push(int value) {
        if (!isFull()) {
            stackArray[++top] = value;
        }
    }

    public int pop() {
        if (!isEmpty()) {
            return stackArray[top--];
        }
        return -1; // Stack underflow
    }

    public int peek() {
        if (!isEmpty()) {
            return stackArray[top];
        }
        return -1; // Stack is empty
    }

    public void moveSmallestToTop() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }

        int smallestIndex = 0;
        int smallestValue = stackArray[0];

        // Find the index of the smallest element
        for (int i = 1; i <= top; i++) {
            if (stackArray[i] < smallestValue) {
                smallestValue = stackArray[i];
                smallestIndex = i;
            }
        }

        // Move the smallest element to the top
        for (int i = smallestIndex; i < top; i++) {
            stackArray[i] = stackArray[i + 1];
        }

        stackArray[top] = smallestValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the stack: ");
        int size = scanner.nextInt();

        stackl stack = new stackl(size);

        System.out.println("Enter elements for the stack:");
        for (int i = 0; i < size; i++) {
            int value = scanner.nextInt();
            stack.push(value);
        }

        stack.moveSmallestToTop();

        System.out.println("Stack after moving the smallest element to the top:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

        scanner.close();
    }
}