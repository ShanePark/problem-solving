package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static com.tistory.shanepark.STool.convertToIntArray;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 65 ms, faster than 53.94% of Java online submissions for Image Overlap.
 * Memory Usage: 41.7 MB, less than 95.15% of Java online submissions for Image Overlap.
 */
public class Q835ImageOverlap {

    @Test
    public void test() {
        assertThat(largestOverlap(convertToIntArray("[[1,1,0],[0,1,0],[0,1,0]]"), convertToIntArray("[[0,0,0],[0,1,1],[0,0,1]]"))).isEqualTo(3);
        assertThat(largestOverlap(convertToIntArray("[[1]]"), convertToIntArray("[[1]]"))).isEqualTo(1);
        assertThat(largestOverlap(convertToIntArray("[[0]]"), convertToIntArray("[[0]]"))).isEqualTo(0);
    }

    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int[][] big1 = new int[3 * n - 2][3 * n - 2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                big1[n + i - 1][n + j - 1] = img1[i][j];
            }
        }
        int max = 0;
        for (int i = 0; i < 2 * n - 1; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                max = Math.max(max, count(big1, img2, n, i, j));
            }
        }
        return max;
    }

    private int count(int[][] big1, int[][] img2, int n, int y, int x) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (big1[y + i][x + j] == 1 && img2[i][j] == 1) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
