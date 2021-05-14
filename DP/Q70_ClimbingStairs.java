public class Q70_ClimbingStairs {

    public static int climbStairs_memo(int n, int[] dp) {
        if (n <= 1) {
            return dp[n] = 1;
        }

        if (dp[n] != 0)
            return dp[n];

        int steps = climbStairs_memo(n - 1, dp) + climbStairs_memo(n - 2, dp);
        return dp[n] = steps;
    }

    public static int climbStairs_DP(int N, int[] dp) {
        for (int n = 0; n <= N; n++) {
            if (n <= 1) {
                dp[n] = 1;
                continue;
            }

            int steps = dp[n - 1] + dp[n - 2]; // climbStairs_memo(n-1,dp) + climbStairs_memo(n-2,dp);
            dp[n] = steps;
        }

        return dp[N];
    }

    public static int climbStairs_Opti(int n) {
        int a = 1, b = 1;
        for (int i = 0; i < n; i++) {
            int sum = a + b;
            a = b;
            b = sum;
        }

        return a;
    }

    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        // int ans = climbStairs_memo(n,dp);
        // int ans = climbStairs_DP(n,dp);
        int ans = climbStairs_Opti(n);

        return ans;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.print(climbStairs(n));
    }
}