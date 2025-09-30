package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 43ms
 * Beats55.42%
 */
public class Q2221FindTriangularSumOfAnArray3 {

    @Test
    public void test() {
        assertThat(triangularSum(new int[]{1, 2, 3, 4, 5})).isEqualTo(8);
        assertThat(triangularSum(new int[]{5})).isEqualTo(5);
    }

    public int triangularSum(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                nums[j] = (nums[j] + nums[j + 1]) % 10;
            }
        }
        return nums[0];
    }

}
