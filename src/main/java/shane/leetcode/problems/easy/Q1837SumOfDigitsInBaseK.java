package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1837SumOfDigitsInBaseK {

    @Test
    public void test() {
        assertThat(sumBase(34, 6)).isEqualTo(9);
        assertThat(sumBase(36, 6)).isEqualTo(1);
        assertThat(sumBase(10, 10)).isEqualTo(1);
        assertThat(sumBase(42, 2)).isEqualTo(3);
    }

    public int sumBase(int n, int k) {
        int sum = 0;

        while (n >= k) {
            sum += n % k;
            n /= k;
        }

        return sum + n;
    }
}
