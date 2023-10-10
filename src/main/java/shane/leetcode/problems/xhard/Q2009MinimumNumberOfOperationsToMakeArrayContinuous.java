package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my solution
 */
public class Q2009MinimumNumberOfOperationsToMakeArrayContinuous {

    @Test
    public void test() {
        assertThat(minOperations(new int[]{4, 2, 5, 3})).isEqualTo(0);
        assertThat(minOperations(new int[]{1, 2, 3, 5, 6})).isEqualTo(1);
        assertThat(minOperations(new int[]{1, 10, 100, 1000})).isEqualTo(3);
    }

    public int minOperations(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        int cnt = 1;
        for (int i = 1; i < length; i++) {
            if (nums[i] != nums[i - 1])
                nums[cnt++] = nums[i];
        }

        int answer = length;
        int right = 0;
        for (int left = 0; left < cnt; left++) {
            while (right < cnt && nums[right] <= nums[left] + length - 1)
                right++;
            answer = Math.min(answer, length + left - right);
        }

        return answer;
    }

}
