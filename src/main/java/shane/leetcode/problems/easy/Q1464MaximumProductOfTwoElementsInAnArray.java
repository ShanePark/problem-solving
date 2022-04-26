package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1464MaximumProductOfTwoElementsInAnArray {

    @Test
    public void test() {
        assertThat(maxProduct(new int[]{3, 4, 5, 2})).isEqualTo(12);
    }

    public int maxProduct(int[] nums) {
        int max = 0;
        int max2 = -1;
        for (int num : nums) {
            max2 = Math.max(max2, num);
            if (max2 > max) {
                int temp = max;
                max = max2;
                max2 = temp;
            }
        }
        return (max - 1) * (max2 - 1);
    }
}
