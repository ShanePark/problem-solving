package shane.leetcode.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q121BestTimetoBuyandSellStock {

    @Test
    void test() {
        Assertions.assertThat(maxProfit(new int[]{7, 1, 5, 3, 6, 4})).isEqualTo(5);
        Assertions.assertThat(maxProfit(new int[]{7, 6, 4, 3, 1})).isEqualTo(0);
        Assertions.assertThat(maxProfit(new int[]{3, 6, 4, 3, 1})).isEqualTo(3);
        Assertions.assertThat(maxProfit(new int[]{1})).isEqualTo(0);
    }

    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int get = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                if (get >= prices[j]) {
                    break;
                }
                max = Math.max(max, prices[j] - get);
            }
        }
        return max;
    }
}
