package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q440KthSmallestInLexicographicalOrder {

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

    long answer = -1;

    public int findKthNumber(int n, int k) {
        answer = -1;
        find(n, k, 0, 0);
        return (int) answer;
    }

    private int find(int n, int k, long prefix, int cnt) {
        for (int i = 0; i <= 9; i++) {
            long cur = prefix * 10L + i;
            if (cur == 0)
                continue;
            if (n < cur)
                return cnt;
            if (++cnt == k) {
                answer = cur;
                return k;
            }
            cnt = find(n, k, cur, cnt);
            if (cnt == k)
                return k;
        }
        return cnt;
    }

}
