package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 6ms Beats 15.38%of users with Java
 * Memory Details 57.65MB Beats 62.18%of users with Java
 */
public class Q1685SumOfAbsoluteDifferencesInASortedArray {

    @Test
    public void test() {
        assertThat(getSumAbsoluteDifferences(new int[]{2, 3, 5})).containsExactly(4, 3, 5);
        assertThat(getSumAbsoluteDifferences(new int[]{1, 4, 6, 8, 10})).containsExactly(24, 15, 13, 15, 21);
    }

    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] sums = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i] = sum;
        }

        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            answer[i] = getDiff(sums, 0, i - 1, nums[i]) + getDiff(sums, i + 1, nums.length - 1, nums[i]);
        }

        return answer;
    }

    private int getDiff(int[] sums, int from, int end, int value) {
        if (from > end)
            return 0;
        int sum = sums[end] - ((from == 0) ? 0 : sums[from - 1]);
        int length = end - from + 1;
        int diff = sum - value * length;
        return Math.abs(diff);
    }

}
