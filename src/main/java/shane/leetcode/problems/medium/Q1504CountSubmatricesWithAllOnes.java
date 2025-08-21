package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE 72 / 73 testcases passed
 */
public class Q1504CountSubmatricesWithAllOnes {

    @Test
    public void test() {
        assertThat(numSubmat(Ps.intArray("[[1,0,1],[1,1,0],[1,1,0]]"))).isEqualTo(13);
        assertThat(numSubmat(Ps.intArray("[[0,1,1,0],[0,1,1,1],[1,1,1,0]]"))).isEqualTo(24);
    }

    /**
     * 4 sec
     */
    @Test
    public void tle() {
        int[][] arr = new int[150][150];
        for (int[] ints : arr) {
            Arrays.fill(ints, 1);
        }
        assertThat(numSubmat(arr)).isEqualTo(128255625);
    }

    public int numSubmat(int[][] mat) {
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                sum += findSubmatrices(mat, i, j);
            }
        }
        return sum;
    }

    private int findSubmatrices(int[][] mat, int i, int j) {
        final int HEIGHT = mat.length;
        final int WIDTH = mat[0].length;
        int cnt = 0;
        for (int height = 1; i + height <= HEIGHT; height++) {
            wLoop:
            for (int width = 1; j + width <= WIDTH; width++) {
                for (int k = 0; k < height; k++) {
                    if (mat[i + k][j + width - 1] == 0)
                        break wLoop;
                }
                cnt++;
            }
        }
        return cnt;
    }

}
