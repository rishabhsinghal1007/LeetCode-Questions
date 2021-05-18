import java.io.*;
import java.util.*;

public class Q39_CombinationSum {

    public static int combinationSum(int[] arr, int tar, int idx, List<Integer> smallAns, List<List<Integer>> res) {
        if (tar == 0) {
            List<Integer> base = new ArrayList<>(smallAns);
            res.add(base);
            return 1;
        }

        int count = 0;
        for (int i = idx; i < arr.length; i++) {
            if (tar - arr[i] >= 0) {
                smallAns.add(arr[i]);
                count += combinationSum(arr, tar - arr[i], i, smallAns, res);
                smallAns.remove(smallAns.size() - 1);
            }
        }
        return count;
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> smallAns = new ArrayList<>();

        combinationSum(candidates, target, 0, smallAns, res);
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 5 };
        int target = 8;
        System.out.println(combinationSum(arr, target));
    }
}
