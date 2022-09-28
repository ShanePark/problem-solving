package shane.programmers.lv3;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 채점을 시작합니다.
 * 정확성  테스트
 * 테스트 1 〉	통과 (1.63ms, 81.6MB)
 * 테스트 2 〉	통과 (0.40ms, 77.1MB)
 * 테스트 3 〉	통과 (0.53ms, 81MB)
 * 테스트 4 〉	통과 (0.48ms, 85.6MB)
 * 테스트 5 〉	통과 (0.61ms, 74.2MB)
 * 테스트 6 〉	통과 (2.32ms, 77.3MB)
 * 테스트 7 〉	통과 (1.79ms, 82.3MB)
 * 테스트 8 〉	통과 (1.59ms, 81.4MB)
 * 테스트 9 〉	통과 (1.89ms, 80.8MB)
 * 테스트 10 〉	통과 (1.40ms, 71.7MB)
 * 테스트 11 〉	통과 (39.67ms, 94MB)
 * 테스트 12 〉	통과 (62.27ms, 97.9MB)
 * 테스트 13 〉	통과 (0.64ms, 72.8MB)
 * 테스트 14 〉	통과 (1.42ms, 74.9MB)
 * 테스트 15 〉	통과 (4.74ms, 77.6MB)
 * 테스트 16 〉	통과 (4.83ms, 88.9MB)
 * 테스트 17 〉	통과 (16.33ms, 66.5MB)
 * 테스트 18 〉	통과 (28.00ms, 82.8MB)
 * 테스트 19 〉	통과 (41.29ms, 95MB)
 * 테스트 20 〉	통과 (1.34ms, 80.6MB)
 * 테스트 21 〉	통과 (0.79ms, 72.5MB)
 * 테스트 22 〉	통과 (0.45ms, 73.4MB)
 * 테스트 23 〉	통과 (0.59ms, 79.3MB)
 * 테스트 24 〉	통과 (0.70ms, 76.8MB)
 * 테스트 25 〉	통과 (0.62ms, 77.8MB)
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
@SuppressWarnings("ALL")
public class 경주로건설2 {

    @Test
    public void test() {
        assertThat(solution(STool.convertToIntArray("[[0,0,1,0],[0,0,0,0],[0,1,0,1],[1,0,0,0]]"))).isEqualTo(2100);
        assertThat(solution(STool.convertToIntArray("[[0,0,0],[0,0,0],[0,0,0]]"))).isEqualTo(900);
        assertThat(solution(STool.convertToIntArray("[[0,0,0,0,0,0,0,1],[0,0,0,0,0,0,0,0],[0,0,0,0,0,1,0,0],[0,0,0,0,1,0,0,0],[0,0,0,1,0,0,0,1],[0,0,1,0,0,0,1,0],[0,1,0,0,0,1,0,0],[1,0,0,0,0,0,0,0]]"))).isEqualTo(3800);
        assertThat(solution(STool.convertToIntArray("[[0,0,0,0,0,0],[0,1,1,1,1,0],[0,0,1,0,0,0],[1,0,0,1,0,1],[1,1,0,0,0,1],[1,1,0,1,0,0]]"))).isEqualTo(3200);
    }

    public int solution(int[][] board) {
        final int LENGTH = board.length;

        final int[][] dp = new int[LENGTH][LENGTH];
        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        dp[0][0] = 0;

        boolean[][] visited = new boolean[LENGTH][LENGTH];
        visited[0][0] = true;

        if (board[0][1] == 0) {
            visited[0][1] = true;
            dfs(0, 1, Way.RIGHT, 100, dp, visited, board);
        }
        if (board[1][0] == 0) {
            visited[1][0] = true;
            dfs(1, 0, Way.DOWN, 100, dp, visited, board);
        }
        return dp[LENGTH - 1][LENGTH - 1];
    }

    private void dfs(int y, int x, Way way, int current, int[][] dp, boolean[][] visited, int[][] board) {
        if (dp[y][x] < current - 400) {
            return;
        }
        dp[y][x] = Math.min(dp[y][x], current);
        int length = dp.length;

        if (y == length - 1 && x == length - 1) {
            return;
        }

        for (Way nextWay : Way.values()) {
            if (nextWay.getOpposite() == way)
                continue;
            int nextY = y + nextWay.point[0];
            int nextX = x + nextWay.point[1];
            if (0 <= nextY && nextY < length && 0 <= nextX && nextX < length && !visited[nextY][nextX] && board[nextY][nextX] == 0) {
                int price = (way == nextWay) ? 100 : 600;
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
