package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE 43 / 49 testcases passed
 */
public class Q815BusRoutes {

    @Test
    public void test() {
        assertThat(numBusesToDestination(Ps.intArray("[[1,2,7],[3,6,7]]"), 1, 6)).isEqualTo(2);
        assertThat(numBusesToDestination(Ps.intArray("[[7,12],[4,5,15],[6],[15,19],[9,12,13]]"), 15, 12)).isEqualTo(-1);
    }

    @Test
    public void tle() {
        int[][] routes = new int[500][100000];
        assertThat(numBusesToDestination(routes, 0, 90000)).isEqualTo(-1);
    }

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target)
            return 0;
        Map<Integer, Set<Integer>> buses = new HashMap<>();
        for (int[] route : routes) {
            for (int busI : route) {
                Set<Integer> busIAdjacent = buses.getOrDefault(busI, new HashSet<>());
                buses.put(busI, busIAdjacent);
                for (int busJ : route) {
                    if (busI == busJ)
                        continue;
                    busIAdjacent.add(busJ);
                }
            }
        }
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        int distance = 1;
        visited.add(source);
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                Integer poll = q.poll();
                for (Integer next : buses.get(poll)) {
                    if (next == target)
                        return distance;
                    if (visited.add(next)) {
                        q.offer(next);
                    }
                }
            }
            distance++;
        }
        return -1;
    }

}
