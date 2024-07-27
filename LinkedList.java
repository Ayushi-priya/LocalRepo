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
            head = addFirst(data, head);
            return head;
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
            return head;
        }
        head = head.next;
        return head;
    }

    public static Node removeLast(Node head) {
        if(head == null) {
            System.out.println("Nothing to delete");
            return head;
        }
        Node temp = head;
        while(temp.next.next != null) {
            temp=temp.next;
        }
        temp.next=null;
        return head;
    }

    public static Node removeInBetween(Node head, int pos) {
        int i = 0;
        Node temp = head.next;
        Node prev = head;
        if(pos == 0) {
            head = removeFirst(head);
            return head;
        }
        while(i != pos-1) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = temp.next;
        temp.next = null;
        temp = prev;
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
        head = addLast(4, head);
        head = addLast(5, head);
        head = addLast(6, head);
        head = addLast(7, head);
        head = addInBetween(2, head, 2);
        printList(head);
        // head = removeFirst(head);
        // head = removeLast(head);
        // head = removeLast(head);
        head = removeInBetween(head, 0);
        printList(head);
        sizeList(head);
    }
}
