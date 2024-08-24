package LocalRepo.Queue;
import java.util.*;

public class QueueUsingTwoStack {
    public static void stackSwap(Stack<Integer> first, Stack<Integer> second) {
        while (!first.isEmpty()) {
            second.push(first.pop());
        }
    }

    public static void queueUsingTwoStack(Stack<Integer> s1, Stack<Integer> s2, int data) {
        stackSwap(s1, s2);
        s1.push(data);
        stackSwap(s2, s1);
    }

    public static void print(Stack<Integer> s1) {
        // for (int i = 0; i < s1.size(); i++) {
        //     System.out.print(s1.get(i)+" ");
        // }
        // System.out.println();
        while (!s1.isEmpty()) {
            System.out.print((s1.pop())+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        s1.push(1);
        queueUsingTwoStack(s1, s2, 2);
        queueUsingTwoStack(s1, s2, 3);
        queueUsingTwoStack(s1, s2, 4);
        print(s1);
    }
}
