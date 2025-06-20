package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my idea
 */
public class Q3443MaximumManhattanDistanceAfterKChanges {

    @Test
    public void test() {
        assertThat(maxDistance("NSWWEW", 3)).isEqualTo(6);
        assertThat(maxDistance("NWSE", 1)).isEqualTo(3);
    }

    @Test
    public void test2() {
        assertThat(maxDistance("NSES", 1)).isEqualTo(4);
    }

    public int maxDistance(String s, int k) {
        int x = 0, y = 0, max = 0;
        Map<Character, int[]> dir = Map.of(
                'N', new int[]{0, 1},
                'S', new int[]{0, -1},
                'E', new int[]{1, 0},
                'W', new int[]{-1, 0}
        );

        for (int i = 0; i < s.length(); i++) {
            int[] d = dir.get(s.charAt(i));
            x += d[0];
            y += d[1];
            int dist = Math.abs(x) + Math.abs(y);
            max = Math.max(max, Math.min(dist + k * 2, i + 1));
        }

        return max;
    }

}
