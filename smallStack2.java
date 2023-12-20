public class smallStack2 {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node rearrangeWithSmallestAtBeginning(Node head) {
        if (head == null || head.next == null) {
            return head; // Nothing to rearrange for an empty list or a list with only one element
        }

        // Find the minimum element in the linked list
        Node current = head;
        Node minNode = head;
        Node prevMinNode = null;

        while (current != null) {
            if (current.data < minNode.data) {
                minNode = current;
                prevMinNode = null;
            } else if (prevMinNode != null && current.data == minNode.data) {
                prevMinNode.next = current.next;
            } else {
                prevMinNode = current;
            }
            current = current.next;
        }

        // If the minimum element is not at the beginning, rearrange the list
        if (minNode != head) {
            prevMinNode.next = head;
            head = minNode;
        }

        return head;
    }

    static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(4);
        head.next.next = new Node(1);
        head.next.next.next = new Node(8);
        head.next.next.next.next = new Node(7);

        // Linked list before: 10 -> 4 -> 1 -> 8 -> 7
        head = rearrangeWithSmallestAtBeginning(head);

        // Linked list after: 1 -> 10 -> 4 -> 8 -> 7
        printLinkedList(head);
    }
}
