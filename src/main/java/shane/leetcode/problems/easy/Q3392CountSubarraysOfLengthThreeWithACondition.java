package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 1
 * ms
 * Beats
 * 100.00%
 */
public class Q3392CountSubarraysOfLengthThreeWithACondition {

    @Test
    public void test() {
        assertThat(countSubarrays(new int[]{1, 2, 1, 4, 1})).isEqualTo(1);
        assertThat(countSubarrays(new int[]{1, 1, 1})).isEqualTo(0);
    }

    public int countSubarrays(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if ((nums[i] + nums[i + 2]) * 2 == nums[i + 1]) {
                sum++;
            }
        }
        return sum;
    }

}
