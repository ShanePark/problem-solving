package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1475FinalPricesWithASpecialDiscountInAShop {

    @Test
    public void test() {
        assertThat(finalPrices(new int[]{8, 4, 6, 2, 3})).containsExactly(4, 2, 4, 2, 3);
        assertThat(finalPrices(new int[]{1, 2, 3, 4, 5})).containsExactly(1, 2, 3, 4, 5);
        assertThat(finalPrices(new int[]{10, 1, 1, 6})).containsExactly(9, 0, 1, 6);
    }

    public int[] finalPrices(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            int sale = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (price >= prices[j]) {
                    sale = prices[j];
                    break;
                }
            }
            answer[i] = price - sale;
        }
        return answer;
    }

}
