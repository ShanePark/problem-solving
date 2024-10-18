package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime10msBeats54.00%
 */
public class Q2044CountNumberOfMaximumBitwiseORSubsets2 {

    @Test
    public void test() {
        assertThat(countMaxOrSubsets(new int[]{3, 1})).isEqualTo(2);
        assertThat(countMaxOrSubsets(new int[]{2, 2, 2})).isEqualTo(7);
        assertThat(countMaxOrSubsets(new int[]{3, 2, 1, 5})).isEqualTo(6);
    }

    public int countMaxOrSubsets(int[] nums) {
        int max = Arrays.stream(nums).reduce((a, b) -> a | b).orElse(0);
        return dfs(nums, 0, 0, max);
    }

    private int dfs(int[] nums, int cur, int index, int max) {
        if (nums.length == index)
            return 0;
        int or = cur | nums[index];
        int answer = 0;
        if (or == max)
            answer++;
        return answer + dfs(nums, or, index + 1, max) + dfs(nums, cur, index + 1, max);
    }

}
