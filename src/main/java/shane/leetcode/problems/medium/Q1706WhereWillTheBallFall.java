package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 7 ms, faster than 34.60% of Java online submissions for Where Will the Ball Fall.
 * Memory Usage: 54 MB, less than 72.75% of Java online submissions for Where Will the Ball Fall.
 */
public class Q1706WhereWillTheBallFall {

    @Test
    public void test() {
        assertThat(findBall(Ps.intArray("[[1,1,1,-1,-1],[1,1,1,-1,-1],[-1,-1,-1,1,1],[1,1,1,1,-1],[-1,-1,-1,-1,-1]]")))
                .containsExactly(1, -1, -1, -1, -1);
        assertThat(findBall(Ps.intArray("[[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1],[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1]]"))).containsExactly(0, 1, 2, 3, 4, -1);
        assertThat(findBall(Ps.intArray("[[-1]]"))).containsExactly(-1);
    }

    public int[] findBall(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        int[] answer = new int[width];
        for (int j = 0; j < width; j++) {
            int y = 0;
            int x = j;
            Direction direction = null;
            while (y < height) {
                if (x < 0 || x == width) {
                    answer[j] = -1;
                    break;
                }
                Direction next = grid[y][x] == 1 ? Direction.RIGHT : Direction.LEFT;
                if (direction == Direction.DOWN) {
                    x = (next == Direction.RIGHT) ? x + 1 : x - 1;
                    direction = next;
                } else if (direction == next) {
                    direction = Direction.DOWN;
                    y++;
                } else if (direction == null) {
                    direction = next;
                    x = direction == Direction.RIGHT ? x + 1 : x - 1;
                } else {
                    answer[j] = -1;
                    break;
                }
            }
            if (y == height)
                answer[j] = x;
        }
        return answer;
    }

    enum Direction {
        LEFT, RIGHT, DOWN
    }
}
