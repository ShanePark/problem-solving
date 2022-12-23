package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100%
 * Memory 40.4 MB Beats 89.35%
 */
public class Q309BestTimeToBuyAndSellStockWithCoolDown2 {

    @Test
    public void test() {
        assertThat(maxProfit(new int[]{1, 2, 3, 0, 2})).isEqualTo(3);
        assertThat(maxProfit(new int[]{1})).isEqualTo(0);
    }

    public int maxProfit(int[] prices) {
        int canBuy = 0;
        int hasStock = -1000;
        int coolDown = 0;
        int keepStock;

        for (int price : prices) {
            keepStock = hasStock;
            hasStock = Math.max(canBuy - price, keepStock);
            canBuy = coolDown;
            coolDown = Math.max(keepStock + price, canBuy);
        }

        return coolDown;
    }

}
