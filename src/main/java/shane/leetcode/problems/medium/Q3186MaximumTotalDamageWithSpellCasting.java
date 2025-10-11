package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Q3186MaximumTotalDamageWithSpellCasting {

    @Test
    public void test() {
        assertThat(maximumTotalDamage(new int[]{1, 1, 3, 4})).isEqualTo(6);
        assertThat(maximumTotalDamage(new int[]{7, 1, 6, 6})).isEqualTo(13);
    }

    public long maximumTotalDamage(int[] power) {
        Arrays.sort(power);
        long[] dp = new long[power.length + 1];
        long maxDp = 0;
        long answer = 0;
        for (int i = 0, j = 0; i < power.length; i++) {
            if (power[i] == power[Math.max(0, i - 1)]) {
                answer = Math.max(answer, (dp[i + 1] = power[i] + dp[i]));
                continue;
            }
            while (power[j] + 2 < power[i])
                maxDp = Math.max(maxDp, dp[++j]);
            answer = Math.max(answer, (dp[i + 1] = power[i] + maxDp));
        }
        return answer;
    }

}
