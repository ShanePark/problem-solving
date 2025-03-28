package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 98ms
 * Beats60.30%
 */
public class Q2503MaximumNumberOfPointsFromGridQueries {

    @Test
    public void test() {
        assertThat(maxPoints(Ps.intArray("[[1,2,3],[2,5,7],[3,5,1]]"), new int[]{5, 6, 2})).containsExactly(5, 8, 1);
        assertThat(maxPoints(Ps.intArray("[[5,2,1],[1,1,2]]"), new int[]{3})).containsExactly(0);
    }

    int[][] DIRS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int[] maxPoints(int[][] grid, int[] queries) {
        int HEIGHT = grid.length;
        int WIDTH = grid[0].length;

        boolean[][] visited = new boolean[HEIGHT][WIDTH];
        TreeMap<Integer, Integer> queryMap = new TreeMap<>();
        Queue<Area> next = new PriorityQueue<>();
        Area start = new Area(0, 0, grid[0][0]);
        visited[0][0] = true;
        next.offer(start);
        int lastVal = start.value;
        int possibleCnt = 0;

        while (!next.isEmpty()) {
            while (!next.isEmpty() && next.peek().value <= lastVal) {
                Area poll = next.poll();
                possibleCnt++;
                queryMap.put(lastVal + 1, possibleCnt);
                for (int[] dir : DIRS) {
                    int nextY = poll.y + dir[0];
                    int nextX = poll.x + dir[1];
                    if (nextY < 0 || nextY == grid.length || nextX < 0 || nextX == grid[0].length || visited[nextY][nextX])
                        continue;
                    visited[nextY][nextX] = true;
                    next.offer(new Area(nextY, nextX, grid[nextY][nextX]));
                }
            }
            if (next.isEmpty())
                break;
            lastVal = next.peek().value;
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            Map.Entry<Integer, Integer> e = queryMap.floorEntry(query);
            answer[i] = e == null ? 0 : e.getValue();
        }
        return answer;
    }

    static class Area implements Comparable<Area> {
        int y;
        int x;
        int value;

        public Area(int y, int x, int value) {
            this.y = y;
            this.x = x;
            this.value = value;
        }

        @Override
        public int compareTo(Area o) {
            return this.value - o.value;
        }

        @Override
        public String toString() {
            return "Area{" +
                    "y=" + y +
                    ", x=" + x +
                    ", value=" + value +
                    '}';
        }
    }

}
