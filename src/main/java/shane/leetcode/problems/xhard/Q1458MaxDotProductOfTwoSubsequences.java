package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 12ms Beats 50.00%of users with Java
 * Memory Details 45.96MB Beats 6.94%of users with Java
 */
public class Q1458MaxDotProductOfTwoSubsequences {

    @Test
    public void test() {
        assertThat(maxDotProduct(new int[]{2, 1, -2, 5}, new int[]{3, 0, -6})).isEqualTo(18);
        assertThat(maxDotProduct(new int[]{3, -2}, new int[]{2, -6, 7})).isEqualTo(21);
        assertThat(maxDotProduct(new int[]{-1, -1}, new int[]{1, 1})).isEqualTo(-1);
    }

    public int maxDotProduct(int[] nums1, int[] nums2) {
        Integer[][] dp = new Integer[nums1.length][nums2.length];
        return calc(nums1, 0, nums2, 0, dp);
    }

    private int calc(int[] nums1, int i, int[] nums2, int j, Integer[][] dp) {
        if (i == nums1.length || j == nums2.length)
            return -1000001;
        if (dp[i][j] != null)
            return dp[i][j];
        // count current
        int max = nums1[i] * nums2[j] + Integer.max(0, calc(nums1, i + 1, nums2, j + 1, dp));
        // skip i
        max = Math.max(max, calc(nums1, i + 1, nums2, j, dp));
        // skip j
        max = Math.max(max, calc(nums1, i, nums2, j + 1, dp));
        return dp[i][j] = max;
    }

}
