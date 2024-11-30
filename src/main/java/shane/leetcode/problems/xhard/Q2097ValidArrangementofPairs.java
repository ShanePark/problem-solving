package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Eulerian Path Hint
 */
public class Q2097ValidArrangementofPairs {

    @Test
    public void test() {
        assertThat(validArrangement(Ps.intArray("[[5,13],[10,6],[11,3],[15,19],[16,19],[1,10],[19,11],[4,16],[19,9][16,19],[1,10],[19,11],[4,16],[19,9],[5,11],[5,6],[13,5],[13,9],[9,15],[11,16],[6,9],[9,13],[3,1],[16,5],[6,5]]"))).isEqualTo(Ps.intArray("[[1, 10],[10, 6],[6, 5],[5, 6],[6, 19],[6, 9],[9, 13],[13, 9],[9, 15],[15, 19],[19, 11],[11, 16],[16, 19],[19, 11],[19, 9],[16, 5],[5, 13],[13, 5],[5, 11],[11, 3],[3, 1],[1, 10],[19, 9]]"));
        assertThat(validArrangement(Ps.intArray("[[1,2],[1,3],[2,1]]"))).isEqualTo(Ps.intArray("[[1,2],[2,1],[1,3]]"));
        assertThat(validArrangement(Ps.intArray("[[5,1],[4,5],[11,9],[9,4]]"))).isEqualTo(Ps.intArray("[[11,9],[9,4],[4,5],[5,1]]"));
        assertThat(validArrangement(Ps.intArray("[[1,3],[3,2],[2,1]]"))).isEqualTo(Ps.intArray("[[1,3],[3,2],[2,1]]"));
    }

    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, Stack<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> findStartMap = new HashMap<>();
        for (int[] pair : pairs) {
            graph.computeIfAbsent(pair[0], k -> new Stack<>()).push(pair[1]);
            findStartMap.merge(pair[0], 1, Integer::sum);
            findStartMap.merge(pair[1], -1, Integer::sum);
            findStartMap.remove(pair[0], 0);
            findStartMap.remove(pair[1], 0);
        }
        int startNum = findStartMap.entrySet()
                .stream()
                .filter(e -> e.getValue() > 0)
                .mapToInt(Map.Entry::getKey)
                .findAny()
                .orElse(pairs[0][0]);

        List<int[]> answer = new ArrayList<>();
        visit(answer, graph, startNum);

        Collections.reverse(answer);
        return answer.toArray(new int[0][]);
    }

    void visit(List<int[]> answer, Map<Integer, Stack<Integer>> graph, int cur) {
        Stack<Integer> stack = graph.getOrDefault(cur, new Stack<>());
        while (!stack.isEmpty()) {
            int next = stack.pop();
            visit(answer, graph, next);
            answer.add(new int[]{cur, next});
        }
    }

}
