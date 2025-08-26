package shane.leetcode.problems.easy;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
1ms
Beats96.00%
 */
public class Q3000MaximumAreaOfLongestDiagonalRectangle {

    @Test
    public void test() {
        assertThat(areaOfMaxDiagonal(Ps.intArray("[[9,3],[8,6]]"))).isEqualTo(48);
        assertThat(areaOfMaxDiagonal(Ps.intArray("[[3,4],[4,3]]"))).isEqualTo(12);
    }

    @Test
    public void test2() {
        assertThat(areaOfMaxDiagonal(Ps.intArray("[[2,6],[5,1],[3,10],[8,4]]"))).isEqualTo(30);
        assertThat(areaOfMaxDiagonal(Ps.intArray("[[6,5],[8,6],[2,10],[8,1],[9,2],[3,5],[3,5]]"))).isEqualTo(20);
    }

    public int areaOfMaxDiagonal(int[][] dimensions) {
        double max = 0;
        int answer = 0;
        for (int[] dimension : dimensions) {
            double diagonal = Math.sqrt(dimension[0] * dimension[0] + dimension[1] * dimension[1]);
            if (diagonal < max) {
                continue;
            }
            if (diagonal == max) {
                answer = Math.max(answer, dimension[0] * dimension[1]);
            } else {
                answer = dimension[0] * dimension[1];
            }
            max = diagonal;
        }
        return answer;
    }

}
