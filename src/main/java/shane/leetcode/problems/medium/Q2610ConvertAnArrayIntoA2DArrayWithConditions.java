package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 6ms Beats 16.31%of users with Java
 * Memory Details 44.98MB Beats 14.62%of users with Java
 */
public class Q2610ConvertAnArrayIntoA2DArrayWithConditions {

    @Test
    public void test() {
        assertThat(findMatrix(new int[]{1, 3, 4, 1, 2, 3, 1})).isEqualTo(Ps.intList("[[1,3,4,2],[1,3],[1]]"));
        assertThat(findMatrix(new int[]{1, 2, 3, 4})).isEqualTo(Ps.intList("[[1,2,3,4]]"));
    }

    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Map<Integer, Integer> size = new HashMap<>();
        for (int i : nums) {
            Integer cnt = size.merge(i, 1, Integer::sum);
            if (answer.size() < cnt) {
                answer.add(new ArrayList<>());
            }
            answer.get(cnt - 1).add(i);
        }
        return answer;
    }

}
