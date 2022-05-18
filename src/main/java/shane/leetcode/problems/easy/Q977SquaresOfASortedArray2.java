package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

public class Q977SquaresOfASortedArray2 {

    @Test
    public void test() {
        assertThat(sortedSquares(new int[]{-4, -1, 0, 3, 10})).containsExactly(0, 1, 9, 16, 100);
        assertThat(sortedSquares(new int[]{-7, -3, 2, 3, 11})).containsExactly(4, 9, 9, 49, 121);
    }

    public int[] sortedSquares(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}
