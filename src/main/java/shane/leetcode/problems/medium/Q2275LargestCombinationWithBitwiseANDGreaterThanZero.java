package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 117 ms, faster than 10.19% of Java online submissions for Largest Combination With Bitwise AND Greater Than Zero.
 * Memory Usage: 80.8 MB, less than 54.48% of Java online submissions for Largest Combination With Bitwise AND Greater Than Zero.
 */
public class Q2275LargestCombinationWithBitwiseANDGreaterThanZero {

    @Test
    public void test() {
        assertThat(largestCombination(new int[]{5, 3, 4})).isEqualTo(2);
        assertThat(largestCombination(new int[]{16, 16, 48, 71, 62, 12, 24, 14, 17, 18, 19, 20, 10000})).isEqualTo(10);
        assertThat(largestCombination(new int[]{16, 17, 71, 62, 12, 24, 14})).isEqualTo(4);
        assertThat(largestCombination(new int[]{8, 8})).isEqualTo(2);
    }

    public int largestCombination(int[] candidates) {
        int maxLength = Integer.toBinaryString((int) 1e7).length();
        int[] arr = new int[maxLength];
        for (int candidate : candidates) {
            String binary = Integer.toBinaryString(candidate);
            int length = binary.length();
            for (int i = 0; i < length; i++) {
                if (binary.charAt(length - 1 - i) == '1') {
                    arr[i]++;
                }
            }
        }
        return Arrays.stream(arr).max().getAsInt();
    }
}
