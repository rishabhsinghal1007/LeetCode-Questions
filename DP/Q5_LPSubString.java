public class Q5_LPSubString {
    
    public static String longestPalindrome(String str) {
        int n = str.length();
        int[][] dp = new int[n][n];

        int maxLen = 0;
        int count = 0;
        int sp = 0, ep = 0;

        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (gap == 0)
                    dp[i][j] = 1;
                else if (gap == 1)
                    dp[i][j] = str.charAt(i) == str.charAt(j) ? 2 : 0;
                else if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1] > 0)
                    dp[i][j] = dp[i + 1][j - 1] + 2;

                if (dp[i][j] > maxLen) {
                    maxLen = dp[i][j];
                    sp = i;
                    ep = j;
                }

                if (dp[i][j] != 0)
                    count++;
            }
        }
        return str.substring(sp, ep + 1);
    }

    public static void main(String[] args) {
        String str = "geegfgeek";
        System.out.println(longestPalindrome(str));
    }
}