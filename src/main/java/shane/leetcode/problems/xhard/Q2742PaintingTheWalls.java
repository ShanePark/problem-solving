package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my solution
 */
public class Q2742PaintingTheWalls {

    @Test
    public void test() {
        assertThat(paintWalls(new int[]{1, 2, 3, 2}, new int[]{1, 2, 3, 2})).isEqualTo(3);
        assertThat(paintWalls(new int[]{2, 3, 4, 2}, new int[]{1, 1, 1, 1})).isEqualTo(4);
    }

    public int paintWalls(int[] cost, int[] time) {
        int[] dp = new int[cost.length + 1];
        Arrays.fill(dp, 1_000_000 * 500);
        dp[0] = 0;

        for (int i = 0; i < cost.length; i++) {
            for (int j = cost.length; j > 0; j--) {
                int paid = dp[Math.max(j - time[i] - 1, 0)] + cost[i];
                dp[j] = Math.min(dp[j], paid);
            }
        }

        return dp[cost.length];
    }

}
