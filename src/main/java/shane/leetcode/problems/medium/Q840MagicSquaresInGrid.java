package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime1msBeats41.08%
 */
public class Q840MagicSquaresInGrid {

    @Test
    public void test() {
        assertThat(numMagicSquaresInside(Ps.intArray("[[4,3,8,4],[9,5,1,9],[2,7,6,2]]")))
                .isEqualTo(1);
        assertThat(numMagicSquaresInside(Ps.intArray("[[8]]"))).isEqualTo(0);
        assertThat(numMagicSquaresInside(Ps.intArray("[[5,5,5],[5,5,5],[5,5,5]]"))).isEqualTo(0);
        assertThat(numMagicSquaresInside(Ps.intArray("[[10,3,5],[1,6,11],[7,9,2]]"))).isEqualTo(0);
        assertThat(numMagicSquaresInside(Ps.intArray("[[7,0,5],[2,4,6],[3,8,1]]"))).isEqualTo(0);
    }

    public int numMagicSquaresInside(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length - 2; i++) {
            loop:
            for (int j = 0; j < grid[0].length - 2; j++) {
                Set<Integer> set = new HashSet<>();
                for (int row = 0; row < 3; row++) {
                    for (int col = 0; col < 3; col++) {
                        int cur = grid[i + col][j + row];
                        if (cur == 0 || cur > 9 || !set.add(cur)) {
                            continue loop;
                        }
                    }
                }
                int row1 = grid[i][j] + grid[i][j + 1] + grid[i][j + 2];
                int row2 = grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2];
                if (row1 != row2)
                    continue;
                int row3 = grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2];
                if (row1 != row3)
                    continue;
                int col1 = grid[i][j] + grid[i + 1][j] + grid[i + 2][j];
                if (row1 != col1)
                    continue;
                int col2 = grid[i][j + 1] + grid[i + 1][j + 1] + grid[i + 2][j + 1];
                if (row1 != col2)
                    continue;
                int col3 = grid[i][j + 2] + grid[i + 1][j + 2] + grid[i + 2][j + 2];
                if (row1 != col3)
                    continue;
                int diagonal1 = grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2];
                if (row1 != diagonal1)
                    continue;
                int diagonal2 = grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j];
                if (row1 != diagonal2)
                    continue;
                sum++;
            }
        }
        return sum;
    }

}
