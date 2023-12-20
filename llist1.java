class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    LinkedList() {
        head = null;
    }

    // Insertion at the end of the linked list
    void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Deletion of a node with a specific value
    void delete(int data) {
        if (head == null) {
            System.out.println("Linked List is empty.");
            return;
        }
        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;
        Node previous = null;
        while (current != null && current.data != data) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Element not found in the list.");
            return;
        }

        previous.next = current.next;
    }

    // Display the linked list
    void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class llist1 {
    public static void main(String[] args) {
        LinkedList myList = new LinkedList();

        myList.insert(1);
        System.out.print("Linked List after inserting 1: ");
        myList.display();

        myList.insert(2);
        System.out.print("Linked List after inserting 2: ");
        myList.display();

        myList.insert(3);
        System.out.print("Linked List after inserting 3: ");
        myList.display();

        myList.insert(4);
        System.out.print("Linked List after inserting 4: ");
        myList.display();

        myList.delete(2); // Delete node with value 2
        System.out.print("Linked List after deleting 2: ");
        myList.display();

        myList.delete(1); // Delete node with value 1
        System.out.print("Linked List after deleting 1: ");
        myList.display();
    }
}