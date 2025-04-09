package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
2ms
Beats82.71%

 */
public class Q3375MinimumOperationsToMakeArrayValuesEqualToK {

    @Test
    public void test() {
        assertThat(minOperations(new int[]{5, 2, 5, 4, 5}, 2)).isEqualTo(2);
        assertThat(minOperations(new int[]{2, 1, 2}, 2)).isEqualTo(-1);
        assertThat(minOperations(new int[]{9, 7, 5, 3}, 1)).isEqualTo(4);
    }

    public int minOperations(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num < k)
                return -1;
            if (num == k)
                continue;
            set.add(num);
        }
        return set.size();
    }

}
