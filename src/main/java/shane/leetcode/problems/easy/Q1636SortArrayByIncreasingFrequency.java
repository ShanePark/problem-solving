package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 21 ms, faster than 13.40% of Java online submissions for Sort Array by Increasing Frequency.
 * Memory Usage: 45.2 MB, less than 10.19% of Java online submissions for Sort Array by Increasing Frequency.
 */
public class Q1636SortArrayByIncreasingFrequency {

    @Test
    public void test() {
        assertThat(frequencySort(new int[]{1, 1, 2, 2, 2, 3})).containsExactly(3, 1, 1, 2, 2, 2);
        assertThat(frequencySort(new int[]{2, 3, 1, 3, 2})).containsExactly(1, 3, 3, 2, 2);
        assertThat(frequencySort(new int[]{-1, 1, -6, 4, 5, -6, 1, 4, 1})).containsExactly(5, -1, 4, 4, -6, -6, 1, 1, 1);
    }

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        map.entrySet().stream().sorted((e1, e2) -> {
            if (e1.getValue() == e2.getValue()) {
                return Integer.compare(e2.getKey(), e1.getKey());
            }
            return Integer.compare(e1.getValue(), e2.getValue());
        }).forEach(e -> {
            for (int i = 0; i < e.getValue(); i++) {
                list.add(e.getKey());
            }
        });
        return list.stream().mapToInt(i -> i).toArray();
    }

}
