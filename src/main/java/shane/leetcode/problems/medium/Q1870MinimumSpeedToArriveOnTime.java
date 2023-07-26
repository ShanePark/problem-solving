package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 190 ms Beats 74.39%
 * Memory 59 MB Beats 68.17%
 */
public class Q1870MinimumSpeedToArriveOnTime {

    @Test
    public void test() {
        assertThat(minSpeedOnTime(new int[]{5, 3, 1}, 2.01)).isEqualTo(100);
        assertThat(minSpeedOnTime(new int[]{1, 5}, 1.09)).isEqualTo(56);
        assertThat(minSpeedOnTime(new int[]{1, 1}, 1.0)).isEqualTo(-1);
        assertThat(minSpeedOnTime(new int[]{1, 1, 100000}, 2.01)).isEqualTo(10000000);
        assertThat(minSpeedOnTime(new int[]{2, 1, 5, 4, 4, 3, 2, 9, 2, 10}, 734452549.14)).isEqualTo(1);
        assertThat(minSpeedOnTime(new int[]{2, 1, 5, 4, 4, 3, 2, 9, 2, 10}, 75.12)).isEqualTo(1);
        assertThat(minSpeedOnTime(new int[]{1, 3, 2}, 2.7)).isEqualTo(3);
        assertThat(minSpeedOnTime(new int[]{1, 3, 2}, 6)).isEqualTo(1);
        assertThat(minSpeedOnTime(new int[]{1, 3, 2}, 1.9)).isEqualTo(-1);
    }

    public int minSpeedOnTime(int[] dist, double hour) {
        if (dist.length >= hour + 1)
            return -1;

        long hour100 = Math.round(hour * 100);

        int left = 1;
        int right = 10_000_000;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (possible(dist, hour100, mid)) {
                right = mid;
                continue;
            }
            left = mid + 1;

        }
        return left;
    }

    private boolean possible(int[] dist, long hour100, int speed) {
        int length = dist.length;
        for (int i = 0; i < length - 1; i++) {
            double time = (double) dist[i] / speed;
            int ceil = (int) Math.ceil(time);
            hour100 -= ceil * 100;
        }
        return dist[length - 1] * 100 <= hour100 * speed;
    }

}
