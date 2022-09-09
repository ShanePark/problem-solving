package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 131 ms, faster than 95.74% of Java online submissions for Apply Discount Every n Orders.
 * Memory Usage: 71.1 MB, less than 88.65% of Java online submissions for Apply Discount Every n Orders.
 */
public class Q1357ApplyDiscountEveryNOrders {

    @Test
    public void test() {
        Cashier cashier = new Cashier(3, 50, new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{100, 200, 300, 400, 300, 200, 100});
        assertThat(cashier.getBill(new int[]{1, 2}, new int[]{1, 2})).isEqualTo(500.0);
        assertThat(cashier.getBill(new int[]{3, 7}, new int[]{10, 10})).isEqualTo(4000.0);
        assertThat(cashier.getBill(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{1, 1, 1, 1, 1, 1, 1})).isEqualTo(800.0);
        assertThat(cashier.getBill(new int[]{4}, new int[]{10})).isEqualTo(4000.0);
        assertThat(cashier.getBill(new int[]{7, 3}, new int[]{10, 10})).isEqualTo(4000.0);
        assertThat(cashier.getBill(new int[]{7, 5, 3, 1, 6, 4, 2}, new int[]{10, 10, 10, 9, 9, 9, 7})).isEqualTo(7350.0);
        assertThat(cashier.getBill(new int[]{2, 3, 5}, new int[]{5, 3, 2})).isEqualTo(2500.0);
    }

    class Cashier {
        int n;
        int discount;
        Map<Integer, Integer> prices = new HashMap<>();
        int cnt = 0;

        public Cashier(int n, int discount, int[] products, int[] prices) {
            this.n = n;
            this.discount = discount;
            for (int i = 0; i < products.length; i++) {
                this.prices.put(products[i], prices[i]);
            }
        }

        public double getBill(int[] product, int[] amount) {
            double rate = 1;
            if (++cnt == n) {
                rate = ((double) 100 - discount) / 100;
                cnt = 0;
            }
            double sum = 0;
            for (int i = 0; i < product.length; i++) {
                sum += prices.get(product[i]) * amount[i] * rate;
            }
            return sum;
        }
    }
}
