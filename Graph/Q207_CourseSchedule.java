import java.util.ArrayList;
import java.util.LinkedList;

public class Q207_CourseSchedule {

    public boolean canFinish(int N, int[][] arr) {
        ArrayList<Integer>[] graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] a : arr) {
            graph[a[0]].add(a[1]);
        }

        LinkedList<Integer> que = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int[] indegree = new int[N];

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
            ans.add(rvtx);

            for (Integer v : graph[rvtx]) {
                if (--indegree[v] == 0) {
                    que.addLast(v);
                }
            }
        }

        return ans.size() == N;
    }
}
