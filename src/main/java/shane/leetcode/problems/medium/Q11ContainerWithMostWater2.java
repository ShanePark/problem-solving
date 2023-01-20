package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Runtime 4 ms Beats 69.59%
 * Memory 52.4 MB Beats 90.72%
 */
public class Q11ContainerWithMostWater2 {

    @Test
    void test() {
        Assertions.assertThat(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})).isEqualTo(49);
    }

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            max = Math.max(max, (right - left) * Math.min(height[right], height[left]));
            if (height[right] < height[left]) {
                right--;
            } else {
                left++;
            }
        }
        return max;
    }

}
