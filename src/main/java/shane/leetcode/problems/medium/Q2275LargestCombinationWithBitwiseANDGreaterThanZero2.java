package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 92 ms, faster than 12.59% of Java online submissions for Largest Combination With Bitwise AND Greater Than Zero.
 * Memory Usage: 83 MB, less than 44.08% of Java online submissions for Largest Combination With Bitwise AND Greater Than Zero.
 */
public class Q2275LargestCombinationWithBitwiseANDGreaterThanZero2 {

    @Test
    public void test() {
        assertThat(largestCombination(new int[]{5, 3, 4})).isEqualTo(2);
        assertThat(largestCombination(new int[]{16, 16, 48, 71, 62, 12, 24, 14, 17, 18, 19, 20, 10000})).isEqualTo(10);
        assertThat(largestCombination(new int[]{16, 17, 71, 62, 12, 24, 14})).isEqualTo(4);
        assertThat(largestCombination(new int[]{8, 8})).isEqualTo(2);
        assertThat(largestCombination(new int[]{8, 4})).isEqualTo(1);
    }

    public int largestCombination(int[] candidates) {
        int[] arr = new int[24];
        for (int candidate : candidates) {
            for (int i = 0; candidate > 0; i++, candidate >>= 1) {
                if (candidate % 2 == 1)
                    arr[i]++;
            }
        }
        return Arrays.stream(arr).max().getAsInt();
    }
}
