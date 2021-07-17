class Solution {

    // TC : E + V (n*m)
    public void dfs_numIslands(char[][] grid, int[][] dir, int i, int j) {
        grid[i][j] = '2';
        for (int d = 0; d < dir.length; d++) {
            int r = i + dir[d][0];
            int c = j + dir[d][1];
            if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == '1') {
                dfs_numIslands(grid, dir, r, c);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int count = 0;
        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs_numIslands(grid, dir, i, j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '2') {
                    grid[i][j] = '1';
                }
            }
        }

        return count;
    }
}