package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 226 ms Beats 70.04% of users with Java
 */
public class Q552StudentAttendanceRecordII {

    @Test
    public void test() {
        assertThat(checkRecord(2)).isEqualTo(8);
        assertThat(checkRecord(1)).isEqualTo(3);
        assertThat(checkRecord(10101)).isEqualTo(183236316);
    }

    final int MOD = (int) 1e9 + 7;

    public int checkRecord(int n) {
        long[][] dp = new long[2][3]; // [0]absent, [1]late
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            long[][] next = new long[2][3];
            // 1. Absent
            next[1][0] += dp[0][0] + dp[0][1] + dp[0][2];

            // 2. Late
            next[0][1] += dp[0][0];
            next[0][2] += dp[0][1];
            next[1][1] = dp[1][0];
            next[1][2] = dp[1][1];

            // 3. Present
            next[0][0] += dp[0][0] + dp[0][1] + dp[0][2];
            next[1][0] += dp[1][0] + dp[1][1] + dp[1][2];

            // MOD
            for (long[] longs : next) {
                for (int j = 0; j < longs.length; j++) {
                    longs[j] %= MOD;
                }
            }

            dp = next;
        }
        return (int) ((sum(dp[0]) + sum(dp[1])) % MOD);
    }

    private long sum(long[] ints) {
        long sum = 0;
        for (long n : ints) {
            sum = (sum + n) % MOD;
        }
        return sum;
    }

}
