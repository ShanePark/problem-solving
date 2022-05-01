package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2044CountNumberOfMaximumBitwiseORSubsets {

    @Test
    public void test() {
        assertThat(countMaxOrSubsets(new int[]{3, 1})).isEqualTo(2);
        assertThat(countMaxOrSubsets(new int[]{3, 2, 1, 5})).isEqualTo(6);
    }

    int cnt;

    public int countMaxOrSubsets(int[] nums) {
        cnt = 0;
        int maxOr = 0;
        for (int num : nums) {
            maxOr |= num;
        }

        for (int i = 1; i <= nums.length; i++) {
            backTracking(nums, maxOr, i, 0, 0, 0);
        }

        return cnt;
    }

    private void backTracking(int[] nums, int targetNumber, int targetTotal, int curCnt, int curNum, int index) {
        if (index >= nums.length || targetTotal == curCnt) {
            if (targetTotal == curCnt && targetNumber == curNum) {
                cnt++;
            }
            return;
        }
        backTracking(nums, targetNumber, targetTotal, curCnt, curNum, index + 1);
        backTracking(nums, targetNumber, targetTotal, curCnt + 1, curNum | nums[index], index + 1);
    }
}
