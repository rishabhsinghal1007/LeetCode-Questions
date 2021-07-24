import java.util.LinkedList;

public class Q329_Khans_LongestIncPath {

    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        LinkedList<Integer> que = new LinkedList<>();
        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        int[][] indegree = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int d = 0; d < 4; d++) {
                    int r = i + dir[d][0];
                    int c = j + dir[d][1];

                    if (r >= 0 && c >= 0 && r < n && c < m && matrix[i][j] > matrix[r][c])
                        indegree[i][j]++;
                }

                if (indegree[i][j] == 0)
                    que.addLast(i * m + j);
            }
        }

        int level = 0;
        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                int rvtx = que.removeFirst();
                int i = rvtx / m, j = rvtx % m;

                for (int d = 0; d < 4; d++) {
                    int r = i + dir[d][0];
                    int c = j + dir[d][1];

                    if (r >= 0 && c >= 0 && r < n && c < m && matrix[i][j] < matrix[r][c] && --indegree[r][c] == 0)
                        que.addLast(r * m + c);
                }
            }
            level++;
        }

        return level;
    }
}
