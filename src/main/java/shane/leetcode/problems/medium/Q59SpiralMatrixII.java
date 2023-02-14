package shane.leetcode.problems.medium;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q59SpiralMatrixII {

    @Test
    public void test() {
        assertThat(generateMatrix(3)).isDeepEqualTo(Ps.intArray("[[1,2,3],[8,9,4],[7,6,5]]"));
        assertThat(generateMatrix(1)).isDeepEqualTo(Ps.intArray("[[1]]"));
    }

    public int[][] generateMatrix(int n) {
        int[][] answer = new int[n][n];
        int y = 0;
        int x = 0;
        Direction direction = Direction.RIGHT;
        for (int i = 1; i <= n * n; i++) {
            answer[y][x] = i;
            direction = getDirection(n, x, y, direction, answer);
            switch (direction) {
                case RIGHT:
                    x++;
                    break;
                case LEFT:
                    x--;
                    break;
                case UP:
                    y--;
                    break;
                case DOWN:
                    y++;
                    break;
            }
        }

        return answer;

    }

    private Direction getDirection(int n, int x, int y, Direction direction, int[][] answer) {
        if (!canMove(n, x, y, direction, answer)) {
            return direction.next();
        } else {
            return direction;
        }
    }

    private boolean canMove(int n, int x, int y, Direction direction, int[][] answer) {
        switch (direction) {
            case UP:
                return (y > 0 && answer[y - 1][x] == 0);
            case DOWN:
                return (y < n - 1 && answer[y + 1][x] == 0);
            case LEFT:
                return (x > 0 && answer[y][x - 1] == 0);
            case RIGHT:
                return (x < n - 1 && answer[y][x + 1] == 0);
            default:
                return false;
        }
    }

    enum Direction {
        RIGHT, DOWN, LEFT, UP;

        public Direction next() {
            switch (this) {
                case RIGHT:
                    return DOWN;
                case DOWN:
                    return LEFT;
                case LEFT:
                    return UP;
                case UP:
                    return RIGHT;
                default:
                    return null;
            }
        }
    }
}
