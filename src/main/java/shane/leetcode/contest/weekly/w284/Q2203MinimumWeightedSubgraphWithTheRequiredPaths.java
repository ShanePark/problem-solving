package shane.leetcode.contest.weekly.w284;

import io.github.shanepark.Ps;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * FAILED
 */
public class Q2203MinimumWeightedSubgraphWithTheRequiredPaths {

    @Test
    void test() {
        Assertions.assertThat(minimumWeight(6, Ps.intArray("[[0,2,2],[0,5,6],[1,0,3],[1,4,5],[2,1,1],[2,3,3],[2,3,4],[3,4,2],[4,5,1]]"), 0, 1, 5)).isEqualTo(9);
        Assertions.assertThat(minimumWeight(6, Ps.intArray("[[0,1,1],[2,1,1]]"), 0, 1, 2)).isEqualTo(-1);
        Assertions.assertThat(minimumWeight(8, Ps.intArray("[[4,7,24],[1,3,30],[4,0,31],[1,2,31],[1,5,18],[1,6,19],[4,6,25],[5,6,32],[0,6,50]]"), 4, 1, 6)).isEqualTo(44);
        Assertions.assertThat(minimumWeight(5, Ps.intArray("[[0,2,1],[0,3,1],[2,4,1],[3,4,1],[1,2,1],[1,3,10]]"), 0, 1, 4)).isEqualTo(3);
    }

    Map<Integer, List<Route>> map = new HashMap<>();

    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            Route route = new Route(edge);
            map.get(edge[0]).add(route);
        }
        long d1 = distance(src1, src2);
        long d2 = distance(src2, dest);
        long d3;

        if (distance(src1, dest) >= 0 && distance(src2, dest) >= 0) {
            d3 = distance(src1, dest) + distance(src2, dest);
            System.out.println("distance(src1, dest) = " + distance(src1, dest));
            System.out.println("distance(src2, dest) = " + distance(src2, dest));
        } else {
            d3 = -1;
        }

        long d1d2 = (d1 == -1 || d2 == -1) ? -1 : d1 + d2;

        System.out.println("d1d2 = " + d1d2);
        System.out.println("d3 = " + d3);

        if (d1d2 <= 0 && d3 <= 0)
            return -1;

        if (d1d2 <= 0) {
            return d3;
        } else if (d3 <= 0) {
            return d1d2;
        } else {
            return Math.min(d1d2, d3);
        }

    }

    private long distance(int from, int to) {
        return dfs(from, to, from, 0);
    }

    private long dfs(int from, int to, int cur, int distance) {
        List<Route> routes = map.get(cur);
        long weight = Long.MAX_VALUE;
        boolean flag = false;
        for (Route route : routes) {
            if (route.to == from) {
                continue;
            } else if (route.to == to) {
                flag = true;
                weight = Math.min(route.distance, weight);
            } else {
                long dfs = dfs(from, to, route.to, distance + route.distance);
                if (dfs != -1) {
                    weight = Math.min(weight, dfs);
                    flag = true;
                }
            }
        }
        if (!flag)
            return -1;
        return weight + distance;
    }

    class Route {
        int from;
        int to;
        int distance;

        public Route(int[] edge) {
            from = edge[0];
            to = edge[1];
            distance = edge[2];
        }
    }

}
