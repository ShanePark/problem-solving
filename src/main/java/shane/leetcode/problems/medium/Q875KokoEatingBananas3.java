package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 39 ms Beats 55.10%
 * Memory 43.5 MB Beats 27.66%
 */
public class Q875KokoEatingBananas3 {

    @Test
    public void test() {
        assertThat(minEatingSpeed(new int[]{3, 6, 7, 11}, 8)).isEqualTo(4);
        assertThat(minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5)).isEqualTo(30);
        assertThat(minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6)).isEqualTo(23);
        assertThat(minEatingSpeed(new int[]{(int) 1e9}, 1)).isEqualTo((int) 1e9);
    }

    public int minEatingSpeed(int[] piles, int h) {
        int left = 0;
        int right = Integer.MAX_VALUE;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int takenTime = calcHour(piles, mid);
            if (h < takenTime) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int calcHour(int[] piles, int speed) {
        int cnt = 0;
        for (int pile : piles) {
            cnt += Math.ceil((double) pile / speed);
        }
        return cnt;
    }

}
