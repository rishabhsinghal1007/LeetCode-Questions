public class Q959_DSU_RegionBySlashes {
    int[] par;

    public int findPar(int u) {
        return par[u] == u ? u : (par[u] = findPar(par[u]));
    }

    public int regionsBySlashes(String[] grid) {
        if (grid.length == 0)
            return 0;
        int n = grid.length;
        int m = n + 1;
        int region = 1;

        par = new int[m * m];

        for (int i = 0; i < m * m; i++) {
            par[i] = i;
            int r = i / m, c = i % m;

            if (r == 0 || c == 0 || r == m - 1 || c == m - 1) {
                par[i] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            String s = grid[i];
            for (int j = 0; j < s.length(); j++) {
                char ch = s.charAt(j);
                int p1 = 0, p2 = 0;
                if (ch == '/') {
                    p1 = findPar(i * m + j + 1);
                    p2 = findPar((i + 1) * m + j);
                } else if (ch == '\\') {
                    p1 = findPar(i * m + j);
                    p2 = findPar((i + 1) * m + j + 1);
                } else {
                    continue;
                }

                if (p1 != p2) {
                    par[p1] = p2;
                } else {
                    region++;
                }
            }
        }
        return region;
    }

}
