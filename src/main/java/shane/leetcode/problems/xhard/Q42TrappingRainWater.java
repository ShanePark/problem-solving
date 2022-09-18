package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 12 ms, faster than 12.14% of Java online submissions for Trapping Rain Water.
 * Memory Usage: 50.4 MB, less than 5.43% of Java online submissions for Trapping Rain Water.
 */
public class Q42TrappingRainWater {

    @Test
    public void test() {
        assertThat(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1})).isEqualTo(6);
        assertThat(trap(new int[]{4, 2, 0, 3, 2, 5})).isEqualTo(9);
    }

    public int trap(int[] height) {
        int[][] memo = new int[height.length][2];
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            max = Math.max(max, height[i]);
            memo[i][0] = max;
        }
        max = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            max = Math.max(max, height[i]);
            memo[i][1] = max;
        }
        int answer = 0;
        for (int i = 0; i < height.length; i++) {
            answer += Math.min(memo[i][0], memo[i][1]) - height[i];
        }
        return answer;
    }

}
