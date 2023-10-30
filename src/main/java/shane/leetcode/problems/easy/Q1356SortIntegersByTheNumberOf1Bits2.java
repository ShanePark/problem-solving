package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 15ms Beats 18.67%of users with Java
 * Memory Details 44.23MB Beats 8.90%of users with Java
 */
public class Q1356SortIntegersByTheNumberOf1Bits2 {

    @Test
    public void test() {
        assertThat(sortByBits(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8})).containsExactly(0, 1, 2, 4, 8, 3, 5, 6, 7);
        assertThat(sortByBits(new int[]{1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1})).containsExactly(1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024);
    }

    public int[] sortByBits(int[] arr) {
        return Arrays.stream(arr)
                .boxed()
                .sorted(Comparator.comparingInt(Integer::bitCount).thenComparingInt(Integer::valueOf))
                .mapToInt(Integer::valueOf)
                .toArray();
    }

}
