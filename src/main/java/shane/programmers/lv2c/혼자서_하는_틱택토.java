package shane.programmers.lv2c;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 혼자서_하는_틱택토 {

    @Test
    public void test() {
        assertThat(solution(new String[]{"O.X", "OOX", ".OX"})).isEqualTo(0);
        assertThat(solution(new String[]{"OXO", "XOX", "OXO"})).isEqualTo(1);
        assertThat(solution(new String[]{"OXX", "OXX", "OOO"})).isEqualTo(1);
        assertThat(solution(new String[]{"O.X", ".O.", "..X"})).isEqualTo(1);
        assertThat(solution(new String[]{"OOO", "...", "XXX"})).isEqualTo(0);
        assertThat(solution(new String[]{"...", ".X.", "..."})).isEqualTo(0);
        assertThat(solution(new String[]{"...", "...", "..."})).isEqualTo(1);
    }

    public int solution(String[] board) {
        int countO = 0, countX = 0;
        int finishO = 0, finishX = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char c = board[i].charAt(j);
                if (c == 'O') {
                    countO++;
                } else if (c == 'X') {
                    countX++;
                }
            }
            finishO += board[i].equals("OOO") ? 1 : 0;
            finishX += board[i].equals("XXX") ? 1 : 0;
            if (board[0].charAt(i) == board[1].charAt(i) && board[1].charAt(i) == board[2].charAt(i) && board[2].charAt(i) != '.') {
                char c = board[0].charAt(i);
                if (c == 'O') {
                    finishO++;
                } else {
                    finishX++;
                }
            }
        }

        if (board[0].charAt(0) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(2) && board[2].charAt(2) != '.') {
            char c = board[2].charAt(2);
            if (c == 'O') {
                finishO++;
            } else {
                finishX++;
            }
        }
        if (board[0].charAt(2) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(0) && board[2].charAt(0) != '.') {
            char c = board[2].charAt(0);
            if (c == 'O') {
                finishO++;
            } else {
                finishX++;
            }
        }

        if (countO < countX || countX + 1 < countO)
            return 0;
        if (finishX == 1 && (finishO == 1 || countX != countO))
            return 0;
        if (finishO == 1 && countX == countO)
            return 0;
        return 1;
    }

}
