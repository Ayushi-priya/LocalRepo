package LocalRepo.Queue;
import java.util.LinkedList;
import java.util.*;

public class ReverseQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        Stack<Integer> s = new Stack<>();
        System.out.println(q);
        while(!q.isEmpty()) {
            s.push(q.remove());
        }
        System.out.println(s);
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
        System.out.println(q);
    }
}
