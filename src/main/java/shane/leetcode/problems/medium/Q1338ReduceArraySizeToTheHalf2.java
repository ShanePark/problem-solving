package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 43 ms, faster than 84.15% of Java online submissions for Reduce Array Size to The Half.
 * Memory Usage: 60.3 MB, less than 87.39% of Java online submissions for Reduce Array Size to The Half.
 */
public class Q1338ReduceArraySizeToTheHalf2 {

    @Test
    public void test() {
        assertThat(minSetSize(new int[]{1, 9})).isEqualTo(1);
        assertThat(minSetSize(new int[]{3, 3, 3, 3, 5, 5, 5, 2, 2, 7})).isEqualTo(2);
        assertThat(minSetSize(new int[]{7, 7, 7, 7, 7, 7})).isEqualTo(1);
    }

    public int minSetSize(int[] arr) {
        Map<Integer, Integer> cntMap = new LinkedHashMap<>();
        for (int i : arr) {
            cntMap.merge(i, 1, Integer::sum);
        }
        List<Integer> values = cntMap.values().stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        int sum = 0;
        for (int i = 0; i < values.size(); i++) {
            sum += values.get(i);
            if (sum >= arr.length / 2) {
                return i + 1;
            }
        }
        // never reach here
        return -1;
    }
}
