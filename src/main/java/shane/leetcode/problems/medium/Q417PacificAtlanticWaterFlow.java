package shane.leetcode.problems.medium;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 875 ms, faster than 5.02% of Java online submissions for Pacific Atlantic Water Flow.
 * Memory Usage: 44.4 MB, less than 85.22% of Java online submissions for Pacific Atlantic Water Flow.
 */
public class Q417PacificAtlanticWaterFlow {

    @Test
    public void test() {
        assertThat(pacificAtlantic(STool.convertToIntArray("[[1,2,3],[8,9,4],[7,6,5]]")))
                .isEqualTo(STool.convertToIntList("[[0, 2], [1, 0], [1, 1], [1, 2], [2, 0], [2, 1], [2, 2]]"));
        assertThat(pacificAtlantic(STool.convertToIntArray("[[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]")))
                .isEqualTo(STool.convertToIntList("[[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]"));
        assertThat(pacificAtlantic(STool.convertToIntArray("[[1]]")))
                .isEqualTo(STool.convertToIntList("[[0,0]]"));
    }

    @Test
    public void test2() {
        assertThat(pacificAtlantic(STool.convertToIntArray("[[7,1,17,13,9,10,5,14,0,3],[7,15,7,8,15,16,10,10,5,13],[18,9,15,8,19,16,7,5,5,10],[15,11,18,3,1,17,6,4,10,19],[3,16,19,12,12,19,2,14,5,9],[7,16,0,13,14,7,2,8,6,19],[5,10,1,10,2,12,19,1,0,19],[13,18,19,12,17,17,4,5,8,2],[2,1,17,13,14,12,14,2,16,10],[5,8,1,11,16,1,18,15,6,19],[3,8,14,14,5,0,2,7,5,1],[17,1,9,17,10,10,10,7,1,16],[14,18,5,11,17,15,8,8,14,13],[6,4,10,17,8,0,11,4,2,8],[16,11,17,9,3,2,11,0,6,5],[12,18,18,11,1,7,12,16,12,12],[2,14,12,0,2,8,5,10,7,0],[16,13,1,19,8,13,11,8,11,3],[11,2,8,19,6,14,14,6,16,12],[18,0,18,10,16,15,15,12,4,3],[8,15,9,13,8,2,6,11,17,6],[7,3,0,18,7,12,2,3,12,10],[7,9,13,0,11,16,9,9,12,13],[9,4,19,6,8,10,12,6,7,11],[5,9,18,0,4,9,6,4,0,1],[9,12,1,11,13,13,0,16,0,6],[7,15,4,8,15,17,17,19,15,1],[7,17,4,1,1,14,10,19,10,19],[10,5,12,5,8,8,14,14,6,0],[16,10,10,7,13,4,0,15,18,0],[11,2,10,6,5,13,4,5,3,1],[9,14,16,14,15,3,2,13,17,8],[19,2,10,1,2,15,12,10,2,5],[12,4,8,9,8,6,4,14,14,0],[11,17,17,4,16,13,6,15,5,7],[12,18,1,3,9,10,7,1,1,1],[18,6,10,8,12,14,9,12,10,3],[15,13,18,13,8,5,12,14,18,0],[15,4,8,9,19,18,6,19,12,0],[4,14,15,4,17,17,9,17,9,0],[6,17,16,10,3,8,8,18,15,9],[3,8,4,2,13,0,2,8,8,2],[14,12,13,12,17,4,16,9,8,7],[0,19,8,16,1,13,7,6,15,11],[1,13,16,14,10,4,11,19,9,13],[8,0,2,1,16,12,16,9,9,9],[5,2,10,4,8,12,17,0,2,15],[11,2,15,15,14,9,11,19,18,11],[4,4,1,5,13,19,9,17,17,17],[4,1,8,0,8,19,11,0,5,4],[8,16,14,18,12,2,0,19,0,13],[7,11,3,18,8,2,2,19,8,7],[3,13,6,1,12,16,4,13,0,5],[12,1,16,19,2,12,16,15,19,6],[1,7,12,15,3,3,13,17,16,12]]")))
                .isEqualTo(STool.convertToIntList("[[0,9],[1,9],[2,9],[3,9],[11,3],[53,0],[53,2],[53,3],[54,0],[54,1],[54,2],[54,3]]"));
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        final int HEIGHT = heights.length;
        final int WIDTH = heights[0].length;
        HashMap<Point, Boolean> pacific = new HashMap<>();
        HashMap<Point, Boolean> atlantic = new HashMap<>();

        for (int i = 0; i < HEIGHT; i++) {
            pacific.put(new Point(i, 0), true);
            atlantic.put(new Point(i, WIDTH - 1), true);
        }
        for (int j = 0; j < WIDTH; j++) {
            pacific.put(new Point(0, j), true);
            atlantic.put(new Point(HEIGHT - 1, j), true);
        }

        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                dfs(i, j, heights, pacific, new boolean[HEIGHT][WIDTH]);
                dfs(i, j, heights, atlantic, new boolean[HEIGHT][WIDTH]);
            }
        }

        Set<Point> pacificSet = pacific.entrySet().stream().filter(e -> e.getValue()).map(e -> e.getKey()).collect(Collectors.toSet());
        Set<Point> atlanticSet = atlantic.entrySet().stream().filter(e -> e.getValue()).map(e -> e.getKey()).collect(Collectors.toSet());

        pacificSet.retainAll(atlanticSet);
        List<List<Integer>> result = pacificSet.stream().sorted((p1, p2) -> {
            if (p1.y == p2.y) {
                return Integer.compare(p1.x, p2.x);
            }
            return Integer.compare(p1.y, p2.y);
        }).map(p -> List.of(p.y, p.x)).collect(Collectors.toList());
        return result;
    }

    private boolean dfs(int i, int j, int[][] heights, Map<Point, Boolean> ocean, boolean[][] visited) {
        Point point = new Point(i, j);
        visited[i][j] = true;
        if (i > 0 && !visited[i - 1][j] && heights[i][j] >= heights[i - 1][j]) {
            Boolean up = ocean.get(new Point(i - 1, j));
            if (up == null) {
                up = dfs(i - 1, j, heights, ocean, visited);
            }

            if (up) {
                ocean.put(point, true);
                return true;
            }
        }
        if (i < heights.length - 1 && !visited[i + 1][j] && heights[i][j] >= heights[i + 1][j]) {
            Boolean down = ocean.get(new Point(i + 1, j));
            if (down == null) {
                down = dfs(i + 1, j, heights, ocean, visited);
            }
            if (down) {
                ocean.put(point, true);
                return true;
            }
        }

        if (j > 0 && !visited[i][j - 1] && heights[i][j] >= heights[i][j - 1]) {
            Boolean left = ocean.get(new Point(i, j - 1));
            if (left == null) {
                left = dfs(i, j - 1, heights, ocean, visited);
            }
            if (left) {
                ocean.put(point, true);
                return true;
            }
        }

        if (j < heights[0].length - 1 && !visited[i][j + 1] && heights[i][j] >= heights[i][j + 1]) {
            Boolean right = ocean.get(new Point(i, j + 1));
            if (right == null) {
                right = dfs(i, j + 1, heights, ocean, visited);
            }
            if (right) {
                ocean.put(point, true);
                return true;
            }
        }
        if (!ocean.containsKey(point)) {
//            ocean.put(point, false); // faster but can't pass few cases
            return false;
        }
        return ocean.get(point);
    }

    class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;
            Point point = (Point) o;
            return y == point.y && x == point.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }

        @Override
        public String toString() {
            return "Point{" +
                    "y=" + y +
                    ", x=" + x +
                    '}';
        }
    }
}
