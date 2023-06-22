package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my idea
 */
public class Q714BestTimeToBuyAndSellStockWithTransactionFee {

    @Test
    public void test() {
        assertThat(maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2)).isEqualTo(8);
        assertThat(maxProfit(new int[]{1, 3, 7, 5, 10, 3}, 3)).isEqualTo(6);
    }

    public int maxProfit(int[] prices, int fee) {
        int maxProfit = 0;
        int curProfit = Integer.MIN_VALUE;

        for (int price : prices) {
            int before = maxProfit;
            maxProfit = Math.max(maxProfit, curProfit + price);
            curProfit = Math.max(curProfit, before - price - fee);
        }

        return maxProfit;
    }

}
