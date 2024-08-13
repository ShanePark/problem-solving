package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q40CombinationSumII2 {

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
        List<List<Integer>> answer = new ArrayList<>();
        dfs(candidates, 0, target, new ArrayList<>(), answer);
        return answer;
    }

    void dfs(int[] candidates, int index, int target, List<Integer> curList, List<List<Integer>> res) {
        if (target < 0)
            return;
        if (target == 0) {
            res.add(new ArrayList<>(curList));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            int cur = candidates[i];
            if (index != i && cur == candidates[i - 1])
                continue;
            curList.add(cur);
            dfs(candidates, i + 1, target - cur, curList, res);
            curList.remove(curList.size() - 1);
        }
    }

}
