package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1335MinimumDifficultyOfAJobSchedule2 {

    @Test
    public void test() {
        assertThat(minDifficulty(new int[]{6, 5, 4, 3, 2, 1}, 2)).isEqualTo(7);
        assertThat(minDifficulty(new int[]{9, 9, 9}, 4)).isEqualTo(-1);
        assertThat(minDifficulty(new int[]{1, 1, 1}, 3)).isEqualTo(3);
    }

    public int minDifficulty(int[] jobDifficulty, int d) {
        if (jobDifficulty.length < d) {
            return -1;
        }
        return dfs(jobDifficulty, d - 1, 0, new Integer[d - 1][jobDifficulty.length]);
    }

    private int dfs(int[] jobDifficulty, int leftDays, int index, Integer[][] memo) {
        if (leftDays == 0) {
            int max = jobDifficulty[index];
            for (int i = index; i < jobDifficulty.length; i++) {
                max = Math.max(max, jobDifficulty[i]);
            }
            return max;
        }

        int day = memo.length - leftDays;

        if (memo[day][index] != null)
            return memo[day][index];

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = index; i < jobDifficulty.length - leftDays; i++) {
            max = Math.max(max, jobDifficulty[i]);
            min = Math.min(min, max + dfs(jobDifficulty, leftDays - 1, i + 1, memo));
        }

        return memo[day][index] = min;
    }

}
