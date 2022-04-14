package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1827MinimumOperationsToMakeTheArrayIncreasing {
    @Test
    public void test() {
        assertThat(minOperations(new int[]{1, 5, 2, 4, 1})).isEqualTo(14);
        assertThat(minOperations(new int[]{8})).isEqualTo(0);
    }

    public int minOperations(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int sum = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] >= nums[i]) {
                int gap = nums[i - 1] - nums[i] + 1;
                nums[i] += gap;
                sum += gap;
            }
        }

        return sum;
    }
}
