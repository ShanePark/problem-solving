package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 3ms
 * Beats53.95%
 */
public class Q2873MaximumValueOfAnOrderedTripletI {

    @Test
    public void test() {
        assertThat(maximumTripletValue(new int[]{12, 6, 1, 2, 7})).isEqualTo(77);
        assertThat(maximumTripletValue(new int[]{1, 10, 3, 4, 19})).isEqualTo(133);
        assertThat(maximumTripletValue(new int[]{1, 2, 3})).isEqualTo(0);
    }

    public long maximumTripletValue(int[] nums) {
        long max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    max = Math.max(max, (nums[i] - nums[j]) * (long) nums[k]);
                }
            }
        }
        return max;
    }

}
