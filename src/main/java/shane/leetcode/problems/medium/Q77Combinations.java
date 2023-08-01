package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 15 ms Beats 81.73%
 * Memory 45.3 MB Beats 65.9%
 */
public class Q77Combinations {

    @Test
    public void test() {
        assertThat(combine(4, 2)).containsExactlyInAnyOrder(List.of(1, 2), List.of(1, 3), List.of(1, 4), List.of(2, 3), List.of(2, 4), List.of(3, 4));
        assertThat(combine(1, 1)).isEqualTo(Ps.intList("[[1]]"));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        dfs(answer, n, k, 1, new ArrayList<>());
        return answer;
    }

    private void dfs(List<List<Integer>> answer, int n, int k, int index, List<Integer> list) {
        if (n < index) {
            return;
        }
        dfs(answer, n, k, index + 1, list);

        list.add(index);
        int size = list.size();
        if (size == k) {
            answer.add(new ArrayList<>(list));
            list.remove(size - 1);
            return;
        }
        dfs(answer, n, k, index + 1, list);
        list.remove(size - 1);
    }

}
