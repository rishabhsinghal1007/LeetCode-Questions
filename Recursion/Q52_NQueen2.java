public class Q52_NQueen2 {
    static boolean[] rows;
    static boolean[] cols;
    static boolean[] diag;
    static boolean[] adiag;

    public static int nqueen_Combination(int n, int m, int tnq, int idx) {
        if (tnq == 0) {
            return 1;
        }

        int count = 0;
        for (int i = idx; i < n * m; i++) {
            int r = i / m;
            int c = i % m;
            if (!rows[r] && !cols[c] && !diag[r + c] && !adiag[r - c + m - 1]) {
                rows[r] = cols[c] = diag[r + c] = adiag[r - c + m - 1] = true;
                count += nqueen_Combination(n, m, tnq - 1, i + 1);
                rows[r] = cols[c] = diag[r + c] = adiag[r - c + m - 1] = false;
            }
        }
        return count;
    }

    public static int totalNQueens(int n) {
        int m = n;
        rows = new boolean[n];
        cols = new boolean[m];
        diag = new boolean[n + m - 1];
        adiag = new boolean[n + m - 1];
        return nqueen_Combination(n, m, n, 0);
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(totalNQueens(n));
    }
}
