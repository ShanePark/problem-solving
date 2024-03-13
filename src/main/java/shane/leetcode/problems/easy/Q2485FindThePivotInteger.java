package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 1 ms Beats 77.54% of users with Java
 */
public class Q2485FindThePivotInteger {

    @Test
    public void test() {
        assertThat(pivotInteger(49)).isEqualTo(35);
        assertThat(pivotInteger(8)).isEqualTo(6);
        assertThat(pivotInteger(1)).isEqualTo(1);
        assertThat(pivotInteger(4)).isEqualTo(-1);
    }

    public int pivotInteger(int n) {
        if (n == 1)
            return 1;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        int curSum = 0;
        for (int i = 1; i <= n; i++) {
            curSum += i;
            if (sum - curSum + i == curSum) {
                return i;
            }
        }
        return -1;
    }

}
