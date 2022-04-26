package shane.leetcode.problems.xhard;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q1359CountAllValidPickupAndDeliveryOptions {

    @Test
    void test() {
        Assertions.assertThat(countOrders(1)).isEqualTo(1);
        Assertions.assertThat(countOrders(2)).isEqualTo(6);
        Assertions.assertThat(countOrders(3)).isEqualTo(90);
        Assertions.assertThat(countOrders(4)).isEqualTo(2520);
        Assertions.assertThat(countOrders(8)).isEqualTo(729647433);
    }

    public int countOrders(int n) {
        long answer = 1;
        for (int i = 1; i <= n; i++) {
            answer = (answer * i * (2 * i - 1)) % ((long) 1e9 + 7);
        }
        return (int) answer;
    }
}
