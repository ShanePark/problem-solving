package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 8ms
 * Beats16.37%
 */
public class Q120Triangle2 {

    @Test
    public void test() {
        assertThat(minimumTotal(Ps.intList("[[2],[3,4],[6,5,7],[4,1,8,3]]"))).isEqualTo(11);
        assertThat(minimumTotal(Ps.intList("[[-10]]"))).isEqualTo(-10);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> rowBefore = triangle.get(i - 1);
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                int cur = row.get(j);
                if (j == 0) {
                    row.set(j, cur + rowBefore.get(0));
                    continue;
                }
                if (rowBefore.size() == j) {
                    row.set(j, cur + rowBefore.get(j - 1));
                    continue;
                }
                row.set(j, cur + Math.min(rowBefore.get(j - 1), rowBefore.get(j)));
            }
        }
        List<Integer> lastRow = triangle.get(triangle.size() - 1);
        return lastRow.stream().mapToInt(Integer::valueOf).min().orElse(-1);
    }

}
