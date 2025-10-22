package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class Q3347MaximumFrequencyOfAnElementAfterPerformingOperationsII {

    @Test
    public void test() {
        assertThat(maxFrequency(new int[]{1, 4, 5}, 1, 2)).isEqualTo(2);
        assertThat(maxFrequency(new int[]{5, 11, 20, 20}, 5, 1)).isEqualTo(2);
    }

    @Test
    public void test2() {
        assertThat(maxFrequency(new int[]{999999997, 999999999, 999999999}, 999999999, 2)).isEqualTo(3);
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
            while (left < nums.length && nums[left] + 2 * k < nums[right]) {
                left++;
            }
            answer = Math.max(answer, Math.min(right - left + 1, numOperations));
        }
        return answer;
    }

}
