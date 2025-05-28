package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 330ms
 * Beats59.49%
 */
public class Q3372MaximizeTheNumberOfTargetNodesAfterConnectingTreesI {

    @Test
    public void test() {
        assertThat(maxTargetNodes(Ps.intArray("[[0,1],[0,2],[2,3],[2,4]]"), Ps.intArray("[[0,1],[0,2],[0,3],[2,7],[1,4],[4,5],[4,6]]"), 2))
                .isEqualTo(new int[]{9, 7, 9, 8, 8});
        assertThat(maxTargetNodes(Ps.intArray("[[0,1],[0,2],[0,3],[0,4]]"), Ps.intArray("[[0,1],[1,2],[2,3]]"), 1))
                .isEqualTo(new int[]{6, 3, 3, 3, 3});
    }

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        List<List<Integer>> graph1 = makeGraph(edges1);
        int[] findDistanceInK = findDistanceIn(graph1, k);

        int maxLeavesGraph2 = Arrays.stream(findDistanceIn(makeGraph(edges2), k - 1)).max().getAsInt();
        int[] answer = new int[graph1.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = findDistanceInK[i] + maxLeavesGraph2;
        }
        return answer;
    }

    private int[] findDistanceIn(List<List<Integer>> graph, int k) {
        int[] answer = new int[graph.size()];
        for (int i = 0; i < graph.size(); i++) {
            tryVisitDfs(answer, new boolean[answer.length], graph, i, i, k);
        }
        return answer;
    }

    private void tryVisitDfs(int[] answer, boolean[] visited, List<List<Integer>> graph, int start, int cur, int k) {
        if (visited[cur] || k < 0)
            return;
        answer[start]++;
        visited[cur] = true;
        for (Integer next : graph.get(cur)) {
            tryVisitDfs(answer, visited, graph, start, next, k - 1);
        }
    }

    private List<List<Integer>> makeGraph(int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= edges.length; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] ints : edges) {
            graph.get(ints[0]).add(ints[1]);
            graph.get(ints[1]).add(ints[0]);
        }
        return graph;
    }

}
