package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 14 ms, faster than 25.92% of Java online submissions for Largest Perimeter Triangle.
 * Memory Usage: 54.6 MB, less than 24.74% of Java online submissions for Largest Perimeter Triangle.
 */
public class Q976LargestPerimeterTriangle {

    @Test
    public void test() {
        assertThat(largestPerimeter(new int[]{3, 2, 3, 4})).isEqualTo(10);
        assertThat(largestPerimeter(new int[]{2, 1, 2})).isEqualTo(5);
        assertThat(largestPerimeter(new int[]{1, 2, 1})).isEqualTo(0);
    }

    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i] < nums[i - 1] + nums[i - 2]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        return 0;
    }

}
