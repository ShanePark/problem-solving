package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1671MinimumNumberOfRemovalsToMakeMountainArray {

    @Test
    public void test() {
        assertThat(minimumMountainRemovals(new int[]{1, 3, 1})).isEqualTo(0);
        assertThat(minimumMountainRemovals(new int[]{2, 1, 1, 5, 6, 2, 3, 1})).isEqualTo(3);
    }

    public int minimumMountainRemovals(int[] nums) {
        final int LENGTH = nums.length;
        int[] left = new int[LENGTH];
        int[] right = new int[LENGTH];

        for (int i = 0; i < LENGTH; i++) {
            left[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    left[i] = Math.max(left[i], left[j] + 1);
                }
            }
        }

        for (int i = LENGTH - 1; i >= 0; i--) {
            right[i] = 1;
            for (int j = LENGTH - 1; j > i; j--) {
                if (nums[j] < nums[i]) {
                    right[i] = Math.max(right[i], right[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < LENGTH; i++) {
            if (left[i] == 1 || right[i] == 1) {
                continue;
            }
            max = Math.max(max, left[i] + right[i] - 1);
        }

        return LENGTH - max;
    }

}
