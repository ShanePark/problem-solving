package shane.leetcode.problems.medium;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * it should be `hard` problem. still not understand well
 */
public class Q837New21Game {

    @Test
    public void test() {
        Offset<Double> offset = Offset.offset(0.00001);

        assertThat(new21Game(12, 1, 10)).isCloseTo(1.0000, offset);
        assertThat(new21Game(10, 1, 10)).isCloseTo(1.0000, offset);
        assertThat(new21Game(6, 1, 10)).isCloseTo(0.60000, offset);
        assertThat(new21Game(21, 17, 10)).isCloseTo(0.73278, offset);
        assertThat(new21Game(1, 0, 10)).isCloseTo(1, offset);
    }

    @Test
    public void edge() {
        assertThat(new21Game(10000, 10000, 10000));
    }

    public double new21Game(int validTarget, int stopPoint, int range) {
        if (stopPoint == 0)
            return 1;

        double dp[] = new double[validTarget + 1];
        dp[0] = 1;
        double windowSum = 1;

        for (int i = 1; i <= validTarget; i++) {
            dp[i] = windowSum / range;
            if (i < stopPoint) {
                windowSum += dp[i];
            }
            if (i >= range && i - range < stopPoint) {
                windowSum -= dp[i - range];
            }
        }
        double ans = 0;
        for (int i = stopPoint; i <= validTarget; i++) {
            ans += dp[i];
        }
        return ans;
    }


}
