package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q799ChampagneTower3 {

    @Test
    void test() {
        Assertions.assertThat(champagneTower(1, 1, 1)).isEqualTo(0.00000);
        Assertions.assertThat(champagneTower(2, 1, 1)).isEqualTo(0.50000);
        Assertions.assertThat(champagneTower(100000009, 33, 17)).isEqualTo(1.00000);
    }

    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] dp = new double[query_row + 2];
        dp[0] = poured;
        for (int i = 1; i <= query_row; i++) {
            for (int j = i; j >= 0; j--) {
                double before = Math.max(0, dp[j] - 1);
                dp[j] = before / 2;
                dp[j + 1] += dp[j];
            }
        }

        return Math.min(dp[query_glass], 1);
    }

}
