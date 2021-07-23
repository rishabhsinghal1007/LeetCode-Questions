import java.util.ArrayList;
import java.util.LinkedList;

public class Q210_CourseSchedule_2 {
    public int[] findOrder(int N, int[][] arr) {

        ArrayList<Integer>[] graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] a : arr) {
            graph[a[1]].add(a[0]);
        }

        LinkedList<Integer> que = new LinkedList<>();
        int[] indegree = new int[N];
        int[] ans = new int[N];
        int idx = 0;

        for (int i = 0; i < N; i++) {
            for (Integer v : graph[i]) {
                indegree[v]++;
            }
        }

        for (int i = 0; i < N; i++) {
            if (indegree[i] == 0) {
                que.addLast(i);
            }
        }

        while (que.size() != 0) {
            int rvtx = que.removeFirst();
            ans[idx++] = rvtx;

            for (Integer v : graph[rvtx]) {
                if (--indegree[v] == 0) {
                    que.addLast(v);
                }
            }
        }

        if (idx != N) {
            ans = new int[0];
        }

        return ans;
    }
}
