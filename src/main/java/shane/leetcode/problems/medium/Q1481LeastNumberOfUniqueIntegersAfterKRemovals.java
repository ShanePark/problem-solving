package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 59 ms Beats 33.37% of users with Java
 */
public class Q1481LeastNumberOfUniqueIntegersAfterKRemovals {

    @Test
    public void test() {
        assertThat(findLeastNumOfUniqueInts(new int[]{5, 5, 4}, 1)).isEqualTo(1);
        assertThat(findLeastNumOfUniqueInts(new int[]{4, 3, 1, 1, 3, 3, 2}, 3)).isEqualTo(2);
    }

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i : arr) {
            cnt.merge(i, 1, Integer::sum);
        }
        List<Map.Entry<Integer, Integer>> entries = cnt.entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry::getValue))
                .collect(Collectors.toList());
        int unique = cnt.size();
        for (Map.Entry<Integer, Integer> e : entries) {
            if (k < e.getValue()) {
                break;
            }
            k -= e.getValue();
            unique--;
        }
        return unique;
    }

}
