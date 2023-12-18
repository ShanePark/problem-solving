package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 6ms Beats 78.29%of users with Java
 * Memory Details 44.33MB Beats 36.94%of users with Java
 */
public class Q1913MaximumProductDifferenceBetweenTwoPairs2 {

    @Test
    public void test() {
        assertThat(maxProductDifference(new int[]{5, 6, 2, 7, 4})).isEqualTo(34);
        assertThat(maxProductDifference(new int[]{4, 2, 5, 9, 7, 4, 8})).isEqualTo(64);
    }

    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        return nums[length - 1] * nums[length - 2] - nums[0] * nums[1];
    }

}
