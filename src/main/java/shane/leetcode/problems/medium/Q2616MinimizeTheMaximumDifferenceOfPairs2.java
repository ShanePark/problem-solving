package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2616MinimizeTheMaximumDifferenceOfPairs2 {

    @Test
    public void test() {
        assertThat(minimizeMax(new int[]{0, 5, 3, 4}, 0)).isEqualTo(0);
        assertThat(minimizeMax(new int[]{1, 1, 0, 3}, 2)).isEqualTo(2);
        assertThat(minimizeMax(new int[]{8, 9, 1, 5, 4, 3, 6, 4, 3, 7}, 4)).isEqualTo(1);
        assertThat(minimizeMax(new int[]{1, 40, 40, 100, 2000, 3000}, 2)).isEqualTo(60);
        assertThat(minimizeMax(new int[]{10, 1, 2, 7, 1, 3}, 2)).isEqualTo(1);
        assertThat(minimizeMax(new int[]{4, 2, 1, 2}, 1)).isEqualTo(0);
    }

    public int minimizeMax(int[] nums, int p) {
        if (p == 0)
            return 0;

        Arrays.sort(nums);
        int left = 0;
        int right = nums[nums.length - 1] - nums[0];

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isPossible(nums, mid, p)) {
                right = mid;
                continue;
            }
            left = mid + 1;
        }
        return left;
    }

    private boolean isPossible(int[] nums, int gap, int pair) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] <= gap) {
                if (--pair == 0)
                    return true;
                i++;
            }
        }
        return false;
    }

}
