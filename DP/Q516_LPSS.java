import java.io.*;
import java.util.*;

public class Q516_LPSS {

    public static void print(int[] arr) {
        for (int ele: arr) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void print2D(int[][] arr) {
        for (int[] a: arr) {
            print(a);
        }
        System.out.println();
    }

    // LPSS = LongestPalindromicSubSequence
    public static int LPSS(String str, int i, int j, int[][] dp) {

        if (i >= j) {
            return dp[i][j] = (i == j) ? 1 : 0;
        }
        if (dp[i][j] != -1)
            return dp[i][j];

        if (str.charAt(i) == str.charAt(j))
            return dp[i][j] = LPSS(str, i + 1, j - 1, dp) + 2;
        else
            return dp[i][j] = Math.max(LPSS(str, i + 1, j, dp), LPSS(str, i, j - 1, dp));

    }

    public static int LPSS_DP(String str, int I, int J, int[][] dp) {
        int n = str.length();
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (i >= j) {
                    dp[i][j] = (i == j) ? 1 : 0;
                    continue;
                }

                if (str.charAt(i) == str.charAt(j))
                    dp[i][j] = dp[i + 1][j - 1] + 2; 
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]); 
            }
        }
        return dp[I][J];
    }

    public static void longestPalindromicSubSequence() {
        String str = "geeksfgeek";
        int n = str.length();
        int[][] dp = new int[n][n];

        for (int[] d: dp) {
            Arrays.fill(d, 0);
        }

        System.out.println(LPSS_DP(str, 0, n - 1, dp));
        print2D(dp);
    }

    public static void main(String[] args) {
        longestPalindromicSubSequence();
    }
}