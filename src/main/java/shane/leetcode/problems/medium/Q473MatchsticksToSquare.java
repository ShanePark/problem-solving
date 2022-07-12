package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Q473MatchsticksToSquare {

    @Test
    public void test() {
        assertThat(makesquare(new int[]{2, 2, 3, 4, 4, 4, 4, 4, 5})).isTrue();
        assertThat(makesquare(new int[]{1, 1, 2, 2, 2})).isTrue();
        assertThat(makesquare(new int[]{3, 3, 3, 3, 4})).isFalse();
    }

    public boolean makesquare(int[] matchsticks) {
        if (matchsticks.length < 4)
            return false;
        int sum = 0;
        for (int matchstick : matchsticks) {
            sum += matchstick;
        }
        if (sum % 4 != 0)
            return false;
        Arrays.sort(matchsticks);
        return dfs(matchsticks, new int[4], matchsticks.length - 1, sum / 4);
    }

    private boolean dfs(int[] matchsticks, int[] lengths, int i, int length) {
        if (i < 0) {
            return lengths[0] == length && lengths[1] == length && lengths[2] == length && lengths[3] == length;
        }
        int match = matchsticks[i];
        for (int j = 0; j < 4; j++) {
            if (lengths[j] + match > length)
                continue;
            lengths[j] += match;
            if (dfs(matchsticks, lengths, i - 1, length))
                return true;
            lengths[j] -= match;
        }
        return false;
    }
}
