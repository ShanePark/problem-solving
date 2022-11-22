package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 162 ms Beats 24.80%
 * Memory 41.4 MB Beats 91.81%
 */
public class Q279PerfectSquares4 {

    @Test
    public void test() {
        assertThat(numSquares(12)).isEqualTo(3);
        assertThat(numSquares(3)).isEqualTo(3);
        assertThat(numSquares(13)).isEqualTo(2);
        assertThat(numSquares(32)).isEqualTo(2);
    }

    @Test
    public void tle() {
        assertThat(numSquares(5238)).isEqualTo(3);
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (i == j * j) {
                    dp[i] = 1;
                    break;
                }
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

}
