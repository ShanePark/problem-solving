package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 187 ms Beats 33.36% of users with Java
 */
public class Q79WordSearch3 {

    @Test
    public void test() {
        assertThat(exist(Ps.charArray("[[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"C\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]]"), "ABCCED")).isTrue();
        assertThat(exist(Ps.charArray("[[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"C\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]]"), "SEE")).isTrue();
        assertThat(exist(Ps.charArray("[[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"C\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]]"), "ABCB")).isFalse();
    }

    public boolean exist(char[][] board, String word) {
        int height = board.length;
        int width = board[0].length;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (isPossible(board, i, j, new boolean[height][width], word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    int[][] DIRS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private boolean isPossible(char[][] board, int i, int j, boolean[][] visited, String word, int index) {
        char target = word.charAt(index);
        char cur = board[i][j];
        if (target != cur)
            return false;
        if (index == word.length() - 1)
            return true;
        visited[i][j] = true;

        for (int[] dir : DIRS) {
            int y = i + dir[0];
            int x = j + dir[1];
            if (y < 0 || x < 0 || y == board.length || x == board[0].length || visited[y][x]) {
                continue;
            }
            if (isPossible(board, y, x, visited, word, index + 1)) {
                return true;
            }
        }

        visited[i][j] = false;
        return false;
    }

}
