package LocalRepo;
public class CircularLinkedList {
    static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node addFirst(Node last, int data) {
        Node newNode = new Node(data);
        if(last == null) {
            last = newNode;
            newNode.next = last;
            return last;
        }
        newNode.next = last.next;
        last.next = newNode;
        return last;
    }

    public static Node addLast(Node last, int data) {
        Node newNode = new Node(data);
        if(last == null) {
            addFirst(last, data);
            return last;
        }
        Node temp = last.next;
        while(temp != last) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        last = newNode;
        return last;
    }

    public static Node addN(Node last, int pos, int data) {
        if(last == null) {
            addFirst(last, data);
            return last;
        }
        Node temp = last.next;
        int i=0;
        while(i != pos-1 && last != temp) {
            temp = temp.next;
            i++;
        } 
        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
        return last;
    }

    public static Node removeFirst(Node last) {
        if(last == null) {
            return null;
        }
        last.next = last.next.next;
        return last;
    }

    public static Node removeLast(Node last) {
        Node temp = last.next;
        while(temp.next != last) {
            temp = temp.next;
        }
        temp.next = last.next;
        last = temp;
        return last;
    }

    public static Node removeN(Node last, int pos) {
        Node temp = last.next;
        int i = 0;
        while(i != pos-1 && last != temp) {
            temp = temp.next;
            i++;
        }
        temp.next = temp.next.next;
        return last;
    }

    // public static Node reverseList(Node last) {
    //     Node prev=null, curr=last.next, next;
    //     while(curr != last) {
    //         next = curr.next;
    //         curr.next = prev;
    //         prev = curr;
    //         curr = next;
    //     }
    //     last = prev;
    //     return last;
    // }

    public static void printList(Node last) {
        Node temp = last.next;
        while(temp != last) {
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println(temp.data+"->Null");
    }

    public static void main(String[] args) {
        Node last = addFirst(null, 1);
        last = addFirst(last, 0);
        last = addLast(last, 3);
        last = addLast(last, 4);
        last = addLast(last, 5);
        last = addN(last, 2, 2);
        printList(last);
        // last = reverseList(last);
        // printList(last);
        last = removeFirst(last);
        printList(last);
        last = removeLast(last);
        printList(last);
        last = removeN(last, 2);
        printList(last);
    }
}