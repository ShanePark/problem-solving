package shane.leetcode.problems.easy;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q832FlippingAnImage {

    @Test
    public void test() {
        assertThat(flipAndInvertImage(Ps.intArray("[[1,1,0],[1,0,1],[0,0,0]]")))
                .isDeepEqualTo(Ps.intArray("[[1,0,0],[0,1,0],[1,1,1]]"));
    }

    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        int[][] answer = new int[n][image.length];
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                answer[i][j] = image[i][n - 1 - j] == 0 ? 1 : 0;
            }
        }
        return answer;
    }
}
