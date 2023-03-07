package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 377 ms Beats 32.90%
 * Memory 55.2 MB Beats 96.73%
 */
public class Q2187MinimumTimeToCompleteTrips {

    @Test
    public void test() {
        assertThat(minimumTime(new int[]{1, 2, 3}, 5)).isEqualTo(3);
        assertThat(minimumTime(new int[]{2}, 1)).isEqualTo(2);
        assertThat(minimumTime(new int[]{10000000}, 10000000)).isEqualTo(100000000000000L);
    }

    public long minimumTime(int[] time, int totalTrips) {
        long left = 1;
        long right = (long) 1e14;
        while (left < right) {
            long mid = left + (right - left) / 2;
            long trip = calcTrip(time, mid);
            if (trip < totalTrips) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private long calcTrip(int[] time, long totalTime) {
        long sum = 0;
        for (int t : time) {
            sum += totalTime / t;
        }
        return sum;
    }

}
