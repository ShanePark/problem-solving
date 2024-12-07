package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime27msBeats83.10%
 * used hint: bs
 */
public class Q1760MinimumLimitofBallsinaBag {

    @Test
    public void test() {
        assertThat(minimumSize(new int[]{9, 6}, 2)).isEqualTo(5);
        assertThat(minimumSize(new int[]{9, 6, 4}, 3)).isEqualTo(4);
        assertThat(minimumSize(new int[]{9, 3}, 2)).isEqualTo(3);
        assertThat(minimumSize(new int[]{2, 4, 8, 2}, 4)).isEqualTo(2);
        assertThat(minimumSize(new int[]{9}, 2)).isEqualTo(3);
        assertThat(minimumSize(new int[]{9}, 4)).isEqualTo(2);
        assertThat(minimumSize(new int[]{1}, 1)).isEqualTo(1);
    }

    public int minimumSize(int[] nums, int maxOperations) {
        int bagSize = nums.length + maxOperations;
        int left = 1;
        int right = Integer.MAX_VALUE;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (possible(nums, bagSize, mid)) {
                right = mid;
                continue;
            }
            left = mid + 1;
        }
        return left;
    }

    private boolean possible(int[] nums, int bagSize, int penalty) {
        for (int num : nums) {
            bagSize -= (num - 1) / penalty + 1;
            if (bagSize < 0)
                return false;
        }
        return bagSize >= 0;
    }

}
