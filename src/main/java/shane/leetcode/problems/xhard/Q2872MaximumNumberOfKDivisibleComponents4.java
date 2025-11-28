package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2872MaximumNumberOfKDivisibleComponents4 {

    @Test
    public void test() {
        assertThat(maxKDivisibleComponents(5, Ps.intArray("[[0,2],[1,2],[1,3],[2,4]]"), new int[]{1, 8, 1, 4, 4}, 6)).isEqualTo(2);
        assertThat(maxKDivisibleComponents(7, Ps.intArray("[[0,1],[0,2],[1,3],[1,4],[2,5],[2,6]]"), new int[]{3, 0, 6, 1, 5, 2, 1}, 3)).isEqualTo(3);
    }

    int count;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        count = 0;
        dfs(0, -1, graph, values, k);
        return count;
    }

    private long dfs(int node, int parent, List<List<Integer>> graph, int[] values, int k) {
        long sum = values[node];
        for (int neighbor : graph.get(node)) {
            if (neighbor != parent) {
                sum += dfs(neighbor, node, graph, values, k);
            }
        }
        if (sum % k == 0) {
            count++;
            return 0;
        }
        return sum;
    }

}
