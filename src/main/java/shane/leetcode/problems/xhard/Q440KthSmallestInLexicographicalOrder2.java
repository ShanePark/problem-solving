package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not Mine
 */
public class Q440KthSmallestInLexicographicalOrder2 {

    @Test
    public void test() {
        assertThat(findKthNumber(13, 2)).isEqualTo(10);
        assertThat(findKthNumber(1, 1)).isEqualTo(1);
        assertThat(findKthNumber(681692778, 351251360)).isEqualTo(416126219);
    }

    @Test
    public void tle() {
        assertThat(findKthNumber(719885387, 209989719)).isEqualTo(288990744);
    }

    public int findKthNumber(int n, int k) {
        int cur = 1;
        k--;

        while (k > 0) {
            int steps = countSteps(n, cur);
            if (steps <= k) {
                cur++;
                k -= steps;
                continue;
            }
            cur *= 10;
            k--;
        }
        return cur;
    }

    private int countSteps(int n, long prefix) {
        int steps = 0;
        long next = prefix + 1;
        while (prefix <= n) {
            long rangeEnd = Math.min(n + 1, next);
            steps += (int) (rangeEnd - prefix);
            prefix *= 10;
            next *= 10;
        }
        return steps;
    }

}
