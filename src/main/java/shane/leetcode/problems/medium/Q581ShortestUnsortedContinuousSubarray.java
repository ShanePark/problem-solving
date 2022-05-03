package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Q581ShortestUnsortedContinuousSubarray {

    @Test
    public void test() {
        assertThat(findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15})).isEqualTo(5);
        assertThat(findUnsortedSubarray(new int[]{1, 2, 3, 4})).isEqualTo(0);
        assertThat(findUnsortedSubarray(new int[]{1})).isEqualTo(0);
    }

    public int findUnsortedSubarray(int[] nums) {
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);

        if (Arrays.equals(nums, sorted))
            return 0;

        int left = 0;
        int right = nums.length - 1;
        while (nums[left] == sorted[left] && left < nums.length - 1) {
            left++;
        }
        while (nums[right] == sorted[right] && right > 0) {
            right--;
        }

        return right - left + 1;
    }

}
