package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 32
 * ms
 * Beats
 * 25.35%
 */
public class Q3437PermutationsIII {

    @Test
    public void test() {
        assertThat(permute(2)).isEqualTo(Ps.intArray("[[1,2],[2,1]]"));
        assertThat(permute(3)).isEqualTo(Ps.intArray("[[1,2,3],[3,2,1]]"));
        assertThat(permute(4)).isEqualTo(Ps.intArray("[[1,2,3,4],[1,4,3,2],[2,1,4,3],[2,3,4,1],[3,2,1,4],[3,4,1,2],[4,1,2,3],[4,3,2,1]]"));
    }

    public int[][] permute(int n) {
        List<List<Integer>> answer = new ArrayList<>();
        dfs(answer, n, new ArrayList<>(), new HashSet<>());
        return answer.stream().map(l -> l.stream().mapToInt(i -> i).toArray()).toArray(int[][]::new);
    }

    private void dfs(List<List<Integer>> answer, int n, List<Integer> list, Set<Integer> set) {
        if (set.size() == n) {
            answer.add(new ArrayList<>(list));
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (set.contains(i))
                continue;
            if (!list.isEmpty() && list.get(list.size() - 1) % 2 == i % 2)
                continue;
            list.add(i);
            set.add(i);
            dfs(answer, n, list, set);
            set.remove(i);
            list.remove(list.size() - 1);
        }
    }

}
