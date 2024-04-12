package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 1 ms Beats 71.17% of users with Java
 */
public class Q42TrappingRainWater3 {

    @Test
    public void test() {
        assertThat(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1})).isEqualTo(6);
        assertThat(trap(new int[]{4, 2, 0, 3, 2, 5})).isEqualTo(9);
    }

    public int trap(int[] height) {
        final int LENGTH = height.length;
        int[] maxLeft = new int[LENGTH];
        int[] maxRight = new int[LENGTH];
        maxLeft[0] = height[0];
        maxRight[LENGTH - 1] = height[LENGTH - 1];
        for (int i = 1; i < LENGTH; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
            maxRight[LENGTH - 1 - i] = Math.max(maxRight[LENGTH - i], height[LENGTH - 1 - i]);
        }
        int sum = 0;
        for (int i = 0; i < LENGTH; i++) {
            sum += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        return sum;
    }

}
