package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("ALL")
public class Q1631PathWithMinimumEffort4 {

    @Test
    public void test() {
        assertThat(minimumEffortPath(Ps.intArray("[[1,2,2],[3,8,2],[5,3,5]]"))).isEqualTo(2);
        assertThat(minimumEffortPath(Ps.intArray("[[1,2,3],[3,8,4],[5,3,5]]"))).isEqualTo(1);
        assertThat(minimumEffortPath(Ps.intArray("[[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]"))).isEqualTo(0);
        assertThat(minimumEffortPath(Ps.intArray("[[1,10,6,7,9,10,4,9]]"))).isEqualTo(9);
    }


    public int minimumEffortPath(int[][] heights) {
        final int HEIGHT = heights.length;
        final int WIDTH = heights[0].length;
        int[][] arr = new int[HEIGHT][WIDTH];

        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                arr[i][j] = Integer.MAX_VALUE;
            }
        }
        arr[0][0] = 0;
        PriorityQueue<Status> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        pq.add(new Status(0, 0, 0));
        while (!pq.isEmpty()) {
            Status status = pq.poll();
            int y = status.y;
            int x = status.x;
            int distance = status.distance;
            if (y == HEIGHT - 1 && x == WIDTH - 1) {
                break;
            }
            if (x > 0) {
                int nextDistance = Math.max(distance, Math.abs(heights[y][x] - heights[y][x - 1]));
                if (nextDistance < arr[y][x - 1]) {
                    pq.offer(new Status(y, x - 1, nextDistance));
                    arr[y][x - 1] = nextDistance;
                }
            }
            if (y > 0) {
                int nextDistance = Math.max(distance, Math.abs(heights[y][x] - heights[y - 1][x]));
                if (nextDistance < arr[y - 1][x]) {
                    pq.offer(new Status(y - 1, x, nextDistance));
                    arr[y - 1][x] = nextDistance;

                }
            }
            if (y < HEIGHT - 1) {
                int nextDistance = Math.max(distance, Math.abs(heights[y][x] - heights[y + 1][x]));
                if (nextDistance < arr[y + 1][x]) {
                    pq.offer(new Status(y + 1, x, nextDistance));
                    arr[y + 1][x] = nextDistance;
                }
            }
            if (x < WIDTH - 1) {
                int nextDistance = Math.max(distance, Math.abs(heights[y][x] - heights[y][x + 1]));
                if (nextDistance < arr[y][x + 1]) {
                    pq.offer(new Status(y, x + 1, nextDistance));
                    arr[y][x + 1] = nextDistance;
                }
            }
        }

        return arr[HEIGHT - 1][WIDTH - 1];
    }

    class Status {
        int y;
        int x;
        int distance;

        public Status(int y, int x, int distance) {
            this.y = y;
            this.x = x;
            this.distance = distance;
        }
    }
}
