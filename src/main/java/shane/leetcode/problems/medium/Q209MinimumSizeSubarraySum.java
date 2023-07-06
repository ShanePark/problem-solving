package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Q209MinimumSizeSubarraySum {

    @Test
    void test() {
        assertThat(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3})).isEqualTo(2);
        assertThat(minSubArrayLen(4, new int[]{1, 4, 4})).isEqualTo(1);
        assertThat(minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1})).isEqualTo(0);
    }

    public int minSubArrayLen(int target, int[] nums) {
        if (Arrays.stream(nums).sum() < target)
            return 0;

        int answer = nums.length;
        int sum = 0;
        int left = 0;

        for (int right = left; right < nums.length; right++) {
            sum += nums[right];

            while (target <= sum) {
                int length = right - left + 1;
                answer = Math.min(answer, length);
                sum -= nums[left++];
            }
        }

        return answer;
    }

}
