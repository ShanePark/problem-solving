package shane.programmers.lv3;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class 합승택시요금 {

    @Test
    public void test() {
        assertThat(solution(6, 4, 6, 2,
                Ps.intArray("[[4, 1, 10], [3, 5, 24], [5, 6, 2], [3, 1, 41], [5, 1, 24], [4, 6, 50], [2, 4, 66], [2, 3, 22], [1, 6, 25]]")))
                .isEqualTo(82);

    }

    public int solution(int n, int s, int a, int b, int[][] fares) {
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
        return min(s, a, b, map, visited, 0);
    }

    private int min(int current, int a, int b, Map<Integer, Map<Integer, Integer>> map, boolean[] visited, int distance) {
        int min = Integer.MAX_VALUE;

        // separate here
        min = (int) Math.min(min, distance + dfs(current, a, map, visited, 0) + dfs(current, b, map, visited, 0));

        // move together
        Map<Integer, Integer> paths = map.get(current);
        for (Integer key : paths.keySet()) {
            if (!visited[key]) {
                visited[key] = true;
                min = Math.min(min, min(key, a, b, map, visited, distance + paths.get(key)));
                visited[key] = false;
            }
        }

        return min;
    }

    private long dfs(int current, int destination, Map<Integer, Map<Integer, Integer>> map, boolean[] visited, int distance) {
        if (current == destination) {
            return distance;
        }

        Map<Integer, Integer> paths = map.get(current);

        int min = Integer.MAX_VALUE;
        for (Integer key : paths.keySet()) {
            if (!visited[key]) {
                visited[key] = true;
                min = (int) Math.min(min, dfs(key, destination, map, visited, distance + paths.get(key)));
                visited[key] = false;
            }
        }
        return min;
    }

}
