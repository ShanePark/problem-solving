package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * backtracking tle
 */
public class Q920NumberOfMusicPlaylists {

    @Test
    public void test() {
        assertThat(numMusicPlaylists(2, 3, 1)).isEqualTo(2);
        assertThat(numMusicPlaylists(3, 3, 1)).isEqualTo(6);
        assertThat(numMusicPlaylists(2, 3, 0)).isEqualTo(6);
    }

    @Test
    public void tle() {
        assertThat(numMusicPlaylists(16, 16, 4));
    }

    final int MOD = (int) (1e9 + 7);

    public int numMusicPlaylists(int n, int goal, int k) {
        Map<Integer, Integer> history = new HashMap<>();
        return numMusicPlaylists(n, goal, k, 0, history);
    }

    private int numMusicPlaylists(int n, int goal, int k, int cur, Map<Integer, Integer> history) {
        if (cur == goal) {
            if (history.keySet().size() == n)
                return 1;
            return 0;
        }
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            Integer saved = history.get(i);
            if (saved != null && cur - saved <= k) {
                continue;
            }
            history.put(i, cur);
            sum += numMusicPlaylists(n, goal, k, cur + 1, history);
            if (saved == null) {
                history.remove(i);
                continue;
            }
            history.put(i, saved);
        }
        return (int) (sum % MOD);
    }

}
