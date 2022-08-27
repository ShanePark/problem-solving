package shane.leetcode.problems.xhard;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not really understood
 * Runtime: 831 ms, faster than 26.60% of Java online submissions for Max Sum of Rectangle No Larger Than K.
 * Memory Usage: 117.6 MB, less than 26.79% of Java online submissions for Max Sum of Rectangle No Larger Than K.
 */
public class Q363MaxSumOfRectangleNoLargerThanK2 {

    @Test
    public void test() {
        assertThat(maxSumSubmatrix(STool.convertToIntArray("[[5,-4,-3,4],[-3,-4,4,5],[5,1,5,-4]]"), 3))
                .isEqualTo(2);
        assertThat(maxSumSubmatrix(STool.convertToIntArray("[[2,2,-1]]"), 2)).isEqualTo(2);
        assertThat(maxSumSubmatrix(STool.convertToIntArray("[[1,0,1],[0,-2,3]]"), 5)).isEqualTo(4);
        assertThat(maxSumSubmatrix(STool.convertToIntArray("[[1,0,1],[0,-2,3]]"), 2)).isEqualTo(2);
        assertThat(maxSumSubmatrix(STool.convertToIntArray("[[2,2,-1]]"), 3)).isEqualTo(3);
        assertThat(maxSumSubmatrix(STool.convertToIntArray("[[5,-4,-3,4],[-3,-4,4,5],[5,1,5,-4]]"), 8))
                .isEqualTo(8);
    }

    public int maxSumSubmatrix(int[][] matrix, int k) {
        final int HEIGHT = matrix.length;
        final int WIDTH = matrix[0].length;

        int answer = Integer.MIN_VALUE;

        for (int x = 0; x < WIDTH; x++) {
            int[] lines = new int[HEIGHT];
            for (int length = 1; x + length - 1 < WIDTH; length++) {
                for (int i = 0; i < HEIGHT; i++) {
                    lines[i] += matrix[i][x + length - 1];
                }

                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);

                int sum = 0;
                for (int line : lines) {
                    sum += line;
                    Integer num = set.ceiling(sum - k);
                    if (num != null)
                        answer = Math.max(answer, sum - num);
                    set.add(sum);
                }
            }
        }

        return answer;
    }


}
