package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q40CombinationSumII {

    @Test
    public void test() {
        assertThat(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8)).containsExactlyInAnyOrder(
                List.of(1, 7),
                List.of(1, 2, 5),
                List.of(2, 6),
                List.of(1, 1, 6)
        );
        assertThat(combinationSum2(new int[]{2, 5, 2, 1, 2}, 5)).containsExactlyInAnyOrder(
                List.of(1, 2, 2),
                List.of(5)
        );
    }

    @Test
    public void tle() {
        assertThat(combinationSum2(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                30)).containsExactlyInAnyOrder(
                List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1)
        );
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> answer = new HashSet<>();
        dfs(new ArrayList<>(), candidates, 0, target, answer);
        return new ArrayList<>(answer);
    }

    private void dfs(List<Integer> curList, int[] candidates, int i, int target, Set<List<Integer>> answer) {
        if (i == candidates.length)
            return;
        int cur = candidates[i];
        dfs(curList, candidates, i + 1, target, answer);
        if (target < cur) {
            return;
        }
        curList.add(cur);
        if (target == cur) {
            answer.add(new ArrayList<>(curList));
            curList.remove(curList.size() - 1);
            return;
        }
        dfs(curList, candidates, i + 1, target - cur, answer);
        curList.remove(curList.size() - 1);
    }

}
