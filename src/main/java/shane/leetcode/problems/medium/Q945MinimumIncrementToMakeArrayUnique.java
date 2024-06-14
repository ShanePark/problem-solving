package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime35msBeats82.95%
 */
public class Q945MinimumIncrementToMakeArrayUnique {

    @Test
    public void test() {
        assertThat(minIncrementForUnique(new int[]{1, 2, 2})).isEqualTo(1);
        assertThat(minIncrementForUnique(new int[]{3, 2, 1, 2, 1, 7})).isEqualTo(6);
    }

    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);

        int sum = 0;
        int min = -1;
        for (int num : nums) {
            if (num <= min) {
                sum += (++min - num);
                continue;
            }
            min = num;
        }
        return sum;
    }

}
