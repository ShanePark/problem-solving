package shane.leetcode.contest.biweekly.w73;

import io.github.shanepark.Ps;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * FAIL
 */
public class Q2192AllAncestorsOfANodeInADirectedAcyclicGraph3 {

    @Test
    void test() {
        Assertions.assertThat(getAncestors(8, Ps.intArray("[[0,3],[0,4],[1,3],[2,4],[2,7],[3,5],[3,6],[3,7],[4,6]]"))).containsExactly(
                Arrays.asList(), Arrays.asList(), Arrays.asList(), Arrays.asList(0, 1), Arrays.asList(0, 2), Arrays.asList(0, 1, 3), Arrays.asList(0, 1, 2, 3, 4), Arrays.asList(0, 1, 2, 3)
        );
        Assertions.assertThat(getAncestors(6, Ps.intArray("[[0,3],[5,0],[2,3],[4,3],[5,3],[1,3],[2,5],[0,1],[4,5],[4,2],[4,0],[2,1],[5,1]]"))).containsExactly(
                Arrays.asList(2, 4, 5), Arrays.asList(0, 2, 4, 5), Arrays.asList(4), Arrays.asList(0, 1, 2, 4, 5), Arrays.asList(), Arrays.asList(2, 4)
        );
    }

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> parents = new ArrayList<>();
        List<List<Integer>> children = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            parents.add(new ArrayList<>());
            children.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            children.get(edge[0]).add(edge[1]);
        }
        for (int i = 0; i < n; i++) {
            dfs(i, i, parents, children);
        }
        return parents;

    }

    private void dfs(int i, int cur, List<List<Integer>> parents, List<List<Integer>> children) {
        for (Integer child : children.get(cur)) {
            if (parents.get(child).size() == 0 || parents.get(child).get(parents.get(child).size() - 1) != i) {
                parents.get(child).add(i);
                dfs(i, child, parents, children);
            }
        }
    }

}
