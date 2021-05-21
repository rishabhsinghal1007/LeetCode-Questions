import java.util.*;

public class Q51_Nqueens {
    static boolean[] rows;
    static boolean[] cols;
    static boolean[] diag;
    static boolean[] adiag;
    static List<List<String>> ans = new ArrayList<>();

    public static int nqueen_Combination(boolean[][] boxes, int tnq, int idx) {
        int n = boxes.length, m = boxes[0].length;

        if (tnq == 0) {
            ArrayList<String> smallAns = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < m; j++) {
                    sb.append(boxes[i][j] ? "Q" : ".");
                }
                smallAns.add(sb.toString());
            }

            ans.add(smallAns);
            return 1;
        }

        int count = 0;
        for (int i = idx; i < n * m; i++) {
            int r = i / m;
            int c = i % m;
            if (!rows[r] && !cols[c] && !diag[r + c] && !adiag[r - c + m - 1]) {
                rows[r] = cols[c] = diag[r + c] = adiag[r - c + m - 1] = boxes[r][c] = true;
                count += nqueen_Combination(boxes, tnq - 1, i + 1);
                rows[r] = cols[c] = diag[r + c] = adiag[r - c + m - 1] = boxes[r][c] = false;
            }
        }
        return count;
    }

    public static List<List<String>> solveNQueens(int n) {
        int m = n;
        boolean[][] boxes = new boolean[n][m];
        rows = new boolean[n];
        cols = new boolean[m];
        diag = new boolean[n + m - 1];
        adiag = new boolean[n + m - 1];
        nqueen_Combination(boxes, n, 0);
        return ans;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(solveNQueens(n));
    }
}
