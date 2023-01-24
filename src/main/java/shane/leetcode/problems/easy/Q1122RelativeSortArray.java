package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 3 ms Beats 48.18%
 * Memory 42.3 MB Beats 48.95%
 */
public class Q1122RelativeSortArray {

    @Test
    public void test() {
        assertThat(relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6})).isEqualTo(new int[]{2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19});
        assertThat(relativeSortArray(new int[]{28, 6, 22, 8, 44, 17}, new int[]{22, 28, 8, 6})).isEqualTo(new int[]{22, 28, 8, 6, 17, 44});
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int i : arr1) {
            cntMap.merge(i, 1, Integer::sum);
        }

        int i = 0;
        for (int n : arr2) {
            for (int j = 0; j < cntMap.getOrDefault(n, 1); j++) {
                arr1[i++] = n;
            }
            cntMap.remove(n);
        }
        List<Integer> keys = cntMap.keySet().stream().sorted().collect(Collectors.toList());
        for (Integer k : keys) {
            for (int j = 0; j < cntMap.get(k); j++) {
                arr1[i++] = k;
            }
        }
        return arr1;
    }

}
