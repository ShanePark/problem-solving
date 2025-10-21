package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my solution
 */
public class Q3346MaximumFrequencyOfAnElementAfterPerformingOperationsI2 {

    @Test
    public void test() {
        assertThat(maxFrequency(new int[]{1, 4, 5}, 1, 2)).isEqualTo(2);
        assertThat(maxFrequency(new int[]{5, 11, 20, 20}, 5, 1)).isEqualTo(2);
    }

    @Test
    public void test2() {
        assertThat(maxFrequency(new int[]{2, 49}, 97, 0)).isEqualTo(1);
        assertThat(maxFrequency(new int[]{2}, 7, 0)).isEqualTo(1);
        assertThat(maxFrequency(new int[]{1, 90}, 76, 1)).isEqualTo(1);
    }

    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);
        Map<Integer, Integer> count = new HashMap<>();
        int answer = 0;
        int left = 0;
        int right = 0;
        for (int n : nums) {
            while (right < nums.length && nums[right] <= n + k) {
                count.merge(nums[right], 1, Integer::sum);
                right++;
            }
            while (left < nums.length && nums[left] < n - k) {
                count.merge(nums[left], -1, Integer::sum);
                left++;
            }
            int cur = Math.min(right - left, count.getOrDefault(n, 0) + numOperations);
            answer = Math.max(answer, cur);
        }

        for (left = 0, right = 0; right < nums.length; right++) {
            while (nums[left] + 2 * k < nums[right]) {
                left++;
            }
            answer = Math.max(answer, Math.min(right - left + 1, numOperations));
        }
        return answer;
    }

}
