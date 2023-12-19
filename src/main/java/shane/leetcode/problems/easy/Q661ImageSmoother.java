package shane.leetcode.problems.easy;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 4ms Beats 93.84%of users with Java
 * Memory Details 44.76MB Beats 33.89%of users with Java
 */
public class Q661ImageSmoother {

    @Test
    public void test() {
        assertThat(imageSmoother(Ps.intArray("[[1,1,1],[1,0,1],[1,1,1]]")))
                .isEqualTo(Ps.intArray("[[0,0,0],[0,0,0],[0,0,0]]"));
        assertThat(imageSmoother(Ps.intArray("[[100,200,100],[200,50,200],[100,200,100]]")))
                .isEqualTo(Ps.intArray("[[137,141,137],[141,138,141],[137,141,137]]"));
    }

    public int[][] imageSmoother(int[][] img) {
        int[][] answer = new int[img.length][img[0].length];
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[0].length; j++) {
                answer[i][j] = smoother(img, i, j);
            }
        }
        return answer;
    }

    private int smoother(int[][] img, int i, int j) {
        int sum = 0;
        int cnt = 0;
        for (int y = Math.max(0, i - 1); y <= Math.min(img.length - 1, i + 1); y++) {
            for (int x = Math.max(0, j - 1); x <= Math.min(img[0].length - 1, j + 1); x++) {
                sum += img[y][x];
                cnt++;
            }
        }
        return sum / cnt;
    }

}
