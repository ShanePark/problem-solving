package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q3346MaximumFrequencyOfAnElementAfterPerformingOperationsI {

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
        int min = nums[0];
        int max = nums[nums.length - 1];
        int answer = 0;
        for (int i = min; i <= max; i++) {
            answer = Math.max(answer, cnt(nums, i, k, numOperations));
        }
        return answer;
    }

    private int cnt(int[] nums, int target, int k, int numOperations) {
        int cnt = 0;
        for (int num : nums) {
            if (num == target) {
                cnt++;
                continue;
            }
            if (num + k < target)
                continue;
            if (numOperations == 0 && target < num)
                break;
            if (num - k > target)
                break;
            if (numOperations > 0) {
                cnt++;
                numOperations--;
            }
        }
        return cnt;
    }

}
