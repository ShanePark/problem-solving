package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q11ContainerWithMostWater3 {

    @Test
    void test() {
        Assertions.assertThat(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})).isEqualTo(49);
    }

    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int water = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, water);
            if (height[left] < height[right]) {
                left++;
                continue;
            }
            right--;
        }
        return max;
    }

}
