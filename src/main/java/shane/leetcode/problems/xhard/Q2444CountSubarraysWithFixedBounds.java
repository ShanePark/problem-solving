package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my own idea
 * Runtime 6 ms Beats 98.76% Memory 60.6 MB Beats 23.22%
 */
public class Q2444CountSubarraysWithFixedBounds {

    @Test
    void test() {
        assertThat(countSubarrays(new int[]{1, 3, 5, 2, 7, 5}, 1, 5)).isEqualTo(2);
        assertThat(countSubarrays(new int[]{1, 1, 1, 1}, 1, 1)).isEqualTo(10);
    }

    public long countSubarrays(int[] nums, int minK, int maxK) {
        long answer = 0;
        int invalidUntil = -1;
        int minIndex = -1;
        int maxIndex = -1;

        for (int i = 0; i < nums.length; ++i) {
            int n = nums[i];
            if (n < minK || n > maxK) {
                invalidUntil = i;
                continue;
            }
            if (n == minK)
                minIndex = i;
            if (n == maxK)
                maxIndex = i;
            if (invalidUntil < minIndex && invalidUntil < maxIndex) {
                answer += Math.min(minIndex, maxIndex) - invalidUntil;
            }
        }
        return answer;
    }

}
