package LocalRepo.Queue;
import java.util.*;
public class StackUsingTwoQueue {
    public static void queueSwap(Queue<Integer> first, Queue<Integer> second) {
        while (!first.isEmpty()) {
            second.add(first.remove());
        }
    }
    public static void stackUsingTwoQueue(Queue<Integer> first, Queue<Integer> second, int data) {
        queueSwap(first, second);
        first.add(data);
        queueSwap(second, first);
    }
    public static void print(Queue<Integer> q1) {
        while (!q1.isEmpty()) {
            System.out.print(q1.remove() + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        q1.add(1);
        stackUsingTwoQueue(q1, q2, 2);
        stackUsingTwoQueue(q1, q2, 3);
        print(q1);
    } 
}
