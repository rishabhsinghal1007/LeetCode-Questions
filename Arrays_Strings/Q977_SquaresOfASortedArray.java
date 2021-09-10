class Solution {

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int i = 0, j = n - 1;
        int[] ans = new int[n];

        for (int k = ans.length - 1; k >= 0; k--) {
            int val1 = nums[i] * nums[i];
            int val2 = nums[j] * nums[j];

            if (val1 > val2) {
                ans[k] = val1;
                i++;
            } else {
                ans[k] = val2;
                j--;
            }
        }
        
        return ans;
    }
}