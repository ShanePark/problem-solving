package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1922CountGoodNumbers {

    @Test
    public void test() {
        assertThat(countGoodNumbers(1)).isEqualTo(5);
        assertThat(countGoodNumbers(2)).isEqualTo(20);
        assertThat(countGoodNumbers(3)).isEqualTo(100);
        assertThat(countGoodNumbers(4)).isEqualTo(400);
        assertThat(countGoodNumbers(50)).isEqualTo(564908303);
    }

    final int MOD = (int) 1e9 + 7;

    public int countGoodNumbers(long n) {
        long pow5 = modPow(5, (n + 1) / 2);
        long pow4 = modPow(4, n / 2);
        return (int) (pow5 * pow4 % MOD);
    }

    private long modPow(long base, long exp) {
        long answer = 1;
        while (exp > 0) {
            if (exp % 2 == 1) {
                answer = answer * base % MOD;
            }
            base = (base * base) % MOD;
            exp /= 2;
        }
        return (int) answer;
    }


}
