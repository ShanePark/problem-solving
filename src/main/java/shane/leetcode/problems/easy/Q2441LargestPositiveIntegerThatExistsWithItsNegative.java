package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 6 ms Beats 64.14% of users with Java
 */
public class Q2441LargestPositiveIntegerThatExistsWithItsNegative {

    @Test
    public void test() {
        assertThat(findMaxK(new int[]{-1, 2, -3, 3})).isEqualTo(3);
        assertThat(findMaxK(new int[]{-1, 10, 6, 7, -7, 1})).isEqualTo(7);
        assertThat(findMaxK(new int[]{-10, 8, 6, 7, -2, -3})).isEqualTo(-1);
    }

    public int findMaxK(int[] nums) {
        int max = -1;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
            if (set.contains(-num)) {
                max = Math.max(max, Math.abs(num));
            }
        }
        return max;
    }

}
