package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 19 ms, faster than 91.55% of Java online submissions for Contains Duplicate II.
 * Memory Usage: 54.4 MB, less than 85.76% of Java online submissions for Contains Duplicate II.
 */
public class Q219ContainsDuplicateII2 {

    @Test
    public void test() {
        assertThat(containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3)).isTrue();
        assertThat(containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1)).isTrue();
        assertThat(containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2)).isFalse();
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
            if (set.size() > k) {
                set.remove(set.iterator().next());
            }
        }
        return false;
    }
}
