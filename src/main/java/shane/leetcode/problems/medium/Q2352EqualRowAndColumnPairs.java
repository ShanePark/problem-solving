package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 72 ms Beats 27.91%
 * Memory 54.3 MB Beats 5.54%
 */
public class Q2352EqualRowAndColumnPairs {

    @Test
    public void test() {
        assertThat(equalPairs(Ps.intArray("[[11,1],[1,11]]"))).isEqualTo(2);
        assertThat(equalPairs(Ps.intArray("[[3,2,1],[1,7,6],[2,7,7]]"))).isEqualTo(1);
        assertThat(equalPairs(Ps.intArray("[[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]"))).isEqualTo(3);
    }

    public int equalPairs(int[][] grid) {
        int length = grid.length;
        Map<String, Integer> cnt = new HashMap<>();
        for (int i = 0; i < length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < length; j++) {
                sb.append(grid[i][j] + " ");
            }
            cnt.merge(sb.toString(), 1, Integer::sum);
        }
        int result = 0;
        for (int j = 0; j < length; j++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < length; i++) {
                sb.append(grid[i][j] + " ");
            }
            result += cnt.getOrDefault(sb.toString(), 0);
        }
        return result;
    }

}
