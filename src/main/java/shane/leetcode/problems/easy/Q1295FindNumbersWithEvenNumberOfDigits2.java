package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 3ms
 * Beats2.42%
 */
public class Q1295FindNumbersWithEvenNumberOfDigits2 {

    @Test
    public void test() {
        assertThat(findNumbers(new int[]{12, 345, 2, 6, 7896, 100})).isEqualTo(2);
        assertThat(findNumbers(new int[]{555, 901, 482, 1771})).isEqualTo(1);
    }

    public int findNumbers(int[] nums) {
        return (int) Arrays.stream(nums)
                .map(n -> (int) Math.log10(n) + 1)
                .filter(n -> n % 2 == 0)
                .count();
    }

}
