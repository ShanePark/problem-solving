package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2154KeepMultiplyingFoundValuesByTwo {

    @Test
    public void test() {
        assertThat(findFinalValue(new int[]{5, 3, 6, 1, 12}, 3)).isEqualTo(24);
        assertThat(findFinalValue(new int[]{2, 7, 9}, 4)).isEqualTo(4);
        assertThat(findFinalValue(new int[]{2}, 2)).isEqualTo(4);
    }

    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        while (Arrays.binarySearch(nums, original) >= 0) {
            original *= 2;
        }
        return original;
    }

}
