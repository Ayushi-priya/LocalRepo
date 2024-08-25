package LocalRepo.GreedyAlgorithm;
import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int value[] = {60, 100, 120};
        int weight[] = {10, 20, 30};
        int w = 50;

        double ratio[][] = new double[value.length][2];
        for (int i = 0; i < ratio.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = value[i]/weight[i];
        }

        Arrays.sort(ratio, Comparator.comparingDouble(o->o[1]));
        int ans=0;
        int capacity = w;
        for (int i = ratio.length-1; i >= 0; i--) {
            int idx = (int)ratio[i][0];
            if(capacity >= weight[idx]) {
                capacity -= weight[idx];
                ans += value[idx];
            } else if(capacity != 0) {
                ans += capacity * value[idx] / weight[idx];
                capacity = 0;
            }
        }
        System.out.println(ans);
    }
}


