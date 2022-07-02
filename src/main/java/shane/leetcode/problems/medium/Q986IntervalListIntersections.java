package shane.leetcode.problems.medium;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 14 ms, faster than 6.95% of Java online submissions for Interval List Intersections.
 * Memory Usage: 54.7 MB, less than 45.90% of Java online submissions for Interval List Intersections.
 */
public class Q986IntervalListIntersections {

    @Test
    public void test() {
        assertThat(intervalIntersection(STool.convertToIntArray("[[0,2],[5,10],[13,23],[24,25]]"), STool.convertToIntArray("[[1,5],[8,12],[15,24],[25,26]]")))
                .isDeepEqualTo(STool.convertToIntArray("[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]"));
        assertThat(intervalIntersection(STool.convertToIntArray("[[1,3],[5,9]]"), STool.convertToIntArray("[]")))
                .isDeepEqualTo(STool.convertToIntArray("[]"));
    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> answer = new ArrayList<>();
        int p1 = 0, p2 = 0;

        while (p1 < firstList.length && p2 < secondList.length) {
            int[] a = firstList[p1];
            int[] b = secondList[p2];
            if (a[0] > b[1]) {
                p2++;
            } else if (a[1] < b[0]) {
                p1++;
            } else {
                answer.add(new int[]{Math.max(a[0], b[0]), Math.min(a[1], b[1])});
                if (a[1] < b[1]) {
                    p1++;
                } else {
                    p2++;
                }
            }
        }

//        return answer.stream().toArray(value -> new int[answer.size()][2]);
        int[][] result = new int[answer.size()][2];
        for (int i = 0; i < result.length; i++) {
            result[i] = answer.get(i);
        }
        return result;
    }
}
