package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2221FindTriangularSumOfAnArray {

    @Test
    public void test() {
        assertThat(triangularSum(new int[]{1, 2, 3, 4, 5})).isEqualTo(8);
        assertThat(triangularSum(new int[]{5})).isEqualTo(5);
    }

    public int triangularSum(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int[] arr = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            arr[i] = (nums[i] + nums[i + 1]) % 10;
        }
        return triangularSum(arr);
    }
}
