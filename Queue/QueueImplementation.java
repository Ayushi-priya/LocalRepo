package LocalRepo.Queue;
public class QueueImplementation {
    static class Queue {
        static int arr[];
        static int size;
        static int rear;
        static int front;

        public Queue(int n){
            this.arr = new int[n];
            this.size = n;
            rear = -1;
            front = -1;
        }

        public static boolean isEmpty() {
            if(rear == -1 || front == size) {
                return true;
            }
            return false;
        }

        public static boolean isFull() {
            if(rear == size-1) {
                return true;
            }
            return false;
        }

        public static void enqueue(int data) {
            if(isFull()) {
                System.out.println("Queue full");
            } else if(isEmpty()){
                front++;
                rear++;
                arr[rear] = data;
            } else {
                rear++;
                arr[rear] = data;
            }
        } 

        public static int dequeue() {
            int data=-1;
            if(isEmpty()) {
                System.err.println("Nothing to delete");
            } else {
                data = arr[front];
                front++;
            }
            return data;
        }

        public static void print() {
            if(!isEmpty()) {
                for (int i = front; i <= rear; i++) {
                    System.out.print(arr[i]+" ");
                }
            } 
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue(4);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.print();
        System.out.println();
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        q.print();
    }
}