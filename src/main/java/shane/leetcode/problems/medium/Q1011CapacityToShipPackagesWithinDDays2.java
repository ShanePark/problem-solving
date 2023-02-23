package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 10 ms Beats 62.60%
 * Memory 54.5 MB Beats 5.90%
 */
public class Q1011CapacityToShipPackagesWithinDDays2 {

    @Test
    public void test() {
        assertThat(shipWithinDays(new int[]{5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, 8)).isEqualTo(10);
        assertThat(shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3)).isEqualTo(6);
        assertThat(shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5)).isEqualTo(15);
        assertThat(shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4)).isEqualTo(3);
    }

    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;

            int cnt = 1;
            int weight = 0;
            for (int w : weights) {
                if (weight + w > mid) {
                    weight = 0;
                    cnt++;
                }
                weight += w;
            }

            if (cnt <= days) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
