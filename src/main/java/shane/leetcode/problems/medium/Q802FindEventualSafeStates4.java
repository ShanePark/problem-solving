package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 5ms
 * Beats71.34%
 */
public class Q802FindEventualSafeStates4 {

    @Test
    public void test() {
        assertThat(eventualSafeNodes(Ps.intArray("[[],[0,2,3,4],[3],[4],[]]"))).containsExactly(0, 1, 2, 3, 4);
        assertThat(eventualSafeNodes(Ps.intArray("[[1,2],[2,3],[5],[0],[5],[],[]]"))).containsExactly(2, 4, 5, 6);
        assertThat(eventualSafeNodes(Ps.intArray("[[1,2,3,4],[1,2],[3,4],[0,4],[]]"))).containsExactly(4);
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        Boolean[] isCycle = new Boolean[graph.length];
        boolean[] visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            isCycle(isCycle, graph, i, visited);
        }
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (!isCycle[i]) {
                answer.add(i);
            }
        }
        return answer;
    }

    private boolean isCycle(Boolean[] isCycle, int[][] graph, int i, boolean[] visited) {
        if (isCycle[i] != null)
            return isCycle[i];
        if (visited[i]) {
            return isCycle[i] = true;
        }
        visited[i] = true;
        for (int next : graph[i]) {
            if (isCycle(isCycle, graph, next, visited)) {
                visited[i] = false;
                return isCycle[i] = true;
            }
        }
        visited[i] = false;
        return isCycle[i] = false;
    }


}
