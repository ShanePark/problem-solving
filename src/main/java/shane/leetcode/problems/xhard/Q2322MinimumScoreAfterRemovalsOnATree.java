package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2322MinimumScoreAfterRemovalsOnATree {

    @Test
    public void test() {
        assertThat(minimumScore(new int[]{1, 5, 5, 4, 11}, new int[][]{{0, 1}, {1, 2}, {1, 3}, {3, 4}})).isEqualTo(9);
        assertThat(minimumScore(new int[]{5, 5, 2, 4, 4, 2}, new int[][]{{0, 1}, {1, 2}, {5, 2}, {4, 3}, {1, 3}})).isEqualTo(0);
    }

    int answer = Integer.MAX_VALUE;

    public int minimumScore(int[] nums, int[][] edges) {
        answer = Integer.MAX_VALUE;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] v : edges) {
            graph.get(v[0]).add(v[1]);
            graph.get(v[1]).add(v[0]);
        }

        int xor = 0;
        for (int x : nums) {
            xor ^= x;
        }

        dfs(0, -1, nums, graph, xor);
        return answer;
    }

    private int dfs(int x, int f, int[] nums, List<List<Integer>> e, int xor) {
        int child = nums[x];
        for (int y : e.get(x)) {
            if (y == f) {
                continue;
            }
            child ^= dfs(y, x, nums, e, xor);
        }

        for (int y : e.get(x)) {
            if (y == f) {
                dfs2(y, x, child, x, nums, e, xor);
            }
        }
        return child;
    }

    private int dfs2(int x, int f, int oth, int anc, int[] nums, List<List<Integer>> e, int xor) {
        int child = nums[x];
        for (int y : e.get(x)) {
            if (y == f) {
                continue;
            }
            child ^= dfs2(y, x, oth, anc, nums, e, xor);
        }
        if (f == anc)
            return child;
        answer = Math.min(answer, (Math.max(oth, Math.max(child, xor ^ oth ^ child)) - Math.min(oth, Math.min(child, xor ^ oth ^ child))));
        return child;
    }

}
