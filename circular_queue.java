class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularQueue {
    private Node front;
    private Node rear;

    public CircularQueue() {
        front = null;
        rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        rear.next = front; // Make it circular
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        int removedValue = front.data;
        if (front == rear) {
            front = null;
            rear = null;
        } else {
            front = front.next;
            rear.next = front; // Update rear to maintain circular structure
        }

        return removedValue;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return front.data;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        Node current = front;
        System.out.print("Queue: ");
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != front);
        System.out.println();
    }
}

public class circular_queue {
    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue();

        // Enqueue some elements
        queue.enqueue(1);
        queue.printQueue();

        queue.enqueue(2);
        queue.printQueue();

        queue.enqueue(3);
        queue.printQueue();

        // Print and dequeue elements
        System.out.println("Front element: " + queue.peek());
        System.out.println("Dequeue: " + queue.dequeue());
        queue.printQueue();

        System.out.println("Front element: " + queue.peek());
        System.out.println("Dequeue: " + queue.dequeue());
        queue.printQueue();

        System.out.println("Front element: " + queue.peek());
        System.out.println("Dequeue: " + queue.dequeue());
        queue.printQueue();
    }
}