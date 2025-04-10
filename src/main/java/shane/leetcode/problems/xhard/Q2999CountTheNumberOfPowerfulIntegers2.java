package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my answer
 */
public class Q2999CountTheNumberOfPowerfulIntegers2 {

    @Test
    public void test() {
        assertThat(numberOfPowerfulInt(1, 6000, 4, "124")).isEqualTo(5);
        assertThat(numberOfPowerfulInt(15, 215, 6, "10")).isEqualTo(2);
        assertThat(numberOfPowerfulInt(1000, 2000, 4, "3000")).isEqualTo(0);
    }

    @Test
    public void tle() {
        assertThat(numberOfPowerfulInt(15398, 1_424_153_842, 8, "220")).isEqualTo(783790L);
    }

    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        return countPowerful(finish, limit, s, new StringBuilder()) - countPowerful(start - 1, limit, s, new StringBuilder());
    }

    private long countPowerful(long num, int limit, String suffix, StringBuilder dpPrefix) {
        String numStr = String.valueOf(num);
        int totalLen = numStr.length();
        int suffixLen = suffix.length();

        if (suffixLen > totalLen)
            return 0;

        int prefixLen = totalLen - suffixLen;
        return dfs(0, true, numStr.substring(0, prefixLen), limit, new Long[prefixLen + 1][2], suffix, num, dpPrefix);
    }

    private long dfs(int digitIndex, boolean tight, String prefixTarget, int limit, Long[][] dp, String suffix, long max, StringBuilder dpPrefix) {
        if (digitIndex == prefixTarget.length()) {
            return Long.parseLong(dpPrefix + suffix) <= max ? 1 : 0;
        }

        if (dp[digitIndex][tight ? 1 : 0] != null)
            return dp[digitIndex][tight ? 1 : 0];

        int maxDigit = tight ? prefixTarget.charAt(digitIndex) - '0' : limit;
        long count = 0;

        for (int i = 0; i <= maxDigit; i++) {
            if (i > limit) continue;
            dpPrefix.append((char) ('0' + i));
            count += dfs(digitIndex + 1, tight && (i == maxDigit), prefixTarget, limit, dp, suffix, max, dpPrefix);
            dpPrefix.setLength(dpPrefix.length() - 1);
        }

        dp[digitIndex][tight ? 1 : 0] = count;
        return count;
    }

}

