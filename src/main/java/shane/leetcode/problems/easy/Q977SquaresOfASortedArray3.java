package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q977SquaresOfASortedArray3 {

    @Test
    public void test() {
        assertThat(sortedSquares(new int[]{-4, -1, 0, 3, 10})).containsExactly(0, 1, 9, 16, 100);
        assertThat(sortedSquares(new int[]{-7, -3, 2, 3, 11})).containsExactly(4, 9, 9, 49, 121);
    }

    public int[] sortedSquares(int[] nums) {
        final int LENGTH = nums.length;
        int[] answer = new int[LENGTH];
        int l = 0;
        int r = LENGTH - 1;
        for (int i = LENGTH - 1; i >= 0; i--) {
            if (nums[l] * nums[l] < nums[r] * nums[r]) {
                answer[i] = nums[r] * nums[r];
                r--;
            } else {
                answer[i] = nums[l] * nums[l];
                l++;
            }
        }
        return answer;
    }
}
