package LocalRepo;

import java.util.Stack;

public class StackReverseString {
    public static void reverseString(String str) {
        Stack<Character> s = new Stack<>();
        int i = 0;
        while(i < str.length()) {
            s.push(str.charAt(i));
            i++;
        }
        String reverse = "";
        while(!s.isEmpty()) {
            reverse += s.pop();
        }
        System.out.println(reverse);
    }
    public static void main(String[] args) {
        String s = "Hello Jess";
        reverseString(s);
    }
}
