import java.util.*;

public class Q46_Permutation {

    // tel - total no of element
    public static int permute(int[] arr, int tele, List<Integer> smallAns, List<List<Integer>> res) {
        if (tele == 0) {
            List<Integer> base = new ArrayList<>(smallAns);
            res.add(base);
            return 1;
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > -11) {     // as per contraints
                int val = arr[i];
                arr[i] = -11;
                smallAns.add(val);

                count += permute(arr, tele - 1, smallAns, res);
                smallAns.remove(smallAns.size() - 1);
                arr[i] = val;
            }
        }
        return count;
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> smallAns = new ArrayList<>();

        permute(nums, nums.length, smallAns, res);
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        System.out.println(permute(arr));
    }
}
