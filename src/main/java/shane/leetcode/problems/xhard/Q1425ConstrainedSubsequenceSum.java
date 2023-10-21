package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q1425ConstrainedSubsequenceSum {

    @Test
    public void test() {
        assertThat(constrainedSubsetSum(new int[]{10, 2, -10, 5, 20}, 2)).isEqualTo(37);
        assertThat(constrainedSubsetSum(new int[]{-1, -2, -3}, 1)).isEqualTo(-1);
        assertThat(constrainedSubsetSum(new int[]{10, -2, -10, -5, 20}, 2)).isEqualTo(23);
    }

    /**
     * 622 ms
     */
    @Test
    public void tle() {
        int[] arr = new int[(int) 1e5];
        assertThat(constrainedSubsetSum(arr, (int) 1e4)).isEqualTo(0);
    }

    public int constrainedSubsetSum(int[] nums, int k) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int curMax = 0;
            for (int j = Math.max(0, i - k); j < i; j++) {
                curMax = Math.max(curMax, nums[j]);
            }
            nums[i] += curMax;
            max = Math.max(max, nums[i]);
        }
        return max;
    }

}
