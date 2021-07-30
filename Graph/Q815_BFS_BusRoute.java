import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Q815_BFS_BusRoute {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }

        int N = routes.length;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>(); // busStand to bus mapping
        for (int bus = 0; bus < routes.length; bus++) {
            for (int busStand : routes[bus]) {
                map.putIfAbsent(busStand, new ArrayList<>());
                map.get(busStand).add(bus);
            }
        }

        HashSet<Integer> busStandVisted = new HashSet<>();
        boolean[] busVisited = new boolean[N];
        int interchange = 0;

        LinkedList<Integer> que = new LinkedList<>();
        que.addLast(source);
        busStandVisted.add(source);

        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                int busStand = que.removeFirst();
                for (int bus : map.get(busStand)) {

                    if (busVisited[bus])
                        continue;

                    for (int upcomingBusStand : routes[bus]) {
                        if (!busStandVisted.contains(upcomingBusStand)) {
                            busStandVisted.add(upcomingBusStand);
                            que.addLast(upcomingBusStand);
                            if (upcomingBusStand == target) {
                                return interchange + 1;
                            }
                        }
                    }

                    busVisited[bus] = true;
                }
            }
            interchange++;
        }

        return -1;
    }

}
