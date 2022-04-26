package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q1829MaximumXORForEachQuery {


    @Test
    public void test() {
        assertThat(getMaximumXor(new int[]{0, 1, 1, 3}, 2)).containsExactly(0, 3, 2, 3);
        assertThat(getMaximumXor(new int[]{2, 3, 4, 7}, 3)).containsExactly(5, 2, 6, 5);
        assertThat(getMaximumXor(new int[]{0, 1, 2, 2, 5, 7}, 3)).containsExactly(4, 3, 6, 4, 6, 7);
    }

    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int[] answer = new int[nums.length];
        final int MAX = (int) Math.pow(2, maximumBit) - 1;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[0];
            for (int j = 1; j < nums.length - i; j++) {
                n ^= nums[j];
            }
            answer[i] = MAX ^ n;
        }
        return answer;
    }

}
