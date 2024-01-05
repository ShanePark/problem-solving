package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 9ms Beats 76.61%of users with Java
 * Memory Details 44.16MB Beats 26.18%of users with Java
 */
public class Q300LongestIncreasingSubsequence2 {

    @Test
    public void test() {
        assertThat(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18})).isEqualTo(4);
        assertThat(lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3})).isEqualTo(4);
        assertThat(lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7})).isEqualTo(1);
    }

    public int lengthOfLIS(int[] nums) {
        int[] mins = new int[nums.length];
        int maxLength = 1;
        mins[0] = nums[0];

        for (int num : nums) {
            mins[0] = Math.min(mins[0], num);
            for (int i = 0; i < maxLength; i++) {
                if (mins[i] < num) {
                    if (i == maxLength - 1) {
                        maxLength++;
                        mins[i + 1] = num;
                    }
                    if ((num < mins[i + 1])) {
                        mins[i + 1] = num;
                    }
                }
            }
        }
        return maxLength;
    }

}
