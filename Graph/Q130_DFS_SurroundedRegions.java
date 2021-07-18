class Solution {
    public void surrounded_dfs(char[][] board, int i, int j, int[][] dir) {
        board[i][j] = '$';
        int n = board.length, m = board[0].length;
        for (int d = 0; d < dir.length; d++) {
            int r = i + dir[d][0];
            int c = j + dir[d][1];

            if (r >= 0 && c >= 0 && r < n && c < m && board[r][c] == 'O') {
                surrounded_dfs(board, r, c, dir);
            }
        }

    }

    public void solve(char[][] board) {
        int n = board.length, m = board[0].length;
        int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 || j == 0 || i == n - 1 || j == m - 1) && board[i][j] == 'O') {
                    surrounded_dfs(board, i, j, dir);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == '$')
                    board[i][j] = 'O';
                else
                    board[i][j] = 'X';
            }
        }
    }
}