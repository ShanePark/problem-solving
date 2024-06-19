package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 16msBeats95.37%
 */
public class Q1482MinimumNumberOfDaysToMakeMBouquets {

    @Test
    public void test() {
        assertThat(minDays(new int[]{1, 10, 2, 9, 3, 8, 4, 7, 5, 6}, 4, 2)).isEqualTo(9);
        assertThat(minDays(new int[]{1, 10, 3, 10, 2}, 3, 1)).isEqualTo(3);
        assertThat(minDays(new int[]{1, 10, 3, 10, 2}, 3, 2)).isEqualTo(-1);
        assertThat(minDays(new int[]{7, 7, 7, 7, 12, 7, 7}, 2, 3)).isEqualTo(12);
    }

    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < (long) m * k)
            return -1;
        int left = 0;
        int right = 0;
        for (int i : bloomDay) {
            right = Math.max(right, i);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (possible(bloomDay, m, k, mid)) {
                right = mid;
                continue;
            }
            left = mid + 1;
        }
        return left;
    }

    private boolean possible(int[] bloomDay, int m, int k, int day) {
        int count = 0;
        for (int i : bloomDay) {
            if (day < i) {
                count = 0;
                continue;
            }
            if (++count == k) {
                count = 0;
                if (--m == 0) {
                    return true;
                }
            }
        }
        return false;
    }

}
