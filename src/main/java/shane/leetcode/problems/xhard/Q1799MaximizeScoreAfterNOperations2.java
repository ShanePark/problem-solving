package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * borrowed idea from solutions
 * Runtime 567 ms Beats 5.55% Memory 43.6 MB Beats 9.72%
 */
public class Q1799MaximizeScoreAfterNOperations2 {

    @Test
    void test() {
        assertThat(maxScore(new int[]{3, 4, 6, 8})).isEqualTo(11);
        assertThat(maxScore(new int[]{1, 2})).isEqualTo(1);
        assertThat(maxScore(new int[]{1, 2, 3, 4, 5, 6})).isEqualTo(14);
    }

    @Test
    void tle() {
        assertThat(maxScore(new int[]{984916, 312350, 779975, 165893, 436389, 592384, 264617, 136726, 8893, 587955, 921403, 891842})).isEqualTo(257);
    }

    int maxScore(int[] nums) {
        int length = nums.length;
        int[][] dp = new int[length / 2 + 1][pow2i(length)];
        return dfs(nums, dp, 1, 0);
    }

    int dfs(int[] nums, int[][] dp, int index, int mask) {
        if (index == dp.length)
            return 0;
        if (dp[index][mask] != 0)
            return dp[index][mask];

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int nextMask = pow2i(i) + pow2i(j);
                if ((mask & nextMask) != 0)
                    continue;
                int cur = index * gcd(nums[i], nums[j]) + dfs(nums, dp, index + 1, mask + nextMask);
                max = Math.max(max, cur);
            }
        }
        dp[index][mask] = max;
        return max;
    }

    private int gcd(int num1, int num2) {
        if (num2 == 0)
            return num1;
        return gcd(num2, num1 % num2);
    }

    private int pow2i(int i) {
        return (int) Math.pow(2, i);
    }

}
