package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 6 ms Beats 5.53%
 * Memory 53.4 MB Beats 11.97%
 */
public class Q1493LongestSubarrayOf1sAfterDeletingOneElement {

    @Test
    void test() {
        assertThat(longestSubarray(new int[]{1, 1, 0})).isEqualTo(2);
        assertThat(longestSubarray(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1})).isEqualTo(5);
        assertThat(longestSubarray(new int[]{1, 1, 1})).isEqualTo(2);
        assertThat(longestSubarray(new int[]{0, 0, 1, 1})).isEqualTo(2);
        assertThat(longestSubarray(new int[]{1, 1, 0, 1})).isEqualTo(3);
    }

    public int longestSubarray(int[] nums) {
        int onlyOne = 0;
        int oneZero = 0;
        int hasZeroInAdvance = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 1) {
                onlyOne++;
                if (oneZero != 0) {
                    oneZero++;
                }
                if (hasZeroInAdvance > 0 || i > 0) {
                    hasZeroInAdvance++;
                }
            } else {
                oneZero = onlyOne;
                onlyOne = 0;
                hasZeroInAdvance = 0;
            }
            max = Math.max(max, onlyOne - 1);
            max = Math.max(max, hasZeroInAdvance);
            max = Math.max(max, oneZero);
        }
        return max;
    }

}
