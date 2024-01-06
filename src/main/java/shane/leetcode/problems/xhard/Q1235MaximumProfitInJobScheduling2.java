package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Time Limit Exceeded
 * 30 / 31 testcases passed
 */
public class Q1235MaximumProfitInJobScheduling2 {


    @Test
    public void test() {
        assertThat(jobScheduling(new int[]{1, 2, 3, 4, 6}, new int[]{3, 5, 10, 6, 9}, new int[]{20, 20, 100, 70, 60})).isEqualTo(150);
        assertThat(jobScheduling(new int[]{1, 2, 3, 3}, new int[]{3, 4, 5, 6}, new int[]{50, 10, 40, 70})).isEqualTo(120);
        assertThat(jobScheduling(new int[]{1, 1, 1}, new int[]{2, 3, 4}, new int[]{5, 6, 4})).isEqualTo(6);
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        final int LENGTH = startTime.length;

        List<Job> jobs = IntStream.range(0, LENGTH)
                .mapToObj(i -> new Job(startTime[i], endTime[i], profit[i]))
                .sorted()
                .collect(Collectors.toList());

        int[] dp = new int[LENGTH];
        dp[0] = jobs.get(0).profit;

        for (int i = 1; i < LENGTH; i++) {
            int maxBefore = findMaxBefore(i, jobs);
            int calc = jobs.get(i).profit + (maxBefore == -1 ? 0 : dp[maxBefore]);
            dp[i] = Math.max(calc, dp[i - 1]);
        }
        return dp[LENGTH - 1];
    }

    private int findMaxBefore(int cur, List<Job> jobs) {
        Job curJob = jobs.get(cur);
        for (int i = cur - 1; i >= 0; i--) {
            Job job = jobs.get(i);
            if (job.end <= curJob.start) {
                return i;
            }
        }
        return -1;
    }

    class Job implements Comparable<Job> {
        int start;
        int end;
        int profit;

        public Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }

        public int compareTo(Job o) {
            return this.end - o.end;
        }

        @Override
        public String toString() {
            return "Job{" +
                    "start=" + start +
                    ", end=" + end +
                    ", profit=" + profit +
                    '}';
        }
    }

}
