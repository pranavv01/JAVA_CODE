class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CustomStack {
    private Node top;

    CustomStack() {
        top = null;
    }

    // Push operation
    void push(int data) {
        Node newNode = new Node(data);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    // Pop operation
    int pop() {
        if (top == null) {
            System.out.println("Stack is empty.");
            return -1; // Return a sentinel value for an empty stack
        } else {
            int data = top.data;
            top = top.next;
            return data;
        }
    }

    // Determine the smallest value in the stack and move it to the top
    void moveSmallestToTop() {
        if (top == null) {
            System.out.println("Stack is empty.");
            return;
        }

        int smallest = top.data;
        CustomStack tempStack = new CustomStack();

        // Find the smallest value in the stack
        while (top != null) {
            int data = pop();
            if (data < smallest) {
                smallest = data;
            }
            tempStack.push(data);
        }

        // Push the smallest value to the top of the stack
        push(smallest);

        // Restore the original order of other elements
        int data = tempStack.pop(); // Remove the smallest value from tempStack
        while (data != -1) {
            push(data);
            data = tempStack.pop();
        }
    }

    // Display the stack
    void display() {
        Node current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class smallStack {
    public static void main(String[] args) {
        CustomStack myStack = new CustomStack();

        myStack.push(5);
        myStack.push(2);
        myStack.push(8);
        myStack.push(1);
        myStack.push(3);

        System.out.print("Original Stack: ");
        myStack.display();

        myStack.moveSmallestToTop();

        System.out.print("Stack after moving smallest value to the top: ");
        myStack.display();
    }
}
