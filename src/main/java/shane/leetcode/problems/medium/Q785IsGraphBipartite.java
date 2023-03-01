package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q785IsGraphBipartite {

    @Test
    public void test() {
        assertThat(isBipartite(Ps.intArray("[[1,2,3],[0,2],[0,1,3],[0,2]]"))).isFalse();
        assertThat(isBipartite(Ps.intArray("[[1,3],[0,2],[1,3],[0,2]]"))).isTrue();
    }

    public boolean isBipartite(int[][] graph) {
        int[] connection = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (connection[i] == 0 && !dfs(graph, connection, i, 1))
                return false;
        }
        return true;
    }

    private boolean dfs(int[][] graph, int[] connection, int i, int n) {
        connection[i] = n;
        for (int j = 0; j < graph[i].length; j++) {
            if (connection[graph[i][j]] == -n)
                continue;
            if (connection[graph[i][j]] == n || !dfs(graph, connection, graph[i][j], -n))
                return false;
        }
        return true;
    }
}
