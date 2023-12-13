package shane.leetcode.problems.easy;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 2ms Beats 88.89%of users with Java
 * Memory Details 44.17MB Beats 31.31%of users with Java
 */
public class Q1582SpecialPositionsInABinaryMatrix {

    @Test
    public void test() {
        assertThat(numSpecial(Ps.intArray("[[1,0,0],[0,0,1],[1,0,0]]"))).isEqualTo(1);
        assertThat(numSpecial(Ps.intArray("[[1,0,0],[0,1,0],[0,0,1]]"))).isEqualTo(3);
    }

    public int numSpecial(int[][] mat) {
        int cnt = 0;
        int length = mat.length;
        int width = mat[0].length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (isSpecial(mat, i, j)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private boolean isSpecial(int[][] mat, int i, int j) {
        if (mat[i][j] == 0)
            return false;
        for (int k = 0; k < mat.length; k++) {
            if (mat[k][j] == 1 && k != i)
                return false;
        }
        for (int k = 0; k < mat[0].length; k++) {
            if (mat[i][k] == 1 && k != j)
                return false;
        }
        return true;
    }

}
