package shane.leetcode.problems.easy;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 1ms Beats 89.25%of users with Java
 * Memory Details 40.79MB Beats 85.07%of users with Java
 */
public class Q118PascalsTriangle2 {

    @Test
    public void test() {
        assertThat(generate(5)).isEqualTo(Ps.intList("[[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]"));
        assertThat(generate(1)).isEqualTo(Ps.intList("[[1]]"));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(List.of(1));
        if (numRows == 1)
            return answer;
        answer.add(List.of(1, 1));
        for (int i = 2; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            List<Integer> before = answer.get(i - 1);
            for (int j = 1; j < before.size(); j++) {
                list.add(before.get(j - 1) + before.get(j));
            }
            list.add(1);
            answer.add(list);
        }
        return answer;
    }

}
