package shane.programmers.lv2c;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

public class 리코쳇_로봇 {

    @Test
    public void test() {
        assertThat(solution(new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."})).isEqualTo(7);
        assertThat(solution(new String[]{".D.R", "....", ".G..", "...D"})).isEqualTo(-1);
    }

    public int solution(String[] board) {
        char[][] game = new char[board.length][board[0].length()];
        boolean[][] visited = new boolean[game.length][game[0].length];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                char c = board[i].charAt(j);
                game[i][j] = c;
                if (c == 'R') {
                    queue.add(new int[]{i, j});
                }
            }
        }
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int y = poll[0];
                int x = poll[1];
                if (visited[y][x])
                    continue;
                visited[y][x] = true;
                if (game[y][x] == 'G')
                    return steps;
                move4ways(y, x, game, queue);
            }
            steps++;
        }

        return -1;
    }

    private void move4ways(int y, int x, char[][] game, Queue<int[]> queue) {
        // move up
        int i = y;
        int j = x;
        while (i + 1 < game.length && game[i + 1][j] != 'D') {
            i++;
        }
        queue.offer(new int[]{i, j});
        i = y;

        // move right
        while (j + 1 < game[0].length && game[i][j + 1] != 'D') {
            j++;
        }
        queue.offer(new int[]{i, j});
        j = x;

        // move down
        while (i - 1 >= 0 && game[i - 1][j] != 'D') {
            i--;
        }
        queue.offer(new int[]{i, j});
        i = y;


        // move left
        while (j - 1 >= 0 && game[i][j - 1] != 'D') {
            j--;
        }
        queue.offer(new int[]{i, j});
    }

}
