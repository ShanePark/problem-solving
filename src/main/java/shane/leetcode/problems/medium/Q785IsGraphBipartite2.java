package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 1 ms Beats 66.41%
 * Memory 44.4 MB Beats 6.63%
 */
public class Q785IsGraphBipartite2 {

    @Test
    public void test() {
        assertThat(isBipartite(Ps.intArray("[[1],[0,3],[3],[1,2]]"))).isTrue();
        assertThat(isBipartite(Ps.intArray("[[1,2,3],[0,2],[0,1,3],[0,2]]"))).isFalse();
        assertThat(isBipartite(Ps.intArray("[[4],[],[4],[4],[0,2,3]]"))).isTrue();
        assertThat(isBipartite(Ps.intArray("[[],[2,4,6],[1,4,8,9],[7,8],[1,2,8,9],[6,9],[1,5,7,8,9],[3,6,9],[2,3,4,6,9],[2,4,5,6,7,8]]"))).isFalse();
        assertThat(isBipartite(Ps.intArray("[[1,3],[0,2],[1,3],[0,2]]"))).isTrue();
    }

    public boolean isBipartite(int[][] graph) {
        int[] groups = new int[graph.length];
        Arrays.fill(groups, -1);
        for (int i = 0; i < graph.length; i++) {
            if (groups[i] < 0)
                groups[i] = 0;
            for (int next : graph[i]) {
                try {
                    dfs(graph, groups, i, next);
                } catch (IllegalStateException e) {
                    return false;
                }
            }
        }
        return true;
    }

    private void dfs(int[][] graph, int[] groups, int current, int next) {
        int nextGroup = (groups[current] + 1) % 2;

        if (groups[next] == -1) {
            groups[next] = nextGroup;
            for (int more : graph[next]) {
                dfs(graph, groups, next, more);
            }
        }

        if (groups[next] == groups[current])
            throw new IllegalStateException();
    }

}
