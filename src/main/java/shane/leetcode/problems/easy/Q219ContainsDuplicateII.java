package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 39 ms, faster than 73.19% of Java online submissions for Contains Duplicate II.
 * Memory Usage: 89.3 MB, less than 55.95% of Java online submissions for Contains Duplicate II.
 */
public class Q219ContainsDuplicateII {

    @Test
    public void test() {
        assertThat(containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3)).isTrue();
        assertThat(containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1)).isTrue();
        assertThat(containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2)).isFalse();
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        List<Integer> list = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            list.add(num);
            if (!set.add(num)) {
                return true;
            }
            if (list.size() > k) {
                Integer first = list.remove(0);
                set.remove(first);
            }
        }
        return false;
    }
}
