package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q2406DivideIntervalsIntoMinimumNumberOfGroups {

    @Test
    public void test() {
        assertThat(minGroups(Ps.intArray("[[5,10],[6,8],[1,5],[2,3],[1,10]]"))).isEqualTo(3);
        assertThat(minGroups(Ps.intArray("[[1,3],[5,6],[8,10],[11,13]]"))).isEqualTo(1);
    }

    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> groups = new ArrayList<>();
        for (int[] interval : intervals) {
            boolean isNewGroup = true;
            for (int[] group : groups) {
                if (!isIntersect(group, interval)) {
                    group[0] = interval[0];
                    group[1] = interval[1];
                    isNewGroup = false;
                    break;
                }
            }
            if (isNewGroup) {
                groups.add(interval);
            }
        }
        return groups.size();
    }

    private boolean isIntersect(int[] group, int[] interval) {
        return group[1] >= interval[0] && group[0] <= interval[1];
    }

}
