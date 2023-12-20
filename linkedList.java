
public class linkedList {

class Node
{
    int data;
    Node next;

    Node(int data)
    {
        this.data=data;
    }
}

private Node head;
private Node tail;
private int length;

public linkedList(int data)
{
    Node newNode = new Node(data);
    head=newNode;
    tail=newNode;
    length=1;
}

public void append(int data)
{
    Node newNode = new Node(data);
    if (length==0)
    {
        head = newNode;
        tail=newNode;
    }
    else
    {
        tail.next=newNode;
        tail=newNode;
    }
    length++;
}
public void printList()
{
    Node temp = head;
    while (temp !=null){
        System.out.println(temp.data);
        temp=temp.next;
    }
}

public Node removeLast() {
    if (length == 0) return null;
    Node temp = head;
    Node pre = head;
    while(temp.next != null) {
        pre = temp;
        temp = temp.next;
    }
    tail = pre;
    tail.next = null;
    length--;
    if (length == 0) {
        head = null;
        tail = null;
    }
    return temp;
}

public void prepend(int data)
{
    Node newNode=new Node(data);
    if(length==0)
    {
        head = newNode;
        tail=newNode;
    }
    else
    {
        newNode.next=head;
        head=newNode;
    }
    length++;
}

public void getHead()
{
    System.out.println("HEAD="+head.data);
}
public void getTail()
{
    System.out.println("TAIL="+tail.data);
}
public void getLength()
{
    System.out.println("length="+length);
}  

    public static void main(String args[])
    {
        linkedList myLinkedList=new linkedList(4);
        myLinkedList.append(12);
        myLinkedList.getHead();
        myLinkedList.getTail();
        myLinkedList.getLength();

        // (2) Items - Returns 2 Node
        System.out.println(myLinkedList.removeLast().data);
        // (1) Item - Returns 1 Node
        System.out.println(myLinkedList.removeLast().data);
        // (0) Items - Returns null
        System.out.println(myLinkedList.removeLast());

        myLinkedList.printList();
    }

}
