package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * MLE
 */
public class Q2338CountTheNumberOfIdealArrays {

    @Test
    public void test() {
        assertThat(idealArrays(2, 5)).isEqualTo(10);
        assertThat(idealArrays(5, 3)).isEqualTo(11);
        assertThat(idealArrays(184, 389)).isEqualTo(510488787);
    }

    @Test
    public void mle() {
        assertThat(idealArrays(9767, 9557)).isEqualTo(0);
    }

    final int MOD = (int) 1e9 + 7;

    public int idealArrays(int n, int maxValue) {
        Integer[][] dp = new Integer[n + 1][maxValue + 1];
        int answer = 0;
        for (int i = 1; i <= maxValue; i++) {
            answer = (answer + dfs(i, n, maxValue, dp)) % MOD;
        }
        return answer;
    }

    private int dfs(int cur, int length, int maxValue, Integer[][] dp) {
        if (length == 1)
            return 1;
        if (dp[length][cur] != null)
            return dp[length][cur];
        long sum = 0;
        for (int i = 1; cur * i <= maxValue; i++) {
            sum += dfs(cur * i, length - 1, maxValue, dp);
        }
        return dp[length][cur] = (int) (sum % MOD);
    }

}
