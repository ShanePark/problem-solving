package shane.leetcode.problems.easy;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q812LargestTriangleArea {

    @Test
    public void test() {
        assertThat(largestTriangleArea(Ps.intArray("[[0,0],[0,1],[1,0],[0,2],[2,0]]"))).isEqualTo(2);
        assertThat(largestTriangleArea(Ps.intArray("[[1,0],[0,0],[0,1]]"))).isEqualTo(0.5);
    }

    public double largestTriangleArea(int[][] points) {
        double max = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    int abx = points[j][0] - points[i][0];
                    int aby = points[j][1] - points[i][1];
                    int acx = points[k][0] - points[i][0];
                    int acy = points[k][1] - points[i][1];

                    int crossProduct = abx * acy - acx * aby;
                    double area = 0.5 * Math.abs(crossProduct);
                    max = Math.max(max, area);
                }
            }
        }
        return max;
    }

}
