public class Q1905_DFS_CountSubIslands {
    
    int n, m;
    int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public boolean countSubIslands_DFS(int[][] grid1, int[][] grid2, int i, int j) {
        grid2[i][j] = 0;
        boolean res = true;
        for (int d = 0; d < 4; d++) {
            int r = i + dir[d][0];
            int c = j + dir[d][1];

            if (r >= 0 && c >= 0 && r < n && c < m && grid2[r][c] == 1) {
                res = countSubIslands_DFS(grid1, grid2, r, c) && res;
            }
        }

        return res && grid1[i][j] == 1;
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        n = grid1.length;
        m = grid1[0].length;

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid2[i][j] == 1) {
                    count += countSubIslands_DFS(grid1, grid2, i, j) ? 1 : 0;
                }
            }
        }

        return count;
    }
}
