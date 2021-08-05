import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Q743_Dijikstra_NetworkDelayTime {

    public static class Edge {
        int v, w;

        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void addEdge(ArrayList<Edge>[] graph, int u, int v, int w) {
        graph[u].add(new Edge(v, w));
    }

    public static class pair {
        int vtx, wsf;

        pair(int vtx, int wsf) {
            this.vtx = vtx;
            this.wsf = wsf;
        }
    }

    public static int networkDelayTime(int[][] times, int n, int k) {

        ArrayList<Edge>[] graph = new ArrayList[n + 1];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] time : times) {
            int u = time[0], v = time[1], w = time[2];
            graph[u].add(new Edge(v, w));
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, (int) 1e9);

        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> {
            return a.wsf - b.wsf;
        });

        pq.add(new pair(k, 0));
        dist[k] = 0;

        while (pq.size() != 0) {
            pair p = pq.remove();

            if (p.wsf > dist[p.vtx]) {
                continue;
            }

            for (Edge e : graph[p.vtx]) {
                if (p.wsf + e.w < dist[e.v]) {
                    dist[e.v] = p.wsf + e.w;
                    pq.add(new pair(e.v, p.wsf + e.w));
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == (int) 1e9)
                return -1;
            max = Math.max(max, dist[i]);
        }

        return max;
    }

    // 2nd Method
    public int networkDelayTime_2(int[][] times, int n, int k) {
        // {v,w}
        ArrayList<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int[] time : times) {
            int u = time[0], v = time[1], w = time[2];
            graph[u].add(new int[] { v, w });
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, (int) 1e9);

        // {vtx,wsf}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });

        pq.add(new int[] { k, 0 });
        dist[k] = 0;

        while (pq.size() != 0) {
            int[] rp = pq.remove(); // remove pair
            int vtx = rp[0], wsf = rp[1];

            if (wsf > dist[vtx])
                continue;

            for (int[] e : graph[vtx]) {
                int v = e[0], w = e[1];
                if (wsf + w < dist[v]) {
                    dist[v] = wsf + w;
                    pq.add(new int[] { v, wsf + w });
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == (int) 1e9)
                return -1;
            max = Math.max(max, dist[i]);
        }

        return max;
    }
}
