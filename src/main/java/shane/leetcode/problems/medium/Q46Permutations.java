package shane.leetcode.problems.medium;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q46Permutations {

    @Test
    public void test() {
        assertThat(permute(new int[]{1, 2, 3})).isEqualTo(STool.convertToIntList("[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]"));
        assertThat(permute(new int[]{0, 1})).isEqualTo(STool.convertToIntList("[[0,1],[1,0]]"));
        assertThat(permute(new int[]{1})).isEqualTo(STool.convertToIntList("[[1]]"));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        dfs(nums, answer, new boolean[nums.length], new ArrayList<>());
        return answer;
    }

    private void dfs(int[] nums, List<List<Integer>> answer, boolean[] visited, List<Integer> list) {
        if (list.size() == nums.length) {
            answer.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            list.add(nums[i]);
            dfs(nums, answer, visited, list);
            visited[i] = false;
            list.remove((Integer) nums[i]);
        }
    }
}
