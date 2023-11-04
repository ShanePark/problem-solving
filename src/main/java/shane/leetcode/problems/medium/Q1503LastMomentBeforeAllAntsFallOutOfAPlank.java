package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 3ms Beats 20.88%of users with Java
 * Memory Details 43.73MB Beats 42.86%of users with Java
 */
public class Q1503LastMomentBeforeAllAntsFallOutOfAPlank {

    @Test
    public void test() {
        assertThat(getLastMoment(4, new int[]{4, 3}, new int[]{0, 1})).isEqualTo(4);
        assertThat(getLastMoment(7, new int[]{}, new int[]{0, 1, 2, 3, 4, 5, 6, 7})).isEqualTo(7);
        assertThat(getLastMoment(7, new int[]{0, 1, 2, 3, 4, 5, 6, 7}, new int[]{})).isEqualTo(7);
    }

    public int getLastMoment(int n, int[] left, int[] right) {
        int leftMax = Arrays.stream(left).max().orElse(0);
        int rightMax = n - Arrays.stream(right).min().orElse(n);
        return Math.max(leftMax, rightMax);
    }

}
