package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 6 ms Beats 22.31%
 * Memory 44.1 MB Beats 39.69%
 */
public class Q137SingleNumberII {

    @Test
    public void test() {
        assertThat(singleNumber(new int[]{2, 2, 3, 2})).isEqualTo(3);
        assertThat(singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99})).isEqualTo(99);
    }

    public int singleNumber(int[] nums) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums) {
            if (!set1.add(num)) {
                set2.add(num);
            }
        }
        set1.removeAll(set2);
        return set1.stream().findAny().get();
    }

}
