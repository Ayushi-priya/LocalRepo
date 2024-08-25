package LocalRepo.GreedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

public class ChocolaProblem {
    public static void main(String[] args) {
        Integer verticalCut[] = {2, 1, 3, 1, 4};
        Integer horizontalCut[] = {4, 1, 2};
        Arrays.sort(horizontalCut, Comparator.reverseOrder());
        Arrays.sort(verticalCut, Comparator.reverseOrder());

        int h = 0, v = 0;
        int hp = 1, vp = 1;
        int cost = 0;

        while (h < horizontalCut.length && v < verticalCut.length) {
            if(verticalCut[v] > horizontalCut[h]) {
                cost += verticalCut[v] * hp;
                v++;
                vp++;
            } else {
                cost += horizontalCut[h] * vp;
                hp++;
                h++;
            }
        }

        while(h < horizontalCut.length) {
            cost += horizontalCut[h] * vp;
            h++;
            hp++;
        }
        while(v < verticalCut.length) {
            cost += verticalCut[v] * hp;
            v++;
            vp++;
        }
        System.out.println(cost);
    }
}
