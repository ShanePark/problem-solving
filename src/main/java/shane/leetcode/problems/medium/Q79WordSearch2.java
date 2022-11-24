package shane.leetcode.problems.medium;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 160 ms Beats 72.13%
 * Memory 40.5 MB Beats 89.10%
 */
public class Q79WordSearch2 {

    @Test
    public void test() {
        assertThat(exist(STool.convertToCharArray("[[\"a\"]]"), "a")).isTrue();
        assertThat(exist(STool.convertToCharArray("[[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"C\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]]"), "SEE")).isTrue();
        assertThat(exist(STool.convertToCharArray("[[\"a\",\"a\"]]"), "aaa")).isFalse();
        assertThat(exist(STool.convertToCharArray("[[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"C\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]]"), "ABCCED")).isTrue();
        assertThat(exist(STool.convertToCharArray("[[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"C\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]]"), "ABCB")).isFalse();
    }

    int[][] DIRS = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public boolean exist(char[][] board, String word) {
        int HEIGHT = board.length;
        int WIDTH = board[0].length;
        boolean[][] visited = new boolean[HEIGHT][WIDTH];
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                visited[i][j] = true;
                if (exist(i, j, board, word, 0, visited))
                    return true;
                visited[i][j] = false;
            }
        }
        return false;
    }

    private boolean exist(int i, int j, char[][] board, String word, int index, boolean[][] visited) {
        if (word.charAt(index) != board[i][j])
            return false;
        if (word.length() == index + 1)
            return true;

        for (int[] dir : DIRS) {
            int y = i + dir[0];
            int x = j + dir[1];
            if (0 <= x && x < board[0].length && 0 <= y && y < board.length && !visited[y][x]) {
                visited[y][x] = true;
                if (exist(y, x, board, word, index + 1, visited))
                    return true;
                visited[y][x] = false;
            }
        }
        return false;
    }
}
