package LocalRepo.GreedyAlgorithm;

import java.util.Arrays;

public class MinAbsoluteDiffPairs {
    public static void main(String[] args) {
        int a[] = {4, 1, 8, 7};
        int b[] = {2, 3, 6, 5};
        Arrays.sort(a);
        Arrays.sort(b);
        int sum=0;
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        for (int i = 0; i < b.length; i++) {
            sum += Math.abs(a[i]-b[i]);
        }
        System.out.println(sum);
    }
}
