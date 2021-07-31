import java.util.ArrayList;
import java.util.List;

public class Q1192_AP_criticalConnections {
    int time = 0;
    int[] low, disc;
    boolean[] vis;

    public void dfs(ArrayList<Integer>[] graph, int src, int par, List<List<Integer>> ans) {
        low[src] = disc[src] = time++;
        vis[src] = true;
        for (Integer v : graph[src]) {
            if (!vis[v]) {
                dfs(graph, v, src, ans);
                if (disc[src] < low[v]) {
                    List<Integer> edge = new ArrayList<>();
                    edge.add(src);
                    edge.add(v);
                    ans.add(edge);
                }

                low[src] = Math.min(low[src], low[v]);

            } else if (v != par) {
                low[src] = Math.min(low[src], disc[v]);
            }
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        low = new int[n];
        disc = new int[n];
        vis = new boolean[n];

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
        for (List<Integer> a : connections) {
            graph[a.get(0)].add(a.get(1));
            graph[a.get(1)].add(a.get(0));
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(graph, i, -1, ans);
            }
        }
        return ans;
    }

}
