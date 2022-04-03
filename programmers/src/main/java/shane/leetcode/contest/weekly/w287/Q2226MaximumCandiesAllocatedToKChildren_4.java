package shane.leetcode.contest.weekly.w287;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2226MaximumCandiesAllocatedToKChildren_4 {

    @Test
    public void test() {
        assertThat(maximumCandies(new int[]{5, 8, 6}, 3)).isEqualTo(5);
        assertThat(maximumCandies(new int[]{2, 5}, 11)).isEqualTo(0);
        assertThat(maximumCandies(new int[]{2, 5}, 7)).isEqualTo(1);
        assertThat(maximumCandies(new int[]{4, 5, 7}, 4)).isEqualTo(3);
        assertThat(maximumCandies(new int[]{1, 2, 3}, 1_000_000_000_000L)).isEqualTo(0);
        assertThat(maximumCandies(new int[]{1, 2, 3, 4, 10}, 5)).isEqualTo(3);
        assertThat(maximumCandies(new int[]{4, 7, 5}, 16)).isEqualTo(1);
    }

    public int maximumCandies(int[] candies, long k) {
        double sum = 0;

        for (int candy : candies) {
            sum += candy;
        }

        int left = sum >= k ? 1 : 0;
        int right = (int) (sum / k);

        Arrays.sort(candies);

        while (left < right) {
            int mid = (left + right) / 2 + 1;
            if (valid(candies, mid, k)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left;

    }

    private boolean valid(int[] candies, int min, long k) {
        long cnt = 0;
        for (int candy : candies) {
            cnt += candy / min;
            if (cnt >= k)
                return true;
        }
        return false;
    }

}
