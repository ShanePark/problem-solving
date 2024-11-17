package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Wrong Answer
 * 63 / 98 testcases passed
 */
public class Q862ShortestSubarraywithSumatLeastK {

    @Test
    public void test() {
        assertThat(shortestSubarray(new int[]{-28, 81, -20, 28, -29}, 89)).isEqualTo(3);
        assertThat(shortestSubarray(new int[]{84, -37, 32, 40, 95}, 167)).isEqualTo(3);
        assertThat(shortestSubarray(new int[]{1}, 1)).isEqualTo(1);
        assertThat(shortestSubarray(new int[]{1, 2}, 4)).isEqualTo(-1);
        assertThat(shortestSubarray(new int[]{2, -1, 2}, 3)).isEqualTo(3);
    }

    @Test
    public void wrong() {
        assertThat(shortestSubarray(new int[]{-34, 37, 51, 3, -12, -50, 51, 100, -47, 99, 34, 14, -13, 89, 31, -14, -44, 23, -38, 6}, 151)).isEqualTo(2);
    }

    public int shortestSubarray(int[] nums, int k) {
        int answer = Integer.MAX_VALUE;

        int right = -1;
        long sum = 0;

        for (int left = 0; left < nums.length; left++) {
            int maxRight = right;
            long maxSum = sum;
            while (right < nums.length - 1 && sum < k) {
                sum += nums[++right];
                if (k <= sum && sum < maxSum) {
                    maxSum = sum;
                    maxRight = right;
                }
            }
            if (k <= sum) {
                answer = Math.min(answer, right - left + 1);
                sum -= nums[left];
                continue;
            }
            while (maxRight < right) {
                sum -= nums[right--];
            }
            sum -= nums[left];
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

}
