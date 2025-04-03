package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
2ms
Beats97.85%

 */
public class Q2874MaximumValueOfAnOrderedTripletII2 {

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

        int maxIValue = nums[0];
        long answer = 0;
        for (int j = 1; j < nums.length - 1; j++) {
            answer = Math.max(answer, (maxIValue - nums[j]) * (long) max[j + 1]);
            maxIValue = Math.max(maxIValue, nums[j]);
        }
        return answer;
    }

}
