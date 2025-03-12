package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 0ms
 * Beats100.00%
 */
public class Q2529MaximumCountOfPositiveIntegerAndNegativeInteger {

    @Test
    public void test() {
        assertThat(maximumCount(new int[]{-2, -1, -1, 1, 2, 3})).isEqualTo(3);
        assertThat(maximumCount(new int[]{-3, -2, -1, 0, 0, 1, 2})).isEqualTo(3);
        assertThat(maximumCount(new int[]{5, 20, 66, 1314})).isEqualTo(4);

    }

    public int maximumCount(int[] nums) {
        int p = 0;
        int n = 0;
        for (int num : nums) {
            if (num < 0) {
                n++;
                continue;
            }
            if (num > 0)
                p++;
        }
        return Math.max(p, n);
    }

}
