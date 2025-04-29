package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 5
 * ms
 * Beats
 * 84.53%
 */
public class Q2962CountSubarraysWhereMaxElementAppearsAtLeastKTimes2 {

    @Test
    public void test() {
        assertThat(countSubarrays(new int[]{1, 3, 2, 3, 3}, 2)).isEqualTo(6);
        assertThat(countSubarrays(new int[]{1, 4, 2, 1}, 3)).isEqualTo(0);
    }

    public long countSubarrays(int[] nums, int k) {
        int max = findMax(nums);
        int cnt = 0;
        long answer = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            while (j < nums.length && cnt < k) {
                if (nums[j++] == max) {
                    cnt++;
                }
            }
            if (cnt < k)
                break;
            answer += nums.length - (j - 1);
            if (nums[i] == max)
                cnt--;
        }
        return answer;
    }

    private int findMax(int[] nums) {
        int max = -1;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }

}
