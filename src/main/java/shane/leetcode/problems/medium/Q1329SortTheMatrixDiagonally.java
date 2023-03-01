package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1329SortTheMatrixDiagonally {

    @Test
    public void test() {
        assertThat(diagonalSort(Ps.intArray("[[3,3,1,1],[2,2,1,2],[1,1,1,2]]")))
                .isDeepEqualTo(Ps.intArray("[[1,1,1,1],[1,2,2,2],[1,2,3,3]]"));
        assertThat(diagonalSort(Ps.intArray("[[11,25,66,1,69,7],[23,55,17,45,15,52],[75,31,36,44,58,8],[22,27,33,25,68,4],[84,28,14,11,5,50]]")))
                .isDeepEqualTo(Ps.intArray("[[5,17,4,1,52,7],[11,11,25,45,8,69],[14,23,25,44,58,15],[22,27,31,36,50,66],[84,28,75,33,55,68]]"));
    }

    public int[][] diagonalSort(int[][] mat) {
        // GO UP
        for (int i = mat.length - 1; i > 0; i--) {
            List<Integer> list = new ArrayList<>();
            int i2 = i;
            for (int j = 0; j < mat[0].length && i2 < mat.length; i2++, j++) {
                list.add(mat[i2][j]);
            }
            i2 = i;
            Collections.sort(list);
            for (int j = 0; j < mat[0].length && i2 < mat.length; i2++, j++) {
                mat[i2][j] = list.get(j);
            }
        }

        // GO RIGHT
        for (int j = 0; j < mat[0].length; j++) {
            List<Integer> list = new ArrayList<>();
            int j2 = j;
            for (int i = 0; j2 < mat[0].length && i < mat.length; i++, j2++) {
                list.add(mat[i][j2]);
            }
            j2 = j;
            Collections.sort(list);
            for (int i = 0; j2 < mat[0].length && i < mat.length; i++, j2++) {
                mat[i][j2] = list.get(i);
            }
        }

        return mat;
    }
}
