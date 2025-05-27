package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 0ms
 * Beats100.00%
 */
public class Q2894DivisibleAndNondivisibleSumsDifference {

    @Test
    public void test() {
        assertThat(differenceOfSums(10, 3)).isEqualTo(19);
        assertThat(differenceOfSums(5, 6)).isEqualTo(15);
        assertThat(differenceOfSums(5, 1)).isEqualTo(-15);
    }

    public int differenceOfSums(int n, int m) {
        int sum = (n + 1) * n / 2;
        for (int i = m; i <= n; i += m) {
            sum -= i * 2;
        }
        return sum;
    }

}
