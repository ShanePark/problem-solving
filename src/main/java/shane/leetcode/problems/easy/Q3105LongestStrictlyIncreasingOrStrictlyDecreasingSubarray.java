package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 1ms
 * Beats93.94%
 */
public class Q3105LongestStrictlyIncreasingOrStrictlyDecreasingSubarray {

    @Test
    public void est() {
        assertThat(longestMonotonicSubarray(new int[]{1, 4, 3, 3, 2})).isEqualTo(2);
        assertThat(longestMonotonicSubarray(new int[]{3, 3, 3, 3})).isEqualTo(1);
        assertThat(longestMonotonicSubarray(new int[]{3, 2, 1})).isEqualTo(3);
    }

    public int longestMonotonicSubarray(int[] nums) {
        int beforeNum = nums[0];
        Status status = Status.NONE;
        int curLen = 1;
        int maxLen = curLen;
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            if (beforeNum == cur) {
                curLen = 1;
                status = Status.NONE;
                continue;
            }
            if ((status == Status.INCREASING && cur < beforeNum) || (status == Status.DECREASING && beforeNum < cur)) {
                curLen = 1;
                status = Status.NONE;
                i--;
                continue;
            }
            if (status == Status.NONE) {
                status = cur < beforeNum ? Status.DECREASING : Status.INCREASING;
            }
            curLen++;
            beforeNum = cur;
            maxLen = Math.max(curLen, maxLen);
        }

        return maxLen;
    }

    enum Status {
        INCREASING,
        DECREASING,
        NONE,
    }

}
