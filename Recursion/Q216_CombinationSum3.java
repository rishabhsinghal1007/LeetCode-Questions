import java.util.*;

public class Q216_CombinationSum3 {

    public static int combinationSum3(int tar, int k, int idx, List<Integer> smallAns, List<List<Integer>> res) {
        if (k == 0 || tar == 0) {
            if (tar == 0 && k == 0) {
                List<Integer> base = new ArrayList<>(smallAns);
                res.add(base);
                return 1;
            }
            return 0;
        }

        int count = 0;
        for (int i = idx; i <= 9; i++) {
            if (tar - i >= 0) {
                smallAns.add(i);
                count += combinationSum3(tar - i, k - 1, i + 1, smallAns, res);
                smallAns.remove(smallAns.size() - 1);
            } else
                break;
        }
        return count;
    }

    public static List<List<Integer>> combinationSum3(int k, int tar) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> smallAns = new ArrayList<>();

        combinationSum3(tar, k, 1, smallAns, res);
        return res;
    }

    public static void main(String[] args) {
        int k = 3;
        int tar = 7;
        System.out.println(combinationSum3(k, tar));
    }
}
