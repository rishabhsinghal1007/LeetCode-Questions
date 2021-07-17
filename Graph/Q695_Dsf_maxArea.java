class Solution {

    public int dfs_AreaIsland(int[][] grid, int[][] dir, int i, int j) {
        grid[i][j] = 0;
        int n = grid.length, m = grid[0].length;
        int size = 0;

        for (int d = 0; d < 4; d++) {
            int r = i + dir[d][0];
            int c = j + dir[d][1];

            if (r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == 1)
                size += dfs_AreaIsland(grid, dir, r, c);
        }
        return size + 1;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        int maxSize = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    int s = dfs_AreaIsland(grid, dir, i, j);
                    maxSize = Math.max(maxSize, s);
                }
            }
        }
        return maxSize;
    }

}