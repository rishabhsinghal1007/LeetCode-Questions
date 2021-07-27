public class Q839_DSU_SimilarStringGroups {

    int[] par;

    public int findPar(int u) {
        if (par[u] == u) {
            return u;
        }

        return par[u] = findPar(par[u]);
    }

    public boolean isSimilar(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i) && ++count > 2) {
                return false;
            }
        }

        return true;
    }

    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        int group = n;

        par = new int[n];

        for (int i = 0; i < n; i++) {
            par[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    int p1 = findPar(i);
                    int p2 = findPar(j);

                    if (p1 != p2) {
                        par[p1] = p2;
                        group--;
                    }

                }
            }
        }
        return group;
    }
}
