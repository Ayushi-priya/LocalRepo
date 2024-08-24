package LocalRepo.Queue;

import java.util.*;
public class InterleaveTwoHalfOfQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        System.out.println(q);

        Queue<Integer> firstHalf = new LinkedList<>();
        int size = q.size()/2;
        for (int i = 0; i < size; i++) {
            firstHalf.add(q.remove());
        }

        while(!firstHalf.isEmpty()) {
            q.add(q.remove());
            q.add(firstHalf.remove());
        }

        System.out.println(q);
    }
}
