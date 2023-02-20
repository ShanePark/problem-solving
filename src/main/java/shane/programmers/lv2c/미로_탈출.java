package shane.programmers.lv2c;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class 미로_탈출 {

    @Test
    public void test() {
        assertThat(solution(new String[]{"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"})).isEqualTo(16);
        assertThat(solution(new String[]{"LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO"})).isEqualTo(-1);
    }

    @Test
    public void tle() {
        String[] arr = new String[100];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            sb.append("O");
        }
        Arrays.fill(arr, sb.toString());
        arr[0] = new StringBuilder(sb)
                .replace(0, 1, "S")
                .replace(1, 2, "E")
                .toString();
        arr[99] = new StringBuilder(sb).replace(98, 99, "L").toString();
        assertThat(solution(arr));
    }

    public int solution(String[] maps) {
        int height = maps.length;
        int width = maps[0].length();
        char[][] map = new char[height][width];
        int[] start = null;
        int[] l = null;
        int[] end = null;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                map[i][j] = maps[i].charAt(j);
                if (map[i][j] == 'S') {
                    start = new int[]{i, j};
                } else if (map[i][j] == 'L') {
                    l = new int[]{i, j};
                } else if (map[i][j] == 'E') {
                    end = new int[]{i, j};
                }
            }
        }
        int toL = distance(start, l, map);
        if (toL == -1)
            return -1;
        int toE = distance(l, end, map);
        if (toE == -1)
            return -1;
        return toL + toE;
    }

    final int[][] DIRS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private int distance(int[] from, int[] to, char[][] originalMap) {
        int height = originalMap.length;
        int width = originalMap[0].length;
        char[][] map = new char[height][width];
        for (int i = 0; i < height; i++) {
            map[i] = Arrays.copyOf(originalMap[i], width);
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(from);

        int distance = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] poll = q.poll();
                if (Arrays.equals(poll, to))
                    return distance;
                map[poll[0]][poll[1]] = 'X';
                for (int[] dir : DIRS) {
                    int y = poll[0] + dir[0];
                    int x = poll[1] + dir[1];
                    if (0 <= y && y < height && 0 <= x && x < width && map[y][x] != 'X') {
                        q.offer(new int[]{y, x});
                    }
                }
            }
            distance++;
        }
        return -1;
    }

}
