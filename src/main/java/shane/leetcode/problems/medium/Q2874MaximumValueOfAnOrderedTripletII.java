package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q2874MaximumValueOfAnOrderedTripletII {

    @Test
    public void test() {
        assertThat(maximumTripletValue(new int[]{12, 6, 1, 2, 7})).isEqualTo(77);
        assertThat(maximumTripletValue(new int[]{1, 10, 3, 4, 19})).isEqualTo(133);
        assertThat(maximumTripletValue(new int[]{1, 2, 3})).isEqualTo(0);
    }

    public long maximumTripletValue(int[] nums) {
        int[] max = new int[nums.length];
        max[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            max[i] = Math.max(nums[i], max[i + 1]);
        }
        long answer = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                answer = Math.max(answer, (nums[i] - nums[j]) * (long) max[j + 1]);
            }
        }
        return answer;
    }

}
