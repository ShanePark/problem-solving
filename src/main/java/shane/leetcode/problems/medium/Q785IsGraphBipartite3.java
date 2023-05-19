package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100%
 * Memory 44.1 MB Beats 6.63%
 */
public class Q785IsGraphBipartite3 {

    @Test
    public void test() {
        assertThat(isBipartite(Ps.intArray("[[1,2,3],[0,2],[0,1,3],[0,2]]"))).isFalse();
        assertThat(isBipartite(Ps.intArray("[[1,3],[0,2],[1,3],[0,2]]"))).isTrue();
    }

    public boolean isBipartite(int[][] graph) {
        Boolean[] groups = new Boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (groups[i] == null && !dfs(graph, groups, i, true))
                return false;
        }
        return true;
    }

    private boolean dfs(int[][] graph, Boolean[] groups, int node, boolean group) {
        groups[node] = group;
        for (int next : graph[node]) {
            if (Objects.equals(groups[next], !group))
                continue;
            if (Objects.equals(groups[next], group) || !dfs(graph, groups, next, !group))
                return false;
        }
        return true;
    }

}
