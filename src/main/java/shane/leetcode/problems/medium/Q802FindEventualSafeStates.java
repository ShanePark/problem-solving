package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 29 ms Beats 35.5%
 * Memory 53.9 MB Beats 90.9%
 */
public class Q802FindEventualSafeStates {

    @Test
    public void test() {
        assertThat(eventualSafeNodes(Ps.intArray("[[1,2],[2,3],[5],[0],[5],[],[]]"))).containsExactly(2, 4, 5, 6);
        assertThat(eventualSafeNodes(Ps.intArray("[[1,2,3,4],[1,2],[3,4],[0,4],[]]"))).containsExactly(4);
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        final int LENGTH = graph.length;
        Boolean[] isTerminalOrSafe = new Boolean[LENGTH];

        for (int i = 0; i < graph.length; i++) {
            if (graph[i].length == 0) {
                isTerminalOrSafe[i] = true;
            }
        }

        for (int i = 0; i < LENGTH; i++) {
            Set<Integer> visited = new HashSet();
            visited.add(i);
            isSafe(graph, i, isTerminalOrSafe, visited);
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (isTerminalOrSafe[i]) {
                answer.add(i);
            }
        }
        return answer;
    }

    private boolean isSafe(int[][] graph, int i, Boolean[] isTerminalOrSafe, Set<Integer> visited) {
        if (isTerminalOrSafe[i] != null) {
            return isTerminalOrSafe[i];
        }

        boolean isSafe = true;
        for (int next : graph[i]) {
            if (!visited.add(next)) {
                isTerminalOrSafe[i] = false;
                return false;
            }
            if (!isSafe(graph, next, isTerminalOrSafe, visited)) {
                isSafe = false;
            }
            visited.remove(next);
        }
        isTerminalOrSafe[i] = isSafe;
        visited.remove(i);
        return isTerminalOrSafe[i];
    }

}
