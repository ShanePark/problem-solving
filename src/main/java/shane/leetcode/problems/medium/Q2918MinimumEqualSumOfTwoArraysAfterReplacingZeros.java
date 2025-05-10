package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 3
 * ms
 * Beats
 * 88.73%
 */
public class Q2918MinimumEqualSumOfTwoArraysAfterReplacingZeros {

    @Test
    public void test() {
        assertThat(minSum(new int[]{3, 2, 0, 1, 0}, new int[]{6, 5, 0})).isEqualTo(12);
        assertThat(minSum(new int[]{2, 0, 2, 0}, new int[]{1, 4})).isEqualTo(-1);
    }

    public long minSum(int[] nums1, int[] nums2) {
        long leftSum = 0;
        int leftZeroCnt = 0;
        long rightSum = 0;
        int rightZeroCnt = 0;
        for (int i : nums1) {
            leftSum += i;
            if (i == 0)
                leftZeroCnt++;
        }
        for (int i : nums2) {
            rightSum += i;
            if (i == 0)
                rightZeroCnt++;
        }
        long answer = Math.max(leftSum + leftZeroCnt, rightSum + rightZeroCnt);
        if ((leftSum < answer && leftZeroCnt == 0) || (rightSum < answer && rightZeroCnt == 0))
            return -1;
        return answer;
    }

}
