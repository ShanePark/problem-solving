package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 3ms
 * Beats69.35%
 */
public class Q2154KeepMultiplyingFoundValuesByTwo2 {

    @Test
    public void test() {
        assertThat(findFinalValue(new int[]{5, 3, 6, 1, 12}, 3)).isEqualTo(24);
        assertThat(findFinalValue(new int[]{2, 7, 9}, 4)).isEqualTo(4);
        assertThat(findFinalValue(new int[]{2}, 2)).isEqualTo(4);
    }

    public int findFinalValue(int[] nums, int original) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        while (set.contains(original)) {
            original *= 2;
        }
        return original;
    }

}
