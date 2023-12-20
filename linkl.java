class Node {
    int data;
    Node next;

    // Constructor to initialize a new Node
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    // Constructor to initialize an empty linked list
    public LinkedList() {
        this.head = null;
    }

    // Method to add a new node to the end of the linked list
    public void append(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    // Method to display the elements of the linked list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class linkl {
    public static void main(String[] args) {
        LinkedList myList = new LinkedList();

        // Adding elements to the linked list
        myList.append(10);
        myList.append(20);
        myList.append(30);

        // Displaying the linked list
        System.out.print("Linked List: ");
        myList.display();
    }
}