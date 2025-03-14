package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 10ms
 * Beats100.00%
 */
public class Q2226MaximumCandiesAllocatedToKChildren {

    @Test
    public void test() {
        assertThat(maximumCandies(new int[]{5, 8, 6}, 3)).isEqualTo(5);
        assertThat(maximumCandies(new int[]{2, 5}, 11)).isEqualTo(0);
    }

    public int maximumCandies(int[] candies, long k) {
        long sum = 0;
        for (int candy : candies) {
            sum += candy;
        }
        if (sum < k)
            return 0;
        if (sum == k)
            return 1;
        int left = 0;
        int right = (int) (sum / k);
        while (left < right) {
            int mid = left + (right - left) / 2 + 1;
            if (isPossible(candies, k, mid)) {
                left = mid;
                continue;
            }
            right = mid - 1;
        }
        return left;
    }

    private boolean isPossible(int[] candies, long k, int perOneChild) {
        for (int candy : candies) {
            k -= candy / perOneChild;
            if (k <= 0)
                return true;
        }
        return false;
    }

}
