class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    private Node top;

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        int data = top.data;
        top = top.next;
        return data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}

public class Stackimpl {
    public static void main(String[] args) {
        Stack sourceStack = new Stack();
        Stack destinationStack = new Stack();

        // Push elements to the source stack
        sourceStack.push(1);
        sourceStack.push(2);
        sourceStack.push(3);
        sourceStack.push(4);
        sourceStack.push(5);

        // Copy elements from source stack to destination stack
        while (!sourceStack.isEmpty()) {
            int element = sourceStack.pop();
            destinationStack.push(element);
        }

        // Print the copied stack
        System.out.print("Copied Stack (Linked List Implementation): ");
        while (!destinationStack.isEmpty()) {
            System.out.print(destinationStack.pop() + " ");
        }
    }
}