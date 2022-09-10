package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my solution
 * Runtime: 2 ms, faster than 90.63% of Java online submissions for Best Time to Buy and Sell Stock IV.
 * Memory Usage: 42.8 MB, less than 48.29% of Java online submissions for Best Time to Buy and Sell Stock IV.
 */
public class Q188BestTimeToBuyAndSellStockIV2 {

    @Test
    public void test() {
        assertThat(maxProfit(2, new int[]{})).isEqualTo(0);
        assertThat(maxProfit(0, new int[]{1, 3})).isEqualTo(0);
        assertThat(maxProfit(2, new int[]{3, 2, 6, 5, 0, 3})).isEqualTo(7);
        assertThat(maxProfit(2, new int[]{2, 4, 1})).isEqualTo(2);
    }

    public int maxProfit(int k, int[] prices) {
        final int LENGTH = prices.length;
        int[][] dp = new int[k + 1][LENGTH];

        if (prices.length == 0)
            return 0;

        for (int i = 0; i < k; i++) {
            int max = dp[i][0] - prices[0];
            for (int j = 1; j < LENGTH; j++) {
                dp[i + 1][j] = Math.max(dp[i + 1][j - 1], prices[j] + max);
                max = Math.max(max, dp[i][j] - prices[j]);
            }
        }
        return dp[k][LENGTH - 1];
    }

}
