package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

public class Q407TrappingRainWaterII {

    @Test
    public void test() {
        assertThat(trapRainWater(Ps.intArray("[" +
                "[1,4,3,1,3,2], " +
                "[3,2,1,3,2,4], " +
                "[2,3,3,2,3,1]]")))
                .isEqualTo(4);
        assertThat(trapRainWater(Ps.intArray("[[3,3,3,3,3], [3,2,2,2,3], [3,2,1,2,3], [3,2,2,2,3], [3,3,3,3,3]]"))).isEqualTo(10);
    }

    @Test
    public void test2() {
        assertThat(trapRainWater(Ps.intArray("[[9,9,9,9,9,9,8,9,9,9,9],[9,0,0,0,0,0,1,0,0,0,9],[9,0,0,0,0,0,0,0,0,0,9],[9,0,0,0,0,0,0,0,0,0,9],[9,9,9,9,9,9,9,9,9,9,9]]"))).isEqualTo(215);
        assertThat(trapRainWater(Ps.intArray("[" +
                "[2,2,2]," +
                "[2,1,2]," +
                "[2,1,2]," +
                "[2,1,2]]"))).isEqualTo(0);
        assertThat(trapRainWater(Ps.intArray("[[1,3,3,1,3,2],[3,2,1,3,2,3],[3,3,3,2,3,1]]"))).isEqualTo(4);
    }

    final int[][] DIRS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int trapRainWater(int[][] heightMap) {
        final int HEIGHT = heightMap.length;
        final int WIDTH = heightMap[0].length;
        boolean[][] visited = new boolean[HEIGHT][WIDTH];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (i == 0 || i == HEIGHT - 1 || j == 0 || j == WIDTH - 1) {
                    pq.offer(new int[]{i, j, heightMap[i][j]});
                    visited[i][j] = true;
                }
            }
        }

        int answer = 0;
        while (!pq.isEmpty()) {
            int[] point = pq.poll();
            int y = point[0];
            int x = point[1];
            int height = point[2];
            for (int[] dir : DIRS) {
                int nextY = y + dir[0];
                int nextX = x + dir[1];

                if (nextY < 0 || nextY == HEIGHT || nextX < 0 || nextX == WIDTH || visited[nextY][nextX]) {
                    continue;
                }
                visited[nextY][nextX] = true;
                answer += Math.max(0, height - heightMap[nextY][nextX]);
                pq.offer(new int[]{nextY, nextX, Math.max(height, heightMap[nextY][nextX])});
            }
        }
        return answer;
    }

}
