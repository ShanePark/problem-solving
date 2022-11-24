package shane.leetcode.problems.medium;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 1143 ms Beats 5.1%
 * Memory 43.2 MB Beats 18.6%
 */
public class Q79WordSearch {

    @Test
    public void test() {
        assertThat(exist(STool.convertToCharArray("[[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"C\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]]"), "SEE")).isTrue();
        assertThat(exist(STool.convertToCharArray("[[\"a\",\"a\"]]"), "aaa")).isFalse();
        assertThat(exist(STool.convertToCharArray("[[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"C\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]]"), "ABCCED")).isTrue();
        assertThat(exist(STool.convertToCharArray("[[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"C\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]]"), "ABCB")).isFalse();
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                board[i][j] = '.';
                if (exist(i, j, board, word, String.valueOf(c)))
                    return true;
                board[i][j] = c;
            }
        }
        return false;
    }

    private boolean exist(int i, int j, char[][] board, String word, String s) {
        if (word.equals(s))
            return true;
        if (!word.startsWith(s))
            return false;
        int[][] DIRS = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        for (int[] dir : DIRS) {
            int y = i + dir[0];
            int x = j + dir[1];
            if (0 <= x && x < board[0].length && 0 <= y && y < board.length) {
                char c = board[y][x];
                if (c != '.') {
                    board[y][x] = '.';
                    if (exist(y, x, board, word, s + c))
                        return true;
                    board[y][x] = c;
                }
            }
        }
        return false;
    }
}
