package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 13 ms Beats 27.79%
 * Memory 54.1 MB Beats 9.51%
 */
public class Q1011CapacityToShipPackagesWithinDDays {

    @Test
    public void test() {
        assertThat(shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3)).isEqualTo(6);
        assertThat(shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5)).isEqualTo(15);
        assertThat(shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4)).isEqualTo(3);
    }

    public int shipWithinDays(int[] weights, int days) {
        int left = 1;
        int right = 500 * 5 * 10000;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int day = calcDays(weights, mid);
            if (0 < day && day <= days) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int calcDays(int[] weights, int maxWeight) {
        int cnt = 0;
        int weight = 0;
        for (int w : weights) {
            if (maxWeight < w) {
                return -1;
            } else if (weight + w > maxWeight) {
                weight = 0;
                cnt++;
            }
            weight += w;
        }
        return weight > 0 ? cnt + 1 : cnt;
    }

}
