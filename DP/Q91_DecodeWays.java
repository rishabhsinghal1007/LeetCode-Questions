import java.util.Arrays;

public class Q91_DecodeWays {

    public int numDecodings_memo(String s, int idx, int[] dp) {
        if (idx == s.length()) {
            return dp[idx] = 1;
        }

        if (dp[idx] != -1)
            return dp[idx];

        if (s.charAt(idx) == '0')
            return dp[idx] = 0;

        int count = 0;
        count += numDecodings_memo(s, idx + 1, dp);

        if (idx < s.length() - 1) {

            int num = (s.charAt(idx) - '0') * 10 + (s.charAt(idx + 1) - '0');
            if (num <= 26)
                count += numDecodings_memo(s, idx + 2, dp);
        }
        return dp[idx] = count;
    }

    public int numDecodings_memo2(String s, int n, int[] dp) {
        if (n == 0) {
            return dp[n] = 1;
        }

        if (dp[n - 1] != -1)
            return dp[n];

        int count = 0;
        if (s.charAt(n - 1) > '0')
            count += numDecodings_memo2(s, n - 1, dp);

        if (n > 1) {

            int num = (s.charAt(n - 2) - '0') * 10 + (s.charAt(n - 1) - '0');
            if (num <= 26 && num >= 10)
                count += numDecodings_memo2(s, n - 2, dp);
        }
        return dp[n] = count;
    }

    public int numDecodings_tabu(String s, int IDX, int[] dp) {
        for (int idx = s.length(); idx >= 0; idx--) {
            if (idx == s.length()) {
                dp[idx] = 1;
                continue;
            }

            if (s.charAt(idx) == '0') {
                dp[idx] = 0;
                continue;
            }

            int count = 0;
            count += dp[idx + 1];

            if (idx < s.length() - 1) {

                int num = (s.charAt(idx) - '0') * 10 + (s.charAt(idx + 1) - '0');
                if (num <= 26)
                    count += dp[idx + 2];
            }
            dp[idx] = count;
        }

        return dp[IDX];
    }

    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        // int ans = numDecodings_memo(s, 0, dp);
        int ans = numDecodings_memo2(s, n, dp);
        // int ans = numDecodings_tabu(s, 0, dp);

        return ans;
    }
}