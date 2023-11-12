package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 550ms Beats 44.04%of users with Java
 * Memory Details 66.16MB Beats 79.14%of users with Java
 */
public class Q815BusRoutes3 {

    @Test
    public void test() {
        assertThat(numBusesToDestination(Ps.intArray("[[1,2,7],[3,6,7]]"), 1, 6)).isEqualTo(2);
        assertThat(numBusesToDestination(Ps.intArray("[[2],[2,8]]"), 8, 2)).isEqualTo(1);
        assertThat(numBusesToDestination(Ps.intArray("[[7,12],[4,5,15],[6],[15,19],[9,12,13]]"), 15, 12)).isEqualTo(-1);
        assertThat(numBusesToDestination(Ps.intArray("[[1,7],[3,5]]"), 5, 5)).isEqualTo(0);
    }

    /**
     * 487 ms
     */
    @Test
    public void tle() {
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
        if (source == target)
            return 0;
        Queue<Route> routeList = new LinkedList<>();
        for (int[] r : routes) {
            routeList.add(new Route(r));
        }

        Set<Integer> cur = new HashSet<>();
        cur.add(source);

        int distance = 1;
        while (!routeList.isEmpty()) {
            int size = routeList.size();
            Set<Integer> curNext = new HashSet<>(cur);
            for (int i = 0; i < size; i++) {
                Route route = routeList.poll();
                if (anyCommon(cur, route.include)) {
                    curNext.addAll(route.include);
                    if (curNext.contains(target))
                        return distance;
                    continue;
                }
                routeList.add(route);
            }
            cur = curNext;
            if (size == routeList.size())
                return -1;
            distance++;
        }

        return -1;
    }

    private boolean anyCommon(Set<Integer> cur, Set<Integer> include) {
        Set<Integer> smaller = cur.size() < include.size() ? cur : include;
        Set<Integer> bigger = cur.size() < include.size() ? include : cur;
        for (Integer i : smaller) {
            if (bigger.contains(i))
                return true;
        }
        return false;
    }

    class Route {
        Set<Integer> include = new HashSet<>();

        public Route(int[] r) {
            for (int i : r) {
                include.add(i);
            }
        }

        public boolean contains(int n) {
            return include.contains(n);
        }
    }

}
