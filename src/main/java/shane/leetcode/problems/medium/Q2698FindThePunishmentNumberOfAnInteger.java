package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 131
 * ms
 * Beats
 * 54.86%
 */
public class Q2698FindThePunishmentNumberOfAnInteger {

    @Test
    public void test() {
        assertThat(punishmentNumber(10)).isEqualTo(182);
        assertThat(punishmentNumber(37)).isEqualTo(1478);
        assertThat(punishmentNumber(1000)).isEqualTo(10804657);
    }

    public int punishmentNumber(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (canMake(String.valueOf(i * i), 0, i)) {
                sum += (i * i);
            }
        }
        return sum;
    }

    private boolean canMake(String input, int index, int target) {
        if (Integer.parseInt(input.substring(index)) == target)
            return true;
        for (int i = index + 1; i < input.length(); i++) {
            int left = Integer.parseInt(input.substring(index, i));
            if (canMake(input, i, target - left))
                return true;
        }
        return false;
    }

}
