package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 153ms
 * Beats49.15%
 */
public class Q3373MaximizeTheNumberOfTargetNodesAfterConnectingTreesII2 {

    @Test
    public void test() {
        assertThat(maxTargetNodes(Ps.intArray("[[0,1],[0,2],[2,3],[2,4]]"), Ps.intArray("[[0,1],[0,2],[0,3],[2,7],[1,4],[4,5],[4,6]]")))
                .containsExactly(8, 7, 7, 8, 8);
        assertThat(maxTargetNodes(Ps.intArray("[[0,1],[0,2],[0,3],[0,4]]"), Ps.intArray("[[0,1],[1,2],[2,3]]")))
                .containsExactly(3, 6, 6, 6, 6);
    }

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        List<List<Integer>> graph = makeGraph(edges1);
        List<List<Integer>> graph2 = makeGraph(edges2);
        int maxOdd = findMaxOdd(graph2);
        int size = graph.size();
        int[] answer = new int[size];
        Set<Integer>[] groups = divideGroup(graph);
        for (int i = 0; i < size; i++) {
            if (groups[0].contains(i)) {
                answer[i] = groups[0].size() + maxOdd;
                continue;
            }
            answer[i] = groups[1].size() + maxOdd;
        }
        return answer;
    }

    /**
     * Set(MaxGroup), Set(MinGroup)
     */
    private Set<Integer>[] divideGroup(List<List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        Set<Integer> group = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int poll = q.poll();
                if (visited[poll])
                    continue;
                visited[poll] = true;
                if (step % 2 == 0)
                    group.add(poll);
                List<Integer> nexts = graph.get(poll);
                for (int next : nexts) {
                    if (!visited[next])
                        q.add(next);
                }
            }
            step++;
        }
        Set<Integer> group2 = new HashSet<>();
        for (int i = 0; i < visited.length; i++) {
            if (group.contains(i)) {
                continue;
            }
            group2.add(i);
        }
        if (group.size() <= group2.size()) {
            return new Set[]{group2, group};
        }
        return new Set[]{group, group2};
    }

    private int findMaxOdd(List<List<Integer>> graph) {
        Set<Integer>[] groups = divideGroup(graph);
        return Math.max(groups[0].size(), groups[1].size());
    }

    private List<List<Integer>> makeGraph(int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= edges.length; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }

}
