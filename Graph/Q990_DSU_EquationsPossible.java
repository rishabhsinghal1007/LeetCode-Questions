public class Q990_DSU_EquationsPossible {

    int[] par;

    public int findPar(int u) {
        if (par[u] == u) {
            return u;
        }

        return par[u] = findPar(par[u]);
    }

    public boolean equationsPossible(String[] equations) {

        par = new int[26];

        for (int i = 0; i < 26; i++) {
            par[i] = i;
        }

        for (String s : equations) {
            char ch1 = s.charAt(0), ch2 = s.charAt(1), ch3 = s.charAt(3);

            int p1 = findPar(ch1 - 'a');
            int p2 = findPar(ch3 - 'a');

            if (ch2 == '=' && p1 != p2) {
                par[p1] = p2;
            }
        }

        for (String s : equations) {
            char ch1 = s.charAt(0), ch2 = s.charAt(1), ch3 = s.charAt(3);

            int p1 = findPar(ch1 - 'a');
            int p2 = findPar(ch3 - 'a');

            if (ch2 == '!' && p1 == p2) {
                return false;
            }
        }

        return true;
    }
}
