package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1235MaximumProfitInJobScheduling {


    @Test
    public void test() {
        assertThat(jobScheduling(new int[]{1, 2, 3, 3}, new int[]{3, 4, 5, 6}, new int[]{50, 10, 40, 70})).isEqualTo(120);
        assertThat(jobScheduling(new int[]{1, 2, 3, 4, 6}, new int[]{3, 5, 10, 6, 9}, new int[]{20, 20, 100, 70, 60})).isEqualTo(150);
        assertThat(jobScheduling(new int[]{1, 1, 1}, new int[]{2, 3, 4}, new int[]{5, 6, 4})).isEqualTo(6);
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<Job> jobs = new ArrayList<>();
        final int SIZE = startTime.length;
        for (int i = 0; i < SIZE; i++) {
            jobs.add(new Job(startTime[i], endTime[i], profit[i]));
        }
        jobs.sort(Comparator.comparingInt(o -> o.start));

        int[] dp = new int[SIZE];
        dp[SIZE - 1] = jobs.get(SIZE - 1).profit;
        for (int cur = SIZE - 2; cur >= 0; cur--) {
            int next = findNext(cur, jobs);
            dp[cur] = Math.max(jobs.get(cur).profit + (next == -1 ? 0 : dp[next]), dp[cur + 1]);
        }
        return dp[0];
    }

    private int findNext(int cur, List<Job> jobs) {
        for (int next = cur + 1; next < jobs.size(); next++) {
            if (jobs.get(next).start >= jobs.get(cur).end) {
                return next;
            }
        }
        return -1;
    }

    class Job {
        int start;
        int end;
        int profit;

        public Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }

}
