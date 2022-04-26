package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2239FindClosestNumberToZero {

    @Test
    public void test() {
        assertThat(findClosestNumber(new int[]{-4, -2, 1, 4, 8})).isEqualTo(1);
        assertThat(findClosestNumber(new int[]{2, -1, 1})).isEqualTo(1);
        assertThat(findClosestNumber(new int[]{2, 1, -1})).isEqualTo(1);
    }

    public int findClosestNumber(int[] nums) {
        int gap = Integer.MAX_VALUE;
        int num = 0;
        for (int i : nums) {
            int abs = Math.abs(i);
            if (abs < gap) {
                gap = abs;
                num = i;
            } else if (abs == gap && num < i) {
                gap = abs;
                num = i;
            }
        }
        return num;
    }
}
