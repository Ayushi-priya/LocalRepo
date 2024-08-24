package LocalRepo.Queue;

public class QueueUsingLL {
    static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node enqueue(int data, Node head) {
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

    public static Node dequeue(Node head) {
        if(head == null) {
            System.out.println("Nothing to delete");
            return null;
        }
        System.out.println("deleted: "+head.data);
        head = head.next;
        return head;
    }

    public static void print(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head = enqueue(2, head);
        head = enqueue(3, head);
        print(head);
        head = dequeue(head);
        head = dequeue(head);
        head = dequeue(head);
        head = dequeue(head);
        print(head);
    }
}
