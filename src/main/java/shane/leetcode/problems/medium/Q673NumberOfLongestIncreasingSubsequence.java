package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class Q673NumberOfLongestIncreasingSubsequence {

    @Test
    public void test() {
        assertThat(findNumberOfLIS(new int[]{1, 3, 5, 4, 7})).isEqualTo(2);
        assertThat(findNumberOfLIS(new int[]{2, 2, 2, 2, 2})).isEqualTo(5);
    }

    public int findNumberOfLIS(int[] nums) {
        final int LENGTH = nums.length;
        int[] lengths = new int[LENGTH];
        int[] counts = new int[LENGTH];
        Arrays.fill(counts, 1);
        int maxLength = 0;

        for (int after = 0; after < LENGTH; after++) {
            for (int before = 0; before < after; before++) {
                if (nums[before] >= nums[after]) {
                    continue;
                }
                int beforeLength = lengths[before];
                int afterLength = lengths[after];

                if (afterLength <= beforeLength) {
                    lengths[after] = beforeLength + 1;
                    maxLength = Math.max(maxLength, beforeLength + 1);
                    counts[after] = counts[before];
                }
                if (afterLength == beforeLength + 1) {
                    counts[after] += counts[before];
                }
            }
        }

        final int max = maxLength;

        return (int) IntStream.range(0, LENGTH)
                .filter(i -> lengths[i] == max)
                .mapToLong(i -> counts[i])
                .sum();
    }

}
