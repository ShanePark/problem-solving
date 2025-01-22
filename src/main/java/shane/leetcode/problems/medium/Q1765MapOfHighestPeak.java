package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 56ms
 * Beats29.14%
 */
public class Q1765MapOfHighestPeak {

    @Test
    public void test() {
        assertThat(highestPeak(Ps.intArray("[[0,1],[0,0]]"))).isEqualTo(Ps.intArray("[[1,0],[2,1]]"));
        assertThat(highestPeak(Ps.intArray("[[0,0,1],[1,0,0],[0,0,0]]"))).isEqualTo(Ps.intArray("[[1,1,0],[0,1,1],[1,2,2]]"));
    }

    int[][] DIRS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int[][] highestPeak(int[][] isWater) {
        int HEIGHT = isWater.length;
        int WIDTH = isWater[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (isWater[i][j] == 1) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        int height = 1;
        int[][] answer = new int[HEIGHT][WIDTH];
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] poll = q.poll();
                for (int[] dir : DIRS) {
                    int y = poll[0] + dir[0];
                    int x = poll[1] + dir[1];
                    if (y < 0 || y == HEIGHT || x < 0 || x == WIDTH || answer[y][x] > 0 || isWater[y][x] == 1)
                        continue;
                    answer[y][x] = height;
                    q.offer(new int[]{y, x});
                }
            }
            height++;
        }
        return answer;
    }

}
