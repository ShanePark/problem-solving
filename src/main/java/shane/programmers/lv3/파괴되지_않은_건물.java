package shane.programmers.lv3;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class 파괴되지_않은_건물 {

    @Test
    public void test() {
        assertThat(solution(
                Ps.intArray("[[5,5,5,5,5],[5,5,5,5,5],[5,5,5,5,5],[5,5,5,5,5]]")
                , Ps.intArray("[[1,0,0,3,4,4],[1,2,0,2,3,2],[2,1,0,3,1,2],[1,0,1,3,3,1]]"))).isEqualTo(10);
        assertThat(solution(Ps.intArray("[[1,2,3],[4,5,6],[7,8,9]]")
                , Ps.intArray("[[1,1,1,2,2,4],[1,0,0,1,1,2],[2,2,0,2,0,100]]")))
                .isEqualTo(6);
    }

    /**
     * 2 sec 523 ms
     */
    @Test
    public void tle() {
        int[][] board = new int[100][100];
        int[][] skill = new int[250000][6];
        Arrays.fill(skill, new int[]{1, 0, 0, 99, 99, 1});

        assertThat(solution(board, skill));
    }

    public int solution(int[][] board, int[][] skill) {
        for (int[] ints : skill) {
            if (ints[0] == 1) {
                ints[5] *= -1;
            }
            for (int i = ints[1]; i <= ints[3]; i++) {
                for (int j = ints[2]; j <= ints[4]; j++) {
                    board[i][j] += ints[5];
                }
            }
        }
        int sum = 0;
        for (int[] ints : board) {
            for (int i : ints) {
                if (i > 0)
                    sum++;
            }
        }
        return sum;
    }

}
