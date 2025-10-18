package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 19
 * ms
 * Beats
 * 84.14%
 */
public class Q3397MaximumNumberOfDistinctElementsAfterOperations {

    @Test
    public void test() {
        assertThat(maxDistinctElements(new int[]{1, 2, 2, 3, 3, 4}, 2)).isEqualTo(6);
        assertThat(maxDistinctElements(new int[]{4, 4, 4, 4}, 1)).isEqualTo(3);
    }

    public int maxDistinctElements(int[] nums, int k) {
        int answer = 0;
        int min = Integer.MIN_VALUE;
        Arrays.sort(nums);
        for (int num : nums) {
            int next = Math.max(min + 1, num - k);
            if (num + k < next)
                continue;
            answer++;
            min = next;
        }
        return answer;
    }

}
