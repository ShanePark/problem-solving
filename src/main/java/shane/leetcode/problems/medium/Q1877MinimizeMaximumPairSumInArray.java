package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1877MinimizeMaximumPairSumInArray {

    @Test
    public void test() {
        assertThat(minPairSum(new int[]{3, 5, 2, 3})).isEqualTo(7);
        assertThat(minPairSum(new int[]{3, 5, 4, 2, 4, 6})).isEqualTo(8);
    }

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            max = Math.max(max, nums[i] + nums[nums.length - 1 - i]);
        }
        return max;
    }
}
