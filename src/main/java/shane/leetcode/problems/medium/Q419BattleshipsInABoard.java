package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q419BattleshipsInABoard {

    @Test
    public void test() {
        assertThat(countBattleships(Ps.charArray("[[\".\",\"X\"],[\"X\",\".\"]]"))).isEqualTo(2);
        assertThat(countBattleships(Ps.charArray("[[\"X\",\".\",\".\",\"X\"],[\".\",\".\",\".\",\"X\"],[\".\",\".\",\".\",\"X\"]]"))).isEqualTo(2);
        assertThat(countBattleships(Ps.charArray("[[\".\"]]"))).isEqualTo(0);
    }

    public int countBattleships(char[][] board) {
        int cnt = 0;

        final int WIDTH = board[0].length;
        final int HEIGHT = board.length;
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (board[i][j] == 'X') {
                    cnt++;
                    for (int k = i; k < HEIGHT - 1 && board[k + 1][j] == 'X'; k++) {
                        board[k + 1][j] = '.';
                    }
                    while (board[i][j] == 'X' && j < WIDTH - 1) {
                        j++;
                    }
                }
            }
        }

        return cnt;
    }
}
