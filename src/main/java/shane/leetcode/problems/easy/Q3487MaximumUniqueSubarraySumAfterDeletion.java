package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 3ms
 * Beats20.94%
 */
public class Q3487MaximumUniqueSubarraySumAfterDeletion {

    @Test
    public void test() {
        assertThat(maxSum(new int[]{1, 2, 3, 4, 5})).isEqualTo(15);
        assertThat(maxSum(new int[]{1, 1, 0, 1, 1})).isEqualTo(1);
        assertThat(maxSum(new int[]{1, 2, -1, -2, 1, 0, -1})).isEqualTo(3);

    }

    public int maxSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for (int num : nums) {
            if (set.add(num) && num > 0) {
                sum += num;
            }
        }
        if (sum > 0)
            return sum;
        return set.stream().mapToInt(Integer::valueOf).max().getAsInt();
    }

}
