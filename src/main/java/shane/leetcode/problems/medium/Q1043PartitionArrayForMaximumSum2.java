package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1043PartitionArrayForMaximumSum2 {

    @Test
    public void test() {
        assertThat(maxSumAfterPartitioning(new int[]{1, 15, 7, 9, 2, 5, 10}, 3)).isEqualTo(84);
        assertThat(maxSumAfterPartitioning(new int[]{1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3}, 4)).isEqualTo(83);
        assertThat(maxSumAfterPartitioning(new int[]{1}, 1)).isEqualTo(1);
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int max = arr[i];
            dp[i] = dp[i - 1] + arr[i];
            for (int j = 2; (0 <= i - j + 1) && (j <= k); j++) {
                max = Math.max(max, arr[i - j + 1]);
                int apply = ((j <= i) ? dp[i - j] : 0) + (max * j);
                dp[i] = Math.max(dp[i], apply);
            }
        }
        return dp[arr.length - 1];
    }
    
}
