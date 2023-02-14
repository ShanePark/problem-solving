package shane.programmers.challenge2022.backendq2;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q3 {

    @Test
    public void test() {
        assertThat(solution(9, 7, Ps.intArray("[[2,2],[2,3],[2,5],[3,2],[3,4],[3,5],[3,6],[4,3],[4,6],[5,2],[5,5],[6,2],[6,3],[6,4],[6,6],[7,2],[7,6],[8,3],[8,4],[8,5]]")))
                .containsExactly(1, 4);
    }


    int max = 0;
    int min = -1;

    public int[] solution(int rows, int columns, int[][] lands) {
        max = 0;
        min = rows * columns;

        int[][] matrix = new int[rows][columns];
        for (int[] land : lands) {
            matrix[land[0] - 1][land[1] - 1] = 1;
        }

        boolean[][] visited = new boolean[rows][columns];
        findSea(0, 0, matrix, visited);

        visited = new boolean[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == 0 && !visited[i][j]) {
                    int size = findLake(i, j, matrix, visited);
                    min = Math.min(min, size);
                    max = Math.max(max, size);
                }
            }
        }

        if (min == rows * columns) {
            return new int[]{-1, -1};
        }
        return new int[]{min, max};
    }

    private int findLake(int y, int x, int[][] matrix, boolean[][] visited) {
        visited[y][x] = true;
        int sum = 1;

        // left
        if (x > 0 && !visited[y][x - 1] && matrix[y][x - 1] == 0) {
            sum += findLake(y, x - 1, matrix, visited);
        }

        // right
        if (x < matrix[0].length - 1 && !visited[y][x + 1] && matrix[y][x + 1] == 0) {
            sum += findLake(y, x + 1, matrix, visited);
        }

        // down
        if (y < matrix.length - 1 && !visited[y + 1][x] && matrix[y + 1][x] == 0) {
            sum += findLake(y + 1, x, matrix, visited);
        }

        // up
        if (y > 0 && !visited[y - 1][x] && matrix[y - 1][x] == 0) {
            sum += findLake(y - 1, x, matrix, visited);
        }

        return sum;

    }

    private void findSea(int y, int x, int[][] matrix, boolean[][] visited) {
        matrix[y][x] = -1;
        visited[y][x] = true;

        // left
        if (x > 0 && !visited[y][x - 1] && matrix[y][x - 1] == 0) {
            findSea(y, x - 1, matrix, visited);
        }

        // right
        if (x < matrix[0].length - 1 && !visited[y][x + 1] && matrix[y][x + 1] == 0) {
            findSea(y, x + 1, matrix, visited);
        }

        // down
        if (y < matrix.length - 1 && !visited[y + 1][x] && matrix[y + 1][x] == 0) {
            findSea(y + 1, x, matrix, visited);
        }

        // up
        if (y > 0 && !visited[y - 1][x] && matrix[y - 1][x] == 0) {
            findSea(y - 1, x, matrix, visited);
        }
    }

}
