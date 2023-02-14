package shane.leetcode.contest.weekly.w292;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q4_2 {

    @Test
    public void test() {
        assertThat(hasValidPath(Ps.charArray("[[\"(\",\"(\",\"(\",\"(\",\"(\"],[\"(\",\"(\",\")\",\")\",\")\"],[\")\",\"(\",\")\",\")\",\"(\"],[\"(\",\"(\",\")\",\")\",\")\"]]"))).isTrue();
        assertThat(hasValidPath(Ps.charArray("[[\"(\",\"(\",\"(\"],[\")\",\"(\",\")\"],[\"(\",\"(\",\")\"],[\"(\",\"(\",\")\"]]"))).isTrue();
        assertThat(hasValidPath(Ps.charArray("[[\"(\",\"(\"],[\"(\",\"(\"]]"))).isFalse();
        assertThat(hasValidPath(Ps.charArray("[[\")\",\")\"],[\"(\",\"(\"]]"))).isFalse();
    }

    boolean[][][] memo;

    public boolean hasValidPath(char[][] grid) {
        int HEIGHT = grid.length;
        int WIDTH = grid[0].length;

        boolean[][][] dp = new boolean[HEIGHT + 1][WIDTH + 1][103];
        dp[0][0][1] = true;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                for (int k = 1; k <= 101; k++) {
                    dp[i][j + 1][k] = dp[i][j + 1][k] || dp[i][j][k + (grid[i][j] == '(' ? -1 : 1)];
                    dp[i + 1][j][k] = dp[i + 1][j][k] || dp[i][j][k + (grid[i][j] == '(' ? -1 : 1)];
                }
            }
        }
        return dp[HEIGHT - 1][WIDTH][1];
    }

}
