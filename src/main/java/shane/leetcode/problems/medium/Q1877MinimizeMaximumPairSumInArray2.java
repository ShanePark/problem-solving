package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 55ms Beats 21.75%of users with Java
 * Memory Details 58.18MB Beats 6.44%of users with Java
 */
public class Q1877MinimizeMaximumPairSumInArray2 {

    @Test
    public void test() {
        assertThat(minPairSum(new int[]{3, 5, 2, 3})).isEqualTo(7);
        assertThat(minPairSum(new int[]{3, 5, 4, 2, 4, 6})).isEqualTo(8);
    }

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            int sum = nums[i] + nums[nums.length - 1 - i];
            max = Math.max(max, sum);
        }
        return max;
    }

}
