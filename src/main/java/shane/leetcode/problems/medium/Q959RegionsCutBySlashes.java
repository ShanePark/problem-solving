package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q959RegionsCutBySlashes {

    @Test
    public void test() {
        assertThat(regionsBySlashes(new String[]{" /", "/ "})).isEqualTo(2);
        assertThat(regionsBySlashes(new String[]{" /", "  "})).isEqualTo(1);
        assertThat(regionsBySlashes(new String[]{"/\\", "\\/"})).isEqualTo(5);
    }

    public int regionsBySlashes(String[] grid) {
        int answer = 0;
        int[][] upscale = new int[grid.length * 3][grid.length * 3];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                char cur = grid[i].charAt(j);
                if (cur == ' ')
                    continue;
                if (cur == '/') {
                    upscale[i * 3][j * 3 + 2] = 1;
                    upscale[i * 3 + 1][j * 3 + 1] = 1;
                    upscale[i * 3 + 2][j * 3] = 1;
                    continue;
                }
                upscale[i * 3][j * 3] = 1;
                upscale[i * 3 + 1][j * 3 + 1] = 1;
                upscale[i * 3 + 2][j * 3 + 2] = 1;
            }
        }
        for (int i = 0; i < grid.length * 3; i++) {
            for (int j = 0; j < grid.length * 3; j++) {
                answer += dfs(upscale, i, j) == 0 ? 0 : 1;
            }
        }
        return answer;
    }

    int[][] DIRS = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    int dfs(int[][] upscale, int i, int j) {
        if (i < 0 || j < 0 || i == upscale.length || j == upscale.length || upscale[i][j] != 0)
            return 0;
        upscale[i][j] = 1;
        int answer = 1;
        for (int[] dir : DIRS) {
            answer += dfs(upscale, i + dir[0], j + dir[1]);
        }
        return answer;
    }

}
