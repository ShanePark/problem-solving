package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * ## Not my solution
 */
public class Q629KInversePairsArray {

    @Test
    public void test() {
        assertThat(kInversePairs(3, 0)).isEqualTo(1);
    }

    @Test
    public void test2() {
        assertThat(kInversePairs(3, 1)).isEqualTo(2);
    }

    @Test
    public void test3() {
        assertThat(kInversePairs(2, 2)).isEqualTo(0);
    }

    public int kInversePairs(int n, int k) {
        int dp[] = new int[k + 1];
        dp[0] = 1;
        for (int i = 2; i <= n; i++) {
            int curr[] = new int[k + 1];
            for (int j = 0; j < k + 1; j++) {
                long cur = j == 0 ? 0 : curr[j - 1];
                long diff = j >= i ? dp[j - i] : 0;
                curr[j] = (int) ((dp[j] + cur - diff + 1000000007) % 1000000007);
            }
            dp = curr;
        }
        return dp[k];
    }
}
