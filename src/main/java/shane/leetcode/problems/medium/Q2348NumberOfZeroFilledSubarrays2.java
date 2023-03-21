package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 3 ms Beats 99.69%
 * Memory 60 MB Beats 41.69%
 */
public class Q2348NumberOfZeroFilledSubarrays2 {

    @Test
    public void test() {
        assertThat(zeroFilledSubarray(new int[]{1, 3, 0, 0, 2, 0, 0, 4})).isEqualTo(6);
        assertThat(zeroFilledSubarray(new int[]{0, 0, 0, 2, 0, 0})).isEqualTo(9);
        assertThat(zeroFilledSubarray(new int[]{0, 0})).isEqualTo(3);
    }

    public long zeroFilledSubarray(int[] nums) {
        int curCount = 0;
        long answer = 0;
        for (int num : nums) {
            if (num == 0) {
                answer += ++curCount;
                continue;
            }
            curCount = 0;
        }
        return answer;
    }

}
