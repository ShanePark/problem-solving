package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime2msBeats100.00%
 */
public class Q1829MaximumXORforEachQuery2 {


    @Test
    public void test() {
        assertThat(getMaximumXor(new int[]{0, 1, 1, 3}, 2)).containsExactly(0, 3, 2, 3);
        assertThat(getMaximumXor(new int[]{2, 3, 4, 7}, 3)).containsExactly(5, 2, 6, 5);
        assertThat(getMaximumXor(new int[]{0, 1, 2, 2, 5, 7}, 3)).containsExactly(4, 3, 6, 4, 6, 7);
    }

    public int[] getMaximumXor(int[] nums, int maximumBit) {
        final int SIZE = nums.length;
        final int MAX = (int) Math.pow(2, maximumBit) - 1;

        int[] answer = new int[SIZE];
        answer[SIZE - 1] = nums[0] ^ MAX;
        for (int i = 1; i < SIZE; i++) {
            answer[SIZE - 1 - i] = answer[SIZE - i] ^ nums[i];
        }

        return answer;
    }

}
