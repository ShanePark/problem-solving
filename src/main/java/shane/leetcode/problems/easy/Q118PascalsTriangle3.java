package shane.leetcode.problems.easy;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 1ms
 * Beats82.66%
 */
public class Q118PascalsTriangle3 {

    @Test
    public void test() {
        assertThat(generate(5)).isEqualTo(Ps.intList("[[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]"));
        assertThat(generate(1)).isEqualTo(Ps.intList("[[1]]"));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            if (answer.isEmpty()) {
                answer.add(List.of(1));
                continue;
            }
            List<Integer> before = answer.get(i - 1);
            List<Integer> next = new ArrayList<>();
            for (int j = 0; j < before.size(); j++) {
                next.add((j == 0 ? 0 : before.get(j - 1)) + before.get(j));
            }
            next.add(1);
            answer.add(next);
        }
        return answer;
    }

}
