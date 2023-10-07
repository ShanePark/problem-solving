package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 61ms Beats 65.85%of users with Java
 * Memory Details 42.70MB Beats 53.66%of users with Java
 */
public class Q1420BuildArrayWhereYouCanFindTheMaximumExactlyKComparisons2 {

    @Test
    public void test() {
        assertThat(numOfArrays(2, 3, 1)).isEqualTo(6);
        assertThat(numOfArrays(5, 2, 3)).isEqualTo(0);
        assertThat(numOfArrays(9, 1, 1)).isEqualTo(1);
    }

    @Test
    public void tle() {
        assertThat(numOfArrays(50, 100, 25)).isEqualTo(34549172);
    }

    public int numOfArrays(int n, int m, int k) {
        Integer[][][] dp = new Integer[n + 1][n + 1][m + 1];
        return numOfArrays(n, m, k, 0, dp);
    }

    private int numOfArrays(int n, int m, int k, int beforeMax, Integer[][][] dp) {
        if (n == 0 && k == 0)
            return 1;
        if (n == 0 || k < 0)
            return 0;
        if (dp[n][k][beforeMax] != null)
            return dp[n][k][beforeMax];
        long sum = 0;
        for (int cur = 1; cur <= m; cur++) {
            if (beforeMax < cur) {
                sum += numOfArrays(n - 1, m, k - 1, cur, dp);
                continue;
            }
            sum += numOfArrays(n - 1, m, k, beforeMax, dp);
        }
        return dp[n][k][beforeMax] = (int) (sum % (int) (1e9 + 7));
    }

}
