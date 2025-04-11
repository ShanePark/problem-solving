package shane.programmers.lv2c;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

public class 지게차와_크레인 {

    @Test
    public void test() {
        assertThat(solution(new String[]{"AZWQY", "CAABX", "BBDDA", "ACACA"}, new String[]{"A", "BB", "A"})).isEqualTo(11);
        assertThat(solution(new String[]{"HAH", "HBH", "HHH", "HAH", "HBH"}, new String[]{"C", "B", "B", "B", "B", "H"})).isEqualTo(4);
    }

    public int solution(String[] storage, String[] requests) {
        char[][] grid = new char[storage.length][storage[0].length()];
        for (int i = 0; i < storage.length; i++) {
            String row = storage[i];
            for (int j = 0; j < row.length(); j++) {
                grid[i][j] = row.charAt(j);
            }
        }
        for (String request : requests) {
            char c = request.charAt(0);
            if (request.length() == 2) {
                useCrane(grid, c);
                continue;
            }
            useForkLift(grid, c);
        }
        int answer = 0;
        for (char[] chars : grid) {
            for (char c : chars) {
                if (c != ' ')
                    answer++;
            }
        }
        return answer;
    }

    private void useCrane(char[][] grid, char c) {
        for (char[] chars : grid) {
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == c)
                    chars[i] = ' ';
            }
        }
    }

    int[][] DIRS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private void useForkLift(char[][] grid, char c) {
        int HEIGHT = grid.length;
        int WIDTH = grid[0].length;
        boolean[][] visited = new boolean[HEIGHT][WIDTH];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < HEIGHT; i++) {
            q.add(new int[]{i, 0});
            q.add(new int[]{i, WIDTH - 1});
            visited[i][0] = true;
            visited[i][WIDTH - 1] = true;
        }
        for (int j = 0; j < WIDTH; j++) {
            q.add(new int[]{0, j});
            q.add(new int[]{HEIGHT - 1, j});
            visited[0][j] = true;
            visited[HEIGHT - 1][j] = true;
        }
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int y = poll[0];
            int x = poll[1];
            if (grid[y][x] == ' ') {
                grid[y][x] = ' ';
                for (int[] dir : DIRS) {
                    int nextY = y + dir[0];
                    int nextX = x + dir[1];
                    if (0 <= nextY && nextY < HEIGHT && 0 <= nextX && nextX < WIDTH && !visited[nextY][nextX]) {
                        visited[nextY][nextX] = true;
                        q.offer(new int[]{nextY, nextX});
                    }
                }
            }
            if (grid[y][x] == c) {
                grid[y][x] = ' ';
            }
        }
    }

}
