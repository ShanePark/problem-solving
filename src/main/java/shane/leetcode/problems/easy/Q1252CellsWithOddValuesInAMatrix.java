package shane.leetcode.problems.easy;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1252CellsWithOddValuesInAMatrix {

    @Test
    public void test() {
        assertThat(oddCells(2, 3, Ps.intArray(" [[0,1],[1,1]]"))).isEqualTo(6);
        assertThat(oddCells(2, 2, Ps.intArray(" [[1,1],[0,0]]"))).isEqualTo(0);
    }

    public int oddCells(int m, int n, int[][] indices) {
        int[][] arr = new int[m][n];
        for (int[] index : indices) {
            for (int i = 0; i < m; i++) {
                arr[i][index[1]]++;
            }
            for (int i = 0; i < n; i++) {
                arr[index[0]][i]++;
            }
        }
        int sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] % 2 == 1)
                    sum++;
            }
        }
        return sum;
    }
}
