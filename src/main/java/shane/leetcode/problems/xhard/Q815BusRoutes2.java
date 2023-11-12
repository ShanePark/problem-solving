package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE 44 / 49 testcases passed
 */
public class Q815BusRoutes2 {

    @Test
    public void test() {
        assertThat(numBusesToDestination(Ps.intArray("[[1,2,7],[3,6,7]]"), 1, 6)).isEqualTo(2);
        assertThat(numBusesToDestination(Ps.intArray("[[7,12],[4,5,15],[6],[15,19],[9,12,13]]"), 15, 12)).isEqualTo(-1);
    }

    /**
     * 398 ms
     */
    @Test
    public void tle() {
        int[][] routes = new int[500][100000];
        assertThat(numBusesToDestination(routes, 0, 90000)).isEqualTo(-1);
    }

    /**
     * forever
     */
    @Test
    public void tle2() {
        int[][] routes = new int[500][100000];
        for (int i = 0; i < 500; i++) {
            routes[i] = new int[100000];
            for (int j = 0; j < 10000; j++) {
                routes[i][j] = j;
            }
        }
        assertThat(numBusesToDestination(routes, 0, 90000)).isEqualTo(-1);
    }

    public int numBusesToDestination(int[][] routes, int source, int target) {
        List<Set<Integer>> routeList = new ArrayList<>();
        for (int[] route : routes) {
            Set<Integer> set = new HashSet<>();
            for (int r : route) {
                set.add(r);
            }
            routeList.add(set);
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        int distance = 0;
        visited.add(source);
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                Integer poll = q.poll();
                if (poll == target)
                    return distance;
                for (Set<Integer> route : routeList) {
                    if (route.contains(poll)) {
                        for (Integer next : route) {
                            if (visited.add(next)) {
                                q.offer(next);
                            }
                        }
                    }
                }
            }
            distance++;
        }
        return -1;
    }

}
