package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 3ms
 * Beats35.02%
 */
public class Q2302CountSubarraysWithScoreLessThanK {

    @Test
    public void test() {
        assertThat(countSubarrays(new int[]{2, 1, 4, 3, 5}, 10)).isEqualTo(6);
        assertThat(countSubarrays(new int[]{1, 1, 1}, 5)).isEqualTo(5);
    }

    public long countSubarrays(int[] nums, long k) {
        long sum = 0;
        long answer = 0;
        int j = -1;
        for (int i = 0; i < nums.length; i++) {
            while (j < nums.length - 1 && (j - i + 2) * (sum + nums[j + 1]) < k) {
                sum += nums[++j];
            }
            answer += j - i + 1;
            sum -= nums[i];
        }
        return answer;
    }

}
