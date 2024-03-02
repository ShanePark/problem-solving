package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 1 ms Beats 100.00% of users with Java
 */
public class Q977SquaresOfASortedArray4 {

    @Test
    public void test() {
        assertThat(sortedSquares(new int[]{-4, -1, 0, 3, 10})).containsExactly(0, 1, 9, 16, 100);
        assertThat(sortedSquares(new int[]{-7, -3, 2, 3, 11})).containsExactly(4, 9, 9, 49, 121);
    }

    public int[] sortedSquares(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int index = nums.length - 1;
        int[] answer = new int[nums.length];
        while (i <= j) {
            int iValue = Math.abs(nums[i]);
            int jValue = Math.abs(nums[j]);
            if (iValue >= jValue) {
                answer[index] = iValue * iValue;
                i++;
            } else {
                answer[index] = jValue * jValue;
                j--;
            }
            index--;
        }
        return answer;
    }

}
