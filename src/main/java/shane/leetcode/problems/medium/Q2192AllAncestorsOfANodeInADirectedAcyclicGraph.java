package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 65msBeats72.96%
 */
public class Q2192AllAncestorsOfANodeInADirectedAcyclicGraph {

    @Test
    public void test() {
        assertThat(getAncestors(8, Ps.intArray("[[0,3],[0,4],[1,3],[2,4],[2,7],[3,5],[3,6],[3,7],[4,6]]")))
                .isEqualTo(Ps.intList("[[],[],[],[0,1],[0,2],[0,1,3],[0,1,2,3,4],[0,1,2,3]]"));
        assertThat(getAncestors(5, Ps.intArray("[[0,1],[0,2],[0,3],[0,4],[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]")))
                .isEqualTo(Ps.intList("[[],[0],[0,1],[0,1,2],[0,1,2,3]]"));
    }

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> answer = new ArrayList<>();
        List<List<Integer>> next = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            answer.add(new ArrayList<>());
            next.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            next.get(edge[0]).add(edge[1]);
        }

        for (int i = 0; i < n; i++) {
            traverse(i, i, answer, next);
        }

        return answer;
    }

    private void traverse(int from, int cur, List<List<Integer>> answer, List<List<Integer>> next) {
        for (Integer i : next.get(cur)) {
            List<Integer> children = answer.get(i);
            if (children.isEmpty() || children.get(children.size() - 1) != from) {
                children.add(from);
                traverse(from, i, answer, next);
            }
        }
    }

}
