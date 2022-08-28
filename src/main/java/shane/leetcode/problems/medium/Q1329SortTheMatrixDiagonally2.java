package shane.leetcode.problems.medium;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 3 ms, faster than 93.75% of Java online submissions for Sort the Matrix Diagonally.
 * Memory Usage: 47.9 MB, less than 56.25% of Java online submissions for Sort the Matrix Diagonally.
 */
public class Q1329SortTheMatrixDiagonally2 {

    @Test
    public void test() {
        assertThat(diagonalSort(STool.convertToIntArray("[[37,98,82,45,42]]")))
                .isDeepEqualTo(STool.convertToIntArray("[[37, 98, 82, 45, 42]]"));
        assertThat(diagonalSort(STool.convertToIntArray("[[3,3,1,1],[2,2,1,2],[1,1,1,2]]")))
                .isDeepEqualTo(STool.convertToIntArray("[[1,1,1,1],[1,2,2,2],[1,2,3,3]]"));
        assertThat(diagonalSort(STool.convertToIntArray("[[11,25,66,1,69,7],[23,55,17,45,15,52],[75,31,36,44,58,8],[22,27,33,25,68,4],[84,28,14,11,5,50]]")))
                .isDeepEqualTo(STool.convertToIntArray("[[5,17,4,1,52,7],[11,11,25,45,8,69],[14,23,25,44,58,15],[22,27,31,36,50,66],[84,28,75,33,55,68]]"));
    }

    public int[][] diagonalSort(int[][] mat) {
        int HEIGHT = mat.length;
        int WIDTH = mat[0].length;
        int[][] answer = new int[HEIGHT][WIDTH];
        for (int i = HEIGHT - 1; i >= 0; i--) {
            int[] bucket = new int[101];
            for (int j = 0; j < HEIGHT - i && j < WIDTH; j++) {
                bucket[mat[i + j][j]]++;
            }
            int k = 0;
            for (int j = 0; j < HEIGHT - i && j < WIDTH; j++) {
                k = get(bucket, k);
                answer[i + j][j] = k;
            }
        }
        for (int j = 1; j < WIDTH; j++) {
            int[] bucket = new int[101];
            for (int i = 0; i < WIDTH - j && i < HEIGHT; i++) {
                bucket[mat[i][j + i]]++;
            }
            int k = 0;
            for (int i = 0; i < WIDTH - j && i < HEIGHT; i++) {
                k = get(bucket, k);
                answer[i][j + i] = k;
            }

        }

        return answer;
    }

    private int get(int[] bucket, int k) {
        for (; k < bucket.length; k++) {
            if (bucket[k] > 0) {
                bucket[k]--;
                return k;
            }
        }
        return -1;
    }
}
