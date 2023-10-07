package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q1420BuildArrayWhereYouCanFindTheMaximumExactlyKComparisons {

    @Test
    public void test() {
        assertThat(numOfArrays(2, 3, 1)).isEqualTo(6);
        assertThat(numOfArrays(5, 2, 3)).isEqualTo(0);
        assertThat(numOfArrays(9, 1, 1)).isEqualTo(1);
    }

    public int numOfArrays(int n, int m, int k) {
        return numOfArrays(n, m, k, -1);
    }

    private int numOfArrays(int n, int m, int k, int beforeMax) {
        if (n == 0 && k == 0)
            return 1;
        if (n == 0 || k < 0)
            return 0;
        int sum = 0;
        for (int cur = 1; cur <= m; cur++) {
            if (beforeMax < cur) {
                sum += numOfArrays(n - 1, m, k - 1, cur);
                continue;
            }
            sum += numOfArrays(n - 1, m, k, beforeMax);
        }
        return sum;
    }

}
