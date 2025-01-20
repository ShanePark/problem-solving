package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
60ms
Beats11.44%
 */
public class Q2661FirstCompletelyPaintedRowOrColumn {

    @Test
    public void test() {
        assertThat(firstCompleteIndex(new int[]{1, 3, 4, 2}, Ps.intArray("[[1,4],[2,3]]"))).isEqualTo(2);
        assertThat(firstCompleteIndex(new int[]{2, 8, 7, 4, 1, 3, 5, 6, 9}, Ps.intArray("[[3,2,5],[1,4,6],[8,7,9]]"))).isEqualTo(3);
    }

    public int firstCompleteIndex(int[] arr, int[][] mat) {
        final int HEIGHT = mat.length;
        final int WIDTH = mat[0].length;
        Map<Integer, RowOrColumn> rows = new HashMap<>();
        Map<Integer, RowOrColumn> cols = new HashMap<>();
        for (int i = 0; i < HEIGHT; i++) {
            rows.put(i, new RowOrColumn(WIDTH));
        }
        for (int i = 0; i < WIDTH; i++) {
            cols.put(i, new RowOrColumn(HEIGHT));
        }
        Map<Integer, int[]> coordinate = new HashMap<>();
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                coordinate.put(mat[i][j], new int[]{i, j});
            }
        }
        for (int i = 0; i < arr.length; i++) {
            int[] point = coordinate.get(arr[i]);
            int y = point[0];
            int x = point[1];
            if (rows.get(y).addAndReturnIsComplete(x))
                return i;
            if (cols.get(x).addAndReturnIsComplete(y))
                return i;
        }
        return -1;
    }

    static class RowOrColumn {
        final int fullSize;
        Set<Integer> painted = new HashSet<>();

        RowOrColumn(int fullSize) {
            this.fullSize = fullSize;
        }

        public boolean addAndReturnIsComplete(int i) {
            this.painted.add(i);
            return painted.size() == fullSize;
        }
    }

}
