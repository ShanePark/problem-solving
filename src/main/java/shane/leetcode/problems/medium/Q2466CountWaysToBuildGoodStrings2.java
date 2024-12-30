package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Runtime 8ms Beats76.17%
 */
public class Q2466CountWaysToBuildGoodStrings2 {

    @Test
    void test() {
        assertThat(countGoodStrings(3, 3, 1, 1)).isEqualTo(8);
        assertThat(countGoodStrings(2, 3, 1, 2)).isEqualTo(5);
    }

    final int MOD = (int) 1e9 + 7;

    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        dp[0] = 1;
        for (int i = 0; i <= high; i++) {
            if (i + zero <= high) {
                dp[i + zero] = (dp[i + zero] + dp[i]) % MOD;
            }
            if (i + one <= high) {
                dp[i + one] = (dp[i + one] + dp[i]) % MOD;
            }
        }

        int answer = 0;
        for (int i = low; i <= high; i++) {
            answer = (answer + dp[i]) % MOD;
        }
        return answer;
    }

}
