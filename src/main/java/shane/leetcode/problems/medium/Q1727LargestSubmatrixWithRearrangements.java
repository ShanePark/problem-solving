package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 31ms Beats 13.25%of users with Java
 * Memory Details 64.90MB Beats 93.98%of users with Java
 */
public class Q1727LargestSubmatrixWithRearrangements {

    @Test
    public void test() {
        assertThat(largestSubmatrix(Ps.intArray("[[0,0,1],[1,1,1],[1,0,1]]")))
                .isEqualTo(4);
        assertThat(largestSubmatrix(Ps.intArray("[[1,0,1,0,1]]"))).isEqualTo(3);
        assertThat(largestSubmatrix(Ps.intArray("[[1,1,0],[1,0,1]]"))).isEqualTo(2);
    }

    public int largestSubmatrix(int[][] matrix) {
        int WIDTH = matrix[0].length;
        int HEIGHT = matrix.length;
        int[][] cols = new int[WIDTH][HEIGHT];
        for (int i = 0; i < WIDTH; i++) {
            int[] col = cols[i];
            int cur = 0;
            for (int j = 0; j < HEIGHT; j++) {
                cur += matrix[j][i];
                if (matrix[j][i] == 0)
                    cur = 0;
                col[j] = cur;
            }
        }

        int max = 0;
        for (int i = 0; i < HEIGHT; i++) {
            List<Integer> sizes = new ArrayList<>();
            for (int j = 0; j < WIDTH; j++) {
                int subHeight = cols[j][i];
                sizes.add(subHeight);
            }
            Collections.sort(sizes);
            for (int j = 0; j < sizes.size(); j++) {
                int subHeight = sizes.get(j);
                int subWidth = sizes.size() - j;
                max = Math.max(max, subWidth * subHeight);
            }
        }

        return max;
    }

}
