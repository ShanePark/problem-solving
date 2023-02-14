package shane.leetcode.problems.xhard;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 55 ms Beats 52.35%
 * Memory 40 MB Beats 95.59%
 */
public class Q149MaxPointsOnALine2 {

    @Test
    public void test() {
        assertThat(maxPoints(Ps.intArray("[[0,0],[1,-1],[1,1]]"))).isEqualTo(2);
        assertThat(maxPoints(Ps.intArray("[[0,0]]"))).isEqualTo(1);
        assertThat(maxPoints(Ps.intArray("[[1,1],[2,2],[3,3]]"))).isEqualTo(3);
        assertThat(maxPoints(Ps.intArray("[[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]"))).isEqualTo(4);
    }

    public int maxPoints(int[][] points) {
        int max = 1;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                max = Math.max(max, countPoints(i, j, points));
            }
        }
        return max;
    }

    private int countPoints(int p1Index, int p2Index, int[][] points) {
        int[] p1 = points[p1Index];
        int[] p2 = points[p2Index];
        int cnt = 0;
        for (int i = 0; i < points.length; i++) {
            int[] p3 = points[i];
            if (i == p1Index || i == p2Index || (p1[0] - p2[0]) * (p2[1] - p3[1]) == (p2[0] - p3[0]) * (p1[1] - p2[1])) {
                cnt++;
            }
        }
        return cnt;
    }

}
