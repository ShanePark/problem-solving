package shane.programmers.challenge2022.gameq1;


import com.tistory.shanepark.STool;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Q3 {

    @Test
    void test() {
//        Assertions.assertThat(solution(STool.convertToIntArray("[[1,1,1,1],[2,1,2,2],[2,2,2,1],[1,1,2,2]]"))).isEqualTo(5);
        Assertions.assertThat(solution(STool.convertToIntArray("[[1,1,1,2],[1,1,1,2],[2,2,2,1],[1,2,2,2]]"))).isEqualTo(3);
    }

    public int solution(int[][] grid) {
        int[][] answer = new int[][]{{1, 1, 2, 2}, {1, 1, 2, 2}, {2, 2, 1, 1}, {2, 2, 1, 1}};
        Queue<Status> q = new LinkedList<>();
        q.add(new Status(0, grid));

        while (!q.isEmpty()) {
            Status poll = q.poll();
            System.out.println("poll.depth = " + poll.depth);
            if (Arrays.deepEquals(poll.grid, answer)) {
                return poll.depth;
            }
            q.add(new Status(poll.depth + 1, moveLeft(grid)));
            q.add(new Status(poll.depth + 1, moveRight(grid)));
            q.add(new Status(poll.depth + 1, moveUp(grid)));
            q.add(new Status(poll.depth + 1, moveDown(grid)));
        }
        return -1;
    }

    private List<Integer> asList(int[][] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                list.add(arr[i][j]);
            }
        }
        return list;
    }

    private int[][] moveDown(int[][] grid) {
        int[][] arr = copyArr(grid);
        int[] temp = Arrays.copyOf(arr[grid.length - 1], grid.length);
        for (int i = grid.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = temp;
        return arr;
    }

    private int[][] moveUp(int[][] grid) {
        int[][] arr = copyArr(grid);
        int[] temp = Arrays.copyOf(arr[0], grid.length);
        for (int i = 0; i < grid.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[grid.length - 1] = temp;
        return arr;
    }

    private int[][] moveRight(int[][] grid) {
        int[][] arr = copyArr(grid);
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i][arr.length - 1];
            for (int j = arr.length - 1; j > 0; j--) {
                arr[i][j] = arr[i][j - 1];
            }
            arr[i][0] = temp;
        }
        return arr;
    }

    private int[][] moveLeft(int[][] grid) {
        int[][] arr = copyArr(grid);
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i][0];
            for (int j = 0; j < arr.length - 1; j++) {
                arr[i][j] = arr[i][j + 1];
            }
            arr[i][arr.length - 1] = temp;
        }
        return arr;
    }

    private int[][] copyArr(int[][] grid) {
        int[][] arr = new int[grid.length][grid.length];
        for (int i = 0; i < grid.length; i++) {
            arr[i] = Arrays.copyOf(grid[i], grid.length);
        }
        return arr;
    }

    class Status {
        int depth = 1;
        int[][] grid;

        public Status(int depth, int[][] grid) {
            this.depth = depth;
            this.grid = grid;
        }
    }
}
