package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1504CountSubmatricesWithAllOnes2 {

    @Test
    public void test() {
        assertThat(numSubmat(Ps.intArray("[[1,0,1],[1,1,0],[1,1,0]]"))).isEqualTo(13);
        assertThat(numSubmat(Ps.intArray("[[0,1,1,0],[0,1,1,1],[1,1,1,0]]"))).isEqualTo(24);
    }

    @Test
    public void test2() {
        assertThat(numSubmat(Ps.intArray("[[1,0,1],[0,1,0],[1,0,1]]"))).isEqualTo(5);
    }

    @Test
    public void tle() {
        int[][] arr = new int[150][150];
        for (int[] ints : arr) {
            Arrays.fill(ints, 1);
        }
        assertThat(numSubmat(arr)).isEqualTo(128255625);
    }

    public int numSubmat(int[][] mat) {
        int cnt = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0)
                    continue;
                mat[i][j] = (j == 0) ? 1 : mat[i][j - 1] + 1;
                int min = mat[i][j];
                for (int k = i; k >= 0; k--) {
                    min = Math.min(min, mat[k][j]);
                    cnt += min;
                }
            }
        }
        return cnt;
    }

}
