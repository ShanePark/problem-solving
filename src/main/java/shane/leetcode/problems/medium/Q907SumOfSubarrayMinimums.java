package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q907SumOfSubarrayMinimums {

    @Test
    public void test() {
        assertThat(sumSubarrayMins(new int[]{3, 1, 2, 4})).isEqualTo(17);
        assertThat(sumSubarrayMins(new int[]{11, 81, 94, 43, 3})).isEqualTo(444);
    }

    /**
     * 325 ms
     */
    @Test
    public void test2() {
        assertThat(sumSubarrayMins(new int[30000]));
    }

    public int sumSubarrayMins(int[] arr) {
        long sum = 0;
        final int MOD = (int) 1e9 + 7;
        for (int i = 0; i < arr.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < arr.length; j++) {
                min = Math.min(min, arr[j]);
                sum += min;
            }
            sum %= MOD;
        }
        return (int) sum;
    }

}
