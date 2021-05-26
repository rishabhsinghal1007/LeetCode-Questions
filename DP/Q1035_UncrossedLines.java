public class Q1035_UncrossedLines {
    // similar to longest Common Subsequence
    public static int maxUncrossedLines_DP(int[] a, int[] b, int N, int M, int[][] dp) {
        for (int n = 0; n <= N; n++) {
            for (int m = 0; m <= M; m++) {
                if (n == 0 || m == 0) {
                    dp[n][m] = 0;
                    continue;
                }

                if (a[n - 1] == b[m - 1]) {
                    dp[n][m] = dp[n - 1][m - 1] + 1;
                } else {
                    dp[n][m] = Math.max(dp[n - 1][m], dp[n][m - 1]);
                }
            }
        }
        return dp[N][M];
    }

    public static int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];
        return maxUncrossedLines_DP(nums1, nums2, n, m, dp);
    }

    public static void main(String[] args) {
        int[] a = { 2, 5, 1, 2, 5 };
        int[] b = { 10, 5, 2, 1, 5, 2 };
        System.out.println(maxUncrossedLines(a, b));
    }
}
