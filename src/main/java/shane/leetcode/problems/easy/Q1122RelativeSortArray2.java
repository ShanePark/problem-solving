package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 3 ms Beats 44.47% of users with Java
 */
public class Q1122RelativeSortArray2 {

    @Test
    public void test() {
        assertThat(relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6})).isEqualTo(new int[]{2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19});
        assertThat(relativeSortArray(new int[]{28, 6, 22, 8, 44, 17}, new int[]{22, 28, 8, 6})).isEqualTo(new int[]{22, 28, 8, 6, 17, 44});
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i : arr1) {
            cnt.merge(i, 1, Integer::sum);
        }
        int index = 0;
        for (int i : arr2) {
            Integer count = cnt.get(i);
            for (int j = 0; j < count; j++) {
                arr1[index++] = i;
            }
            cnt.remove(i);
        }
        List<Integer> keys = cnt.keySet().stream().sorted().collect(Collectors.toList());
        for (Integer key : keys) {
            Integer count = cnt.get(key);
            for (int i = 0; i < count; i++) {
                arr1[index++] = key;
            }
        }
        return arr1;
    }

}
