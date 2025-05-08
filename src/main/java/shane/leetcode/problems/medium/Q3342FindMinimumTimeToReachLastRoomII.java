package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 47ms
 * Beats94.71%
 */
public class Q3342FindMinimumTimeToReachLastRoomII {

    @Test
    public void test() {
        assertThat(minTimeToReach(Ps.intArray("[[0,4],[4,4]]"))).isEqualTo(7);
        assertThat(minTimeToReach(Ps.intArray("[[0,0,0,0],[0,0,0,0]]"))).isEqualTo(6);
    }

    final int[][] DIRS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int minTimeToReach(int[][] moveTime) {
        final int WIDTH = moveTime[0].length;
        final int HEIGHT = moveTime.length;
        Integer[][] dp = new Integer[HEIGHT][WIDTH];
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2] + a[3]));
        pq.offer(new int[]{0, 0, 0, 0}); // y, x, time, step
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            for (int[] dir : DIRS) {
                int y = poll[0] + dir[0];
                int x = poll[1] + dir[1];
                int curTime = poll[2];
                int curStep = poll[3] % 2 + 1;
                if (y < 0 || y == HEIGHT || x < 0 || x == WIDTH || (dp[y][x] != null && dp[y][x] <= curTime + curStep)) {
                    continue;
                }
                dp[y][x] = Math.max(curTime, moveTime[y][x]) + curStep;
                if (y == HEIGHT - 1 && x == WIDTH - 1)
                    return dp[y][x];
                pq.offer(new int[]{y, x, dp[y][x], curStep});
            }
        }
        return -1;
    }

}
