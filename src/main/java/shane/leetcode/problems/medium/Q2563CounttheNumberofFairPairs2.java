package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2563CounttheNumberofFairPairs2 {

    @Test
    public void test() {
        assertThat(countFairPairs(new int[]{0, 1, 7, 4, 4, 5}, 3, 6)).isEqualTo(6);
        assertThat(countFairPairs(new int[]{1, 7, 9, 2, 5}, 11, 11)).isEqualTo(1);
    }

    @Test
    public void tle() {
        int[] nums = new int[100000];
        assertThat(countFairPairs(nums, 11, 11)).isEqualTo(0);
    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return countLess(nums, upper) - countLess(nums, lower - 1);
    }

    long countLess(int[] nums, int maxSum) {
        long answer = 0;
        for (int left = 0, right = nums.length - 1; left < right; left++) {
            while (left < right && nums[left] + nums[right] > maxSum)
                right--;
            answer += right - left;
        }
        return answer;
    }

}
