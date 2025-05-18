package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my solution
 */
public class Q1931PaintingAGridWithThreeDifferentColors {

    @Test
    public void test() {
        assertThat(colorTheGrid(1, 1)).isEqualTo(3);
        assertThat(colorTheGrid(1, 2)).isEqualTo(6);
        assertThat(colorTheGrid(5, 5)).isEqualTo(580986);
    }

    final int MOD = (int) 1e9 + 7;

    public int colorTheGrid(int m, int n) {
        Map<Integer, Long> currentColumnStates = new HashMap<>();
        dfs(currentColumnStates, 0, m, -1, 0);
        Set<Integer> validColumns = new HashSet<>(currentColumnStates.keySet());
        for (int i = 1; i < n; ++i) {
            Map<Integer, Long> dp = new HashMap<>();
            for (int state : validColumns) {
                for (int prev : validColumns) {
                    if ((state & prev) == 0)
                        dp.merge(state, currentColumnStates.get(prev), (l1, l2) -> (l1 + l2) % MOD);
                }
            }
            currentColumnStates = dp;
        }
        long answer = 0L;
        for (long val : currentColumnStates.values())
            answer = (answer + val) % MOD;
        return (int) answer;
    }

    private void dfs(Map<Integer, Long> state, int j, int m, int prev, int cur) {
        if (j == m) {
            state.merge(cur, 1L, Long::sum);
            return;
        }
        for (int i = 0; i < 3; ++i) {
            if (i == prev)
                continue;
            dfs(state, j + 1, m, i, (cur << 3) | (1 << i));
        }
    }

}
