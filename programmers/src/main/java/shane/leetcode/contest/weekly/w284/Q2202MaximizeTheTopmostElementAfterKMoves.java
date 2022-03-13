package shane.leetcode.contest.weekly.w284;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q2202MaximizeTheTopmostElementAfterKMoves {

    @Test
    void test() {
        Assertions.assertThat(maximumTop(new int[]{5, 2, 2, 4, 0, 6}, 4)).isEqualTo(5);
        Assertions.assertThat(maximumTop(new int[]{2}, 1)).isEqualTo(-1);
        Assertions.assertThat(maximumTop(new int[]{99, 95, 68, 24, 18}, 69)).isEqualTo(99);
        Assertions.assertThat(maximumTop(new int[]{35, 43, 23, 86, 23, 45, 84, 2, 18, 83, 79, 28, 54, 81, 12, 94, 14, 0, 0, 29, 94, 12, 13, 1, 48, 85, 22, 95, 24, 5, 73, 10, 96, 97, 72, 41, 52, 1, 91, 3, 20, 22, 41, 98, 70, 20, 52, 48, 91, 84, 16, 30, 27, 35, 69, 33, 67, 18, 4, 53, 86, 78, 26, 83, 13, 96, 29, 15, 34, 80, 16, 49}, 15)).isEqualTo(94);
        Assertions.assertThat(maximumTop(new int[]{91, 98, 17, 79, 15, 55, 47, 86, 4, 5, 17, 79, 68, 60, 60, 31, 72, 85, 25, 77, 8, 78, 40, 96, 76, 69, 95, 2, 42, 87, 48, 72, 45, 25, 40, 60, 21, 91, 32, 79, 2, 87, 80, 97, 82, 94, 69, 43, 18, 19, 21, 36, 44, 81, 99}, 2)).isEqualTo(91);
        Assertions.assertThat(maximumTop(new int[]{18}, 3)).isEqualTo(-1);
    }

    public int maximumTop(int[] nums, int k) {

        if (nums.length == 1 && k % 2 == 1) {
            return -1;
        }

        int max = 0;
        for (int i = 0; i <= k && i < nums.length; i++) {
            if (i == k - 1)
                continue;
            max = Math.max(max, nums[i]);
        }
        return max;

    }


}
