package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 2 ms Beats 44.45% of users with Java
 */
public class Q57InsertInterval2 {

    @Test
    public void test() {
        assertThat(insert(Ps.intArray("[[1,3],[6,9]]"), new int[]{2, 5}))
                .isEqualTo(Ps.intArray("[[1,5],[6,9]]"));
        assertThat(insert(Ps.intArray("[[1,2],[3,5],[6,7],[8,10],[12,16]]"), new int[]{4, 8}))
                .isEqualTo(Ps.intArray("[[1,2],[3,10],[12,16]]"));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> answer = new ArrayList<>();
        for (int[] interval : intervals) {
            if (isOverlap(interval, newInterval)) {
                newInterval = new int[]{Math.min(interval[0], newInterval[0]), Math.max(interval[1], newInterval[1])};
                continue;
            }
            answer.add(interval);
        }

        for (int i = 0; i < answer.size(); i++) {
            int[] cur = answer.get(i);
            if (newInterval[0] < cur[0]) {
                answer.add(i, newInterval);
                newInterval = null;
                break;
            }
        }
        if (newInterval != null) {
            answer.add(newInterval);
        }

        return answer.toArray(new int[][]{});
    }

    private boolean isOverlap(int[] interval, int[] newInterval) {
        if (interval[1] < newInterval[0])
            return false;
        if (interval[0] > newInterval[1])
            return false;
        return true;
    }

}
