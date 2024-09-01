package shane.leetcode.problems.easy;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime5msBeats54.86%
 */
public class Q2022Convert1DArrayInto2DArray {

    @Test
    public void test() {
        assertThat(construct2DArray(new int[]{1, 2, 3, 4}, 2, 2)).isEqualTo(Ps.intArray("[[1,2],[3,4]]"));
        assertThat(construct2DArray(new int[]{1, 2, 3}, 1, 3)).isEqualTo(Ps.intArray("[[1,2,3]]"));
        assertThat(construct2DArray(new int[]{1, 2}, 1, 1)).isEqualTo(Ps.intArray("[]"));
    }

    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[][]{};
        }
        int[][] answer = new int[m][n];
        for (int i = 0; i < original.length; i++) {
            answer[i / n][i % n] = original[i];
        }
        return answer;
    }

}
