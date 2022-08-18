package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 86 ms, faster than 60.83% of Java online submissions for Reduce Array Size to The Half.
 * Memory Usage: 85 MB, less than 63.51% of Java online submissions for Reduce Array Size to The Half.
 */
public class Q1338ReduceArraySizeToTheHalf {

    @Test
    public void test() {
        assertThat(minSetSize(new int[]{3, 3, 3, 3, 5, 5, 5, 2, 2, 7})).isEqualTo(2);
        assertThat(minSetSize(new int[]{7, 7, 7, 7, 7, 7})).isEqualTo(1);
    }

    public int minSetSize(int[] arr) {
        Map<Integer, Integer> cntMap = new LinkedHashMap<>();
        for (int i : arr) {
            cntMap.merge(i, 1, Integer::sum);
        }

        List<Integer> values = cntMap.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> e.getValue()))
                .map(e -> e.getValue())
                .collect(Collectors.toList());
        int cnt = 0;
        int sum = 0;
        for (int i = values.size() - 1; i >= 0; i--) {
            sum += values.get(i);
            cnt++;
            if (sum >= arr.length / 2) {
                return cnt;
            }
        }
        return -1;
    }
}
