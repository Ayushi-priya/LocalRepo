package LocalRepo.GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class JobSequencing {
    public static void main(String[] args) {
        int deadline[] = {4, 1, 1, 1};
        int profit[] = {20, 10, 40, 30};
        int arr[][] = new int[4][3];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = i;
            arr[i][1] = deadline[i];
            arr[i][2] = profit[i];
        }
        Arrays.sort(arr, Comparator.comparingDouble(o->o[2]));
        ArrayList<Integer> ans = new ArrayList<>();
        int prevDeadline = arr[arr.length-1][1];
        ans.add(arr[arr.length-1][0]);
        for (int i = arr.length-2; i >= 0; i--) {
            if(arr[i][1] > prevDeadline) {
                ans.add(arr[i][0]);
            }
        }
        System.out.println(ans);
    }
}
