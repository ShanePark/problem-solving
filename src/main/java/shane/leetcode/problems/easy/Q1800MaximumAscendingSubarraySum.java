package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 0ms
 * Beats100.00%
 */
public class Q1800MaximumAscendingSubarraySum {

    @Test
    public void test() {
        assertThat(maxAscendingSum(new int[]{10, 20, 30, 5, 10, 50})).isEqualTo(65);
        assertThat(maxAscendingSum(new int[]{10, 20, 30, 40, 50})).isEqualTo(150);
        assertThat(maxAscendingSum(new int[]{12, 17, 15, 13, 10, 11, 12})).isEqualTo(33);
    }

    @Test
    public void test2() {
        assertThat(maxAscendingSum(new int[]{3, 6, 10, 1, 8, 9, 9, 8, 9})).isEqualTo(19);
    }

    public int maxAscendingSum(int[] nums) {
        int sum = 0;
        int max = 0;
        int beforeNum = -1;
        for (int num : nums) {
            if (beforeNum < num) {
                sum += num;
                max = Math.max(max, sum);
                beforeNum = num;
                continue;
            }
            sum = num;
            beforeNum = num;
        }
        return max;
    }

}
