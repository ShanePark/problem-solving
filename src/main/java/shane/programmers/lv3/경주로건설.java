package shane.programmers.lv3;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 채점을 시작합니다.
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.54ms, 74.5MB)
 * 테스트 2 〉	통과 (0.37ms, 75.2MB)
 * 테스트 3 〉	통과 (0.56ms, 77.2MB)
 * 테스트 4 〉	통과 (0.44ms, 73.5MB)
 * 테스트 5 〉	통과 (0.55ms, 76.8MB)
 * 테스트 6 〉	통과 (2.19ms, 80.2MB)
 * 테스트 7 〉	통과 (2.72ms, 67.2MB)
 * 테스트 8 〉	통과 (1.80ms, 77.1MB)
 * 테스트 9 〉	통과 (1.36ms, 72.7MB)
 * 테스트 10 〉	통과 (2.37ms, 73.9MB)
 * 테스트 11 〉	통과 (32.32ms, 83MB)
 * 테스트 12 〉	통과 (20.31ms, 89.7MB)
 * 테스트 13 〉	통과 (0.83ms, 69.4MB)
 * 테스트 14 〉	통과 (1.07ms, 72.4MB)
 * 테스트 15 〉	통과 (3.07ms, 80.8MB)
 * 테스트 16 〉	통과 (5.42ms, 88MB)
 * 테스트 17 〉	통과 (11.80ms, 77.7MB)
 * 테스트 18 〉	통과 (28.90ms, 75.1MB)
 * 테스트 19 〉	통과 (38.49ms, 95.6MB)
 * 테스트 20 〉	통과 (1.04ms, 76MB)
 * 테스트 21 〉	통과 (1.11ms, 77.3MB)
 * 테스트 22 〉	통과 (0.51ms, 74.1MB)
 * 테스트 23 〉	통과 (0.60ms, 77.6MB)
 * 테스트 24 〉	실패 (0.41ms, 70.8MB)
 * 테스트 25 〉	통과 (0.46ms, 75.4MB)
 * 채점 결과
 * 정확성: 96.0
 * 합계: 96.0 / 100.0
 */
@SuppressWarnings("ALL")
public class 경주로건설 {

    @Test
    public void test() {
        assertThat(solution(Ps.intArray("[[0,0,1,0],[0,0,0,0],[0,1,0,1],[1,0,0,0]]"))).isEqualTo(2100);
        assertThat(solution(Ps.intArray("[[0,0,0],[0,0,0],[0,0,0]]"))).isEqualTo(900);
        assertThat(solution(Ps.intArray("[[0,0,0,0,0,0,0,1],[0,0,0,0,0,0,0,0],[0,0,0,0,0,1,0,0],[0,0,0,0,1,0,0,0],[0,0,0,1,0,0,0,1],[0,0,1,0,0,0,1,0],[0,1,0,0,0,1,0,0],[1,0,0,0,0,0,0,0]]"))).isEqualTo(3800);
        assertThat(solution(Ps.intArray("[[0,0,0,0,0,0],[0,1,1,1,1,0],[0,0,1,0,0,0],[1,0,0,1,0,1],[1,1,0,0,0,1],[1,1,0,1,0,0]]"))).isEqualTo(3200);
    }

    public int solution(int[][] board) {
        final int HEIGHT = board.length;
        final int WIDTH = board[0].length;
        final int[][] dp = new int[HEIGHT][WIDTH];

        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        boolean[][] visited = new boolean[HEIGHT][WIDTH];
        visited[0][0] = true;

        if (board[0][1] == 0) {
            visited[0][1] = true;
            dfs(0, 1, Way.RIGHT, 100, dp, visited, board);
        }
        if (board[1][0] == 0) {
            visited[1][0] = true;
            dfs(1, 0, Way.DOWN, 100, dp, visited, board);
        }
        return dp[HEIGHT - 1][WIDTH - 1];
    }

    private void dfs(int y, int x, Way way, int current, int[][] dp, boolean[][] visited, int[][] board) {
        if (dp[y][x] < current) {
            return;
        }
        dp[y][x] = current;

        for (Way nextWay : Way.values()) {
            if (nextWay.getOpposite() == way)
                continue;
            int nextY = y + nextWay.point[0];
            int nextX = x + nextWay.point[1];
            if (0 <= nextX && nextX < dp.length && 0 <= nextY && nextY < dp[0].length && !visited[nextY][nextX] && board[nextY][nextX] == 0) {
                int price = way == nextWay ? 100 : 600;
                visited[nextY][nextX] = true;
                dfs(nextY, nextX, nextWay, current + price, dp, visited, board);
                visited[nextY][nextX] = false;
            }
        }

    }

    enum Way {
        LEFT(new int[]{0, -1}),
        RIGHT(new int[]{0, 1}),
        DOWN(new int[]{1, 0}),
        UP(new int[]{-1, 0});

        private final int[] point;

        Way(int[] point) {
            this.point = point;
        }

        public Way getOpposite() {
            switch (this) {
                case UP:
                    return DOWN;
                case DOWN:
                    return UP;
                case LEFT:
                    return RIGHT;
                case RIGHT:
                    return LEFT;
                default:
                    return null;
            }
        }
    }
}
