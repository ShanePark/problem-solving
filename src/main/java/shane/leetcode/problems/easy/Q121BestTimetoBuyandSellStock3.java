package shane.leetcode.problems.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Runtime 3 ms Beats 21.67%
 * Memory 59 MB Beats 64.97%
 */
public class Q121BestTimetoBuyandSellStock3 {

    @Test
    void test() {
        Assertions.assertThat(maxProfit(new int[]{7, 1, 5, 3, 6, 4})).isEqualTo(5);
        Assertions.assertThat(maxProfit(new int[]{7, 6, 4, 3, 1})).isEqualTo(0);
        Assertions.assertThat(maxProfit(new int[]{3, 6, 4, 3, 1})).isEqualTo(3);
        Assertions.assertThat(maxProfit(new int[]{1})).isEqualTo(0);
    }

    public int maxProfit(int[] prices) {
        int max = 0;
        int profit = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            int price = prices[i];
            max = Math.max(max, price);
            profit = Math.max(profit, max - price);
        }
        return profit;
    }

}
