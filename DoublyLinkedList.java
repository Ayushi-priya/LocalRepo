package LocalRepo;
public class DoublyLinkedList {
    static class Node {
        int data;
        Node next;
        Node prev;
        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node addFirst(Node head, int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return head;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        return head;
    }

    public static Node addLast(Node head, int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
        }
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
        return head;
    }

    public static Node addN(Node head, int data, int n) {
        Node newNode = new Node(data);
        if(head == null) {
            addFirst(head, data);
            return head;
        }
        Node temp = head;
        int i = 0;
        while(i != n-1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        newNode.prev = temp;
        return head;
    }

    public static Node removeFirst(Node head) {
        if(head == null) {
            System.out.println("Nothing to delete");
            return head;
        }
        head = head.next;
        head.prev = null;
        return head;
    }

    public static Node removeLast(Node head) {
        if(head == null) {
            System.out.println("Nothing to delete");
            return head;
        }
        Node prev,temp = head;
        prev=head;
        while(temp.next != null) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        temp.prev = null;
        return head;
    }

    public static Node removeN(Node head, int pos) {
        if(head == null) {
            System.out.println("Nothing to delete");
            return head;
        }
        Node prev, temp;
        temp = prev = head;
        int i = 0;
        while(i != pos) {
            prev=temp;
            temp = temp.next;
            i++;
        }
        prev.next = temp.next;
        temp.next.prev = temp.prev;
        temp.prev = null;
        temp.next = null;
        return head;
    }

    public static Node reverseList(Node head) {
        if(head == null) {
            System.out.println("Nothing to print");
            return head;
        }
        Node curr, prev, next;
        curr = head;
        prev = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void printList(Node head) {
        if(head == null) {
            System.out.println("Nothing to print");
            return;
        }
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    public static void main(String[] args) {
        Node head = addFirst(null, 5);
        head = addFirst(head, 4);
        head = addFirst(head, 3);
        // head = addFirst(head, 2);
        head = addFirst(head, 1);
        head = addFirst(head, 0);
        head = addLast(head, 6);
        head = addN(head, 2, 2);
        printList(head);
        head = removeFirst(head);
        printList(head);
        head = removeLast(head);
        printList(head);
        head = removeN(head, 2);
        printList(head);
        head = reverseList(head);
        printList(head);
    }
}