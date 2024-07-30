package LocalRepo;

public class ZigZagLinkedList {
    static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node addLast(Node head, int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return head;
        }

        newNode.next = head;
        head = newNode;
        return head;
    }

    public static void printNode(Node head) {
        if(head == null) {
            System.out.println("Nothing to print");
        }
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    public static Node findMid(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static Node reverseList(Node head) {
        Node prev = null, curr = head, next = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static Node zigZagList(Node head) {
        Node mid = findMid(head);
        Node right = reverseList(mid);
        Node left = head;
        Node nextL, nextR;
        while(right != null && left != null) {
            nextL = left.next;
            nextR = right.next;
            left.next = right;
            right.next = nextL;
            left = nextL;
            right = nextR;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = addLast(null, 0);
        head = addLast(head, 1);
        head = addLast(head, 2);
        head = addLast(head, 3);
        head = addLast(head, 4);
        head = addLast(head, 5);
        head = addLast(head, 6);
        printNode(head);
        head = zigZagList(head);
        printNode(head);
    }
}
