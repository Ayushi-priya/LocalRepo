package LocalRepo;
import java.util.*;

public class Parenthesis {
    public static boolean validParenthesis(String str) {
        Stack<Character> s = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == ')' && s.peek() == '(') {
                s.pop();
            } else if(ch == '}' && s.peek() == '{') {
                s.pop();
            } else if(ch == ']' && s.peek() == '[') {
                s.pop();
            } else {
                s.push(str.charAt(i));
            }
        }
        if(!s.isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean duplicateParenthesis(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == ')') {
                int count = 0;
                while (!s.isEmpty() && s.peek() != '(') {
                    s.pop();
                    count++;
                }
                if (count < 1) {
                    return true;
                } else {
                    s.pop(); 
                }
            } else {
                s.push(ch);
            }
        } 
        return false;
    }

    public static void main(String[] args) {
        String s = "({[]})";
        System.out.println(validParenthesis(s));
        String str = "(a+(b))+(c+d)";
        System.out.println(duplicateParenthesis(str));
    }
}
