import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

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

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void insert(int data, int position) {
        Node newNode = new Node(data);

        if (position == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            Node previous = head;
            int count = 1;
            while (count < position - 1 && previous.next != null) {
                previous = previous.next;
                count++;
            }
            if (previous.next == null && count < position - 1) {
                System.out.println("Position out of range.");
                return;
            }
            newNode.next = previous.next;
            previous.next = newNode;
        }
    }

    public void delete(int data) {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
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
}

public class linkl1
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList myList = new LinkedList();

        while (true) {
            System.out.println("\nLinked List Operations:");
            System.out.println("1. Append");
            System.out.println("2. Insert");
            System.out.println("3. Delete");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data to append: ");
                    int data = scanner.nextInt();
                    myList.append(data);
                    break;

                case 2:
                    System.out.print("Enter data to insert: ");
                    int insertData = scanner.nextInt();
                    System.out.print("Enter position to insert: ");
                    int position = scanner.nextInt();
                    myList.insert(insertData, position);
                    break;

                case 3:
                    System.out.print("Enter data to delete: ");
                    int deleteData = scanner.nextInt();
                    myList.delete(deleteData);
                    break;

                case 4:
                    myList.display();
                    break;

                case 5:
                    System.out.println("Exiting program.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}