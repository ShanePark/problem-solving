package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

public class Q407TrappingRainWaterII2 {

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

    final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int trapRainWater(int[][] heightMap) {
        int HEIGHT = heightMap.length;
        int WIDTH = heightMap[0].length;
        int[][] waterLevel = new int[HEIGHT][WIDTH];
        for (int[] row : waterLevel) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        for (int i = 0; i < HEIGHT; i++) {
            addCell(pq, waterLevel, heightMap, i, 0);
            addCell(pq, waterLevel, heightMap, i, WIDTH - 1);
        }
        for (int j = 1; j < WIDTH - 1; j++) {
            addCell(pq, waterLevel, heightMap, 0, j);
            addCell(pq, waterLevel, heightMap, HEIGHT - 1, j);
        }

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            for (int[] dir : DIRS) {
                int x = current[0] + dir[0];
                int y = current[1] + dir[1];
                if (x < 0 || x == HEIGHT || y < 0 || y == WIDTH) {
                    continue;
                }
                int height = Math.max(current[2], heightMap[x][y]);
                if (height >= waterLevel[x][y]) {
                    continue;
                }
                waterLevel[x][y] = height;
                pq.offer(new int[]{x, y, height});
            }
        }

        int water = 0;
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                water += waterLevel[i][j] - heightMap[i][j];
            }
        }
        return water;
    }

    private void addCell(PriorityQueue<int[]> pq, int[][] waterLevel, int[][] heightMap, int row, int col) {
        waterLevel[row][col] = heightMap[row][col];
        pq.offer(new int[]{row, col, heightMap[row][col]});
    }

}
