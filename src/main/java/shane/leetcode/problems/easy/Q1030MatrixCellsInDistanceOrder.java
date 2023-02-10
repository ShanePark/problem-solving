package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 21 ms Beats 42.62%
 * Memory 44 MB Beats 94.51%
 */
public class Q1030MatrixCellsInDistanceOrder {

    @Test
    public void test() {
        assertThat(allCellsDistOrder(1, 2, 0, 0)).isEqualTo(new int[][]{{0, 0}, {0, 1}});
        assertThat(allCellsDistOrder(2, 2, 0, 1)).isEqualTo(new int[][]{{0, 1}, {0, 0}, {1, 1}, {1, 0}});
    }

    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                list.add(new int[]{i, j});
            }
        }
        return list.stream()
                .sorted((a1, a2) -> Integer.compare(distance(a1, rCenter, cCenter), distance(a2, rCenter, cCenter)))
                .toArray(int[][]::new);
    }

    private int distance(int[] a1, int rCenter, int cCenter) {
        return Math.abs(a1[0] - rCenter) + Math.abs(a1[1] - cCenter);
    }

}
