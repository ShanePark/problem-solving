package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q3363FindTheMaximumNumberOfFruitsCollected {

    @Test
    public void test() {
        assertThat(maxCollectedFruits(Ps.intArray("[[1,2,3,4],[5,6,8,7],[9,10,11,12],[13,14,15,16]]"))).isEqualTo(100);
        assertThat(maxCollectedFruits(Ps.intArray("[[1,1],[1,1]]"))).isEqualTo(4);
    }

    public int maxCollectedFruits(int[][] fruits) {
        final int LENGTH = fruits.length;
        for (int i = 0; i < LENGTH; i++) {
            for (int j = 0; j < LENGTH; j++) {
                if (i < j && j < LENGTH - 1 - i) {
                    fruits[i][j] = 0;
                }
                if (j < i && i < LENGTH - 1 - j) {
                    fruits[i][j] = 0;
                }
            }
        }

        int first = 0;
        for (int i = 0; i < LENGTH; i++) {
            first += fruits[i][i];
        }

        for (int i = 1; i < LENGTH; i++) {
            for (int j = i + 1; j < LENGTH; j++) {
                fruits[i][j] += Math.max(fruits[i - 1][j - 1], Math.max(fruits[i - 1][j], (j + 1 < LENGTH) ? fruits[i - 1][j + 1] : 0));
            }
        }

        for (int j = 1; j < LENGTH; j++) {
            for (int i = j + 1; i < LENGTH; i++) {
                fruits[i][j] += Math.max(fruits[i - 1][j - 1], Math.max(fruits[i][j - 1], (i + 1 < LENGTH) ? fruits[i + 1][j - 1] : 0));
            }
        }

        return first + fruits[LENGTH - 1][LENGTH - 2] + fruits[LENGTH - 2][LENGTH - 1];
    }

}
