package shane.programmers.lv3;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 채점을 시작합니다.
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.37ms, 74.1MB)
 * 테스트 2 〉	통과 (0.58ms, 79.1MB)
 * 테스트 3 〉	통과 (0.43ms, 75.7MB)
 * 테스트 4 〉	통과 (0.46ms, 71.3MB)
 * 테스트 5 〉	통과 (0.60ms, 72.2MB)
 * 테스트 6 〉	통과 (1.51ms, 74.4MB)
 * 테스트 7 〉	통과 (1.88ms, 78.6MB)
 * 테스트 8 〉	통과 (2.04ms, 79.5MB)
 * 테스트 9 〉	통과 (1.31ms, 72.6MB)
 * 테스트 10 〉	통과 (1.51ms, 74.4MB)
 * 테스트 11 〉	통과 (26.21ms, 82.5MB)
 * 테스트 12 〉	통과 (20.64ms, 89.8MB)
 * 테스트 13 〉	통과 (0.73ms, 72.8MB)
 * 테스트 14 〉	통과 (1.11ms, 79.2MB)
 * 테스트 15 〉	통과 (2.06ms, 76.4MB)
 * 테스트 16 〉	통과 (3.62ms, 79.8MB)
 * 테스트 17 〉	통과 (9.52ms, 81.3MB)
 * 테스트 18 〉	통과 (17.71ms, 82.1MB)
 * 테스트 19 〉	통과 (30.59ms, 85MB)
 * 테스트 20 〉	통과 (1.37ms, 85.2MB)
 * 테스트 21 〉	통과 (0.94ms, 66.5MB)
 * 테스트 22 〉	통과 (0.70ms, 76.4MB)
 * 테스트 23 〉	통과 (0.61ms, 80.1MB)
 * 테스트 24 〉	통과 (0.49ms, 74.2MB)
 * 테스트 25 〉	통과 (0.40ms, 81.1MB)
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
@SuppressWarnings("ALL")
public class 경주로건설3 {

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
            dfs(0, 1, null, Way.RIGHT, 100, dp, visited, board);
        }
        if (board[1][0] == 0) {
            visited[1][0] = true;
            dfs(1, 0, null, Way.DOWN, 100, dp, visited, board);
        }
        return dp[LENGTH - 1][LENGTH - 1];
    }

    private void dfs(int y, int x, Way wayBefore, Way way, int current, int[][] dp, boolean[][] visited, int[][] board) {
        if (dp[y][x] < current && (wayBefore != way || dp[y][x] < current - 400)) {
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
                dfs(nextY, nextX, way, nextWay, current + price, dp, visited, board);
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
