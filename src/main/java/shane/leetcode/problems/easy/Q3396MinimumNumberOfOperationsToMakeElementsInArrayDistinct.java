package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 1ms
 * Beats98.39%
 */
public class Q3396MinimumNumberOfOperationsToMakeElementsInArrayDistinct {

    @Test
    public void test() {
        assertThat(minimumOperations(new int[]{1, 2, 3, 4, 2, 3, 3, 5, 7})).isEqualTo(2);
        assertThat(minimumOperations(new int[]{4, 5, 6, 4, 4})).isEqualTo(2);
        assertThat(minimumOperations(new int[]{6, 7, 8, 9})).isEqualTo(0);
    }

    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (!set.add(nums[i])) {
                return i / 3 + 1;
            }
        }
        return 0;
    }

}
