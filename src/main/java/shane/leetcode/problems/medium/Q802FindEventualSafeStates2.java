package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q802FindEventualSafeStates2 {

    @Test
    public void test() {
        assertThat(eventualSafeNodes(Ps.intArray("[[],[0,2,3,4],[3],[4],[]]"))).containsExactly(0, 1, 2, 3, 4);
        assertThat(eventualSafeNodes(Ps.intArray("[[1,2],[2,3],[5],[0],[5],[],[]]"))).containsExactly(2, 4, 5, 6);
        assertThat(eventualSafeNodes(Ps.intArray("[[1,2,3,4],[1,2],[3,4],[0,4],[]]"))).containsExactly(4);
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        Boolean[] safe = new Boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            safe[i] = isSafe(safe, graph, i);
        }
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (safe[i]) {
                answer.add(i);
            }
        }
        return answer;
    }

    private Boolean isSafe(Boolean[] safe, int[][] graph, int i) {
        if (safe[i] != null)
            return safe[i];
        if (graph[i].length == 0)
            return safe[i] = true;
        return !isCycle(safe, graph, i, new boolean[graph.length]);
    }

    private boolean isCycle(Boolean[] safe, int[][] graph, int i, boolean[] visited) {
        if (safe[i] != null)
            return !safe[i];
        if (visited[i])
            return true;
        visited[i] = true;
        for (int next : graph[i]) {
            if (isCycle(safe, graph, next, visited))
                return true;
        }
        visited[i] = false;
        return false;
    }


}
