package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q629KInversePairsArray2 {

    @Test
    public void test() {
        assertThat(kInversePairs(3, 0)).isEqualTo(1);
        assertThat(kInversePairs(3, 1)).isEqualTo(2);
        assertThat(kInversePairs(2, 2)).isEqualTo(0);
    }

    @Test
    public void overflow() {
        assertThat(kInversePairs(1000, 1000)).isEqualTo(663677020);
    }

    final int MOD = (int) (1e9 + 7);

    public int kInversePairs(int n, int k) {
        long[] dp = new long[k + 1];
        dp[0] = 1;
        for (int i = 2; i <= n; i++) {
            long[] tmp = new long[k + 1];
            for (int j = 0; j <= k; j++) {
                long cur = (j == 0) ? 0 : tmp[j - 1];
                long diff = (j < i) ? 0 : dp[j - i];
                tmp[j] = (dp[j] + cur - diff + MOD) % MOD;
            }
            dp = tmp;
        }
        return (int) dp[k];
    }

}
