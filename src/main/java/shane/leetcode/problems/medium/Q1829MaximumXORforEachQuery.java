package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 8ms Beats9.21%
 */
public class Q1829MaximumXORforEachQuery {

    @Test
    public void test() {
        assertThat(getMaximumXor(new int[]{0, 1, 1, 3}, 2)).containsExactly(0, 3, 2, 3);
        assertThat(getMaximumXor(new int[]{2, 3, 4, 7}, 3)).containsExactly(5, 2, 6, 5);
        assertThat(getMaximumXor(new int[]{0, 1, 2, 2, 5, 7}, 3)).containsExactly(4, 3, 6, 4, 6, 7);
    }

    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int flag = (int) Math.pow(2, maximumBit) - 1;
        int[] answer = new int[nums.length];
        int allXor = Arrays.stream(nums).reduce((a, b) -> a ^ b).getAsInt();
        for (int i = 0; i < nums.length; i++) {
            answer[i] = allXor ^ flag;
            allXor ^= nums[nums.length - 1 - i];
        }
        return answer;
    }

}
