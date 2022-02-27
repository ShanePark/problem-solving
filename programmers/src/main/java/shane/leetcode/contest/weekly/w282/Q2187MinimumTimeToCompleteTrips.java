package shane.leetcode.contest.weekly.w282;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Q2187MinimumTimeToCompleteTrips {

    @Test
    void test() {
        Assertions.assertThat(minimumTime(new int[]{1, 2, 3}, 5)).isEqualTo(3);
        Assertions.assertThat(minimumTime(new int[]{2}, 1)).isEqualTo(2);
        Assertions.assertThat(minimumTime(new int[]{39, 82, 69, 37, 78, 14, 93, 36, 66, 61, 13, 58, 57, 12, 70, 14, 67, 75, 91, 1, 34, 68, 73, 50, 13, 40, 81, 21, 79, 12, 35, 18, 71, 43, 5, 50, 37, 16, 15, 6, 61, 7, 87, 43, 27, 62, 95, 45, 82, 100, 15, 74, 33, 95, 38, 88, 91, 47, 22, 82, 51, 19, 10, 24, 87, 38, 5, 91, 10, 36, 56, 86, 48, 92, 10, 26, 63, 2, 50, 88, 9, 83, 20, 42, 59, 55, 8, 15, 48, 25
        }, 4187)).isEqualTo(858);
        Assertions.assertThat(minimumTime(new int[]{10000}, 10000000)).isEqualTo(10000 * 10000000L);
        Assertions.assertThat(minimumTime(new int[]{Integer.MAX_VALUE}, (int) Math.pow(10, 7))).isEqualTo(Integer.MAX_VALUE * (long) Math.pow(10, 7));
        Assertions.assertThat(minimumTime(new int[]{Integer.MAX_VALUE}, 1)).isEqualTo(Integer.MAX_VALUE);
        Assertions.assertThat(minimumTime(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE}, (int) Math.pow(10, 7))).isEqualTo(Integer.MAX_VALUE * (long) Math.pow(10, 7) / 2);
        int[] arr = new int[100000];
        Arrays.fill(arr, 1);
        Assertions.assertThat(minimumTime(arr, 10000000)).isEqualTo(100);

    }

    public long minimumTime(int[] time, int totalTrips) {

        if (time == null || totalTrips <= 0)
            return 0;

        if (time.length == 1) {
            return (long) time[0] * totalTrips;
        }

        long left = 0;
        long right = Integer.MAX_VALUE * (long) Math.pow(10, 7);

        while (left < right) {
            long mid = (left + right) / 2;
            if (calcTrips(time, mid) >= totalTrips) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private double calcTrips(int[] time, long n) {
        double cnt = 0;
        for (int i : time) {
            cnt += n / i;
        }
        return cnt;
    }


}
