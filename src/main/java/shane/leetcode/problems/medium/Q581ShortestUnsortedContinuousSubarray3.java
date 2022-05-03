package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q581ShortestUnsortedContinuousSubarray3 {

    @Test
    public void test() {
        assertThat(findUnsortedSubarray(new int[]{1, 2, 3, 5, 4})).isEqualTo(2);
        assertThat(findUnsortedSubarray(new int[]{1, 3, 2, 2, 2})).isEqualTo(4);
        assertThat(findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15})).isEqualTo(5);
        assertThat(findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 1, 15})).isEqualTo(6);
        assertThat(findUnsortedSubarray(new int[]{1, 2, 3, 4})).isEqualTo(0);
        assertThat(findUnsortedSubarray(new int[]{4, 3, 2, 1})).isEqualTo(4);
        assertThat(findUnsortedSubarray(new int[]{1})).isEqualTo(0);
    }

    public int findUnsortedSubarray(int[] nums) {
        int start = -1, end = -1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if (nums[i] < max) {
                end = i;
            }
            min = Math.min(min, nums[nums.length - 1 - i]);
            if (nums[nums.length - 1 - i] > min) {
                start = nums.length - 1 - i;
            }
        }

        if (end < 0)
            return 0;

        return end - start + 1;
    }

}
