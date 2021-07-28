public class Q684_DSU_reduntantConnection {
    int[] par;

    public int findPar(int u) {
        if (par[u] == u) {
            return u;
        }
        return par[u] = findPar(par[u]);
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        par = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            par[i] = i;
        }

        int[] ans = null;

        for (int[] e : edges) {
            int u = e[0], v = e[1];

            int p1 = findPar(u);
            int p2 = findPar(v);

            if (p1 != p2) {
                par[p1] = p2;
            } else {
                ans = e;
            }
        }

        return ans;
    }
}
