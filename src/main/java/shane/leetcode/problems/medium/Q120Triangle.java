package shane.leetcode.problems.medium;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q120Triangle {

    @Test
    public void test() {
        assertThat(minimumTotal(Ps.intList("[[2],[3,4],[6,5,7],[4,1,8,3]]"))).isEqualTo(11);
        assertThat(minimumTotal(Ps.intList("[[-10]]"))).isEqualTo(-10);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> before = triangle.get(i - 1);
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                row.set(j, Math.min(
                        j == 0 ? Integer.MAX_VALUE : before.get(j - 1),
                        j == before.size() ? Integer.MAX_VALUE : before.get(j)
                ) + row.get(j));
            }
        }
        return triangle.get(triangle.size() - 1).stream().min(Comparator.naturalOrder()).get();
    }
}
