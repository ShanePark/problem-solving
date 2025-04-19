package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2563CounttheNumberofFairPairs3 {

    @Test
    public void test() {
        assertThat(countFairPairs(new int[]{1, 7, 9, 2, 5}, 11, 11)).isEqualTo(1);
        assertThat(countFairPairs(new int[]{0, 1, 7, 4, 4, 5}, 3, 6)).isEqualTo(6);
    }

    @Test
    public void test2() {
        assertThat(countFairPairs(new int[]{0, 0, 0, 0, 0, 0}, 0, 0)).isEqualTo(15);
    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return countEqOrLess(nums, upper) - countEqOrLess(nums, lower - 1);
    }

    private long countEqOrLess(int[] nums, int target) {
        long cnt = 0;
        int right = nums.length - 1;
        for (int left = 0; left < nums.length; left++) {
            while (right > left && nums[left] + nums[right] > target) {
                right--;
            }
            if (right <= left) break;
            cnt += (right - left);
        }
        return cnt;
    }

}
