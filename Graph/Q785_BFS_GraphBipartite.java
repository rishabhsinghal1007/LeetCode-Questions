import java.util.LinkedList;
import java.util.Arrays;

public class Q785_BFS_GraphBipartite {

    public boolean isBipartite(int[][] graph, int src, int[] vis) {
        LinkedList<Integer> que = new LinkedList<>();
        que.addLast(src);

        int color = 0;
        boolean isCycle = false, isBipartite = true;

        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                int rvtx = que.removeFirst();

                if (vis[rvtx] != -1) {
                    isCycle = true;
                    if (vis[rvtx] != color) {
                        isBipartite = false;
                        break;
                    }
                    continue;
                }

                vis[rvtx] = color;
                for (int e : graph[rvtx]) {
                    if (vis[e] == -1) {
                        que.addLast(e);
                    }
                }

            }
            color = (color + 1) % 2;
            if (!isBipartite)
                break;

        }
        return isBipartite;
    }

    public boolean isBipartite(int[][] graph) {
        int N = graph.length;
        int[] vis = new int[N];
        Arrays.fill(vis, -1);

        boolean res = true;
        for (int i = 0; i < N; i++) {
            if (vis[i] == -1) {
                res = res && isBipartite(graph, i, vis);
            }
        }
        return res;
    }
}
