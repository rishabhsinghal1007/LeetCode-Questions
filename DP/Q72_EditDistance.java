// QUESTION.................
// Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
// You have the following three operations permitted on a word:

// 1. Insert a character
// 2. Delete a character
// 3. Replace a character

// Input: word1 = "horse", word2 = "ros"
// Output: 3
// Explanation: 
// horse -> rorse (replace 'h' with 'r')
// rorse -> rose (remove 'r')
// rose -> ros (remove 'e')

import java.util.Arrays;

public class Q72_EditDistance {

    public static int minDistance(String s1, String s2, int n, int m, int[][] dp) {
        if (n == 0 || m == 0) {
            return dp[n][m] = (n == 0 ? m : n);
        }

        if (dp[n][m] != -1)
            return dp[n][m];

        int insert = minDistance(s1, s2, n, m - 1, dp);
        int replace = minDistance(s1, s2, n - 1, m - 1, dp);
        int delete = minDistance(s1, s2, n - 1, m, dp);

        if (s1.charAt(n - 1) == s2.charAt(m - 1))
            return dp[n][m] = replace;
        else
            return dp[n][m] = Math.min(Math.min(insert, replace), delete) + 1;
    }

    public static int minDistance_DP(String s1, String s2, int N, int M, int[][] dp) {

        for (int n = 0; n <= N; n++) {
            for (int m = 0; m <= M; m++) {
                if (n == 0 || m == 0) {
                    dp[n][m] = (n == 0 ? m : n);
                    continue;
                }

                int insert = dp[n][m - 1];
                int replace = dp[n - 1][m - 1];
                int delete = dp[n - 1][m];

                if (s1.charAt(n - 1) == s2.charAt(m - 1))
                    dp[n][m] = replace;
                else
                    dp[n][m] = Math.min(Math.min(insert, replace), delete) + 1;
            }
        }

        return dp[N][M];
    }

    public static int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int[] d : dp)
            Arrays.fill(d, -1);

        // int ans = minDistance(word1, word2, n, m, dp);
        int ans = minDistance_DP(word1, word2, n, m, dp);
        return ans;
    }

    public static void main(String[] args) {
        String s1 = "intention";
        String s2 = "execution";

        System.out.println(minDistance(s1, s2));
    }
}
