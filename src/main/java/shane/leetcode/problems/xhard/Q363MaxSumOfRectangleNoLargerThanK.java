package shane.leetcode.problems.xhard;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q363MaxSumOfRectangleNoLargerThanK {

    @Test
    public void test() {
        assertThat(maxSumSubmatrix(Ps.intArray("[[1,0,1],[0,-2,3]]"), 2)).isEqualTo(2);
        assertThat(maxSumSubmatrix(Ps.intArray("[[2,2,-1]]"), 3)).isEqualTo(3);
    }

    public int maxSumSubmatrix(int[][] matrix, int k) {
        final int HEIGHT = matrix.length;
        final int WIDTH = matrix[0].length;
        int max = HEIGHT * WIDTH * -100;

        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                for (int y = 1; y <= HEIGHT; y++) {
                    for (int x = 1; x <= WIDTH; x++) {
                        int sum = 0;
                        for (int i1 = 0; i1 < y && i + i1 < HEIGHT; i1++) {
                            for (int j1 = 0; j1 < x && j + j1 < WIDTH; j1++) {
                                sum += matrix[i + i1][j + j1];
                            }
                        }
                        if (max < sum && sum <= k) {
                            max = sum;
                        }
                    }
                }

            }
        }

        return max;
    }

}
