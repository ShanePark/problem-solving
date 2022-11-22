package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q279PerfectSquares2 {

    @Test
    public void test() {
        assertThat(numSquares(12)).isEqualTo(3);
        assertThat(numSquares(3)).isEqualTo(3);
        assertThat(numSquares(13)).isEqualTo(2);
        assertThat(numSquares(32)).isEqualTo(2);
    }

    public int numSquares(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i * i <= n; i++) {
            map.put(i * i, 1);
        }
        while (map.get(n) == null) {
            List<Integer> keys = map.entrySet().stream().sorted(Comparator.comparingInt(e -> e.getValue())).map(e -> e.getKey()).collect(Collectors.toList());
            for (int i : keys) {
                for (int j : keys) {
                    if (i + j <= n && map.get(i + j) == null) {
                        map.put(i + j, map.get(i) + map.get(j));
                    }
                }
            }
        }
        return map.get(n);
    }
}
