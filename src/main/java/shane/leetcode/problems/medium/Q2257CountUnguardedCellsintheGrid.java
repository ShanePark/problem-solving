package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 163ms Beats5.26%
 */
public class Q2257CountUnguardedCellsintheGrid {

    @Test
    public void test() {
        assertThat(countUnguarded(4, 6, Ps.intArray("[[0,0],[1,1],[2,3]]"), Ps.intArray("[[0,1],[2,2],[1,4]]"))).isEqualTo(7);
        assertThat(countUnguarded(3, 3, Ps.intArray("[[1,1]]"), Ps.intArray("[[0,1],[1,0],[2,1],[1,2]]"))).isEqualTo(4);
    }

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        Cell[][] grid = new Cell[m][n];
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = new Cell(CellStatus.WALL);
        }

        for (int[] guard : guards) {
            int y = guard[0];
            int x = guard[1];
            grid[y][x] = new Cell(CellStatus.GUARD);

            tryGuard(grid, y - 1, x, Way.UP);
            tryGuard(grid, y + 1, x, Way.DOWN);
            tryGuard(grid, y, x - 1, Way.LEFT);
            tryGuard(grid, y, x + 1, Way.RIGHT);
        }

        int cnt = 0;
        for (Cell[] cells : grid) {
            for (Cell cell : cells) {
                if (cell == null)
                    cnt++;
            }
        }
        return cnt;
    }

    void tryGuard(Cell[][] grid, int y, int x, Way way) {
        if (y < 0 || x < 0 || y == grid.length || x == grid[0].length)
            return;
        Cell cell = grid[y][x];
        if (cell == null) {
            grid[y][x] = new Cell(CellStatus.GUARDED, way);
            tryGuard(grid, y + way.wayARr[0], x + way.wayARr[1], way);
            return;
        }
        if (cell.status == CellStatus.WALL || cell.status == CellStatus.GUARD)
            return;
        if (cell.isGuarding(way))
            return;
        cell.addGuarding(way);
        tryGuard(grid, y + way.wayARr[0], x + way.wayARr[1], way);
    }

    enum CellStatus {
        WALL, GUARD, GUARDED
    }

    static class Cell {
        final CellStatus status;
        Set<Way> guarding = new HashSet<>();

        Cell(CellStatus status) {
            this.status = status;
        }

        Cell(CellStatus status, Way way) {
            this.status = status;
            guarding.add(way);
        }

        public boolean isGuarding(Way way) {
            return guarding.contains(way);
        }

        public void addGuarding(Way way) {
            this.guarding.add(way);
        }

        @Override
        public String toString() {
            return status.toString();
        }
    }

    public enum Way {
        LEFT(new int[]{0, -1}),
        RIGHT(new int[]{0, 1}),
        UP(new int[]{-1, 0}),
        DOWN(new int[]{1, 0});

        Way(int[] ints) {
            this.wayARr = ints;
        }

        final int[] wayARr;
    }

}
