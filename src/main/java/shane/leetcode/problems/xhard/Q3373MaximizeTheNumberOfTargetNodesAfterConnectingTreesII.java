package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q3373MaximizeTheNumberOfTargetNodesAfterConnectingTreesII {

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
        int[] answer = new int[graph.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = countEven(graph, i) + maxOdd;
        }
        return answer;
    }

    private int countEven(List<List<Integer>> graph, int n) {
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        int step = 0;
        int answer = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int poll = q.poll();
                if (visited[poll])
                    continue;
                visited[poll] = true;
                if (step % 2 == 0)
                    answer++;
                q.addAll(graph.get(poll));
            }
            step++;
        }
        return answer;
    }

    private int findMaxOdd(List<List<Integer>> graph) {
        int size = graph.size();
        int max = 0;
        for (int i = 0; i < size; i++) {
            max = Math.max(max, size - countEven(graph, i));
        }
        return max;
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
