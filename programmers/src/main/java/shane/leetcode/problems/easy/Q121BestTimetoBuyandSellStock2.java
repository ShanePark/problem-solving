package shane.leetcode.problems.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q121BestTimetoBuyandSellStock2 {

    @Test
    void test() {
        Assertions.assertThat(maxProfit(new int[]{7, 1, 5, 3, 6, 4})).isEqualTo(5);
        Assertions.assertThat(maxProfit(new int[]{7, 6, 4, 3, 1})).isEqualTo(0);
        Assertions.assertThat(maxProfit(new int[]{3, 6, 4, 3, 1})).isEqualTo(3);
        Assertions.assertThat(maxProfit(new int[]{1})).isEqualTo(0);
    }

    public int maxProfit(int[] prices) {
        int answer = 0;
        int min = 10000;
        for (int price : prices) {
            if (min >= price) {
                min = price;
            } else {
                answer = Math.max(answer, price - min);
            }
        }
        return answer;
    }
}
