package shane.leetcode.problems.medium;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q837New21Game2 {
    Offset<Double> offset = Offset.offset(0.00001);

    @Test
    public void test() {
        assertThat(new21Game(10, 1, 10)).isCloseTo(1.0000, offset);
        assertThat(new21Game(6, 1, 10)).isCloseTo(0.60000, offset);
        assertThat(new21Game(21, 17, 10)).isCloseTo(0.73278, offset);
    }

    @Test
    public void edge() {
        assertThat(new21Game(1, 0, 1)).isCloseTo(1, offset);
        assertThat(new21Game(10000, 10000, 10000));
    }

    public double new21Game(int n, int k, int maxPts) {
        if (k == 0)
            return 1;
        double[] dp = new double[n + 1];
        dp[0] = 1;
        double curSum = 1;

        for (int i = 1; i <= n; i++) {
            dp[i] = curSum / maxPts;
            if (i < k) {
                curSum += dp[i];
            }
            if (maxPts <= i && i < k + maxPts) {
                curSum -= dp[i - maxPts];
            }
        }
        double ans = 0;
        for (int i = k; i <= n; i++) {
            ans += dp[i];
        }
        return ans;
    }


}
