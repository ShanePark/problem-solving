package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 59 ms, faster than 13.68% of Java online submissions for Minimum Number of Operations to Reinitialize a Permutation.
 * Memory Usage: 67.1 MB, less than 6.32% of Java online submissions for Minimum Number of Operations to Reinitialize a Permutation.
 */
@SuppressWarnings("ALL")
public class Q1806MinimumNumberOfOperationsToReinitializeAPermutation3 {

    @Test
    public void test() {
        assertThat(reinitializePermutation(2)).isEqualTo(1);
        assertThat(reinitializePermutation(4)).isEqualTo(2);
        assertThat(reinitializePermutation(6)).isEqualTo(4);
    }

    public int reinitializePermutation(int n) {
        int[][] dp = new int[n][n];
        int max = 1;
        for (int i = 0; i < n - 1; i++) {
            int number = i;
            int cnt = 0;
            while (cnt == 0 || number != i) {
                if (dp[number][i] > 0) {
                    cnt += dp[number][i];
                    break;
                }
                if (number % 2 == 0) {
                    number /= 2;
                } else {
                    number = (n + number - 1) / 2;
                }
                dp[i][number] = cnt++;
            }
            max = Math.max(max, cnt);
        }
        return max;
    }

}
