package shane.leetcode.contest.weekly.w299;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1 {

    @Test
    public void test() {
        assertThat(checkXMatrix(Ps.intArray("[[2,0,0,1],[0,3,1,0],[0,5,2,0],[4,0,0,2]]"))).isEqualTo(true);
        assertThat(checkXMatrix(Ps.intArray("[[5,7,0],[0,3,1],[0,5,0]]"))).isFalse();
    }

    public boolean checkXMatrix(int[][] grid) {
        int length = grid.length;
        boolean[][] diag = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            diag[i][i] = true;
            diag[length - 1 - i][i] = true;
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (diag[i][j] && grid[i][j] == 0)
                    return false;
                if (!diag[i][j] && grid[i][j] != 0)
                    return false;
            }
        }
        return true;
    }

}
