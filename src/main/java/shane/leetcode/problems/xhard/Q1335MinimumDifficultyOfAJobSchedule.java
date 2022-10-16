package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my solution
 */
public class Q1335MinimumDifficultyOfAJobSchedule {

    @Test
    public void test() {
        assertThat(minDifficulty(new int[]{7, 1, 7, 1, 7, 1}, 3)).isEqualTo(15);
        assertThat(minDifficulty(new int[]{1, 2, 3, 4, 5, 6}, 3)).isEqualTo(9);
        assertThat(minDifficulty(new int[]{6, 5, 4, 3, 2, 1}, 2)).isEqualTo(7);
        assertThat(minDifficulty(new int[]{9, 9, 9}, 4)).isEqualTo(-1);
        assertThat(minDifficulty(new int[]{1, 1, 1}, 3)).isEqualTo(3);
    }

    public int minDifficulty(int[] jobDifficulty, int d) {
        if (jobDifficulty.length < d) {
            return -1;
        }
        int[][] memo = new int[d - 1][jobDifficulty.length];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        return dfs(jobDifficulty, d - 1, 0, memo);
    }

    private int dfs(int[] jobDifficulty, int d, int pos, int[][] memo) {
        if (d == 0) {
            int max = jobDifficulty[pos];
            for (int i = pos; i < jobDifficulty.length; i++) max = Math.max(max, jobDifficulty[i]);
            return max;
        }

        int day = memo.length - d;

        if (memo[day][pos] != -1)
            return memo[day][pos];

        int max = -1;
        int min = Integer.MAX_VALUE;
        for (int i = pos; i < jobDifficulty.length - d; i++) {
            max = Math.max(max, jobDifficulty[i]);
            min = Math.min(min, max + dfs(jobDifficulty, d - 1, i + 1, memo));
        }

        return memo[day][pos] = min;
    }

}
