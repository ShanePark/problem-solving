package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q3405CountTheNumberOfArraysWithKMatchingAdjacentElements {

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
        int answer = 0;
        for (int i = 1; i <= m; i++) {
            answer = (answer + next(i, n - 1, m, k)) % MOD;
        }
        return answer;
    }

    private int next(int before, int n, int m, int k) {
        if (k < 0)
            return 0;
        if (n == 0) {
            if (k == 0) {
                return 1;
            }
            return 0;
        }
        int answer = 0;
        for (int i = 1; i <= m; i++) {
            answer = (answer + next(i, n - 1, m, before == i ? k - 1 : k)) % MOD;
        }
        return answer;
    }

}
