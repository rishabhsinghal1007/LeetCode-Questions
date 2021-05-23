import java.util.*;

// LCSS : Longest Common SubSequnece
public class Q1143_LCSS {

    public static int LCSS_memo(String s1, String s2, int n, int m, int[][] dp) {
        if (n == 0 || m == 0)
            return dp[n][m] = 0;

        if (dp[n][m] != -1)
            return dp[n][m];

        if (s1.charAt(n - 1) == s2.charAt(m - 1))
            return dp[n][m] = LCSS_memo(s1, s2, n - 1, m - 1, dp) + 1;
        else
            return dp[n][m] = Math.max(LCSS_memo(s1, s2, n - 1, m, dp), LCSS_memo(s1, s2, n, m - 1, dp));
    }

    public static int LCSS_DP(String s1, String s2, int N, int M, int[][] dp) {
        for (int n = 0; n <= N; n++) {
            for (int m = 0; m <= M; m++) {
                if (n == 0 || m == 0) {
                    dp[n][m] = 0;
                    continue;
                }

                if (s1.charAt(n - 1) == s2.charAt(m - 1))
                    dp[n][m] = dp[n - 1][m - 1] + 1;
                else
                    dp[n][m] = Math.max(dp[n - 1][m], dp[n][m - 1]);
            }
        }
        return dp[N][M];
    }

    public static int longestCommonSubsequence(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        
        int[][] dp = new int[n + 1][m + 1];

        for (int[] d : dp)  // only for memo code.
            Arrays.fill(d, -1);  

        // int ans = LCSS_memo(s1, s2, n, m, dp);
        int ans = LCSS_DP(s1, s2, n, m, dp);
        return ans;
    }

    public static void main(String[] args) {
        String s1 = "abcdfg";
        String s2 = "acflmg";
        System.out.println(longestCommonSubsequence(s1, s2));
    }
}