package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my solution
 */
public class Q3405CountTheNumberOfArraysWithKMatchingAdjacentElements2 {

    @Test
    public void test() {
        assertThat(countGoodArrays(3, 2, 1)).isEqualTo(4);
        assertThat(countGoodArrays(4, 2, 2)).isEqualTo(6);
        assertThat(countGoodArrays(5, 2, 0)).isEqualTo(2);
    }

    @Test
    public void tle() {
        assertThat(countGoodArrays(8, 10, 2)).isEqualTo(12400290);
    }

    final int MOD = (int) 1e9 + 7;

    public int countGoodArrays(int n, int m, int k) {
        return (int) ((m * modPow(m - 1, n - k - 1) % MOD) * combination(n - 1, k) % MOD);
    }

    private long modPow(long base, int exp) {
        long result = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) result = (result * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return result;
    }

    private long combination(int n, int k) {
        if (k > n)
            return 0;
        long[] factorial = new long[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i % MOD;
        }

        return factorial[n] * (modPow(factorial[k], MOD - 2) * modPow(factorial[n - k], MOD - 2) % MOD) % MOD;
    }

}
