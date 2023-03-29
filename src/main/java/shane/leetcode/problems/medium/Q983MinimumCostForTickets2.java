package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 1 ms Beats 77.14%
 * Memory 40.8 MB Beats 42.84%
 */
public class Q983MinimumCostForTickets2 {

    @Test
    public void test() {
        assertThat(mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15})).isEqualTo(11);
        assertThat(mincostTickets(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31}, new int[]{2, 7, 15})).isEqualTo(17);
    }

    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length - 1];
        int[] dp = new int[lastDay + 1];
        for (int day : days) {
            dp[day] = -1;
        }

        for (int day = 1; day <= lastDay; day++) {
            if (dp[day] == -1) {
                dp[day] = dp[Math.max(0, day - 1)] + costs[0];
                dp[day] = Math.min(dp[day], dp[Math.max(0, day - 7)] + costs[1]);
                dp[day] = Math.min(dp[day], dp[Math.max(0, day - 30)] + costs[2]);
                continue;
            }
            dp[day] = dp[day - 1];
        }
        return dp[lastDay];
    }

}
