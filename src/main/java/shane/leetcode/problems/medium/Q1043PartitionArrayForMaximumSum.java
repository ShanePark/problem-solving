package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 15 ms, faster than 19.39% of Java online submissions for Partition Array for Maximum Sum.
 * Memory Usage: 43.1 MB, less than 23.69% of Java online submissions for Partition Array for Maximum Sum.
 */
public class Q1043PartitionArrayForMaximumSum {

    @Test
    public void test() {
        assertThat(maxSumAfterPartitioning(new int[]{1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3}, 4)).isEqualTo(83);
        assertThat(maxSumAfterPartitioning(new int[]{1, 15, 7, 9, 2, 5, 10}, 3)).isEqualTo(84);
        assertThat(maxSumAfterPartitioning(new int[]{1}, 1)).isEqualTo(1);
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        final int LENGTH = arr.length;
        int[] dp = new int[LENGTH];
        dp[0] = arr[0];
        for (int i = 1; i < LENGTH; i++) {
            int max = arr[i];
            dp[i] = dp[i - 1] + arr[i];
            for (int j = 2; j <= k && i - j + 1 >= 0; j++) {
                max = Math.max(max, arr[i - j + 1]);
                int before = 0;
                if (i - j >= 0)
                    before = dp[i - j];
                dp[i] = Math.max(dp[i], before + max * j);
            }
        }
        return dp[LENGTH - 1];
    }


}
