package shane.leetcode.problems.medium;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("ALL")
public class Q47PermutationsII2 {

    @Test
    public void test() {
        assertThat(permuteUnique(new int[]{2, 2, 1, 1})).containsExactlyInAnyOrderElementsOf(Ps.intList("[[1,1,2,2],[1,2,1,2],[1,2,2,1],[2,1,1,2],[2,1,2,1],[2,2,1,1]]"));
        assertThat(permuteUnique(new int[]{1, 1, 2})).containsExactlyInAnyOrderElementsOf(Ps.intList("[[1, 1, 2], [2, 1, 1], [1, 2, 1]]"));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, new boolean[nums.length], new ArrayList<Integer>(), answer);
        return answer;
    }

    private void dfs(int[] nums, boolean[] visited, ArrayList<Integer> cur, List<List<Integer>> answer) {
        if (cur.size() == nums.length) {
            answer.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i])
                continue;
            if (i > 0 && (nums[i - 1] == nums[i]) && visited[i - 1])
                continue;
            visited[i] = true;
            cur.add(nums[i]);
            dfs(nums, visited, cur, answer);
            visited[i] = false;
            cur.remove(cur.size() - 1);
        }

    }

}
