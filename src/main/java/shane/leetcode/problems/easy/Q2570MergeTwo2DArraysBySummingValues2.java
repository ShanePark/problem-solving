package shane.leetcode.problems.easy;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 8
 * ms
 * Beats
 * 14.37%
 */
public class Q2570MergeTwo2DArraysBySummingValues2 {

    @Test
    void test() {
        assertThat(mergeArrays(Ps.intArray("[[1,2],[2,3],[4,5]]"), Ps.intArray("[[1,4],[3,2],[4,1]]"))
                .equals(Ps.intArray("[[1,6],[2,3],[3,2],[4,6]]")));
        assertThat(mergeArrays(Ps.intArray("[[2,4],[3,6],[5,5]]"), Ps.intArray("[[1,3],[4,3]]"))
                .equals(Ps.intArray("[[1,3],[2,4],[3,6],[4,3],[5,5]]")));

    }

    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> sum = new HashMap<>();
        for (int[] ints : nums1) {
            sum.merge(ints[0], ints[1], Integer::sum);
        }
        for (int[] ints : nums2) {
            sum.merge(ints[0], ints[1], Integer::sum);
        }
        return sum.entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry::getKey))
                .map(e -> new int[]{e.getKey(), e.getValue()})
                .toArray(int[][]::new);
    }

}
