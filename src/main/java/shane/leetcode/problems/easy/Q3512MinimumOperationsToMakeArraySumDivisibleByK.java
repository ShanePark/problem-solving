package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 1
 * ms
 * Beats
 * 92.46%
 */
public class Q3512MinimumOperationsToMakeArraySumDivisibleByK {

    @Test
    public void test() {
        assertThat(minOperations(new int[]{3, 9, 7}, 5)).isEqualTo(4);
        assertThat(minOperations(new int[]{4, 1, 3}, 4)).isEqualTo(0);
        assertThat(minOperations(new int[]{3, 2}, 6)).isEqualTo(5);
    }

    public int minOperations(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum % k;
    }

}
