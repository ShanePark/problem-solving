package shane.leetcode.problems.easy;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 1ms Beats 95.62%of users with Java
 * Memory Details 43.46MB Beats 8.44%of users with Java
 */
public class Q1266MinimumTimeVisitingAllPoints2 {

    @Test
    public void test() {
        assertThat(minTimeToVisitAllPoints(Ps.intArray("[[1,1],[3,4],[-1,0]]]"))).isEqualTo(7);
        assertThat(minTimeToVisitAllPoints(Ps.intArray("[[3,2],[-2,2]]"))).isEqualTo(5);
    }

    public int minTimeToVisitAllPoints(int[][] points) {
        int distance = 0;
        for (int i = 1; i < points.length; i++) {
            int[] before = points[i - 1];
            int[] cur = points[i];
            int yDiff = Math.abs(before[1] - cur[1]);
            int xDiff = Math.abs(before[0] - cur[0]);
            distance += Math.max(xDiff, yDiff);
        }
        return distance;
    }

}
