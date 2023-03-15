package shane.leetcode.problems.easy;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 8 ms Beats 7.80%
 * Memory 43.3 MB Beats 16.26%
 */
public class Q2570MergeTwo2DArraysBySummingValues {

    @Test
    void test() {
        assertThat(mergeArrays(Ps.intArray("[[1,2],[2,3],[4,5]]"), Ps.intArray("[[1,4],[3,2],[4,1]]"))
                .equals(Ps.intArray("[[1,6],[2,3],[3,2],[4,6]]")));
    }

    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] ints : nums1) {
            map.put(ints[0], ints[1]);
        }
        for (int[] ints : nums2) {
            map.merge(ints[0], ints[1], Integer::sum);
        }
        return map.keySet().stream().sorted().map(index -> {
            Integer value = map.get(index);
            return new int[]{index, value};
        }).toArray(i -> new int[map.size()][2]);
    }
}
