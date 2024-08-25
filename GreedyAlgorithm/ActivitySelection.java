package LocalRepo.GreedyAlgorithm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {
    public static void main(String[] args) {
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 6, 7, 9, 9};
        int arr[][] = new int[start.length][3];

        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = i;
            arr[i][1] = start[i];
            arr[i][2] = end[i];
        }

        Arrays.sort(arr, Comparator.comparingInt(o->o[2]));
        ArrayList<Integer> ans = new ArrayList<>();

        int prevEnd = arr[0][0];
        ans.add(0);
        for (int i = 1; i < arr.length; i++) {
            if(arr[i][1] >= prevEnd) {
                ans.add(arr[i][0]);
                prevEnd = arr[i][2];
            }
        } 
        System.out.println(ans);
    }
}



// package LocalRepo.GreedyAlgorithm;
// import java.util.ArrayList;

// public class ActivitySelection {
//     public static void main(String[] args) {
//         int start[] = {1, 3, 0, 5, 8, 5};
//         int end[] = {2, 4, 6, 7, 9, 9};
//         ArrayList<Integer> ans = new ArrayList<>();
//         int prevEnd = end[0];
//         ans.add(0);
//         for(int i = 1; i < end.length; i++) {
//             if(start[i] >= prevEnd) {
//                 ans.add(i);
//                 prevEnd = end[i];
//             }
//         }

//         System.out.println(ans);
//     }
// }
