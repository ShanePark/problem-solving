package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 44ms
 * Beats23.95%
 */
public class Q2843CountSymmetricIntegers {

    @Test
    public void test() {
        assertThat(countSymmetricIntegers(1, 100)).isEqualTo(9);
        assertThat(countSymmetricIntegers(1200, 1230)).isEqualTo(4);
    }

    public int countSymmetricIntegers(int low, int high) {
        int answer = 0;
        for (; low <= high; low++) {
            if (isSymmetric(low)) {
                answer++;
            }
        }
        return answer;
    }

    private boolean isSymmetric(int n) {
        int length = (int) Math.log10(n) + 1;
        if (length % 2 == 1)
            return false;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            int mod = n % 10;
            if (i < length / 2) {
                mod *= -1;
            }
            sum += mod;
            n /= 10;
        }
        return sum == 0;
    }

}
