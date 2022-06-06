package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2293MinMaxGame {

    @Test
    public void test() {
        assertThat(minMaxGame(new int[]{70, 38, 21, 22})).isEqualTo(22);
        assertThat(minMaxGame(new int[]{1, 3, 5, 2, 4, 8, 2, 2})).isEqualTo(1);
        assertThat(minMaxGame(new int[]{3})).isEqualTo(3);
    }

    public int minMaxGame(int[] nums) {
        return minGame(nums, 0, nums.length - 1);
    }

    private int minGame(int[] nums, int start, int end) {
        if (start == end)
            return nums[start];
        int mid = (start + end) / 2;
        return Math.min(minGame(nums, start, mid), maxGame(nums, mid + 1, end));
    }

    private int maxGame(int[] nums, int start, int end) {
        if (start == end)
            return nums[start];
        int mid = (start + end) / 2;
        return Math.max(minGame(nums, start, mid), maxGame(nums, mid + 1, end));
    }
}
