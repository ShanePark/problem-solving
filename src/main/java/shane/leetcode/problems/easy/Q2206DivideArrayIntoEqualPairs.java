package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 5
 * ms
 * Beats
 * 48.55%
 */
public class Q2206DivideArrayIntoEqualPairs {

    @Test
    public void test() {
        assertThat(divideArray(new int[]{3, 2, 3, 2, 2, 2})).isTrue();
        assertThat(divideArray(new int[]{1, 2, 3, 4})).isFalse();
    }

    public boolean divideArray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                set.remove(num);
            }
        }
        return set.isEmpty();
    }

}
