package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 1001ms Beats 8.17%of users with Java
 * Memory Details 56.03MB Beats 44.64%of users with Java
 */
public class Q1235MaximumProfitInJobScheduling3 {


    @Test
    public void test() {
        assertThat(jobScheduling(new int[]{1, 2, 3, 4, 6}, new int[]{3, 5, 10, 6, 9}, new int[]{20, 20, 100, 70, 60})).isEqualTo(150);
        assertThat(jobScheduling(new int[]{1, 2, 3, 3}, new int[]{3, 4, 5, 6}, new int[]{50, 10, 40, 70})).isEqualTo(120);
        assertThat(jobScheduling(new int[]{1, 1, 1}, new int[]{2, 3, 4}, new int[]{5, 6, 4})).isEqualTo(6);
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        final int LENGTH = startTime.length;

        int[][] jobs = new int[LENGTH][3];
        for (int i = 0; i < LENGTH; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, Comparator.comparingInt(o -> o[1]));

        int[] dp = new int[LENGTH];
        dp[0] = jobs[0][2];

        for (int i = 1; i < LENGTH; i++) {
            int maxBefore = findMaxBefore(i, jobs);
            int calc = jobs[i][2] + (maxBefore == -1 ? 0 : dp[maxBefore]);
            dp[i] = Math.max(calc, dp[i - 1]);
        }
        return dp[LENGTH - 1];
    }

    private int findMaxBefore(int cur, int[][] jobs) {
        int[] curJob = jobs[cur];
        for (int i = cur - 1; i >= 0; i--) {
            int[] job = jobs[i];
            if (job[1] <= curJob[0]) {
                return i;
            }
        }
        return -1;
    }

}
