import java.util.LinkedList;

public class Q1091_ShortestPathBinaryMatrix {

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return 0;

        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { -1, 1 }, { 1, -1 }, { -1, -1 } };
        int n = grid.length, m = grid[0].length;
        int shortestPath = 1;

        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1) {
            return -1;
        }

        LinkedList<Integer> que = new LinkedList<>();
        que.add(0);

        while (que.size() != 0) {
            int size = que.size();

            while (size-- > 0) {
                int idx = que.removeFirst();
                int sr = idx / m, sc = idx % m;

                if (sr == n - 1 && sc == m - 1) {
                    return shortestPath;
                }

                for (int d = 0; d < 8; d++) {
                    int r = sr + dir[d][0];
                    int c = sc + dir[d][1];

                    if (r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == 0) {
                        grid[r][c] = 1;
                        que.addLast(r * m + c);
                    }
                }
            }
            shortestPath++;
        }

        return -1;
    }

}
