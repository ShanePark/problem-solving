package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;

/**
 * Time Limit Exceeded
 */
public class Q134GasStation {

    public static void main(String[] args) {
        Assertions.assertThat(canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2})).isEqualTo(3);
        Assertions.assertThat(canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3})).isEqualTo(-1);
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            gas[i] -= cost[i];
        }

        loop:
        for (int i = 0; i < gas.length; i++) {

            if (gas[i] < 0)
                continue;
            ;
            int cnt = 0;

            for (int j = 0; j < gas.length; j++) {
                cnt += gas[(i + j) % gas.length];
                if (cnt < 0)
                    continue loop;
            }

            return i;

        }

        return -1;

    }

}

