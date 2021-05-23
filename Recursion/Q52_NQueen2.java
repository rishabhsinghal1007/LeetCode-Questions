public class Q52_NQueen2 {

    static boolean[] rows;
    static boolean[] cols;
    static boolean[] diag;
    static boolean[] adiag;

    public static int nqueen_Combination(int floor, int tnq, int m) {
        if (tnq == 0) {
            return 1;
        }
        int count = 0;
        for (int room = 0; room < m; room++) {
            int r = floor;
            int c = room;
            if (!rows[r] && !cols[c] && !diag[r + c] && !adiag[r - c + m - 1]) {
                rows[r] = cols[c] = diag[r + c] = adiag[r - c + m - 1] = true;
                count += nqueen_Combination(floor + 1, tnq - 1, m);
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
        return nqueen_Combination(0, n, n);
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(totalNQueens(n));
    }
}
