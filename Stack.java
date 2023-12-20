class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    Node top;

    Stack() {
        this.top = null;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        System.out.println("Element " + data + " pushed onto the stack.");
    }

    public void pop() {
        if (top == null) {
            System.out.println("Stack is empty. Cannot pop elements.");
            return;
        }
        System.out.println("Element " + top.data + " popped from the stack.");
        top = top.next;
    }

    public void displayReverse() {
        if (top == null) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("Elements of the stack in reverse order:");
        displayReverse(top);
        System.out.println();
    }

    private void displayReverse(Node current) {
        if (current == null) {
            return;
        }
        displayReverse(current.next);
        System.out.print(current.data + " ");
    }

    public void displayStack() {
        if (top == null) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("Elements of the stack:");
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.displayStack();

        stack.displayReverse();

        stack.push(40);
        stack.displayStack();

    }
}
