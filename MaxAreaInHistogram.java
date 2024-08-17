package LocalRepo;

import java.util.Stack;

public class MaxAreaInHistogram {
    public static int[] nextSmallestRight(int height[]) {
        int nsr[] = new int[height.length];
        Stack<Integer> s = new Stack<>();
        for (int i = nsr.length-1; i >= 0; i--) {
            while (!s.isEmpty() && height[s.peek()] >= height[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nsr[i] = nsr.length;
            } else {
                nsr[i] = s.peek();
            }
            s.push(i);
        }
        return nsr;
    }

    public static int[] nextSmallestLeft(int heights[]) {
        int nsl[] = new int[heights.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < nsl.length; i++) {
            while (!s.isEmpty() && heights[i] <= heights[s.peek()]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = s.peek();
            }
            s.push(i);
        }
        return nsl;
    }

    public static int greatestArea(int nsr[], int nsl[], int heights[]) {
        int greatest_area = Integer.MIN_VALUE;
        int area;
        for (int i = 0; i < nsl.length; i++) {
            area = heights[i] * (nsr[i] - nsl[i] - 1);
            if(area > greatest_area) {
                greatest_area = area;
            }
        } 
        return greatest_area;
    }
    public static void main(String[] args) {
        int heights[] = {2, 1, 5, 6, 2, 3};
        int nsr[] = nextSmallestRight(heights);
        for (int i = 0; i < nsr.length; i++) {
            System.out.print(nsr[i] + " ");
        } 
        int nsl[] = nextSmallestLeft(heights);
        System.out.println();
        for (int i = 0; i < nsl.length; i++) {
            System.out.print(nsl[i] + " ");
        }
        System.out.println("\nAns: "+greatestArea(nsr, nsl, heights));
    }
}
