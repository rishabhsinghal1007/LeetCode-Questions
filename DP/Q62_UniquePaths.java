public class Q62_UniquePaths {
    public static int mazePath_HDV_DP(int SR, int SC, int er, int ec, int[][] dir, int[][] dp) {
        for (int sr = er; sr >= 0; sr--) {
            for (int sc = ec; sc >= 0; sc--) {
                if (sr == er && sc == ec) {
                    dp[sr][sc] = 1;
                    continue;
                }

                int count = 0;
                for (int d = 0; d < dir.length; d++) {
                    int r = sr + dir[d][0];
                    int c = sc + dir[d][1];

                    if (r >= 0 && c >= 0 && r <= er && c <= ec) {
                        count += dp[r][c];
                    }
                }
                dp[sr][sc] = count;
            }
        }
        return dp[SR][SC];
    }

    public static int uniquePaths(int n, int m) {
        int[][] dp = new int[n][m];
        int[][] dir = { { 1, 0 }, { 0, 1 } };

        return mazePath_HDV_DP(0, 0, n - 1, m - 1, dir, dp);
    }

    public static void main(String[] args) {
        int n = 3, m = 7;
        System.out.println(uniquePaths(n, m));
    }
}
