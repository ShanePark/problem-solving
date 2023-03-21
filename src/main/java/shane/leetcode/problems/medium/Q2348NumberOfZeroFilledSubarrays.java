package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 12 ms Beats 5.64%
 * Memory 72.9 MB Beats 10.3%
 */
public class Q2348NumberOfZeroFilledSubarrays {

    @Test
    public void test() {
        assertThat(zeroFilledSubarray(new int[]{1, 3, 0, 0, 2, 0, 0, 4})).isEqualTo(6);
        assertThat(zeroFilledSubarray(new int[]{0, 0, 0, 2, 0, 0})).isEqualTo(9);
        assertThat(zeroFilledSubarray(new int[]{0, 0})).isEqualTo(3);
    }

    public long zeroFilledSubarray(int[] nums) {
        int curCount = 0;
        long answer = 0;
        long[] dp = new long[nums.length + 1];
        for (int num : nums) {
            if (num != 0) {
                answer += calcDp(dp, curCount);
                curCount = 0;
                continue;
            }
            curCount++;
        }
        return answer + calcDp(dp, curCount);
    }

    private long calcDp(long[] dp, int curCount) {
        if (curCount == 0)
            return 0;
        if (dp[curCount] > 0)
            return dp[curCount];
        dp[curCount] = calcDp(dp, curCount - 1) + curCount;
        return dp[curCount];
    }

}
