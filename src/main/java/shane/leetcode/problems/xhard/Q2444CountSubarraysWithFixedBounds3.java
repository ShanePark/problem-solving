package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2444CountSubarraysWithFixedBounds3 {

    @Test
    void test() {
        assertThat(countSubarrays(new int[]{1, 3, 5, 2, 7, 5}, 1, 5)).isEqualTo(2);
        assertThat(countSubarrays(new int[]{1, 1, 1, 1}, 1, 1)).isEqualTo(10);
    }

    public long countSubarrays(int[] nums, int minK, int maxK) {
        int lastInvalid = -1;
        int minIndex = -1;
        int maxIndex = -1;

        long answer = 0L;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < minK || nums[i] > maxK) {
                lastInvalid = i;
                continue;
            }
            if (nums[i] == minK) minIndex = i;
            if (nums[i] == maxK) maxIndex = i;

            if (minIndex <= lastInvalid || maxIndex <= lastInvalid) {
                continue;
            }
            answer += Math.min(minIndex, maxIndex) - lastInvalid;
        }
        return answer;
    }

}
