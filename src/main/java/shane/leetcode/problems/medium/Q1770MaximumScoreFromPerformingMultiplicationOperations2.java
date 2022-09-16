package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * inspired by Discuss, not my idea
 * Runtime: 143 ms, faster than 60.09% of Java online submissions for Maximum Score from Performing Multiplication Operations.
 * Memory Usage: 69.8 MB, less than 86.49% of Java online submissions for Maximum Score from Performing Multiplication Operations.
 */
public class Q1770MaximumScoreFromPerformingMultiplicationOperations2 {

    @Test
    public void test() {
        assertThat(maximumScore(new int[]{1, 2, 3}, new int[]{3, 2, 1})).isEqualTo(14);
        assertThat(maximumScore(new int[]{-5, -3, -3, -2, 7, 1}, new int[]{-10, -5, 3, 4, 6})).isEqualTo(102);
    }

    @Test
    public void tle() {
        assertThat(maximumScore(new int[]{555, 526, 732, 182, 43, -537, -434, -233, -947, 968, -250, -10, 470, -867, -809, -987, 120, 607, -700, 25, -349, -657, 349, -75, -936, -473, 615, 691, -261, -517, -867, 527, 782, 939, -465, 12, 988, -78, -990, 504, -358, 491, 805, 756, -218, 513, -928, 579, 678, 10}
                , new int[]{783, 911, 820, 37, 466, -251, 286, -74, -899, 586, 792, -643, -969, -267, 121, -656, 381, 871, 762, -355, 721, 753, -521}))
                .isEqualTo(6861161);
    }

    public int maximumScore(int[] nums, int[] multipliers) {
        Integer[][] memo = new Integer[multipliers.length][multipliers.length];
        return dp(memo, nums, multipliers, 0, 0);
    }

    private int dp(Integer[][] memo, int[] nums, int[] multipliers, int left, int i) {
        if (i == multipliers.length)
            return 0;
        if (memo[left][i] != null)
            return memo[left][i];

        memo[left][i] = Math.max(
                dp(memo, nums, multipliers, left + 1, i + 1) + nums[left] * multipliers[i],
                dp(memo, nums, multipliers, left, i + 1) + nums[nums.length - 1 - (i - left)] * multipliers[i]
        );
        return memo[left][i];
    }

}
