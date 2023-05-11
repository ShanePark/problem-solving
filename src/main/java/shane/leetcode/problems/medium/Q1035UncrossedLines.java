package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 5 ms Beats 92.56% Memory 42.7 MB Beats 11.17%
 */
public class Q1035UncrossedLines {

    @Test
    public void test() {
        assertThat(maxUncrossedLines(new int[]{2, 5, 1, 2, 5}, new int[]{10, 5, 2, 1, 5, 2})).isEqualTo(3);
        assertThat(maxUncrossedLines(new int[]{1, 1, 2, 1, 2}, new int[]{1, 3, 2, 3, 1})).isEqualTo(3);
        assertThat(maxUncrossedLines(new int[]{1, 4, 2}, new int[]{1, 2, 4})).isEqualTo(2);
        assertThat(maxUncrossedLines(new int[]{1, 3, 7, 1, 7, 5}, new int[]{1, 9, 2, 5, 1})).isEqualTo(2);
    }

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;

        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                if (nums1[i] == nums2[j]) {
                    dp[i + 1][j + 1] = 1 + dp[i][j];
                }
            }
        }

        return dp[length1][length2];
    }

}
