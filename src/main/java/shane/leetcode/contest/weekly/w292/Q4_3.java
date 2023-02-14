package shane.leetcode.contest.weekly.w292;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q4_3 {

    @Test
    public void test() {
        assertThat(hasValidPath(Ps.charArray("[[\"(\",\"(\",\"(\"],[\")\",\"(\",\")\"],[\"(\",\"(\",\")\"],[\"(\",\"(\",\")\"]]"))).isTrue();
        assertThat(hasValidPath(Ps.charArray("[[\"(\",\"(\",\"(\",\"(\",\"(\"],[\"(\",\"(\",\")\",\")\",\")\"],[\")\",\"(\",\")\",\")\",\"(\"],[\"(\",\"(\",\")\",\")\",\")\"]]"))).isTrue();
        assertThat(hasValidPath(Ps.charArray("[[\"(\",\"(\"],[\"(\",\"(\"]]"))).isFalse();
        assertThat(hasValidPath(Ps.charArray("[[\")\",\")\"],[\"(\",\"(\"]]"))).isFalse();
    }

    boolean[][][] visited;
    int HEIGHT;
    int WIDTH;

    public boolean hasValidPath(char[][] grid) {
        visited = new boolean[100][100][101];
        HEIGHT = grid.length;
        WIDTH = grid[0].length;
        return hasValidPath(grid, 0, 0, 0);
    }

    private boolean hasValidPath(char[][] grid, int i, int j, int count) {
        count += grid[i][j] == '(' ? 1 : -1;
        if (count < 0 || count > (WIDTH + HEIGHT - 2 - i - j) || visited[i][j][count])
            return false;
        visited[i][j][count] = true;

        if (i == HEIGHT - 1 && j == WIDTH - 1 && count == 0)
            return true;
        if (i < HEIGHT - 1 && hasValidPath(grid, i + 1, j, count)) {
            return true;
        }
        if (j < WIDTH - 1 && hasValidPath(grid, i, j + 1, count)) {
            return true;
        }
        return false;
    }

}
