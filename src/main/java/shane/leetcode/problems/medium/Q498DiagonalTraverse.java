package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 3ms
 * Beats61.54%
 */
public class Q498DiagonalTraverse {

    @Test
    public void test() {
        assertThat(findDiagonalOrder(Ps.intArray("[[1,2,3],[4,5,6],[7,8,9]]"))).containsExactly(1, 2, 4, 7, 5, 3, 6, 8, 9);
        assertThat(findDiagonalOrder(Ps.intArray("[[1,2],[3,4]]"))).containsExactly(1, 2, 3, 4);
    }

    public int[] findDiagonalOrder(int[][] mat) {
        final int HEIGHT = mat.length;
        final int WIDTH = mat[0].length;
        final int TOTAL = HEIGHT * WIDTH;
        int[] answer = new int[TOTAL];
        int[] point = new int[]{0, 0};
        int cnt = 0;
        Mover mover = new Mover(mat);
        while (cnt < TOTAL) {
            answer[cnt++] = mat[point[0]][point[1]];
            mover.move(point);
        }
        return answer;
    }

    static class Mover {
        int turn = 0;
        int[][] move = new int[][]{{-1, 1}, {1, -1}};
        final int height;
        final int width;

        public Mover(int[][] mat) {
            this.height = mat.length;
            this.width = mat[0].length;
        }

        void move(int[] point) {
            int y = point[0];
            int x = point[1];
            int[] thisMove = move[turn];
            y += thisMove[0];
            x += thisMove[1];
            if (isValid(y, x)) {
                point[0] = y;
                point[1] = x;
                return;
            }
            if (turn == 0) { // was going up right
                if (x < width) {
                    y = 0;
                } else {
                    y += 2;
                    x = width - 1;
                }
            } else { // was going left bottom
                if (y < height) {
                    x = 0;
                } else {
                    x += 2;
                    y = height - 1;
                }
            }
            point[0] = y;
            point[1] = x;
            this.turn = (this.turn + 1) % 2;
        }

        private boolean isValid(int y, int x) {
            return 0 <= y && y < height && 0 <= x && x < width;
        }
    }

}
