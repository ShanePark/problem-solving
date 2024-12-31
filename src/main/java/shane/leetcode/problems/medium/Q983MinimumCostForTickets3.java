package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime1msBeats79.45%
 */
public class Q983MinimumCostForTickets3 {

    @Test
    public void test() {
        assertThat(mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15})).isEqualTo(11);
        assertThat(mincostTickets(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31}, new int[]{2, 7, 15})).isEqualTo(17);
    }

    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days[days.length - 1] + 1];
        for (int i = 0; i < days.length; i++) {
            int day = days[i];

            int min = calc(day, Ticket.ONE_DAY, costs, dp);
            min = Math.min(min, calc(day, Ticket.SEVEN_DAYS, costs, dp));
            min = Math.min(min, calc(day, Ticket.THIRTY_DAYS, costs, dp));

            dp[day++] = min;
            if (i == days.length - 1)
                continue;
            for (; day < days[i + 1]; day++) {
                dp[day] = min;
            }
        }
        return dp[dp.length - 1];
    }

    private int calc(int day, Ticket ticket, int[] costs, int[] dp) {
        int priceBefore = day < ticket.days ? 0 : dp[day - ticket.days];
        return priceBefore + costs[ticket.costIndex];
    }

    enum Ticket {
        ONE_DAY(1, 0),
        SEVEN_DAYS(7, 1),
        THIRTY_DAYS(30, 2);

        final int days;
        final int costIndex;

        Ticket(int days, int costIndex) {
            this.days = days;
            this.costIndex = costIndex;
        }
    }

}
