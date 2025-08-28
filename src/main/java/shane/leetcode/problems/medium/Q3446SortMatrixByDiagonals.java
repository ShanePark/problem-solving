package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 6ms
 * Beats42.20%
 */
public class Q3446SortMatrixByDiagonals {

    @Test
    public void test() {
        assertThat(sortMatrix(Ps.intArray("[[1,7,3],[9,8,2],[4,5,6]]"))).isEqualTo(Ps.intArray("[[8,2,3],[9,6,7],[4,5,1]]"));
        assertThat(sortMatrix(Ps.intArray("[[0,1],[1,2]]"))).isEqualTo(Ps.intArray("[[2,1],[1,0]]"));
    }

    public int[][] sortMatrix(int[][] grid) {
        int LENGTH = grid.length;
        for (int i = 0; i < LENGTH; i++) {
            List<int[]> points = new ArrayList<>();
            for (int k = 0; i + k < LENGTH; k++) {
                points.add(new int[]{i + k, k});
            }
            sort(grid, points, Comparator.reverseOrder());
        }
        for (int j = 1; j < LENGTH; j++) {
            List<int[]> points = new ArrayList<>();
            for (int k = 0; j + k < LENGTH; k++) {
                points.add(new int[]{k, j + k});
            }
            sort(grid, points, Comparator.naturalOrder());
        }
        return grid;
    }

    private void sort(int[][] grid, List<int[]> points, Comparator<Integer> comparator) {
        List<Integer> nums = new ArrayList<>();
        for (int[] point : points) {
            nums.add(grid[point[0]][point[1]]);
        }
        nums.sort(comparator);
        for (int i = 0; i < nums.size(); i++) {
            int[] point = points.get(i);
            grid[point[0]][point[1]] = nums.get(i);
        }
    }

}
