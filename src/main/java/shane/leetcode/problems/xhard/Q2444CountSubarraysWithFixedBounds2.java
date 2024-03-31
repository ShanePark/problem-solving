package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2444CountSubarraysWithFixedBounds2 {

    @Test
    void test() {
        assertThat(countSubarrays(new int[]{1, 3, 5, 2, 7, 5}, 1, 5)).isEqualTo(2);
        assertThat(countSubarrays(new int[]{1, 1, 1, 1}, 1, 1)).isEqualTo(10);
    }

    public long countSubarrays(int[] nums, int minK, int maxK) {
        long answer = 0L;
        int invalid = -1;
        int min = -1;
        int max = -1;

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < minK || nums[i] > maxK) {
                invalid = i;
                continue;
            }
            min = (nums[i] == minK) ? i : min;
            max = (nums[i] == maxK) ? i : max;

            if (invalid < min && invalid < max) {
                answer += Math.min(min, max) - invalid;
            }
        }
        return answer;
    }

}
