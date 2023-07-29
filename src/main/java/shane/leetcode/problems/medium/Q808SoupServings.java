package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class Q808SoupServings {

    @Test
    void test() {
        assertThat(soupServings(1)).isEqualTo(0.62500);
        assertThat(soupServings(50)).isEqualTo(0.62500);
        assertThat(soupServings(100)).isEqualTo(0.71875);
    }

    public double soupServings(int n) {
        n = (int) Math.ceil((double) n / 25);
        Map<String, Double> dp = new HashMap<>();
        dp.put("0,0", 0.5);

        for (int k = 1; k <= n; k++) {
            dp.put(0 + "," + k, 1d);
            dp.put(k + "," + 0, 0d);
            for (int j = 1; j <= k; j++) {
                dp.put(j + "," + k, calculateDP(j, k, dp));
                dp.put(k + "," + j, calculateDP(k, j, dp));
            }
            if (dp.get(k + "," + k) > 1 - 1e-5) {
                return 1;
            }
        }

        return dp.get(n + "," + n);
    }

    private double calculateDP(int i, int j, Map<String, Double> dp) {
        return (dp.get(Math.max(0, i - 4) + "," + j)
                + dp.get(Math.max(0, i - 3) + "," + (j - 1))
                + dp.get(Math.max(0, i - 2) + "," + (Math.max(0, j - 2)))
                + dp.get(i - 1 + "," + Math.max(0, j - 3))) / 4;
    }

}
