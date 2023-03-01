package shane.leetcode.problems.easy;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 21 ms, faster than 84.39% of Java online submissions for Minimum Absolute Difference.
 * Memory Usage: 61.4 MB, less than 68.86% of Java online submissions for Minimum Absolute Difference.
 */
public class Q1200MinimumAbsoluteDifference {

    @Test
    public void test() {
        assertThat(minimumAbsDifference(new int[]{4, 2, 1, 3})).isEqualTo(Ps.intList("[[1,2],[2,3],[3,4]]"));
        assertThat(minimumAbsDifference(new int[]{1, 3, 6, 10, 15})).isEqualTo(Ps.intList("[[1,3]]"));
        assertThat(minimumAbsDifference(new int[]{3, 8, -10, 23, 19, -4, -14, 27})).isEqualTo(Ps.intList("[[-14,-10],[19,23],[23,27]]"));
    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            int cur = arr[i];
            int before = arr[i - 1];
            int diff = cur - before;
            if (diff < minDiff) {
                list.clear();
                minDiff = diff;
                list.add(List.of(before, cur));
            } else if (diff == minDiff) {
                list.add(List.of(before, cur));
            }
        }
        return list;
    }

}
