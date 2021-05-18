import java.io.*;
import java.util.*;

public class Q40_CombinationSum2 {

    public static int combinationSum2(int[] arr, int tar, int idx, List<Integer> smallAns, List<List<Integer>> res) {
        if (tar == 0) {
            List<Integer> base = new ArrayList<>(smallAns);
            res.add(base);
            return 1;
        }

        int count = 0;
        boolean[] vis = new boolean[51]; // bcz of constraints
        for (int i = idx; i < arr.length; i++) {
            if (!vis[arr[i]] && tar - arr[i] >= 0) {
                vis[arr[i]] = true;
                smallAns.add(arr[i]);
                count += combinationSum2(arr, tar - arr[i], i + 1, smallAns, res);
                smallAns.remove(smallAns.size() - 1);
            }
        }
        return count;
    }

    // 2nd Method ======================================================

    public static int combinationSum2_02(int[] arr, int tar, int idx, List<Integer> smallAns, List<List<Integer>> res) {
        if (tar == 0) {
            List<Integer> base = new ArrayList<>(smallAns);
            res.add(base);
            return 1;
        }

        int count = 0;
        int prev = -1; // bcz of constraints
        for (int i = idx; i < arr.length; i++) {
            if (prev != arr[i] && tar - arr[i] >= 0) {
                smallAns.add(arr[i]);
                count += combinationSum2_02(arr, tar - arr[i], i + 1, smallAns, res);
                smallAns.remove(smallAns.size() - 1);
            }
            if (tar - arr[i] < 0)
                break;

            prev = arr[i];
        }
        return count;
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> smallAns = new ArrayList<>();
        Arrays.sort(candidates);
        // combinationSum2(candidates, target, 0, smallAns, res);
        combinationSum2_02(candidates, target, 0, smallAns, res);
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 1, 2, 7, 6, 1, 5 };
        int target = 8;
        System.out.println(combinationSum(arr, target));
    }
}
