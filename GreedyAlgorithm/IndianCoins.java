package LocalRepo.GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class IndianCoins {
    public static void main(String[] args) {
        int v = 121;
        Integer coins[] = {1, 2, 5, 10, 20, 50, 100, 200, 500, 1000, 2000};
        Arrays.sort(coins, Comparator.reverseOrder());
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < coins.length; i++) {
            while(coins[i] <= v) {
                ans.add(coins[i]);
                v -= coins[i];
            }
        }
        System.out.println(ans);
    }
}
