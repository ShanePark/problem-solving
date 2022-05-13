package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1207UniqueNumberOfOccurrences {

    @Test
    public void test() {
        assertThat(uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3})).isTrue();
        assertThat(uniqueOccurrences(new int[]{1, 2})).isFalse();
        assertThat(uniqueOccurrences(new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0})).isTrue();
    }

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.merge(i, 1, Integer::sum);
        }
        return map.values().stream().distinct().count() == map.size();
    }
}
