package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 71 ms, faster than 6.32% of Java online submissions for Minimum Number of Operations to Reinitialize a Permutation.
 * Memory Usage: 41.1 MB, less than 53.68% of Java online submissions for Minimum Number of Operations to Reinitialize a Permutation.
 */
public class Q1806MinimumNumberOfOperationsToReinitializeAPermutation2 {

    @Test
    public void test() {
        assertThat(reinitializePermutation(2)).isEqualTo(1);
        assertThat(reinitializePermutation(4)).isEqualTo(2);
        assertThat(reinitializePermutation(6)).isEqualTo(4);
    }

    public int reinitializePermutation(int n) {
        int max = 0;
        for (int i = 0; i < n; i++) {
            int number = i;
            int cnt = 0;
            while (cnt == 0 || number != i) {
                if (number % 2 == 0) {
                    number /= 2;
                } else {
                    number = (n + number - 1) / 2;
                }
                cnt++;
            }
            max = Math.max(cnt, max);
        }
        return max;
    }

}
