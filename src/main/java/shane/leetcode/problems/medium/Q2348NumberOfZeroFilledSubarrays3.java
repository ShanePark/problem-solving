package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 3ms
 * Beats94.03%
 */
public class Q2348NumberOfZeroFilledSubarrays3 {

    @Test
    public void test() {
        assertThat(zeroFilledSubarray(new int[]{1, 3, 0, 0, 2, 0, 0, 4})).isEqualTo(6);
        assertThat(zeroFilledSubarray(new int[]{0, 0, 0, 2, 0, 0})).isEqualTo(9);
        assertThat(zeroFilledSubarray(new int[]{2, 10, 2019})).isEqualTo(0);
    }

    public long zeroFilledSubarray(int[] nums) {
        long len = 0;
        long sum = 0;
        for (int num : nums) {
            if (num == 0) {
                len++;
                continue;
            }
            sum += (len * (len + 1) / 2);
            len = 0;
        }
        sum += (len * (len + 1) / 2);
        return sum;
    }

}
