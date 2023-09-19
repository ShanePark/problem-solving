package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 15ms Beats 42.19%of users with Java
 * Memory Details 60.03MB Beats 9.35%of users with Java
 */
public class Q287FindTheDuplicateNumber2 {

    @Test
    public void test() {
        assertThat(findDuplicate(new int[]{1, 3, 4, 2, 2})).isEqualTo(2);
        assertThat(findDuplicate(new int[]{3, 1, 3, 4, 2})).isEqualTo(3);
    }

    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        return -1;
    }

}
