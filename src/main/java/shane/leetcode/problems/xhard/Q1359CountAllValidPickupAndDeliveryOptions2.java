package shane.leetcode.problems.xhard;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Runtime Details 0ms Beats 100.00%of users with Java
 * Memory Details 39.91MB Beats 37.80%of users with Java
 */
public class Q1359CountAllValidPickupAndDeliveryOptions2 {

    @Test
    void test() {
        Assertions.assertThat(countOrders(1)).isEqualTo(1);
        Assertions.assertThat(countOrders(2)).isEqualTo(6);
        Assertions.assertThat(countOrders(3)).isEqualTo(90);
        Assertions.assertThat(countOrders(500)).isEqualTo(764678010);
    }

    final int MOD = (int) 1e9 + 7;

    public int countOrders(int n) {
        int[] answer = new int[n + 1];
        answer[1] = 1;
        for (long i = 2; i <= n; i++) {
            answer[(int) i] = (int) ((answer[(int) i - 1] * (i * 2) * (i * 2 - 1) / 2) % MOD);
        }
        return answer[n];
    }

}
