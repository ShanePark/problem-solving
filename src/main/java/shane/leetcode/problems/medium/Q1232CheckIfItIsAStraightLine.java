package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Runtime 0 ms Beats 100%
 * Memory 43.4 MB Beats 7.31%
 */
public class Q1232CheckIfItIsAStraightLine {

    @Test
    void test() {
        Assertions.assertThat(checkStraightLine(Ps.intArray("[[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]"))).isTrue();
        Assertions.assertThat(checkStraightLine(Ps.intArray("[[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]"))).isFalse();
    }

    public boolean checkStraightLine(int[][] coordinates) {
        for (int i = 0; i < coordinates.length - 2; i++) {
            int[] point1 = coordinates[i];
            int[] point2 = coordinates[i + 1];
            int[] point3 = coordinates[i + 2];
            if ((point2[1] - point1[1]) * (point3[0] - point2[0]) == (point2[0] - point1[0]) * (point3[1] - point2[1])) {
                continue;
            }
            return false;

        }
        return true;
    }
}
