package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Runtime 0 ms Beats 100.00% of users with Java
 */
public class Q78Subsets3 {

    @Test
    void test() {
        Assertions.assertThat(subsets(new int[]{1, 2, 3})).containsExactlyInAnyOrder(
                Arrays.asList(new Integer[]{1, 2, 3}),
                Arrays.asList(new Integer[]{2, 3}),
                Arrays.asList(new Integer[]{1, 3}),
                Arrays.asList(new Integer[]{3}),
                Arrays.asList(new Integer[]{1, 2}),
                Arrays.asList(new Integer[]{2}),
                Arrays.asList(new Integer[]{1}),
                Arrays.asList(new Integer[]{})
        );

        Assertions.assertThat(subsets(new int[]{0})).containsExactlyInAnyOrder(
                Arrays.asList(new Integer[]{0}),
                Arrays.asList(new Integer[]{})
        );

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>());
        dfs(nums, answer, 0, new ArrayList<>());
        return answer;
    }

    private void dfs(int[] nums, List<List<Integer>> answer, int i, List<Integer> cur) {
        if (nums.length == i)
            return;
        dfs(nums, answer, i + 1, cur);

        int size = cur.size();
        cur.add(nums[i]);
        answer.add(new ArrayList<>(cur));
        dfs(nums, answer, i + 1, cur);
        cur.remove(size);
    }

}
