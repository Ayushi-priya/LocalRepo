package LocalRepo;

import java.util.ArrayList;
import java.util.Stack;

public class StackB {
    static ArrayList<Integer> list = new ArrayList<>();
    public static boolean isEmpty() {
        if(list.size() == 0) {
            return true;
        }
        return false;
    }

    public static void push(int data) {
        list.add(data);
    }

    public static int pop() {
        if(isEmpty()) {
            return 0;
        }
        int val = list.get(list.size()-1);
        list.remove(list.size()-1);
        return val;
    }

    public static int peek() {
        return list.get(list.size()-1);
    }

    public static void pushAtBottom(StackB s, int data) {
        if(s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    public static void main(String[] args) {
        StackB s = new StackB();
        s.push(0);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.pushAtBottom(s, 5);
        while(!s.isEmpty()) {
            System.out.print(s.pop());
            
        }
    }
}
