package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 7ms Beats 10.27%of users with Java
 * Memory Details 42.83MB Beats 10.62%of users with Java
 */
public class Q1464MaximumProductOfTwoElementsInAnArray2 {

    @Test
    public void test() {
        assertThat(maxProduct(new int[]{3, 4, 5, 2})).isEqualTo(12);
        assertThat(maxProduct(new int[]{1, 5, 4, 5})).isEqualTo(16);
        assertThat(maxProduct(new int[]{3, 7})).isEqualTo(12);
    }

    public int maxProduct(int[] nums) {
        return Arrays.stream(nums)
                .map(i -> -i)
                .sorted()
                .limit(2)
                .map(i -> -i - 1)
                .reduce((a, b) -> a * b)
                .getAsInt();
    }

}
