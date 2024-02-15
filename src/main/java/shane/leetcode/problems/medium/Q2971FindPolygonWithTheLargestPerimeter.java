package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 30 ms Beats 30.37% of users with Java
 */
public class Q2971FindPolygonWithTheLargestPerimeter {

    @Test
    public void test() {
        assertThat(largestPerimeter(new int[]{5, 5, 5})).isEqualTo(15);
        assertThat(largestPerimeter(new int[]{1, 12, 1, 2, 5, 50, 3})).isEqualTo(12);
        assertThat(largestPerimeter(new int[]{5, 5, 50})).isEqualTo(-1);
    }

    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        long[] sum = new long[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }

        for (int i = nums.length - 2; i >= 1; i--) {
            if (sum[i] > nums[i + 1]) {
                return sum[i] + nums[i + 1];
            }
        }
        return -1;
    }

}

