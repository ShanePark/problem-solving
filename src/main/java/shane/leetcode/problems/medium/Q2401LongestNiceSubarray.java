package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 6ms
 * Beats16.08%
 */
public class Q2401LongestNiceSubarray {

    @Test
    public void test() {
        assertThat(longestNiceSubarray(new int[]{3, 1, 5, 11, 13})).isEqualTo(1);
        assertThat(longestNiceSubarray(new int[]{1, 3, 8, 48, 10, 12})).isEqualTo(3);
    }

    public int longestNiceSubarray(int[] nums) {
        int right = 0;
        int max = 1;
        int or = 0;
        for (int left = 0; left < nums.length; left++) {
            right = Math.max(left, right);
            or |= nums[left];
            while (right < nums.length - 1 && (or & nums[right + 1]) == 0) {
                right++;
                or += nums[right];
            }
            max = Math.max(max, right - left + 1);
            or ^= nums[left];
        }
        return max;
    }

}
