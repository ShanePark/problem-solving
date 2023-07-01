package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * From Editorial
 */
public class Q1970LastDayWhereYouCanStillCross2 {

    @Test
    public void test() {
        assertThat(latestDayToCross(2, 2, Ps.intArray("[[1,1],[2,1],[1,2],[2,2]]"))).isEqualTo(2);
        assertThat(latestDayToCross(2, 2, Ps.intArray("[[1,1],[1,2],[2,1],[2,2]]"))).isEqualTo(1);
        assertThat(latestDayToCross(3, 3, Ps.intArray("[[1,2],[2,1],[3,3],[2,2],[1,1],[1,3],[2,3],[3,2],[3,1]]"))).isEqualTo(3);
    }

    public int latestDayToCross(int row, int col, int[][] cells) {
        UnionFind uf = new UnionFind(row * col + 2);
        boolean[][] water = new boolean[row][col];
        int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

        for (int i = 0; i < row * col; i++) {
            int y = cells[i][0] - 1;
            int x = cells[i][1] - 1;
            water[y][x] = true;
            int curIndex = y * col + x + 1;
            for (int[] dir : DIRS) {
                int nextY = y + dir[0];
                int nextX = x + dir[1];
                int nextIndex = nextY * col + nextX + 1;
                if (nextY >= 0 && nextY < row && nextX >= 0 && nextX < col && water[nextY][nextX]) {
                    uf.union(curIndex, nextIndex);
                }
            }
            if (x == 0) {
                uf.union(0, curIndex);
            }
            if (x == col - 1) {
                uf.union(row * col + 1, curIndex);
            }
            if (uf.find(0) == uf.find(row * col + 1)) {
                return i;
            }
        }
        return -1;
    }

    class UnionFind {
        final int[] root;
        final int[] size;

        public UnionFind(int n) {
            root = new int[n];
            for (int i = 0; i < n; i++) {
                root[i] = i;
            }
            size = new int[n];
            Arrays.fill(size, 1);
        }

        public int find(int x) {
            if (root[x] != x) {
                root[x] = find(root[x]);
            }
            return root[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }

            if (size[rootX] > size[rootY]) {
                int tmp = rootX;
                rootX = rootY;
                rootY = tmp;
            }
            root[rootX] = rootY;
            size[rootY] += size[rootX];
        }
    }

}
