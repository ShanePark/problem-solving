package shane.leetcode.problems.medium;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q289GameOfLife {

    @Test
    public void test() {
        int[][] board = STool.convertToIntArray("[[0,1,0],[0,0,1],[1,1,1],[0,0,0]]");
        gameOfLife(board);
        assertThat(board).isDeepEqualTo(STool.convertToIntArray("[[0,0,0],[1,0,1],[0,1,1],[0,1,0]]"));
    }

    @Test
    public void test2() {
        int[][] board = STool.convertToIntArray("[[1,1],[1,0]]");
        gameOfLife(board);
        assertThat(board).isDeepEqualTo(STool.convertToIntArray("[[1,1],[1,1]]"));
    }

    public void gameOfLife(int[][] board) {
        int height = board.length;
        int width = board[0].length;
        int[][] copy = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int cur = board[i][j];
                int cnt = count(board, i, j);
                int result = 0;
                if (cur == 0) {
                    result = (cnt == 3 ? 1 : 0);
                } else if (cnt == 2 || cnt == 3) {
                    result = 1;
                }
                copy[i][j] = result;
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = copy[i][j];
            }
        }
    }

    private int count(int[][] board, int i, int j) {
        int cnt = 0;
        if (i > 0) {
            if (j > 0)
                cnt += board[i - 1][j - 1];
            cnt += board[i - 1][j];
            if (j < board[0].length - 1)
                cnt += board[i - 1][j + 1];
        }
        if (j > 0)
            cnt += board[i][j - 1];
        if (j < board[0].length - 1)
            cnt += board[i][j + 1];
        if (i < board.length - 1) {
            if (j > 0)
                cnt += board[i + 1][j - 1];
            cnt += board[i + 1][j];
            if (j < board[0].length - 1)
                cnt += board[i + 1][j + 1];
        }
        return cnt;
    }
}
