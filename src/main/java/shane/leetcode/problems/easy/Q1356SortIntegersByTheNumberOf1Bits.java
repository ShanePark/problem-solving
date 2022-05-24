package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1356SortIntegersByTheNumberOf1Bits {

    @Test
    public void test() {
        assertThat(sortByBits(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8})).containsExactly(0, 1, 2, 4, 8, 3, 5, 6, 7);
        assertThat(sortByBits(new int[]{1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1})).containsExactly(1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024);
    }

    public int[] sortByBits(int[] arr) {

        return Arrays.stream(arr).boxed().sorted((o1, o2) -> {
            int bit1 = Integer.bitCount(o1);
            int bit2 = Integer.bitCount(o2);
            if (bit1 == bit2) {
                return Integer.compare(o1, o2);
            }
            return Integer.compare(bit1, bit2);
        }).mapToInt(Integer::valueOf).toArray();
    }
}
