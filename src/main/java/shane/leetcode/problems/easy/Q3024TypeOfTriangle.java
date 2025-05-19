package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 1
 * ms
 * Beats
 * 34.56%
 */
public class Q3024TypeOfTriangle {

    @Test
    public void test() {
        assertThat(triangleType(new int[]{3, 3, 3})).isEqualTo("equilateral");
        assertThat(triangleType(new int[]{3, 4, 5})).isEqualTo("scalene");
    }

    public String triangleType(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] + nums[1] <= nums[2])
            return "none";
        if (nums[0] == nums[2])
            return "equilateral";
        if (nums[0] == nums[1] || nums[1] == nums[2])
            return "isosceles";
        return "scalene";
    }

}
