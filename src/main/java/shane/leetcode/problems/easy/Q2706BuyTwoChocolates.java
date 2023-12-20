package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 1ms Beats 100.00%of users with Java
 * Memory Details 43.62MB Beats 21.83%of users with Java
 */
public class Q2706BuyTwoChocolates {

    @Test
    public void test() {
        assertThat(buyChoco(new int[]{1, 2, 2}, 3)).isEqualTo(0);
        assertThat(buyChoco(new int[]{3, 2, 3}, 3)).isEqualTo(3);

    }

    public int buyChoco(int[] prices, int money) {
        int min = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < min2) {
                min2 = price;
            }
            if (min2 < min) {
                min2 = min;
                min = price;
            }
        }
        if (min + min2 > money) {
            return money;
        }
        return money - min - min2;
    }

}
