package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 1 ms Beats 98.58%
 * Memory 44.1 MB Beats 47.37%
 */
public class Q46Permutations2 {

    @Test
    public void test() {
        assertThat(permute(new int[]{1, 2, 3})).isEqualTo(Ps.intList("[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]"));
        assertThat(permute(new int[]{0, 1})).isEqualTo(Ps.intList("[[0,1],[1,0]]"));
        assertThat(permute(new int[]{1})).isEqualTo(Ps.intList("[[1]]"));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, answer, visited, new ArrayList<>());
        return answer;
    }

    private void dfs(int[] nums, List<List<Integer>> answer, boolean[] visited, List<Integer> list) {
        if (list.size() == visited.length) {
            answer.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < visited.length; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            list.add(nums[i]);
            dfs(nums, answer, visited, list);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }

}
