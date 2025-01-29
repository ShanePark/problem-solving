package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 9
 * ms
 * Beats
 * 11.82%
 */
public class Q684RedundantConnection {

    @Test
    public void test() {
        assertThat(findRedundantConnection(Ps.intArray("[[3,4],[1,2],[2,4],[3,5],[2,5]]"))).isEqualTo(new int[]{2, 5});
        assertThat(findRedundantConnection(Ps.intArray("[[1,2],[1,3],[2,3]]"))).isEqualTo(new int[]{2, 3});
        assertThat(findRedundantConnection(Ps.intArray("[[1,2],[2,3],[2,4],[4,5],[1,5]]"))).isEqualTo(new int[]{1, 5});
        assertThat(findRedundantConnection(Ps.intArray("[[1,2],[2,3],[3,4],[1,4],[1,5]]"))).isEqualTo(new int[]{1, 4});
    }

    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            graph.put(i + 1, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        List<int[]> foundCycleList = new ArrayList<>();
        List<int[]> cycle = new ArrayList<>();
        boolean[] visited = new boolean[edges.length + 1];
        dfs(graph, 1, 0, foundCycleList, cycle, visited);

        Set<String> cycleSet = new HashSet<>();
        for (int[] ints : foundCycleList) {
            int min = Math.min(ints[0], ints[1]);
            int max = Math.max(ints[0], ints[1]);
            cycleSet.add(min + " " + max);
        }

        for (int i = edges.length - 1; i >= 0; i--) {
            int[] edge = edges[i];
            if (cycleSet.contains(edge[0] + " " + edge[1])) {
                return edge;
            }
        }
        return null;
    }

    private void dfs(Map<Integer, List<Integer>> graph, int cur, int before, List<int[]> foundCycleList, List<int[]> cycle, boolean[] visited) {
        if (!foundCycleList.isEmpty()) {
            return;
        }
        int size = cycle.size();
        cycle.add(new int[]{before, cur});

        if (visited[cur]) {
            while (cycle.get(0)[0] != cur && cycle.get(0)[1] != cur) {
                cycle.remove(0);
            }
            cycle.remove(0);
            foundCycleList.addAll(cycle);
            return;
        }
        visited[cur] = true;

        for (Integer next : graph.get(cur)) {
            if (before == next)
                continue;
            dfs(graph, next, cur, foundCycleList, cycle, visited);
        }
        if (foundCycleList.isEmpty()) {
            visited[cur] = false;
            cycle.remove(size);
        }
    }

}
