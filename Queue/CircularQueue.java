package LocalRepo.Queue;

public class CircularQueue {
    static class Queue {
        static int arr[];
        static int size, front, rear;

        public Queue(int n) {
            this.arr = new int[n];
            this.size = n;
            this.front = -1;
            this.rear = -1;
        }

        public static boolean isEmpty() {
            if(rear == -1 && front == -1) {
                System.out.println("Queue Empty");
                return true;
            }
            return false;
        }

        public static boolean isFull() {
            if((rear+1)%size == front) {
                System.out.println("Queue Full");
                return true;
            }
            return false;
        }

        public static void enqueue(int data) {
            if(!isFull()) {
                if(isEmpty()) {
                    front++;
                    rear++;
                    arr[rear] = data;
                } else {
                    // System.out.println("enter");
                    rear = (rear+1)%size;
                    // System.out.println(rear);
                    arr[rear] = data;
                }
            }
        }

        public static void dequeue() {
            if(!isEmpty()) {
                int data = arr[front];
                if(rear == front) {
                    rear = front = -1;
                }
                System.out.println("deleted: "+data);
                arr[front]=-1;
                front=(front+1)%size;
                // System.out.println("pos: "+front);
            }
        }

        public static void print() {
            for (int i = 0; i < size; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.print();
        System.err.println();
        q.dequeue();
        q.dequeue();
        q.enqueue(6);
        q.enqueue(7);
        q.print();
    }
}
