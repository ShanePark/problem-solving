package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 5 ms Beats 33.39% of users with Java
 */
public class Q260SingleNumberIII {

    @Test
    public void test() {
        assertThat(singleNumber(new int[]{1, 2, 1, 3, 2, 5})).containsExactlyInAnyOrder(3, 5);
        assertThat(singleNumber(new int[]{-1, 0})).containsExactlyInAnyOrder(-1, 0);
        assertThat(singleNumber(new int[]{0, 1})).containsExactlyInAnyOrder(1, 0);
    }

    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                set.remove(num);
            }
        }
        return set.stream().mapToInt(Integer::valueOf).toArray();
    }

}
