package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 6 ms Beats 20.98% of users with Java
 */
public class Q713SubarrayProductLessThanK {

    @Test
    public void test() {
        assertThat(numSubarrayProductLessThanK(new int[]{57, 44, 92, 28, 66, 60, 37, 33, 52, 38, 29, 76, 8, 75, 22}, 18)).isEqualTo(1);
        assertThat(numSubarrayProductLessThanK(new int[]{10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3}, 19)).isEqualTo(18);
        assertThat(numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100)).isEqualTo(8);
        assertThat(numSubarrayProductLessThanK(new int[]{1, 2, 3}, 0)).isEqualTo(0);
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int mul = nums[0];
        int cnt = 0;
        while (left < nums.length) {
            if (mul < k) {
                // move right
                while (right < nums.length - 1 && mul * nums[right + 1] < k) {
                    mul *= nums[++right];
                }

                // add cnt
                int length = right - left + 1;
                cnt += length;
            }

            if (left == right && left < nums.length - 1) {
                mul *= nums[++right];
            }
            mul /= nums[left++];
        }
        return cnt;
    }

}
