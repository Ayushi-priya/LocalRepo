package LocalRepo;

import java.util.Stack;

public class NextGreaterEle {


    public static void nextGreaterElement(int arr[]) {
        Stack<Integer> s = new Stack<>();
        int nextGreater[] = new int[arr.length]; 
        for (int i = arr.length-1; i >= 0; i--) {
            while(!s.isEmpty() && arr[i] > s.peek()) {
                s.pop();
            }
            if(s.isEmpty()) {
                nextGreater[i] = -1;
            }
            else if(arr[i] < s.peek()){
                nextGreater[i] = s.peek();
            }
            s.push(arr[i]);
        }

        for (int i = 0; i < nextGreater.length; i++) {
            System.out.print(nextGreater[i] + " ");
        }
    }

    public static void stockSpan(int stocks[], int span[]) {
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);

        for (int i = 0; i < span.length; i++) {
            while(!s.isEmpty() && stocks[i] >= stocks[s.peek()]) {
                s.pop();
            }
            if(s.isEmpty()) {
                span[i] = i+1;
            } else {
                span[i] = i - s.peek();
            }
            s.push(i);
        }

        System.out.println();
        for (int i = 0; i < span.length; i++) {
            System.out.print(span[i] + " ");
        }
    }

    // public static void stockSpan(int stocks[], int span[]) {
    //     Stack<Integer> s = new Stack<>();
    //     span[0] = 1;
    //     s.push(0);
        
    //     for (int i = 1; i < stocks.length; i++) {
    //         int currPrice = stocks[i];
    //         while (!s.isEmpty() && currPrice >= stocks[s.peek()]) {
    //             s.pop();
    //         }
    //         if(s.isEmpty()) {
    //             span[i] = i+1;
    //         } else {
    //             int prevHigh = s.peek();
    //             span[i] = i - prevHigh;
    //         }
    //         s.push(i);
    //     }

    //     System.out.println();
    //     for (int i = 0; i < span.length; i++) {
    //         System.out.print(span[i] + " ");
    //     }
    // }

    public static void main(String[] args) {
        int arr[] = {6, 8, 0, 1 ,3};
        nextGreaterElement(arr);
        int stocks[] = {100, 80, 60, 70, 60, 85, 100};
        stockSpan(stocks, new int[stocks.length]);
    }
}
