public class Q746_MinCostClimbStairs {

    public static int minCostClimbingStairs(int[] cost, int n, int[] dp) {
        if (n <= 1) {
            return dp[n] = cost[n];
        }
        if (dp[n] != 0)
            return dp[n];

        int minCostOfOneStep = minCostClimbingStairs(cost, n - 1, dp);
        int minCostOfTwoStep = minCostClimbingStairs(cost, n - 2, dp);

        int ans = Math.min(minCostOfOneStep, minCostOfTwoStep) + (n != cost.length ? cost[n] : 0);

        return dp[n] = ans;
    }

    public static int minCostClimbingStairs_DP(int[] cost, int N, int[] dp) {
        for (int n = 0; n <= N; n++) {
            if (n <= 1) {
                dp[n] = cost[n];
                continue;
            }

            int minCostOfOneStep = dp[n - 1]; // minCostClimbingStairs(cost, n - 1, dp);
            int minCostOfTwoStep = dp[n - 2]; // minCostClimbingStairs(cost, n - 2, dp);

            int ans = Math.min(minCostOfOneStep, minCostOfTwoStep) + (n != cost.length ? cost[n] : 0);

            dp[n] = ans;
        }
        return dp[N];
    }

    public static int minCostClimbingStairs_Opti(int[] cost, int N) {
        int a = cost[0], b = cost[1];
        for (int i = 2; i <= N; i++) {
            int minVal = Math.min(a, b) + (i != cost.length ? cost[i] : 0);
            a = b;
            b = minVal;
        }
        return b;
    }

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        // int ans = minCostClimbingStairs(cost, n, dp);
        // int ans = minCostClimbingStairs_DP(cost, n, dp);
        int ans = minCostClimbingStairs_Opti(cost, n);
        return ans;
    }

    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.print(minCostClimbingStairs(cost));
    }
}