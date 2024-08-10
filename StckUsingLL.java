package LocalRepo;

public class StckUsingLL {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node push(int data, Node head) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return head;
        }
        newNode.next = head;
        head = newNode;
        return head;
    }

    public static Node pop(Node head) {
        if(head == null) {
            System.out.println("Stack underflow");
            return head;
        }
        int temp = head.data;
        System.out.println("popped data: " + temp);
        head = head.next;
        return head;
    }

    public static void printList(Node head) {
        if(head == null) {
            System.out.println("Stack underflow");
            return; 
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = push(0, null);
        head = push(1, head);
        head = push(2, head);
        head = push(3, head);
        head = push(4, head);
        head = push(5, head);
        head = push(6, head);
        printList(head);
        head = pop(head);
        head = pop(head);
        head = pop(head);
        head = pop(head);
        head = pop(head);
        head = pop(head);
        head = pop(head);
        head = pop(head);
        printList(head);
    }
}
