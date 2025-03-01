package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 0
 * ms
 * Beats
 * 100.00%
 */
public class Q2460ApplyOperationsToAnArray {

    @Test
    public void test() {
        assertThat(applyOperations(new int[]{1, 2, 2, 1, 1, 0})).containsExactly(1, 4, 2, 0, 0, 0);
        assertThat(applyOperations(new int[]{0, 1})).containsExactly(1, 0);
    }

    public int[] applyOperations(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1])
                continue;
            nums[i] *= 2;
            nums[i + 1] = 0;
            i++;
        }
        return shift(nums);
    }

    private int[] shift(int[] nums) {
        int[] result = new int[nums.length];
        int i = 0;
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            result[i++] = num;
        }
        return result;
    }

}
