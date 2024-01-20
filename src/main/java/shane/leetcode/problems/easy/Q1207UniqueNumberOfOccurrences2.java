package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 2 ms Beats 98.10% of users with Java
 */
public class Q1207UniqueNumberOfOccurrences2 {

    @Test
    public void test() {
        assertThat(uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3})).isTrue();
        assertThat(uniqueOccurrences(new int[]{1, 2})).isFalse();
        assertThat(uniqueOccurrences(new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0})).isTrue();
    }

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i : arr) {
            cnt.merge(i, 1, Integer::sum);
        }
        Set<Integer> set = new HashSet<>();
        for (Integer value : cnt.values()) {
            if (!set.add(value))
                return false;
        }
        return true;
    }

}
