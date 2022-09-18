package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 4 ms, faster than 16.50% of Java online submissions for Trapping Rain Water.
 * Memory Usage: 51.2 MB, less than 5.43% of Java online submissions for Trapping Rain Water.
 */
public class Q42TrappingRainWater2 {

    @Test
    public void test() {
        assertThat(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1})).isEqualTo(6);
        assertThat(trap(new int[]{4, 2, 0, 3, 2, 5})).isEqualTo(9);
    }

    public int trap(int[] height) {
        int length = height.length;
        int[][] memo = new int[length][2];
        int maxLeft = 0;
        int maxRight = 0;
        for (int i = 0; i < length; i++) {
            maxLeft = Math.max(maxLeft, height[i]);
            maxRight = Math.max(maxRight, height[length - i - 1]);
            memo[i][0] = maxLeft;
            memo[length - i - 1][1] = maxRight;
        }
        int answer = 0;
        for (int i = 0; i < length; i++) {
            answer += Math.min(memo[i][0], memo[i][1]) - height[i];
        }
        return answer;
    }

}
