package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my solution
 */
public class Q2929DistributeCandiesAmongChildrenII2 {

    @Test
    public void test() {
        assertThat(distributeCandies(5, 2)).isEqualTo(3);
        assertThat(distributeCandies(3, 3)).isEqualTo(10);
    }

    @Test
    public void edge() {
        assertThat(distributeCandies(1000000, 1000000)).isEqualTo(500001500001L);
    }

    public long distributeCandies(int n, int limit) {
        long result = 0;

        for (int k = 0; k <= 3; k++) {
            long remaining = n - (long) k * (limit + 1);
            if (remaining < 0)
                continue;
            int sign = (k % 2 == 0) ? 1 : -1;
            result += sign * comb(3, k) * comb(remaining + 2, 2);
        }
        return result;
    }

    private long comb(long n, long k) {
        if (n < k || k < 0)
            return 0;
        if (k == 0 || n == k)
            return 1;
        if (k == 1)
            return n;
        if (k == 2)
            return n * (n - 1) / 2;
        return n * (n - 1) * (n - 2) / 6;
    }

}
