package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 6
 * ms
 * Beats
 * 93.63%
 */
public class Q778SwimInRisingWater {

    @Test
    public void test() {
        assertThat(swimInWater(Ps.intArray("[[0,2],[1,3]]"))).isEqualTo(3);
        assertThat(swimInWater(Ps.intArray("[[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]"))).isEqualTo(16);
    }

    int[][] DIRS = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2])); // y, x, value
        int time;
        pq.offer(new int[]{0, 0, grid[0][0]});
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            time = poll[2];
            move(poll[0], poll[1], grid, pq, time);
            if (grid[grid.length - 1][grid[0].length - 1] == -1)
                return time;
        }
        return -1;
    }

    private void move(int i, int j, int[][] grid, PriorityQueue<int[]> pq, int time) {
        grid[i][j] = -1;
        for (int[] dir : DIRS) {
            int y = i + dir[0];
            int x = j + dir[1];
            if (y < 0 || x < 0 || y == grid.length || x == grid[0].length)
                continue;
            int nextValue = grid[y][x];
            if (nextValue < 0)
                continue;
            if (nextValue <= time) {
                move(y, x, grid, pq, time);
                continue;
            }
            pq.offer(new int[]{y, x, nextValue});
        }
    }

}
