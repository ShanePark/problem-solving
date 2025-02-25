package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 35ms
 * Beats5.42%
 */
public class Q1524NumberOfSubarraysWithOddSum {

    @Test
    public void test() {
        assertThat(numOfSubarrays(new int[]{1, 2, 3, 4, 5, 6, 7})).isEqualTo(16);
        assertThat(numOfSubarrays(new int[]{1, 3, 5})).isEqualTo(4);
        assertThat(numOfSubarrays(new int[]{2, 4, 6})).isEqualTo(0);
    }


    final int MOD = (int) (1e9) + 7;

    public int numOfSubarrays(int[] arr) {
        long[][] dp = new long[arr.length][2];
        dp[0][arr[0] % 2]++;
        for (int i = 1; i < arr.length; i++) {
            long newOddCntLast = i == 1 ? dp[i - 1][1] : (dp[i - 1][1] - dp[i - 2][1]);
            long newEvenCntLast = i == 1 ? dp[i - 1][0] : (dp[i - 1][0] - dp[i - 2][0]);
            boolean isOdd = (arr[i] % 2) == 1;
            if (!isOdd) {
                dp[i][1] = dp[i - 1][1] + newOddCntLast;
                dp[i][0] = dp[i - 1][0] + newEvenCntLast + 1;
            } else {
                dp[i][1] = dp[i - 1][1] + newEvenCntLast + 1;
                dp[i][0] = dp[i - 1][0] + newOddCntLast;
            }
        }
        return (int) (dp[dp.length - 1][1] % MOD);
    }


}
