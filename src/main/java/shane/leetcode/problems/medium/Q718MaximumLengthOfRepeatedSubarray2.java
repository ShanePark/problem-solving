package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 143 ms, faster than 11.40% of Java online submissions for Maximum Length of Repeated Subarray.
 * Memory Usage: 82.3 MB, less than 14.71% of Java online submissions for Maximum Length of Repeated Subarray.
 */
@SuppressWarnings("ALL")
public class Q718MaximumLengthOfRepeatedSubarray2 {

    @Test
    public void test() {
        assertThat(findLength(new int[]{0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, new int[]{0, 0, 0, 0, 0, 0, 0, 1, 0, 0})).isEqualTo(9);
        assertThat(findLength(new int[]{70, 39, 25, 40, 7}, new int[]{52, 20, 67, 5, 31})).isEqualTo(0);
        assertThat(findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7})).isEqualTo(3);
        assertThat(findLength(new int[]{0, 0, 0, 0, 0}, new int[]{0, 0, 0, 0, 0})).isEqualTo(5);
    }

    public int findLength(int[] nums1, int[] nums2) {
        if (nums1.length * nums2.length == 0)
            return 0;
        int[][] memo = new int[nums1.length][nums2.length];
        int max = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    int before = (i > 0 && j > 0) ? memo[i - 1][j - 1] : 0;
                    memo[i][j] = 1 + before;
                } else {
                    memo[i][j] = 0;
                }
                max = Math.max(max, memo[i][j]);
            }
        }
        return max;
    }
}
