package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Runtime 1 ms Beats 100%
 * Memory 62.6 MB Beats 72.25%
 */
public class Q134GasStation3 {

    @Test
    public void test() {
        Assertions.assertThat(canCompleteCircuit(new int[]{3, 1, 1}, new int[]{1, 2, 2})).isEqualTo(0);
        Assertions.assertThat(canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2})).isEqualTo(3);
        Assertions.assertThat(canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3})).isEqualTo(-1);
        Assertions.assertThat(canCompleteCircuit(new int[]{5, 1, 2, 3, 4}, new int[]{4, 4, 1, 5, 1})).isEqualTo(4);
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            gas[i] -= cost[i];
        }
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i];
            if (sum < min) {
                min = sum;
                minIndex = i;
            }
        }
        if (sum < 0)
            return -1;
        return (minIndex + 1) % gas.length;
    }

}

