package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

public class Q3341FindMinimumTimeToReachLastRoomI2 {

    @Test
    public void test() {
        assertThat(minTimeToReach(Ps.intArray("[[0,4],[4,4]]"))).isEqualTo(6);
        assertThat(minTimeToReach(Ps.intArray("[[0,0,0],[0,0,0]]"))).isEqualTo(3);
    }

    final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int minTimeToReach(int[][] moveTime) {
        final int HEIGHT = moveTime.length;
        final int WIDTH = moveTime[0].length;
        Integer[][] minTime = new Integer[HEIGHT][WIDTH];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0}); // {time, y, x}

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int cur = poll[0];
            int i = poll[1];
            int j = poll[2];
            if (i == HEIGHT - 1 && j == WIDTH - 1)
                return cur;

            for (int[] d : DIRS) {
                int y = i + d[0];
                int x = j + d[1];
                if (y < 0 || x < 0 || y == HEIGHT || x == WIDTH)
                    continue;
                int arrive = Math.max(cur + 1, moveTime[y][x] + 1);
                if (minTime[y][x] == null || arrive < minTime[y][x]) {
                    minTime[y][x] = arrive;
                    pq.offer(new int[]{arrive, y, x});
                }
            }
        }
        return -1;
    }

}
