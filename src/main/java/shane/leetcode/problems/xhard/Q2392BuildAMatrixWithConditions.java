package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2392BuildAMatrixWithConditions {

    @Test
    public void test() {
        assertThat(buildMatrix(3, Ps.intArray("[[1,2],[3,2]]"), Ps.intArray("[[2,1],[3,2]]")))
                .isEqualTo(Ps.intArray("[[0, 0, 1], [3, 0, 0], [0, 2, 0]]"));
        assertThat(buildMatrix(3, Ps.intArray("[[1,2],[2,3],[3,1],[2,3]]"), Ps.intArray("[[2,1]]")))
                .isEmpty();
    }

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> rows = sortNumbers(k, rowConditions);
        List<Integer> cols = sortNumbers(k, colConditions);
        if (rows == null || cols == null) {
            return new int[][]{};
        }

        int[][] answer = new int[k][k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(cols.get(i), i);
        }
        for (int i = 0; i < k; i++) {
            int num = rows.get(i);
            answer[i][map.get(num)] = num;
        }
        return answer;
    }

    private List<Integer> sortNumbers(int k, int[][] conditions) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= k; i++) {
            graph.add(new ArrayList<>());
        }
        int[] inDegree = new int[k + 1];
        for (int[] condition : conditions) {
            int small = condition[0];
            int big = condition[1];
            graph.get(small).add(big);
            inDegree[big]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        List<Integer> order = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            order.add(node);
            for (int next : graph.get(node)) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        if (order.size() == k)
            return order;
        return null;
    }

}
