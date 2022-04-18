package shane.leetcode.problems.easy;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1260Shift2DGrid {

    @Test
    public void test() {
        assertThat(shiftGrid(STool.convertToIntArray(" [[1,2,3],[4,5,6],[7,8,9]]"), 1)).isEqualTo(STool.convertToIntList("[[9,1,2],[3,4,5],[6,7,8]]"));
        assertThat(shiftGrid(STool.convertToIntArray("[[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]]"), 4)).isEqualTo(STool.convertToIntList("[[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]"));
        assertThat(shiftGrid(STool.convertToIntArray("[[1],[2],[3],[4],[7],[6],[5]]"), 23)).isEqualTo(STool.convertToIntList("[[6], [5], [1], [2], [3], [4], [7]]"));
    }

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        final int HEIGHT = grid.length;
        final int WIDTH = grid[0].length;
        final int SIZE = HEIGHT * WIDTH;
        int[] arr = new int[SIZE];
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                arr[WIDTH * i + j] = grid[i][j];
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < HEIGHT; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < WIDTH; j++) {
                list.add(arr[(WIDTH * i + j + SIZE - (k % SIZE)) % SIZE]);
            }
            result.add(list);
        }
        return result;
    }
}
