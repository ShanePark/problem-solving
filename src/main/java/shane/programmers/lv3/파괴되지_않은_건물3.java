package shane.programmers.lv3;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class 파괴되지_않은_건물3 {

    @Test
    public void test() {
        assertThat(solution(
                Ps.intArray("[[5,5,5,5,5],[5,5,5,5,5],[5,5,5,5,5],[5,5,5,5,5]]")
                , Ps.intArray("[" +
                        "[1,0,0,3,4,4]" +
                        ",[1,2,0,2,3,2]" +
                        ",[2,1,0,3,1,2]" +
                        ",[1,0,1,3,3,1]" +
                        "]"))).isEqualTo(10);
        assertThat(solution(Ps.intArray("[[1,2,3],[4,5,6],[7,8,9]]")
                , Ps.intArray("[" +
                        "[1,1,1,2,2,4]" +
                        ",[1,0,0,1,1,2]" +
                        ",[2,2,0,2,0,100]" +
                        "]")))
                .isEqualTo(6);
    }

    /**
     * 69 ms
     */
    @Test
    public void tle() {
        int[][] board = new int[100][100];
        int[][] skill = new int[250000][6];
        Arrays.fill(skill, new int[]{1, 0, 0, 99, 99, 1});

        assertThat(solution(board, skill));
    }

    public int solution(int[][] board, int[][] skill) {
        int height = board.length;
        int width = board[0].length;
        int[][] acc = new int[height + 1][width + 1];
        for (int[] arr : skill) {
            int y1 = arr[1];
            int x1 = arr[2];
            int y2 = arr[3];
            int x2 = arr[4];
            int power = arr[5];
            if (arr[0] == 1) {
                power *= -1;
            }
            acc[y1][x1] += power;
            acc[y2 + 1][x1] -= power;
            acc[y1][x2 + 1] -= power;
            acc[y2 + 1][x2 + 1] += power;
        }
        for (int i = 1; i < height; i++) {
            for (int j = 0; j < width; j++) {
                acc[i][j] += acc[i - 1][j];
            }
        }
        for (int j = 1; j < width; j++) {
            for (int i = 0; i < height; i++) {
                acc[i][j] += acc[i][j - 1];
            }
        }

        int answer = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] += acc[i][j];
                if (board[i][j] > 0)
                    answer++;
            }
        }
        return answer;
    }

}
