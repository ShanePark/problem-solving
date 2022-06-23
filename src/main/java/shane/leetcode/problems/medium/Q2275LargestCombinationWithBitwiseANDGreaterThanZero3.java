package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 39 ms, faster than 82.01% of Java online submissions for Largest Combination With Bitwise AND Greater Than Zero.
 * Memory Usage: 76.7 MB, less than 57.69% of Java online submissions for Largest Combination With Bitwise AND Greater Than Zero.
 */
public class Q2275LargestCombinationWithBitwiseANDGreaterThanZero3 {

    @Test
    public void test() {
        assertThat(largestCombination(new int[]{8388608})).isEqualTo(1);
        assertThat(largestCombination(new int[]{5, 3, 4})).isEqualTo(2);
        assertThat(largestCombination(new int[]{16, 16, 48, 71, 62, 12, 24, 14, 17, 18, 19, 20, 10000})).isEqualTo(10);
        assertThat(largestCombination(new int[]{16, 17, 71, 62, 12, 24, 14})).isEqualTo(4);
        assertThat(largestCombination(new int[]{8, 8})).isEqualTo(2);
        assertThat(largestCombination(new int[]{8, 4})).isEqualTo(1);
    }

    public int largestCombination(int[] candidates) {
        int max = 0;
        for (int i = 1; i <= 1e7; i *= 2) {
            int cnt = 0;
            for (int candidate : candidates) {
                if ((candidate & i) > 0)
                    cnt++;
            }
            max = Math.max(cnt, max);
        }
        return max;
    }
}
