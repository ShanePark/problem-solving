package shane.leetcode.medium;

import org.assertj.core.api.Assertions;

/**
 * Time Limit Exceeded
 */
public class Q134GasStation2 {

    public static void main(String[] args) {
        Assertions.assertThat(canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2})).isEqualTo(3);
        Assertions.assertThat(canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3})).isEqualTo(-1);
        Assertions.assertThat(canCompleteCircuit(new int[]{5, 1, 2, 3, 4}, new int[]{4, 4, 1, 5, 1})).isEqualTo(4);
        Assertions.assertThat(canCompleteCircuit(new int[]{3, 1, 1}, new int[]{1, 2, 2})).isEqualTo(0);
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int temp = 0;
        for (int i = 0; i < gas.length; i++) {
            gas[i] -= cost[i];
            temp += gas[i];
        }

        if (temp < 0)
            return -1;

        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i];
            if (sum < min) {
                min = sum;
                minIndex = i;
            }
        }

        return (minIndex + 1) % gas.length;

    }

}

