package shane.programmers.lv0;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 안전지대 {

    @Test
    public void test() {
        assertThat(solution(Ps.intArray("[[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 1, 0, 0], [0, 0, 0, 0, 0]]"))).isEqualTo(16);
    }

    public int solution(int[][] board) {
        boolean[][] unsafe = new boolean[board.length][board[0].length];
        int[][] ways = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 0}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    for (int[] way : ways) {
                        int y = i + way[0];
                        int x = j + way[1];
                        if (0 <= x && 0 <= y && x < board[0].length && y < board.length) {
                            unsafe[y][x] = true;
                        }
                    }
                }
            }
        }
        int cnt = 0;
        for (boolean[] booleans : unsafe) {
            for (boolean aBoolean : booleans) {
                if (!aBoolean) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
