package shane.leetcode.problems.easy;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1266MinimumTimeVisitingAllPoints {

    @Test
    public void test() {
        assertThat(minTimeToVisitAllPoints(STool.convertToIntArray("[[1,1],[3,4],[-1,0]]]"))).isEqualTo(7);
        assertThat(minTimeToVisitAllPoints(STool.convertToIntArray("[[3,2],[-2,2]]"))).isEqualTo(5);
    }

    public int minTimeToVisitAllPoints(int[][] points) {
        int distance = 0;
        int[] cur = points[0];
        for (int i = 1; i < points.length; i++) {
            int[] point = points[i];
            distance += Math.max(Math.abs(cur[0] - point[0]), Math.abs(cur[1] - point[1]));
            cur = point;
        }

        return distance;
    }
}
