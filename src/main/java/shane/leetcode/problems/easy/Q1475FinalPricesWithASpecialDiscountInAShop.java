package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 1ms Beats98.90% 
 */
public class Q1475FinalPricesWithaSpecialDiscountinaShop {

    @Test
    public void test() {
        assertThat(finalPrices(new int[]{8, 4, 6, 2, 3})).isEqualTo(new int[]{4, 2, 4, 2, 3});
        assertThat(finalPrices(new int[]{1, 2, 3, 4, 5})).isEqualTo(new int[]{1, 2, 3, 4, 5});
        assertThat(finalPrices(new int[]{10, 1, 1, 6})).isEqualTo(new int[]{9, 0, 1, 6});
    }

    public int[] finalPrices(int[] prices) {
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] >= prices[j]) {
                    prices[i] -= prices[j];
                    break;
                }
            }
        }
        return prices;
    }

}
