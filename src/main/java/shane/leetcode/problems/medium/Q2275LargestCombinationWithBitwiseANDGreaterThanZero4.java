package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 38ms Beats11.11%
 */
public class Q2275LargestCombinationWithBitwiseANDGreaterThanZero4 {

    @Test
    public void test() {
        assertThat(largestCombination(new int[]{16, 17, 71, 62, 12, 24, 14})).isEqualTo(4);
        assertThat(largestCombination(new int[]{8, 8})).isEqualTo(2);
    }

    public int largestCombination(int[] candidates) {
        int[] cnt = new int[31];
        for (int candidate : candidates) {
            String binary = Integer.toBinaryString(candidate);
            int length = binary.length();
            for (int i = 0; i < length; i++) {
                int bit = binary.charAt(length - i - 1) - '0';
                cnt[i] += bit;
            }
        }
        return Arrays.stream(cnt).max().getAsInt();
    }

}
