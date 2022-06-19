package shane.leetcode.contest.weekly.w298;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2310SumOfNumbersWithUnitsDigitK {

    @Test
    public void test() {
        assertThat(minimumNumbers(4, 0)).isEqualTo(-1);
        assertThat(minimumNumbers(26, 2)).isEqualTo(3);
        assertThat(minimumNumbers(58, 9)).isEqualTo(2);
        assertThat(minimumNumbers(37, 2)).isEqualTo(-1);
        assertThat(minimumNumbers(0, 7)).isEqualTo(0);
        assertThat(minimumNumbers(44, 4)).isEqualTo(1);
    }

    public int minimumNumbers(int num, int k) {
        if (num == 0)
            return 0;
        if (num % 10 == k)
            return 1;

        if (num < k || k == 0) {
            return -1;
        }

        int calc = minimumNumbers(num - k, k);
        if (calc >= 0)
            return calc + 1;

        return -1;

    }

}
