package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 18
 * ms
 * Beats
 * 65.69%
 */
public class Q1368MinimumCostToMakeAtLeastOneValidPathInAGrid {

    @Test
    public void test() {
        assertThat(minCost(Ps.intArray("[[1,1,1,1],[2,2,2,2],[1,1,1,1],[2,2,2,2]]"))).isEqualTo(3);
        assertThat(minCost(Ps.intArray("[[1,1,3],[3,2,2],[1,1,4]]"))).isEqualTo(0);
        assertThat(minCost(Ps.intArray("[[1,2],[4,3]]"))).isEqualTo(1);
    }

    @Test
    public void test2() {
        assertThat(minCost(Ps.intArray("[[2,2,2],[2,2,2]]"))).isEqualTo(3);
        assertThat(minCost(Ps.intArray("[[3,4,3],[2,2,2],[2,1,1],[4,3,2],[2,1,4],[2,4,1],[3,3,3],[1,4,2],[2,2,1],[2,1,1],[3,3,1],[4,1,4],[2,1,4],[3,2,2],[3,3,1],[4,4,1],[1,2,2],[1,1,1],[1,3,4],[1,2,1],[2,2,4],[2,1,3],[1,2,1],[4,3,2],[3,3,4],[2,2,1],[3,4,3],[4,2,3],[4,4,4]]")))
                .isEqualTo(18);
        assertThat(minCost(Ps.intArray("[[2,2,2],[2,2,2]]"))).isEqualTo(3);
    }

    int[][] DIRS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minCost(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});

        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] poll = q.poll();
                List<int[]> union = new ArrayList<>();
                findAllMoves(grid, poll, union);
                for (int[] p : union) {
                    if (p[0] == grid.length - 1 && p[1] == grid[0].length - 1)
                        return step;
                    for (int[] dir : DIRS) {
                        int y = p[0] + dir[0];
                        int x = p[1] + dir[1];
                        if (y < 0 || x < 0 || y == grid.length || x == grid[0].length || grid[y][x] == -1)
                            continue;
                        q.offer(new int[]{y, x});
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private void findAllMoves(int[][] grid, int[] cur, List<int[]> moves) {
        int y = cur[0];
        int x = cur[1];
        if (grid[y][x] == -1)
            return;
        moves.add(cur);
        switch (grid[cur[0]][cur[1]]) {
            case 1:
                x++;
                break;
            case 2:
                x--;
                break;
            case 3:
                y++;
                break;
            case 4:
                y--;
                break;
        }
        grid[cur[0]][cur[1]] = -1;
        if (y < 0 || x < 0 || y == grid.length || x == grid[0].length || grid[y][x] == -1)
            return;
        findAllMoves(grid, new int[]{y, x}, moves);
    }

}
