package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 4
 * ms
 * Beats
 * 6.35%
 */
public class Q3432CountPartitionsWithEvenSumDifference {

    @Test
    public void test() {
        assertThat(countPartitions(new int[]{10, 10, 3, 7, 6})).isEqualTo(4);
        assertThat(countPartitions(new int[]{1, 2, 2})).isEqualTo(0);
        assertThat(countPartitions(new int[]{2, 4, 6, 8})).isEqualTo(3);
    }

    public int countPartitions(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int left = 0;
        int answer = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            left += nums[i];
            int right = sum - left;
            if ((left - right) % 2 == 0)
                answer++;
        }
        return answer;
    }

}
