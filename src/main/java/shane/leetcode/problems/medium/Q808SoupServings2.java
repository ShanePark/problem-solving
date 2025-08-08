package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q808SoupServings2 {

    @Test
    void test() {
        assertThat(soupServings(50)).isEqualTo(0.62500);
        assertThat(soupServings(100)).isEqualTo(0.71875);
    }

    public double soupServings(int n) {
        if (n == 0) return 0.5;
        if (n > 4800) return 1.0;

        int m = (int) Math.ceil(n / 25.0);
        double[][] dp = new double[m + 1][m + 1];
        dp[0][0] = 0.5;

        for (int k = 1; k <= m; k++) {
            dp[0][k] = 1.0;
            dp[k][0] = 0.0;
            for (int j = 1; j <= k; j++) {
                dp[j][k] = calculateDP(j, k, dp);
                dp[k][j] = calculateDP(k, j, dp);
            }
            if (dp[k][k] > 1 - 1e-5) {
                return 1.0;
            }
        }

        return dp[m][m];
    }

    private double calculateDP(int i, int j, double[][] dp) {
        return (get(dp, i - 4, j)
                + get(dp, i - 3, j - 1)
                + get(dp, i - 2, j - 2)
                + get(dp, i - 1, j - 3)) / 4.0;
    }

    private double get(double[][] dp, int i, int j) {
        if (i <= 0 && j <= 0) return 0.5;
        if (i <= 0) return 1.0;
        if (j <= 0) return 0.0;
        return dp[i][j];
    }
}
