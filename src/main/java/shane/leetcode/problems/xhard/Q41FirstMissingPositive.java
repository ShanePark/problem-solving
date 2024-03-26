package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 13 ms Beats 21.82% of users with Java
 */
public class Q41FirstMissingPositive {

    @Test
    public void test() {
        assertThat(firstMissingPositive(new int[]{0, 2, 2, 1, 1})).isEqualTo(3);
        assertThat(firstMissingPositive(new int[]{1, 2, 0})).isEqualTo(3);
        assertThat(firstMissingPositive(new int[]{3, 4, -1, 1})).isEqualTo(2);
        assertThat(firstMissingPositive(new int[]{7, 8, 9, 11, 12})).isEqualTo(1);
    }

    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int min = 1;
        for (int num : nums) {
            if (num < min)
                continue;
            if (num == min) {
                min++;
                continue;
            }
            return min;
        }
        return min;
    }

}
