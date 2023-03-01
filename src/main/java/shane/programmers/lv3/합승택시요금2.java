package shane.programmers.lv3;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
@SuppressWarnings("ALL")
public class 합승택시요금2 {

    @Test
    public void test() {
        assertThat(solution(7, 3, 4, 1,
                Ps.intArray("[[5, 7, 9], [4, 6, 4], [3, 6, 1], [3, 2, 3], [2, 1, 6]]")))
                .isEqualTo(14);
        assertThat(solution(6, 4, 6, 2,
                Ps.intArray("[[4, 1, 10], [3, 5, 24], [5, 6, 2], [3, 1, 41], [5, 1, 24], [4, 6, 50], [2, 4, 66], [2, 3, 22], [1, 6, 25]]")))
                .isEqualTo(82);

    }

    int[][] memo;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        memo = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    memo[i][j] = 0;
                } else {
                    memo[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new HashMap<>());
        }

        for (int[] fare : fares) {
            Map<Integer, Integer> map0 = map.get(fare[0]);
            Map<Integer, Integer> map1 = map.get(fare[1]);
            map0.put(fare[1], fare[2]);
            map1.put(fare[0], fare[2]);
        }

        boolean[] visited = new boolean[n + 1];
        visited[s] = true;

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            long together = dijkstra(s, i, map, visited);
            long distance = together + dijkstra(i, a, map, visited) + dijkstra(i, b, map, visited);
            min = (int) Math.min(min, distance);
        }

        return min;
    }

    private long dijkstra(int current, int destination, Map<Integer, Map<Integer, Integer>> map, boolean[] visited) {

        Queue<Status> q = new LinkedList<>();
        q.add(new Status(current, 0, Arrays.copyOf(visited, visited.length)));

        while (!q.isEmpty()) {
            Status status = q.poll();
            int cur = status.cur;
            int curDistance = status.distance;
            boolean[] visit = status.visited;

            if (curDistance > memo[current][cur])
                continue;

            memo[current][cur] = curDistance;
            Map<Integer, Integer> paths = map.get(cur);
            for (Map.Entry<Integer, Integer> entry : paths.entrySet()) {
                Integer key = entry.getKey();
                if (!visit[key]) {
                    visit[key] = true;
                    q.add(new Status(key, curDistance + entry.getValue(), Arrays.copyOf(visited, visited.length)));
                }
            }
        }

        return memo[current][destination];
    }

    class Status {
        int cur;
        int distance;
        boolean[] visited;

        public Status(int cur, int distance, boolean[] visited) {
            this.cur = cur;
            this.distance = distance;
            this.visited = visited;
        }
    }

}
