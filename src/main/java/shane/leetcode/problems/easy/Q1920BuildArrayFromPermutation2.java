package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 1
 * ms
 * Beats
 * 98.72%
 */
public class Q1920BuildArrayFromPermutation2 {

    @Test
    public void test() {
        assertThat(buildArray(new int[]{0, 2, 1, 5, 3, 4})).containsExactly(0, 1, 2, 4, 5, 3);
        assertThat(buildArray(new int[]{5, 0, 1, 2, 3, 4})).containsExactly(4, 5, 0, 1, 2, 3);
    }

    public int[] buildArray(int[] nums) {
        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            answer[i] = nums[nums[i]];
        }
        return answer;
    }

}
