import java.util.LinkedList;

class Solution {
    public int orangesRotting(int[][] grid) {

        int freshOrange = 0, time = 0;
        int n = grid.length, m = grid[0].length;
        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        LinkedList<Integer> que = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    freshOrange++;
                } else if (grid[i][j] == 2) {
                    que.addLast(i * m + j);
                    grid[i][j] = 2;
                }
            }
        }

        if (freshOrange == 0)
            return 0;

        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                int rottenOrangeIDX = que.removeFirst();
                int sr = rottenOrangeIDX / m;
                int sc = rottenOrangeIDX % m;

                for (int d = 0; d < 4; d++) {
                    int r = sr + dir[d][0];
                    int c = sc + dir[d][1];

                    if (r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == 1) {
                        if (--freshOrange == 0) {
                            return time + 1;
                        }
                        grid[r][c] = 2;
                        que.addLast(r * m + c);
                    }
                }
            }
            time++;
        }
        return -1;
    }
}