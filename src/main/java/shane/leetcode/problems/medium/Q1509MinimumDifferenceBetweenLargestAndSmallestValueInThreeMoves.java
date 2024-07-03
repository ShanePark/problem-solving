package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime15msBeats96.06%
 */
public class Q1509MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {

    @Test
    public void test() {
        assertThat(minDifference(new int[]{6, 6, 0, 1, 1, 4, 6})).isEqualTo(2);
        assertThat(minDifference(new int[]{1, 5, 0, 10, 14})).isEqualTo(1);
        assertThat(minDifference(new int[]{5, 3, 2, 4})).isEqualTo(0);
        assertThat(minDifference(new int[]{3, 100, 20})).isEqualTo(0);
    }

    public int minDifference(int[] nums) {
        if (nums.length <= 4)
            return 0;
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 4;
        int min = Integer.MAX_VALUE;
        while (right < nums.length) {
            min = Math.min(min, nums[right] - nums[left]);
            left++;
            right++;
        }
        return min;
    }

}
