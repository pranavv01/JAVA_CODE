import java.util.*;

class stackLinkedList {
    static class Node {
        int data;
        Node next;
    }

    static Node head = null;
    static void push(int new_data) {
        Node new_node = new Node();
        new_node.data = new_data;
        new_node.next = (head);
        (head) = new_node;
    }

    static Node reverseList(Node head) {
        Stack<Node> stk = new Stack<Node>();

        Node ptr = head;
        while (ptr.next != null) {
            stk.push(ptr);
            ptr = ptr.next;
        }

        head = ptr;
        while (!stk.isEmpty()) {
            ptr.next = stk.peek();
            ptr = ptr.next;
            stk.pop();
        }
        ptr.next = null;

        return head;
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        push(100);
        push(200);
        push(300);
        push(400);
        push(500);
        printList(head);
        
        head = reverseList(head);
        int newElement = 10;
        push(newElement);
        printList(head);
    }
}