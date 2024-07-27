package LocalRepo;
public class LinkedList {
    static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node addFirst(int data, Node head) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return head;
        }
        newNode.next = head;
        head = newNode;
        return head;
    }

    public static Node addLast(int data, Node head) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return head;
        }
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    public static Node addInBetween(int data, Node head, int pos) {
        Node newNode = new Node(data);
        if(pos == 0) {
            addFirst(data, head);
        } 
        int i = 0;
        Node temp = head;
        while(i != pos-1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }  

    public static Node removeFirst(Node head) {
        if(head == null) {
            System.out.println("Nothing to delete");
        }
        head = head.next;
        return head;
    }

    public static void sizeList(Node head) {
        Node temp = head;
        int count = 0;
        while(temp != null) {
            temp = temp.next;
            count++;
        }
        System.out.println(count);
    }

    public static void printList(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String args[]) {
        Node head = addFirst(1, null);
        head = addFirst(0, head);
        head = addLast(3, head);
        head = addInBetween(2, head, 2);
        printList(head);
        head = removeFirst(head);
        printList(head);
        sizeList(head);
    }
}
