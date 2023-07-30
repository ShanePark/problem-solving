package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my solution
 */
public class Q664StrangePrinter {

    @Test
    void test() {
        assertThat(strangePrinter("aaabbb")).isEqualTo(2);
        assertThat(strangePrinter("aba")).isEqualTo(2);
        assertThat(strangePrinter("aaaabcbaa")).isEqualTo(3);
    }

    public int strangePrinter(String s) {
        int LENGTH = s.length();

        int[][] dp = new int[LENGTH][LENGTH];
        for (int i = 0; i < LENGTH; i++) {
            dp[i][i] = 1;
        }

        for (int size = 1; size < LENGTH; size++) {
            for (int start = 0; size + start < LENGTH; start++) {
                int end = start + size;
                dp[start][end] = size + 1;
                for (int i = start + 1; i <= end; i++) {
                    int cnt = dp[start][i - 1] + dp[i][end];
                    if (s.charAt(i - 1) == s.charAt(end)) {
                        cnt--;
                    }
                    dp[start][end] = Math.min(dp[start][end], cnt);
                }
            }
        }
        return dp[0][LENGTH - 1];
    }

}
