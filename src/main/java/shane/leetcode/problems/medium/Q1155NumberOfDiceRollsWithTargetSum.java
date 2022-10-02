package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 27 ms, faster than 64.17% of Java online submissions for Number of Dice Rolls With Target Sum.
 * Memory Usage: 40.8 MB, less than 97.12% of Java online submissions for Number of Dice Rolls With Target Sum.
 */
public class Q1155NumberOfDiceRollsWithTargetSum {

    @Test
    public void test() {
        assertThat(numRollsToTarget(1, 6, 3)).isEqualTo(1);
        assertThat(numRollsToTarget(2, 6, 7)).isEqualTo(6);
        assertThat(numRollsToTarget(3, 6, 7)).isEqualTo(15);
        assertThat(numRollsToTarget(30, 30, 500)).isEqualTo(222616187);
    }

    public int numRollsToTarget(int n, int k, int target) {
        final int MOD = (int) 1e9 + 7;

        if (target < n || target > n * k)
            return 0;

        int[][] dp = new int[n][target + 1];

        for (int i = 0; i < k && i < target; i++) {
            dp[0][i + 1] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= target; j++) {
                for (int l = 1; l <= k && j - l >= 0; l++) {
                    dp[i][j] = (int) (((long) dp[i][j] + dp[i - 1][j - l]) % MOD);
                }
            }
        }

        return (dp[n - 1][target] % MOD);
    }

}
