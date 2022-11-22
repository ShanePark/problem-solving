package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q279PerfectSquares3 {

    @Test
    public void test() {
        assertThat(numSquares(12)).isEqualTo(3);
        assertThat(numSquares(3)).isEqualTo(3);
        assertThat(numSquares(13)).isEqualTo(2);
        assertThat(numSquares(32)).isEqualTo(2);
    }

    /**
     * 295ms
     */
    @Test
    public void tle() {
        assertThat(numSquares(5238)).isEqualTo(3);
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i * i <= n; i++) {
            dp[i * i] = 1;
        }

        return find(dp, n);

    }

    private int find(int[] dp, int n) {
        if (dp[n] != 0)
            return dp[n];
        int min = n;
        for (int i = 1; i < n - 1; i++) {
            int value = find(dp, i) + find(dp, n - i);
            min = Math.min(min, value);
        }
        dp[n] = min;
        return min;
    }

}
