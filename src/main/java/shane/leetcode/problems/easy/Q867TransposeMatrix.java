package shane.leetcode.problems.easy;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q867TransposeMatrix {

    @Test
    public void test() {
        assertThat(transpose(Ps.intArray("[[1,2,3],[4,5,6],[7,8,9]]"))).isDeepEqualTo(Ps.intArray("[[1,4,7],[2,5,8],[3,6,9]]"));
        assertThat(transpose(Ps.intArray("[[1,2,3],[4,5,6]]"))).isDeepEqualTo(Ps.intArray("[[1,4],[2,5],[3,6]]"));
    }

    public int[][] transpose(int[][] matrix) {
        int[][] answer = new int[matrix[0].length][matrix.length];
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                answer[j][i] = matrix[i][j];
            }
        }
        return answer;
    }
}
